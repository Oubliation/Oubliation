package edu.ycp.cs320spring2015.oubliation.shared.effect;

import java.io.Serializable;

public abstract class Effect implements Serializable {
	
	public abstract void apply(Actor target); //TODO: null object pattern?
}