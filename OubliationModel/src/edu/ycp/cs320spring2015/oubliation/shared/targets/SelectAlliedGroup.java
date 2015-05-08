package edu.ycp.cs320spring2015.oubliation.shared.targets;

import edu.ycp.cs320spring2015.oubliation.shared.behavior.Behavior;

public class SelectAlliedGroup implements TargetAdaptor {
	private static final long serialVersionUID = -2558189665443185359L;

	@Override
	public void apply(PartyController controller, Behavior behavior) {
		controller.selectAlliedGroup(behavior);
	}

}
