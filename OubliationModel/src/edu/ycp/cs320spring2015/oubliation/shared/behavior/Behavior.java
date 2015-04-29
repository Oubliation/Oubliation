package edu.ycp.cs320spring2015.oubliation.shared.behavior;

import java.io.Serializable;
import java.util.Random;

import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;
import edu.ycp.cs320spring2015.oubliation.shared.category.Element;
import edu.ycp.cs320spring2015.oubliation.shared.targets.BattleController;
import edu.ycp.cs320spring2015.oubliation.shared.targets.TargetAdaptor;

//fold into target
public class Behavior implements Serializable {
	private static final long serialVersionUID = 7803355699381784195L;
	protected Behavior() {}
	
	private Effect primaryEffect;
	private TargetAdaptor<BattleController> target;
	private int healthDeltaMin;
	private int healthDeltaRange;
	private int accuracy;
	private Element element;
	private Effect secondaryEffect;
	private int potency;
	
	private String[] descriptors;
	
	public Behavior(Effect primaryEffect, String[] descriptors) {
		this.primaryEffect = primaryEffect;
		
		healthDeltaMin = 0;
		healthDeltaRange = 0;
		accuracy = Integer.MAX_VALUE;
		potency = 0;
		
		assert(descriptors.length > 0 && descriptors.length <= 2);
		this.descriptors = descriptors;
	}
	
	
	
	public void select(BattleController controller) {
		target.apply(controller, this);
	}
	
	public ActionResolution apply(Actor source, Actor target) {
		ActionResolution resolution = ActionResolution.miss; 
		if (target.hitTest(accuracy+source.getAccuracyMod())) {
			
			resolution = ActionResolution.hit;
			int healthDelta = healthDeltaMin+(new Random()).nextInt(healthDeltaRange);
			boolean critical; 
			if (Math.random() < 0.16) {
				healthDelta *= 1.5;
				critical = true;
			} else {
				healthDelta *= 1;
				critical = false;
			}
			
			if (primaryEffect != null) {
				primaryEffect.apply(source, target, healthDelta);
			}
			
			if (healthDeltaMin < 0 || healthDeltaMin == 0 && healthDeltaRange < 0) {
				source.receiveDamage(-healthDelta, element);
			} else if (healthDeltaMin > 0 || healthDeltaMin == 0 && healthDeltaRange > 0) {
				source.receiveHealing(healthDelta);
			}
			if (secondaryEffect != null && target.hitTest(potency+source.getAccuracyMod())) {
				resolution = ActionResolution.fullHit;
				secondaryEffect.apply(source, target, healthDelta);
			}
			
			if (critical) { 
				switch(resolution) {
				case fullHit:
					resolution = ActionResolution.criticalFullHit;
					break;
				case hit:
					resolution = ActionResolution.criticalHit;
					break;
				default:
					throw new IllegalStateException();
				}
			}
		}
		return resolution;
	}
	
	public String getPrimaryDescriptor() {
		return descriptors[0];
	}
	public String getSecondaryDescriptor() {
		return descriptors[1];
	}
}
