package edu.ycp.cs320spring2015.oubliation.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.ycp.cs320spring2015.oubliation.shared.transfer.ProfileTransfer;

@RemoteServiceRelativePath("DataKeeper")
public interface DataKeeper extends RemoteService {
	public boolean validateLogin(String username, String password);
	public ProfileTransfer loadProfile(String username);
	public void saveProfile(String username, ProfileTransfer profile);
	public _Dummy dummy(_Dummy dummy);
}
