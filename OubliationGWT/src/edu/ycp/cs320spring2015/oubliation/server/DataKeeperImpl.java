package edu.ycp.cs320spring2015.oubliation.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.ycp.cs320spring2015.oubliation.client.DataKeeper;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.Profile;
import edu.ycp.cs320spring2015.oubliation.shared.test.Debug;

public class DataKeeperImpl extends RemoteServiceServlet implements DataKeeper {

	@Override
	public boolean validateLogin(String username, String password) {
		if (username.equals("username") && password.equals("password")) {
			return true;
		} else {
			return false;
		}
	}

//	@Override
//	public void saveProfile(String username, Profile profile) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public Profile loadProfile(String username) {
//		return Debug.makeProfile();
//	}

}
