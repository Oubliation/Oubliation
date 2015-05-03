package edu.ycp.cs320spring2015.oubliation.shared.statuses;

import edu.ycp.cs320spring2015.oubliation.shared.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;
import edu.ycp.cs320spring2015.oubliation.shared.targets.BattleController;

public class Corpse extends Status {
	private static final long serialVersionUID = -8865864496098907905L;

	public Corpse() {
		super(new NameTag("Corpse", "A lifeless, rotting carcass"));
	}
	
	public BattleController onTurnStart(BattleController controller) {
		return null;
	}
	
	public ActionModifier getActionModifier(final Actor source, Actor target) {
		return null;
	}
	public ActionModifier getTargetModifier(final Actor target) {
		return null;
	}
	
	@Override
	public Status refresh() {
		return new Corpse();
	}
}
