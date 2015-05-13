package edu.ycp.cs320spring2015.oubliation.shared.targets;

import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;
import edu.ycp.cs320spring2015.oubliation.shared.behavior.Behavior;

public class SelectAlliedColumns implements TargetAdaptor {
	private static final long serialVersionUID = -9083673677854259725L;

	@Override
	public void apply(PartyController controller, Behavior behavior) {
		controller.selectAllies(behavior, new TargetFilter() {
			@Override
			public Actor[][] filter(Actor source, Actor[] targets) {
				return TargetUtils.splitColumns(targets);
			}
			
		});
	}

}
