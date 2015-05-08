package edu.ycp.cs320spring2015.oubliation.shared.targets;

import java.io.Serializable;

import edu.ycp.cs320spring2015.oubliation.shared.behavior.Behavior;

public interface TargetAdaptor extends Serializable {
	public void apply(PartyController controller, Behavior behavior);
}
