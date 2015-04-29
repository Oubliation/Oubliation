package edu.ycp.cs320spring2015.oubliation.shared.targets;

import edu.ycp.cs320spring2015.oubliation.shared.behavior.Behavior;

public class SelectAnyOpposingUnits implements TargetAdaptor<BattleController> {
	private static final long serialVersionUID = -9135467600036249494L;

	@Override
	public void apply(BattleController controller, Behavior behavior) {
		controller.selectAnyOpposingUnits(behavior);
	}

}