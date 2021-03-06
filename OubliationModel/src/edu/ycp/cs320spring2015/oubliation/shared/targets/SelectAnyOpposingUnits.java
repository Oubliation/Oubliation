package edu.ycp.cs320spring2015.oubliation.shared.targets;

import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;
import edu.ycp.cs320spring2015.oubliation.shared.behavior.Behavior;

public class SelectAnyOpposingUnits implements TargetAdaptor {
	private static final long serialVersionUID = -9135467600036249494L;

	@Override
	public void apply(PartyController controller, Behavior behavior) {
		controller.selectOpposition(behavior, new TargetFilter() {

			@Override
			public Actor[][] filter(Actor source, Actor[] targets) {
				return TargetUtils.splitUnits(targets, 6);
			}
			
		});
	}

}
