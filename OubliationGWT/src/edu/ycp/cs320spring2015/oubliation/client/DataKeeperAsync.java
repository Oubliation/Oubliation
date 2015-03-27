package edu.ycp.cs320spring2015.oubliation.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320spring2015.oubliation.shared.transfer.ProfileTransfer;

public interface DataKeeperAsync {
	
	void newProfile(String username, String password, AsyncCallback<ProfileTransfer> callback);

	void loadProfile(String username, String password, AsyncCallback<ProfileTransfer> callback);

	void saveProfile(String username, ProfileTransfer profile,
			AsyncCallback<Void> callback);
	
	void dummy(_Dummy dummy, AsyncCallback<_Dummy> callback);

}
