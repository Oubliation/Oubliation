package edu.ycp.cs320spring2015.oubliation.shared.targets;

import edu.ycp.cs320spring2015.oubliation.shared.BattleController;
import edu.ycp.cs320spring2015.oubliation.shared.behavior.Effect;

public class SelectAnyOpposingRows implements TargetAdaptor<BattleController> {

	@Override
	public void apply(BattleController controller, Effect effect) {
		controller.selectAnyOpposingRows(effect);
	}

}
