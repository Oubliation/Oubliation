package edu.ycp.cs320spring2015.oubliation.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DataKeeperAsync {

	//void loadProfile(String username, AsyncCallback<Profile> callback);

	//void saveProfile(String username, Profile profile,
	//		AsyncCallback<Void> callback);

	void validateLogin(String username, String password,
			AsyncCallback<Boolean> callback);

}
