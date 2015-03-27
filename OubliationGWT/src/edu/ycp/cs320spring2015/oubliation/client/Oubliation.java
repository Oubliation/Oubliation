package edu.ycp.cs320spring2015.oubliation.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

public class Oubliation implements EntryPoint {

	private static DataKeeperAsync theDataKeeper;
	public static DataKeeperAsync getDataKeeper() {
		if (theDataKeeper == null) {
	        throw new IllegalStateException("IDatabase instance has not been set!");
	    }
		return theDataKeeper;
	}
	
	public void onModuleLoad() {
		theDataKeeper = (DataKeeperAsync) GWT.create(DataKeeper.class);
		
		Login login = new Login();
		RootPanel.get("gwtapp").add(login);
	}
	
}