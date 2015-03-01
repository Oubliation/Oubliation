package edu.ycp.cs320spring2015.oubliation.shared.effect;

public abstract class Effect<T> {
	private String description;
	
	public abstract void apply(T target); //TODO: null object pattern?
	
	public Effect(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}