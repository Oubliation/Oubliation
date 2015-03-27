package edu.ycp.cs320spring2015.oubliation.server;

import edu.ycp.cs320spring2015.oubliation.shared.transfer.ProfileTransfer;

public class FakeEntry {
	private ProfileTransfer savedata;
	private String password;
	
	public FakeEntry(String password, ProfileTransfer savedata) {
		this.savedata = savedata;
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	};
	
	public ProfileTransfer getSavedata() {
		return savedata;
	}
}
