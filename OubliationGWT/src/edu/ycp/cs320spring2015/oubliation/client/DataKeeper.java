package edu.ycp.cs320spring2015.oubliation.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.ycp.cs320spring2015.oubliation.shared.Profile;

@RemoteServiceRelativePath("DataKeeper")
public interface DataKeeper extends RemoteService {
	public boolean validateLogin(String username, String password);
//	public void saveProfile(String username, Profile profile);
//	public Profile loadProfile(String username);
}
