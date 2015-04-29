package edu.ycp.cs320spring2015.oubliation.shared.targets;

import edu.ycp.cs320spring2015.oubliation.shared.behavior.Behavior;

public class SelectAlliedColumns implements TargetAdaptor<PartyController> {
	private static final long serialVersionUID = -9083673677854259725L;

	@Override
	public void apply(PartyController controller, Behavior behavior) {
		controller.selectAlliedColumns(behavior);
	}

}
