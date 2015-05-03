package edu.ycp.cs320spring2015.oubliation.shared.targets;

import java.io.Serializable;

import edu.ycp.cs320spring2015.oubliation.shared.behavior.Behavior;

public interface TargetAdaptor<T extends PartyController> extends Serializable {
	public void apply(T controller, Behavior behavior);
}
