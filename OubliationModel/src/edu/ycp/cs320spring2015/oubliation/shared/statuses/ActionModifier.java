package edu.ycp.cs320spring2015.oubliation.shared.statuses;

interface ActionModifier {
	public boolean getActionHitTest(int accuracy);
	public void onActionDamage(int damage);
	public void onActionHeal(int amount);
}
