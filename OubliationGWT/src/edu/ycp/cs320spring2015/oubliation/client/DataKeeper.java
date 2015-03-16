package edu.ycp.cs320spring2015.oubliation.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("DataKeeper")
public interface DataKeeper extends RemoteService {
	public boolean validateLogin(String username, String password);
//	public Profile loadProfile(String username);
//	public void prepareSave(String username);
//	public void saveActor(String username, );
//	public void closeSave(String username, int money, Item items...);
}
