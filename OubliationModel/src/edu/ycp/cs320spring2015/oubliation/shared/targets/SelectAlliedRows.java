package edu.ycp.cs320spring2015.oubliation.shared.targets;

import edu.ycp.cs320spring2015.oubliation.shared.behavior.Behavior;

public class SelectAlliedRows<T extends PartyController> implements TargetAdaptor<T> {
	private static final long serialVersionUID = -5756167498706216661L;

	@Override
	public void apply(T controller, Behavior behavior) {
		controller.selectAlliedRows(behavior);
	}

}
