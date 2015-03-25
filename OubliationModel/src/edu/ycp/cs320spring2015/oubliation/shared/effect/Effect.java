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
	Element element;
	
	public Effect(Element element) {
		this.element = element;
	}
	
	/**
	 * 
	 * @param source actor which caused the effect, if applicable
	 * @param target actor to be targeted by the effect
	 */
	public abstract void apply(Actor source, Actor target); //TODO: null object pattern?
}