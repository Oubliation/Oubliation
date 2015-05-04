package edu.ycp.cs320spring2015.oubliation.client;

import com.google.gwt.user.client.ui.Widget;

public interface BaseScreen {
	
	public void overlayScreen(Widget screen);
	public void removeOverlay(Widget screen);
}
