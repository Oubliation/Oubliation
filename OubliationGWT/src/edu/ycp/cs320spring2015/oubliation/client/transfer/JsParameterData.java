package edu.ycp.cs320spring2015.oubliation.client.transfer;

import com.google.gwt.core.client.JavaScriptObject;

public class JsParameterData extends JavaScriptObject {
	protected JsParameterData() {}
	
	final public native <T> T getField(String field) /*-{
		return this[field];
	}-*/;
}
