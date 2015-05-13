package edu.ycp.cs320spring2015.oubliation.shared.targets;

import java.io.Serializable;

import edu.ycp.cs320spring2015.oubliation.shared.behavior.Behavior;

public interface PartyController extends Serializable {
	public void selectAllies(Behavior behavior, TargetFilter filter);
	public void selectOpposition(Behavior behavior, TargetFilter filter);
}
