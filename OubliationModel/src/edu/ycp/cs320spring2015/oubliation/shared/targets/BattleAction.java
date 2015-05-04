package edu.ycp.cs320spring2015.oubliation.shared.targets;

import java.util.LinkedList;

import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;
import edu.ycp.cs320spring2015.oubliation.shared.behavior.Behavior;

public class BattleAction {
	private Actor source;
	private Actor[] targets;
	private Behavior behavior;
	private int priority;
	
	public BattleAction(Actor source, Actor[] targets, Behavior behavior) {
		this.source = source;
		this.targets = targets;
		this.behavior = behavior;
		priority = source.getInitiative();
	}
	
	public String[] apply() {
		LinkedList<String> descriptions = new LinkedList<String>();
		descriptions.add(behavior.getActionDescriptor(source));
		for (Actor target : targets) {
			descriptions.add(behavior.apply(source.getTargetModifier(), source.getActionModifier(target)));
		}
		return descriptions.toArray(new String[descriptions.size()]);
	}
	
	public int getPriority() {
		return priority;
	}
}
