package edu.ycp.cs320spring2015.oubliation.shared.effect;

import edu.ycp.cs320spring2015.oubliation.shared.character.Unit;

public interface Effect<T> {
	public void apply(T target);
}