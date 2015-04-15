package edu.ycp.cs320spring2015.oubliation.client.transfer;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ycp.cs320spring2015.oubliation.shared.actor.player.BruceScore;

public class JsBruceMap<T> extends JavaScriptObject {
	
	private final native T getField(String field) /*-{
		return this[field];
	}-*/;
	
	public final T getScore(BruceScore score) {
		return getField(score.name());
	}
	
	
}
