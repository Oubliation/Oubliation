package edu.ycp.cs320spring2015.oubliation.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import com.gargoylesoftware.htmlunit.javascript.host.Console;
import com.google.gwt.dev.util.collect.HashMap;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.ycp.cs320spring2015.oubliation.client.DataKeeper;
import edu.ycp.cs320spring2015.oubliation.client.Oubliation;
import edu.ycp.cs320spring2015.oubliation.client._Dummy;
import edu.ycp.cs320spring2015.oubliation.shared.effect.NoEffect;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Effect;
import edu.ycp.cs320spring2015.oubliation.shared.test.Debug;
import edu.ycp.cs320spring2015.oubliation.shared.transfer.ProfileMemento;

public class DataKeeperImpl extends RemoteServiceServlet implements DataKeeper {
	private static final long serialVersionUID = -7277596399415609046L;
	
	static {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (Exception e) {
			throw new IllegalStateException("Could not load Derby JDBC driver");
		}
	}

	private static final int MAX_ATTEMPTS = 10;
	
	private interface Transaction<ResultType> {
		public ResultType execute(Connection conn) throws SQLException;
	}
	
	private<ResultType> ResultType executeTransaction(Transaction<ResultType> txn) {
		try {
			return doExecuteTransaction(txn);
		} catch (SQLException e) {
			throw new PersistenceException("Transaction failed", e);
		}
	}
	
	private<ResultType> ResultType doExecuteTransaction(Transaction<ResultType> txn) throws SQLException {
		Connection conn = connect();
		
		try {
			int numAttempts = 0;
			boolean success = false;
			ResultType result = null;
			
			while (!success && numAttempts < MAX_ATTEMPTS) {
				try {
					result = txn.execute(conn);
					conn.commit();
					success = true;
				} catch (SQLException e) {
					if (e.getSQLState() != null && e.getSQLState().equals("41000")) {
						// Deadlock: retry (unless max retry count has been reached)
						numAttempts++;
					} else {
						// Some other kind of SQLException
						throw e;
					}
				}
			}
			
			if (!success) {
				throw new SQLException("Transaction failed (too many retries)");
			}
			
			// Success!
			return result;
		} finally {
			DbUtils.closeQuietly(conn);
		}
	}

	private Connection connect() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:derby:res/oubliation.db;create=true");
		
		// Set autocommit to false to allow multiple the execution of
		// multiple queries/statements as part of the same transaction.
		conn.setAutoCommit(false);
		
		return conn;
	}
	
	@Override
	public void createProfile(final String username, final String password, final long id) {
		executeTransaction(new Transaction<Void>() {
			@Override
			public Void execute(Connection conn) throws SQLException {
				PreparedStatement createAccount = null;
				PreparedStatement createData = null;
				try {
					createAccount = conn.prepareStatement(
						"insert into accounts values (?, ?, ?)"
					);
					createAccount.setLong(1, id);
					createAccount.setString(2, username);
					createAccount.setString(3, password);
					createAccount.executeUpdate();
					
					createData = conn.prepareStatement(
						"insert into data values (?, ?)"
					);
					createData.setLong(1, id);
					createData.setObject(2, Debug.makeProfileTransfer(username));
					createData.executeUpdate();
				} finally {
					DbUtils.closeQuietly(createAccount);
					DbUtils.closeQuietly(createData);
				}
				return null;
			}
		});
	}
	
	@Override
	public Boolean validateLogin(final String username, final String password) {
		return executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				try {
					stmt = conn.prepareStatement(
						"select password from accounts where username = ?"
					);
					stmt.setString(1, username);
					resultSet = stmt.executeQuery();
					resultSet.next();
					return resultSet.getString(1).equals(password);
				} finally {
					DbUtils.closeQuietly(stmt);
					DbUtils.closeQuietly(resultSet);
				}
			}
		});
	}

	@Override
	public ProfileMemento loadProfile(final String username) {
		return executeTransaction(new Transaction<ProfileMemento>() {
			@Override
			public ProfileMemento execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				try {
					stmt = conn.prepareStatement(
						"select profile from accounts, data where accounts.id = data.id and username = ?"
					);
					stmt.setString(1, username);
					resultSet = stmt.executeQuery();
					resultSet.next();
					
					return (ProfileMemento) resultSet.getObject(1);
				} finally {
					DbUtils.closeQuietly(stmt);
					DbUtils.closeQuietly(resultSet);
				}
			}
		});
	}

	@Override
	public void saveProfile(final String username, final ProfileMemento profile) {
		executeTransaction(new Transaction<Void>() {
			@Override
			public Void execute(Connection conn) throws SQLException {
				PreparedStatement getId = null;
				ResultSet idResult = null;
				PreparedStatement updateProfile = null;
				try {
					getId = conn.prepareStatement(
						"select id from accounts where username = ?"
					);
					getId.setString(1, username);
					idResult = getId.executeQuery();
					idResult.next();
					
					updateProfile = conn.prepareStatement(
						"update data set profile = ? where id = ?"
					);
					updateProfile.setObject(1, profile);
					updateProfile.setLong(2, idResult.getLong(1));
					updateProfile.executeUpdate();
				} finally {
					DbUtils.closeQuietly(getId);
					DbUtils.closeQuietly(idResult);
					DbUtils.closeQuietly(updateProfile);
				}
				return null;
			}
		});
	}
	
	@Override
	public Map<String, Effect> getEffectMap(String[] effectNames) {
		HashMap<String, Effect> effectMap = new HashMap<String, Effect>();
		for (String name : effectNames) {
			try {
				effectMap.put(name, (Effect) Class.forName(name).getConstructor().newInstance());
			} catch(Exception e) {
				effectMap.put(name, new NoEffect());
			}
		}
		assert(effectMap.size()>0);
		return effectMap;
	}
	
	@Override
	public void createDb() {
		executeTransaction(new Transaction<Void>() {
			@Override
			public Void execute(Connection conn) throws SQLException {
				PreparedStatement createProfileType = null;
				PreparedStatement createAccountsTable = null;
				PreparedStatement createDataTable = null;
				try {
					createProfileType = conn.prepareStatement(
						"create type ProfileMemento external name 'edu.ycp.cs320spring2015.oubliation.shared.transfer.ProfileMemento' language java"
					);
					createProfileType.executeUpdate();
					createAccountsTable = conn.prepareStatement(
						"create table accounts (id bigint primary key generated by default as identity, username varchar(15) unique, password varchar(15))"
					);
					createAccountsTable.executeUpdate();
					createDataTable = conn.prepareStatement(
						"create table data (id bigint primary key, profile ProfileMemento)"
					);
					createDataTable.executeUpdate();
				} finally {
					DbUtils.closeQuietly(createProfileType);
					DbUtils.closeQuietly(createAccountsTable);
					DbUtils.closeQuietly(createDataTable);
				}
				return null;
			}
		});
	}
	
	@Override
	public _Dummy dummy(_Dummy dummy) {
		return dummy;
	}

}
