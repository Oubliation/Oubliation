package edu.ycp.cs320spring2015.oubliation.shared.statuses;

import edu.ycp.cs320spring2015.oubliation.shared.EntityClass;
import edu.ycp.cs320spring2015.oubliation.shared.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;
import edu.ycp.cs320spring2015.oubliation.shared.targets.PartyController;

public abstract class Status extends EntityClass {
	private static final long serialVersionUID = -1230357693092494778L;
	protected Status() {}
	
	protected Status(NameTag nameTag) {
		super(nameTag);
	}
	
	public abstract PartyController onTurnStart(PartyController controller);
	public abstract ActionModifier getActionModifier(final Actor source, Actor target);
	public abstract ActionModifier getTargetModifier(final Actor target);
	public abstract Status refresh();
}
