package edu.ycp.cs320spring2015.oubliation.shared.behavior;

import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;

public class Damage extends Effect {
	private static final long serialVersionUID = -3471048874002736937L;

	@Override
	public void apply(Actor source, Actor target, int power) {
		target.receiveDamage((power+source.getAttackMod())*source.getHitCount());
	}

}
