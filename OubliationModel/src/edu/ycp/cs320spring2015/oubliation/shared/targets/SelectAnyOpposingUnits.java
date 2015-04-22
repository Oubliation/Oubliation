package edu.ycp.cs320spring2015.oubliation.shared.targets;

import edu.ycp.cs320spring2015.oubliation.shared.BattleController;
import edu.ycp.cs320spring2015.oubliation.shared.items.Effect;

public class SelectAnyOpposingUnits implements TargetAdaptor<BattleController> {

	@Override
	public void apply(BattleController controller, Effect effect) {
		controller.selectAnyOpposingUnits(effect);
	}

}
