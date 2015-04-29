package edu.ycp.cs320spring2015.oubliation.shared.targets;

import edu.ycp.cs320spring2015.oubliation.shared.behavior.Behavior;

public class SelectFrontOpposingRow implements TargetAdaptor<BattleController> {
	private static final long serialVersionUID = -1600349028189732693L;

	@Override
	public void apply(BattleController controller, Behavior behavior) {
		controller.selectFrontOpposingRow(behavior);
	}

}
