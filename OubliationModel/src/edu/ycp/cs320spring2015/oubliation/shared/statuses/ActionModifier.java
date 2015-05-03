package edu.ycp.cs320spring2015.oubliation.shared.statuses;

import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;
import edu.ycp.cs320spring2015.oubliation.shared.category.Element;

public interface ActionModifier {
	public boolean onHitTest(int accuracy);
	public int onReceiveDamage(int damage, Element element);
	public int onReceiveHealing(int amount);
	public Status getStatus();
	public String getStatusName();
	public Actor getSource();
	public Actor getTarget();
	public ActionModifier getTargetModifier();
}
