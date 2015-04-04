package edu.ycp.cs320spring2015.oubliation.client.transfer;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ycp.cs320spring2015.oubliation.shared.Entity;
import edu.ycp.cs320spring2015.oubliation.shared.NameTag;

public abstract class EntityOverlay<T extends Entity> extends JavaScriptObject {
	protected EntityOverlay() {}

	protected final native String getName() /*-{
		return this.name;
	}-*/;
	protected final native String getDescription() /*-{
		return this.description;
	}-*/;
	protected final NameTag getNameTag() {
		return new NameTag(getName(), getDescription());
	}
}
