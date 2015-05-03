package edu.ycp.cs320spring2015.oubliation.client.transfer;

import com.google.gwt.core.client.JavaScriptObject;

public class JsInventoryData extends JavaScriptObject {
	protected JsInventoryData() {}
	
	final public native String[] getItems() /*-{
		return this.items;
	}-*/;
	final public native String[] getHeadwear() /*-{
		return this.headwear;
	}-*/;
	final public native String[] getSuits() /*-{
		return this.suits;
	}-*/;
	final public native String[] getShields() /*-{
		return this.shields;
	}-*/;
	final public native String[] getUtilities() /*-{
		return this.utilities;
	}-*/;
	final public native String[] getWeapons() /*-{
		return this.weapons;
	}-*/;
}
