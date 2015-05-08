package edu.ycp.cs320spring2015.oubliation.shared.behavior;

import java.io.Serializable;
import java.util.Random;

import edu.ycp.cs320spring2015.oubliation.shared.category.Element;
import edu.ycp.cs320spring2015.oubliation.shared.statuses.ActionModifier;
import edu.ycp.cs320spring2015.oubliation.shared.statuses.Corpse;
import edu.ycp.cs320spring2015.oubliation.shared.targets.ActionTarget;
import edu.ycp.cs320spring2015.oubliation.shared.targets.PartyController;
import edu.ycp.cs320spring2015.oubliation.shared.targets.TargetAdaptor;

//fold into target
public class Behavior implements Serializable {
	private static final long serialVersionUID = 7803355699381784195L;
	protected Behavior() {}
	
	private Effect primaryEffect;
	private TargetAdaptor target;
	private int healthDeltaMin;
	private int healthDeltaRange;
	private int accuracy;
	private Element element;
	private Effect secondaryEffect;
	private int potency;

	private String actionDescriptor;
	private String primaryDescriptor;
	private String secondaryDescriptor;
	
	public Behavior(Effect primaryEffect,
			TargetAdaptor target, int healthDeltaMin,
			int healthDeltaRange, int accuracy, Element element,
			Effect secondaryEffect, int potency, String actionDescriptor,
			String primaryDescriptor, String secondaryDescriptor) {
		this.primaryEffect = primaryEffect;
		this.target = target;
		this.healthDeltaMin = healthDeltaMin;
		this.healthDeltaRange = healthDeltaRange;
		this.accuracy = accuracy;
		this.element = element;
		this.secondaryEffect = secondaryEffect;
		this.potency = potency;
		this.actionDescriptor = actionDescriptor;
		this.primaryDescriptor = primaryDescriptor;
		this.secondaryDescriptor = secondaryDescriptor;
	}

	public void select(PartyController controller) {
		target.apply(controller, this);
	}
	
	public String apply(ActionModifier sourceMod, ActionModifier targetMod) {
		StringBuilder description = new StringBuilder(targetMod.getTarget().getName());
		if (targetMod.onHitTest(accuracy)) {
			
			int healthDelta = healthDeltaMin+(new Random()).nextInt(healthDeltaRange);
			boolean critical; 
			if (Math.random() < 0.16) {
				description.append(" is brutally ");
				healthDelta *= 1.5;
				critical = true;
			} else {
				description.append(" is ");
				healthDelta *= 1;
				critical = false;
			}
			
			description.append(primaryDescriptor);
			if (primaryEffect != null) {
				description.append(primaryEffect.apply(sourceMod, targetMod, healthDelta));
			}
			
			if (healthDeltaMin != 0 || healthDeltaRange != 0) {
				description.append(" for ");
				if (healthDeltaMin < 0 || healthDeltaMin == 0 && healthDeltaRange < 0) {
					description.append(sourceMod.onReceiveDamage(-healthDelta, element));
				} else if (healthDeltaMin > 0 || healthDeltaMin == 0 && healthDeltaRange > 0) {
					description.append(sourceMod.onReceiveHealing(healthDelta));
				}
				description.append(" health");
				if (critical) {
					description.append("!");
				} else {
					description.append(".");
				}
				if (targetMod.getStatus().getClass().equals(Corpse.class)) {
					description.append("!!!!!!");
					description.append("");
					description.append(" dies a painful death!");
				}
				
				if (secondaryEffect != null && critical || targetMod.onHitTest(potency)) {
					//TODO: pronouns
					description.append(" ");
					description.append(secondaryDescriptor);
					description.append(secondaryEffect.apply(sourceMod, targetMod, healthDelta));
				}
			}
		} else  {
			description.append("dodges!");
		}
		return description.toString();
	}
	
	public String getActionDescriptor(ActionTarget source) {
		return source.getName() +" "+ actionDescriptor;
	}
}
