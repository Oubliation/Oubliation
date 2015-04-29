package edu.ycp.cs320spring2015.oubliation.shared.statuses;

import edu.ycp.cs320spring2015.oubliation.shared.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;
import edu.ycp.cs320spring2015.oubliation.shared.category.Element;
import edu.ycp.cs320spring2015.oubliation.shared.targets.BattleController;

public class Healthy extends Status {
	private static final long serialVersionUID = -245305006902248841L;
	
	public Healthy(Actor parent) {
		super(new NameTag("Healthy", "Oll Korrect"), parent);
	}
	
	@Override
	public BattleController onTurnStart(BattleController controller) {
		return controller;
	}
	
	public ActionModifier getActionModifier(final Status target) {
		return new ActionModifier() {

			@Override
			public boolean getActionHitTest(int accuracy) {
				return target.onRecieveHitTest(accuracy);
			}

			@Override
			public void onActionDamage(int amount, Element element) {
				target.onReceiveDamage(amount, element);
			}

			@Override
			public void onActionHeal(int amount) {
				target.onReceiveHealing(amount);
				
			}
		};
	}
	
	@Override
	public boolean onRecieveHitTest(int accuracy) {
		return getParent().hitTest(accuracy);
	}
	@Override
	public void onReceiveDamage(int damage, Element element) {
		getParent().receiveDamage(damage, element);
	}
	@Override
	public void onReceiveHealing(int amount) {
		getParent().receiveHealing(amount);
	}
	
	@Override
	protected int getParam() {
		return -1;
	}
}
