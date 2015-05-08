package edu.ycp.cs320spring2015.oubliation.shared.targets;

import edu.ycp.cs320spring2015.oubliation.shared.behavior.Behavior;

public class SelectFrontOpposingUnits implements TargetAdaptor {
	private static final long serialVersionUID = 9157826167452201741L;

	@Override
	public void apply(PartyController controller, Behavior behavior) {
		controller.selectFrontOpposingUnits(behavior);
	}

}
