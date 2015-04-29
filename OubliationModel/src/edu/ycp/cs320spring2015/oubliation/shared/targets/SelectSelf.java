package edu.ycp.cs320spring2015.oubliation.shared.targets;

import edu.ycp.cs320spring2015.oubliation.shared.behavior.Behavior;

public class SelectSelf implements TargetAdaptor<PartyController> {
	private static final long serialVersionUID = -3591833541038681027L;

	@Override
	public void apply(PartyController controller, Behavior behavior) {
		controller.selectSelf(behavior);
	}
}
