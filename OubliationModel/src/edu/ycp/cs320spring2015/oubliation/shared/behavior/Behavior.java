package edu.ycp.cs320spring2015.oubliation.shared.behavior;

import java.io.Serializable;
import java.util.Random;

import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;
import edu.ycp.cs320spring2015.oubliation.shared.category.Element;
import edu.ycp.cs320spring2015.oubliation.shared.statuses.Status;
import edu.ycp.cs320spring2015.oubliation.shared.targets.BattleController;
import edu.ycp.cs320spring2015.oubliation.shared.targets.TargetAdaptor;

//fold into target
public class Behavior implements Serializable {
	private static final long serialVersionUID = 7803355699381784195L;
	protected Behavior() {}
	
	Effect effect;
	TargetAdaptor<BattleController> target;
	int healthDeltaMin;
	int healthDeltaRange;
	int accuracy;
	Element element;
	Status status;
	int potency;
	
	public Behavior(Effect effect) {
		this.effect = effect;
		
		healthDeltaMin = 0;
		healthDeltaRange = 0;
		accuracy = Integer.MAX_VALUE;
		potency = 0;
	}
	
	public void select(BattleController controller) {
		target.apply(controller, this);
	}
	
	public void apply(Actor source, Actor target) {
		if (target.hitTest(accuracy+source.getAccuracyMod())) {
			int healthDelta = healthDeltaMin+(new Random()).nextInt(healthDeltaRange);
			if (effect != null) {
				effect.apply(source, target, healthDelta);
			}
			
			if (healthDeltaMin < 0 || healthDeltaMin == 0 && healthDeltaRange < 0) {
				source.receiveDamage(-healthDelta, element);
			} else if (healthDeltaMin > 0 || healthDeltaMin == 0 && healthDeltaRange > 0) {
				source.receiveHealing(healthDelta);
			}
			if (target.hitTest(potency+source.getAccuracyMod())) {
				target.setStatus(status);
			}
		}
	}
}
