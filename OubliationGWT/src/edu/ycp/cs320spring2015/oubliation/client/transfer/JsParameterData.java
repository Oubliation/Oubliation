package edu.ycp.cs320spring2015.oubliation.client.transfer;

import com.google.gwt.core.client.JavaScriptObject;

public class JsParameterData extends JavaScriptObject {
	protected JsParameterData() {}
	
	final public native int getInt(String field) /*-{
		return this[field];
	}-*/;
	
	final public native double getDouble(String field) /*-{
		return this[field];
	}-*/;
	
	final public native boolean getBoolean(String field) /*-{
		return this[field];
	}-*/;
	
	final public native String getString(String field) /*-{
		return this[field];
	}-*/;
	
	
	final public native int[] getIntArray(String field) /*-{
		return this[field];
	}-*/;
	
	final public native double[] getDoubleArray(String field) /*-{
		return this[field];
	}-*/;
	
	final public native boolean[] getBooleanArray(String field) /*-{
		return this[field];
	}-*/;
	
	final public native String[] getStringArray(String field) /*-{
		return this[field];
	}-*/;

	
	final public native int[][] getIntArray2(String field) /*-{
		return this[field];
	}-*/;
	
	final public native double[][] getDoubleArray2(String field) /*-{
		return this[field];
	}-*/;
	
	final public native boolean[][] getBooleanArray2(String field) /*-{
		return this[field];
	}-*/;
	
	final public native String[][] getStringArray2(String field) /*-{
		return this[field];
	}-*/;
}
