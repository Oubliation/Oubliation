package edu.ycp.cs320spring2015.oubliation.shared.targets;

import edu.ycp.cs320spring2015.oubliation.shared.PartyController;
import edu.ycp.cs320spring2015.oubliation.shared.behavior.Effect;

public class SelectAlliedGroup implements TargetAdaptor<PartyController> {

	@Override
	public void apply(PartyController controller, Effect effect) {
		controller.selectAlliedGroup(effect);
	}

}
