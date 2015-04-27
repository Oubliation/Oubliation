package edu.ycp.cs320spring2015.oubliation.client.transfer;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ycp.cs320spring2015.oubliation.shared.Entity;
import edu.ycp.cs320spring2015.oubliation.shared.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.BruceScore;

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
	
	private interface Conversion<T> {
		T convert(double value);
	}

	static protected EnumMap<BruceScore, Integer> getBruceIntegerMap(JsBruceMap jsMap) {
		return EntityOverlay.<Integer>getBruceGenericMap(jsMap, new Conversion<Integer>() {
			@Override
			public Integer convert(double value) {
				return new Integer(new Double(value).intValue());
			}
		});
	}

	static protected EnumMap<BruceScore, Double> getBruceDoubleMap(JsBruceMap jsMap) {
		return EntityOverlay.<Double>getBruceGenericMap(jsMap, new Conversion<Double>() {
			@Override
			public Double convert(double value) {
				return new Double(value);
			}
		});
	}

	private static<T> EnumMap<BruceScore, T> getBruceGenericMap(JsBruceMap jsMap, Conversion<T> conversion) {
		EnumMap<BruceScore, T> enumMap = new EnumMap<BruceScore, T>(BruceScore.class);
		for (BruceScore score : BruceScore.values()) {
			enumMap.put(score, conversion.convert(jsMap.getScore(score)));
		}
		return enumMap;
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
