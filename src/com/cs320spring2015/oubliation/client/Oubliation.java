package com.cs320spring2015.oubliation.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;


public class Oubliation implements EntryPoint {

	private double[] perspectiveTransform(double xDist, double yDist, double depth) {
		double xViewSlope = 0, yViewSlope = 0;
		double initialTileHeight = 0, initialTileWidth = 0;

		double xScale = depth*xViewSlope*initialTileHeight;
		double yScale = depth*yViewSlope*initialTileWidth;
		
		double[] screenCoords = {xDist*xScale, yDist*yScale};
		
		return screenCoords;
	}
	
	public void onModuleLoad() {

	}
}
