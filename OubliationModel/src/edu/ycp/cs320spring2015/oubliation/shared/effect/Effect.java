package edu.ycp.cs320spring2015.oubliation.shared.effect;

import java.io.Serializable;

import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;
import edu.ycp.cs320spring2015.oubliation.shared.category.Element;

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
	public abstract void apply(Actor source, Actor target, Element element, int potency, int accuracy); //TODO: null object pattern?
}