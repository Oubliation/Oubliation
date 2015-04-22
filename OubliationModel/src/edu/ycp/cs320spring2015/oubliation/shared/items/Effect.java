package edu.ycp.cs320spring2015.oubliation.shared.items;

import java.io.Serializable;

import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;

/**
 * 
 * A change to actor state caused by an in-game tool
 *
 */
public abstract class Effect implements Serializable {
	private static final long serialVersionUID = 2954502499169810978L;
	public Effect() {}
	
	/**
	 * 
	 * @param source actor which caused the effect, if applicable
	 * @param target actor to be targeted by the effect
	 */
	public abstract void apply(Actor source, Actor target); //TODO: null object pattern?
}