package edu.ycp.cs320spring2015.oubliation.server;

import edu.ycp.cs320spring2015.oubliation.shared.transfer.ProfileMemento;

public class FakeEntry {
	private ProfileMemento savedata;
	private String password;
	
	public FakeEntry(String password, ProfileMemento savedata) {
		this.savedata = savedata;
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	};
	
	public ProfileMemento getSavedata() {
		return savedata;
	}
}
