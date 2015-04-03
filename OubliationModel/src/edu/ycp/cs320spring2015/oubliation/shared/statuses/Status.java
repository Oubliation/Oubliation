package edu.ycp.cs320spring2015.oubliation.shared.statuses;

import edu.ycp.cs320spring2015.oubliation.shared.EntityClass;
import edu.ycp.cs320spring2015.oubliation.shared.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.BattleController;

public abstract class Status extends EntityClass {
	private static final long serialVersionUID = -1230357693092494778L;
	
	Actor parent;
	
	public Status(Actor parent) {
		throw new UnsupportedOperationException();
	}
	
	protected Status(NameTag nameTag, Actor parent) {
		super(nameTag);
		this.parent = parent;
	}
	
	public Actor getParent() {
		return parent;
	}

	public abstract BattleController onTurnStart(BattleController controller);
	public abstract ActionModifier getActionModifier(final Status target);
	public abstract boolean onRecieveHitTest(int accuracy);
	public abstract void onReceiveDamage(int damage);
	public abstract void onReceiveHealing(int amount);
	
	public static Status getStatus(Actor actor, String statusName) {
		switch (statusName) {
			case "Healthy": return new Healthy(actor);
			case "Corpse": return new Healthy(actor);
		}
		throw new UnsupportedOperationException("Status not implemented in getStatus");
	}
}
