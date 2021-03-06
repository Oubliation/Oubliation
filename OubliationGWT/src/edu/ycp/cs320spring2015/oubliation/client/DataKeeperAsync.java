package edu.ycp.cs320spring2015.oubliation.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320spring2015.oubliation.shared.transfer.ProfileMemento;

public interface DataKeeperAsync {
	
	void createProfile(String username, String password, long id, AsyncCallback<Boolean> callback);
	
	void validateLogin(String username, String password, AsyncCallback<Boolean> callback);

	void loadProfile(String username, AsyncCallback<ProfileMemento> callback);

	void saveProfile(String username, ProfileMemento profile, AsyncCallback<Void> callback);
	
	void dummy(_Dummy dummy, AsyncCallback<_Dummy> callback);

}
