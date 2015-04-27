package edu.ycp.cs320spring2015.oubliation.client.transfer;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ycp.cs320spring2015.oubliation.shared.actor.player.BruceScore;

public class JsBruceMap extends JavaScriptObject {
	protected JsBruceMap() {}
	
	private final native Double getField(String field) /*-{
		return this[field];
	}-*/;
	
	public final double getScore(BruceScore score) {
		return getField(score.name());
	}
	
	
}
