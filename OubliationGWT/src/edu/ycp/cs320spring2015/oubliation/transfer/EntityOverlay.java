package edu.ycp.cs320spring2015.oubliation.transfer;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ycp.cs320spring2015.oubliation.shared.NameTag;

public class EntityOverlay extends JavaScriptObject {
	protected EntityOverlay() {}

	protected final native String getName() /*-{
		return this.name;
	}-*/;
	protected final native String getDescription() /*-{
		return this.description;
	}-*/;
	protected NameTag getNameTag() {
		return new NameTag(getName(), getDescription());
	}
}
