package edu.ycp.cs320spring2015.oubliation.shared.targets;

import edu.ycp.cs320spring2015.oubliation.shared.behavior.Behavior;

public class SelectAlliedColumns<T extends PartyController> implements TargetAdaptor<T> {
	private static final long serialVersionUID = -9083673677854259725L;

	@Override
	public void apply(T controller, Behavior behavior) {
		controller.selectAlliedColumns(behavior);
	}

}
