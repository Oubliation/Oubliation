package edu.ycp.cs320spring2015.oubliation.shared.effect;

import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;
import edu.ycp.cs320spring2015.oubliation.shared.category.Element;

public class NoEffect extends Effect {
	private static final long serialVersionUID = 273852401294940171L;

	@Override
	public void apply(Actor source, Actor target, Element element, int potency,
			int accuracy) {
		throw new UnsupportedOperationException();

	}

}
