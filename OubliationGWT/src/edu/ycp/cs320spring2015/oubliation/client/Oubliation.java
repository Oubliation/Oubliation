package edu.ycp.cs320spring2015.oubliation.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

import edu.ycp.cs320spring2015.oubliation.shared.actor.player.Profile;

public class Oubliation implements EntryPoint {

	private Profile profile = TestConstructor.makeTestProfile();
	private ViewStats statScreen = new ViewStats(profile.getParty());
	
	public void onModuleLoad() {
		RootPanel.get("gwtapp").add(statScreen);
	}
}
