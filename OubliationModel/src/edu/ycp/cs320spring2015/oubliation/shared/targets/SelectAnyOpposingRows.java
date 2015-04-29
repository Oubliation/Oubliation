package edu.ycp.cs320spring2015.oubliation.shared.targets;

import edu.ycp.cs320spring2015.oubliation.shared.behavior.Behavior;

public class SelectAnyOpposingRows implements TargetAdaptor<BattleController> {
	private static final long serialVersionUID = -9155824143190781780L;

	@Override
	public void apply(BattleController controller, Behavior behavior) {
		controller.selectAnyOpposingRows(behavior);
	}

}
