package edu.ycp.cs320spring2015.oubliation.shared.effect;

import java.io.Serializable;

import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;

public abstract class Effect implements Serializable {
	
	public abstract void apply(Actor target); //TODO: null object pattern?
}