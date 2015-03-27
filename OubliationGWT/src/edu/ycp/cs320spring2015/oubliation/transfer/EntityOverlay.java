package edu.ycp.cs320spring2015.oubliation.transfer;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ycp.cs320spring2015.oubliation.shared.NameTag;

public abstract class EntityOverlay<T> extends JavaScriptObject {
	protected EntityOverlay() {}

	protected static <T2> void getUrlData(String filename, String name, final DataCallback<T2> callback) {
		
	}
	
	protected static <T2> void getAllUrlData(String filename, final DataCallback<T2[]> callback) {
		
	}

	protected final native String getName() /*-{
		return this.name;
	}-*/;
	protected final native String getDescription() /*-{
		return this.description;
	}-*/;
	protected NameTag getNameTag() {
		return new NameTag(getName(), getDescription());
	}
	
	public abstract T getData();
}
