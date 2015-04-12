package edu.ycp.cs320spring2015.oubliation.client;

import java.util.Map;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.ycp.cs320spring2015.oubliation.shared.effect.Effect;
import edu.ycp.cs320spring2015.oubliation.shared.transfer.ProfileMemento;

@RemoteServiceRelativePath("DataKeeper")
public interface DataKeeper extends RemoteService {
	public void createProfile(String username, String password, long id);
	public Boolean validateLogin(String username, String password);
	public ProfileMemento loadProfile(String username);
	public void saveProfile(String username, ProfileMemento profile);
	public Map<String, Effect> getEffectMap(String[] effectName);
	public void createDb();
	public _Dummy dummy(_Dummy dummy);
}
