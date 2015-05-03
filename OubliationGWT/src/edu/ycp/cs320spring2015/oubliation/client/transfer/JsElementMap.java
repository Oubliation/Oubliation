package edu.ycp.cs320spring2015.oubliation.client.transfer;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ycp.cs320spring2015.oubliation.shared.category.Element;

public class JsElementMap<T> extends JavaScriptObject {
	protected JsElementMap() {}
	
	private final native T getField(String field) /*-{
		return this[field];
	}-*/;
	
	public final T getElement(Element element) {
		return getField(element.name());
	}
	
	
}
