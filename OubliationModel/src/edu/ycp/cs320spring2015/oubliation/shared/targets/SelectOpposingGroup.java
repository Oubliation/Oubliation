package edu.ycp.cs320spring2015.oubliation.shared.targets;

import edu.ycp.cs320spring2015.oubliation.shared.BattleController;
import edu.ycp.cs320spring2015.oubliation.shared.behavior.Behavior;
import edu.ycp.cs320spring2015.oubliation.shared.behavior.Effect;

public class SelectOpposingGroup implements TargetAdaptor<BattleController> {
	private static final long serialVersionUID = 7877565233298707664L;
	public SelectOpposingGroup() {}

	@Override
	public void apply(BattleController controller, Behavior behavior) {
		controller.selectOpposingGroup(behavior);
	}

}
