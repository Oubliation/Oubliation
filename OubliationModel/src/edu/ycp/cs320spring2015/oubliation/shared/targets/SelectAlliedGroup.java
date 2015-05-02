package edu.ycp.cs320spring2015.oubliation.shared.targets;

import edu.ycp.cs320spring2015.oubliation.shared.behavior.Behavior;

public class SelectAlliedGroup<T extends PartyController> implements TargetAdaptor<T> {
	private static final long serialVersionUID = -2558189665443185359L;

	@Override
	public void apply(T controller, Behavior behavior) {
		controller.selectAlliedGroup(behavior);
	}

}
