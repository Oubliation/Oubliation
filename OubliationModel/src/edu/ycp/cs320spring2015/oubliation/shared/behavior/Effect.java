package edu.ycp.cs320spring2015.oubliation.shared.behavior;

import java.io.Serializable;

import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;

/**
 * 
 * A change to actor state caused by an in-game tool
 *
 */
public abstract class Effect implements Serializable {
	private static final long serialVersionUID = -5840753626594178911L;
	public Effect() {}

	/**
	 * 
	 * @param source actor which caused the effect, if applicable
	 * @param target actor to be targeted by the effect
	 */
	public abstract void apply(Actor source, Actor target, int healthDelta); //TODO: null object pattern?
}