package edu.ycp.cs320spring2015.oubliation.shared.statuses;

import edu.ycp.cs320spring2015.oubliation.shared.BattleController;
import edu.ycp.cs320spring2015.oubliation.shared.EntityClass;
import edu.ycp.cs320spring2015.oubliation.shared.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;
import edu.ycp.cs320spring2015.oubliation.shared.transfer.StatusMemento;

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

	protected abstract int getParam();
	
	public StatusMemento getMemento() {
		return new StatusMemento(this.getName(), this.getParam());
	}
}
