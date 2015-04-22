package edu.ycp.cs320spring2015.oubliation.client;

import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;
import edu.ycp.cs320spring2015.oubliation.shared.behavior.Behavior;
import edu.ycp.cs320spring2015.oubliation.shared.behavior.Effect;

public class BattleAction {
	private Actor source;
	private Actor[] targets;
	private Behavior behavior;
	private int priority;
	
	public BattleAction(Actor source, Actor[] targets, Behavior behavior) {
		this.source = source;
		this.targets = targets;
		this.behavior = behavior;
		priority = source.get;
	}
	
	public void apply() {
		for (Actor target : targets) {
			behavior.apply(source, target);
		}
	}
	
	public int getPriority() {
		return priority;
	}
}
