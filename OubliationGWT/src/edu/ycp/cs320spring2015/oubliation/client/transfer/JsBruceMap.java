package edu.ycp.cs320spring2015.oubliation.client.transfer;

import java.util.EnumMap;

import com.google.gwt.core.client.JavaScriptObject;

import edu.ycp.cs320spring2015.oubliation.shared.actor.player.BruceScore;

public class JsBruceMap extends JavaScriptObject {
	protected JsBruceMap() {}
	
	private final native double getField(String field) /*-{
		return this[field];
	}-*/;
	
	private interface Conversion<T> {
		T convert(Double value);
	}

	final public EnumMap<BruceScore, Integer> getIntegerMap() {
		return getGenericMap(new Conversion<Integer>() {
			@Override
			public Integer convert(Double value) {
				return new Integer(value.intValue());
			}
		});
	}

	final public EnumMap<BruceScore, Double> getDoubleMap() {
		return getGenericMap(new Conversion<Double>() {
			@Override
			public Double convert(Double value) {
				return value;
			}
		});
	}

	final private <T> EnumMap<BruceScore, T> getGenericMap(Conversion<T> conversion) {
		EnumMap<BruceScore, T> enumMap = new EnumMap<BruceScore, T>(BruceScore.class);
		for (BruceScore score : BruceScore.values()) {
			enumMap.put(score, conversion.convert(getField(score.name())));
		}
		return enumMap;
	}
	
	
}
