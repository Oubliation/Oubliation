package edu.ycp.cs320spring2015.oubliation.client;

import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;
import edu.ycp.cs320spring2015.oubliation.shared.items.Effect;

public class BattleAction {
	private Actor source;
	private Actor[] targets;
	private Effect effect;
	private int priority;
	
	public BattleAction(Actor source, Actor[] targets, Effect effect) {
		this.source = source;
		this.targets = targets;
		this.effect = effect;
		priority = 0;
	}
	
	public void apply() {
		for (Actor target : targets) {
			effect.apply(source, target);
		}
	}
	
	public int getPriority() {
		return priority;
	}
}
