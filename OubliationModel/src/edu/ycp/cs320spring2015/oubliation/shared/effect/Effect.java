package edu.ycp.cs320spring2015.oubliation.shared.effect;

import java.io.Serializable;

public abstract class Effect<T> implements Serializable {
	private String description;
	
	public abstract void apply(T target); //TODO: null object pattern?
	
	public Effect(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}