package edu.ycp.cs320spring2015.oubliation.shared.actor;

import edu.ycp.cs320spring2015.oubliation.shared.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.category.Element;
import edu.ycp.cs320spring2015.oubliation.shared.statuses.Healthy;
import edu.ycp.cs320spring2015.oubliation.shared.statuses.Status;
import edu.ycp.cs320spring2015.oubliation.shared.targets.HasBehavior;
import edu.ycp.cs320spring2015.oubliation.shared.targets.PartyController;

public class NoActor extends Actor {
	private static final long serialVersionUID = -3331575690975116134L;
	
	private HasBehavior hasBehavior;
	
	public NoActor(HasBehavior hasBehavior) {
		super(new NameTag(null, null), 0, new Healthy(), null);
		this.hasBehavior = hasBehavior;
	}

	@Override
	public int getHitCount() {
		return 0;
	}

	@Override
	public int getMaxHealth() {
		return 0;
	}

	@Override
	public int getInitiative() {
		return 0;
	}

	@Override
	public int getAttackMod() {
		return 0;
	}

	@Override
	public int getAccuracyMod() {
		return 0;
	}

	@Override
	public int getArmorRank() {
		return 0;
	}

	@Override
	protected int getEvasion() {
		return 0;
	}
	
	
	public boolean hitTest(int accuracy) {
		return false;
	}
	public int receiveHealing(int amount) {
		return 0;
	}
	public int receiveDamage(int amount, Element element) {
		return 0;
	}
	public void setStatus(Status status) {
	}
	
	public void revive(int healing) {
	}

	@Override
	public void selectAnyBehavior(PartyController controller) {
		hasBehavior.selectAnyBehavior(controller);
	}

}
