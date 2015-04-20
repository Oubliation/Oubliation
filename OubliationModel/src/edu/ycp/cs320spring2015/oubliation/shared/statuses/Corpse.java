package edu.ycp.cs320spring2015.oubliation.shared.statuses;

import edu.ycp.cs320spring2015.oubliation.shared.BattleController;
import edu.ycp.cs320spring2015.oubliation.shared.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;

public class Corpse extends Status {
	private static final long serialVersionUID = -8865864496098907905L;

	public Corpse(Actor actor) {
		super(new NameTag("Corpse", "A lifeless, rotting carcass"), actor);
	}
	
	public BattleController onTurnStart(BattleController controller) {
		return null;
	}
	
	public ActionModifier getActionModifier(final Status target) {
		return null;
	}

	@Override
	public boolean onRecieveHitTest(int accuracy) {
		return false;
	}

	@Override
	public void onReceiveDamage(int damage) {}

	@Override
	public void onReceiveHealing(int amount) {}
	
	@Override
	protected int getParam() {
		return -1;
	}
}
