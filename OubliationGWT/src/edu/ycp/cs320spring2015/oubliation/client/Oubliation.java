package edu.ycp.cs320spring2015.oubliation.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class Oubliation implements EntryPoint {
	
	public void onModuleLoad() {
		Login login = new Login();
		RootPanel.get("gwtapp").add(login);
	}
}