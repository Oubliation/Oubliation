package edu.ycp.cs320spring2015.oubliation.shared.targets;

import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;
import edu.ycp.cs320spring2015.oubliation.shared.category.Element;
import edu.ycp.cs320spring2015.oubliation.shared.statuses.ActionModifier;

public interface ActionTarget {
	public void selectAnyBehavior(PartyController controller);
	public String getName();
	public int getInitiative();
	public ActionModifier getTargetModifier();
	public ActionModifier getActionModifier(Actor target);
	public boolean hitTest(int accuracy);
	public int receiveDamage(int damage, Element element);
	public int receiveHealing(int amount);
}
