package edu.ycp.cs320spring2015.oubliation.shared.statuses;

import edu.ycp.cs320spring2015.oubliation.shared.category.Element;

interface ActionModifier {
	public boolean getActionHitTest(int accuracy);
	public void onActionDamage(int damage, Element element);
	public void onActionHeal(int amount);
}
