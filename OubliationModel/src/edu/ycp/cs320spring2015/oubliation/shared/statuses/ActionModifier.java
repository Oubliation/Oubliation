package edu.ycp.cs320spring2015.oubliation.shared.statuses;

import edu.ycp.cs320spring2015.oubliation.shared.category.Element;
import edu.ycp.cs320spring2015.oubliation.shared.targets.ActionTarget;

public interface ActionModifier {
	public boolean onHitTest(int accuracy);
	public int onReceiveDamage(int damage, Element element);
	public int onReceiveHealing(int amount);
	public Status getStatus();
	public String getStatusName();
	public ActionTarget getSource();
	public ActionTarget getTarget();
	public ActionModifier getTargetModifier();
}
