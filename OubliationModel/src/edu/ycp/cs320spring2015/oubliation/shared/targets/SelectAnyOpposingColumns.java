package edu.ycp.cs320spring2015.oubliation.shared.targets;

import edu.ycp.cs320spring2015.oubliation.shared.behavior.Behavior;

public class SelectAnyOpposingColumns implements TargetAdaptor<BattleController> {
	private static final long serialVersionUID = -5341181613812237236L;

	@Override
	public void apply(BattleController controller, Behavior behavior) {
		controller.selectAnyOpposingColumns(behavior);
		
	}

}
