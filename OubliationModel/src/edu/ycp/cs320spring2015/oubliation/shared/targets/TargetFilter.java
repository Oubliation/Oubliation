package edu.ycp.cs320spring2015.oubliation.shared.targets;

import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;

public interface TargetFilter {
	
	public Actor[][] filter(Actor source, Actor[] targets);
}
