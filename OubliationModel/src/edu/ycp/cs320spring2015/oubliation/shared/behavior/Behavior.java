package edu.ycp.cs320spring2015.oubliation.shared.behavior;

import java.io.Serializable;

import edu.ycp.cs320spring2015.oubliation.shared.BattleController;
import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;
import edu.ycp.cs320spring2015.oubliation.shared.category.Element;
import edu.ycp.cs320spring2015.oubliation.shared.statuses.Status;
import edu.ycp.cs320spring2015.oubliation.shared.targets.TargetAdaptor;

//fold into target
public class Behavior implements Serializable {
	private static final long serialVersionUID = 7803355699381784195L;
	protected Behavior() {}
	
	Effect effect;
	TargetAdaptor<BattleController> target;
	int powerMin;
	int powerRange;
	int accuracy;
	Element element;
	Status status;
	int potency;
	
	public void select(BattleController controller) {
		target.apply(controller, this);
	}
	
	public void apply(Actor source, Actor target) {
		aa
	}
}
