package edu.ycp.cs320spring2015.oubliation.shared.behavior;

import edu.ycp.cs320spring2015.oubliation.shared.statuses.ActionModifier;

public class NoEffect extends Effect {
	private static final long serialVersionUID = 273852401294940171L;

	@Override
	public String apply(ActionModifier source, ActionModifier target, int healthDelta) { return null; }
}
