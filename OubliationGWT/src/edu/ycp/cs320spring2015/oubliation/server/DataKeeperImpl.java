package edu.ycp.cs320spring2015.oubliation.server;

import com.google.gwt.dev.util.collect.HashMap;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.ycp.cs320spring2015.oubliation.client.DataKeeper;
import edu.ycp.cs320spring2015.oubliation.client._Dummy;
import edu.ycp.cs320spring2015.oubliation.shared.test.Debug;
import edu.ycp.cs320spring2015.oubliation.shared.transfer.ProfileMemento;

public class DataKeeperImpl extends RemoteServiceServlet implements DataKeeper {
	private static final long serialVersionUID = -7277596399415609046L;
	
	private HashMap<String, FakeEntry> fakeDatabase = new HashMap<String, FakeEntry>();

	public Boolean createProfile(String username, String password) {
		if (!fakeDatabase.containsKey(username)) {
			ProfileMemento profile = Debug.makeProfileTransfer(username);
			FakeEntry entry = new FakeEntry(password, profile);
			fakeDatabase.put(username, entry);
			
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public Boolean validateLogin(String username, String password) {
		FakeEntry entry = fakeDatabase.get(username);
		if (entry != null) {
			return password.equals(entry.getPassword());
		} else {
			return false;
		}
	}

	@Override
	public ProfileMemento loadProfile(String username) {
		FakeEntry entry = fakeDatabase.get(username);
		return entry.getSavedata();
	}

	@Override
	public void saveProfile(String username, ProfileMemento profile) {
		FakeEntry oldEntry = fakeDatabase.get(username);
		FakeEntry newEntry = new FakeEntry(oldEntry.getPassword(), profile);
		fakeDatabase.put(username, newEntry);
	}
	
	@Override
	public _Dummy dummy(_Dummy dummy) {
		return dummy;
	}

}
