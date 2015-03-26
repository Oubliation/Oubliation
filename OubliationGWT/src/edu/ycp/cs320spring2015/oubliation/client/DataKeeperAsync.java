package edu.ycp.cs320spring2015.oubliation.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320spring2015.oubliation.shared.transfer.ProfileTransfer;

public interface DataKeeperAsync {

	void loadProfile(String username, AsyncCallback<ProfileTransfer> callback);

	void saveProfile(String username, ProfileTransfer profile,
			AsyncCallback<Void> callback);

	void validateLogin(String username, String password,
			AsyncCallback<Boolean> callback);
	
	void dummy(_Dummy dummy, AsyncCallback<_Dummy> callback);

}
