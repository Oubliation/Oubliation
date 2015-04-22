package edu.ycp.cs320spring2015.oubliation.shared.targets;

import edu.ycp.cs320spring2015.oubliation.shared.PartyController;
import edu.ycp.cs320spring2015.oubliation.shared.items.Effect;

public class SelectAlliedColumns implements TargetAdaptor<PartyController> {

	@Override
	public void apply(PartyController controller, Effect effect) {
		controller.selectAlliedColumns(effect);
		
	}

}
