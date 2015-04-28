package edu.ycp.cs320spring2015.oubliation.client.transfer;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ycp.cs320spring2015.oubliation.shared.Entity;
import edu.ycp.cs320spring2015.oubliation.shared.NameTag;

public abstract class EntityOverlay extends JavaScriptObject {
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
	
	static protected <E extends Entity, O extends EntityOverlay> Map<String, E> remapEntity(Map<String, O> overlayMap, EntityExtractor<E, O> extractor) {
		HashMap<String, E> entityMap = new HashMap<String, E>();
		for (String key : overlayMap.keySet()) {
			entityMap.put(key, extractor.getEntity(overlayMap.get(key)));
		}
		return entityMap;
	}
	
	static protected TreeSet<String> getStringSet(String[] stringArray) {
		TreeSet<String> stringSet = new TreeSet<String>();
		for (String string : stringArray) {
			stringSet.add(string);
		}
		return stringSet;
	}
}
