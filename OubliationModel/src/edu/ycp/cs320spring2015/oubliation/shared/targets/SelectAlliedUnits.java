package edu.ycp.cs320spring2015.oubliation.shared.targets;

import edu.ycp.cs320spring2015.oubliation.shared.behavior.Behavior;

public class SelectAlliedUnits implements TargetAdaptor {
	private static final long serialVersionUID = 3704785829459163544L;

	@Override
	public void apply(PartyController controller, Behavior behavior) {
		controller.selectAlliedUnits(behavior);
	}

}
