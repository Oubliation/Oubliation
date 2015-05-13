package edu.ycp.cs320spring2015.oubliation.shared.targets;

import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;
import edu.ycp.cs320spring2015.oubliation.shared.behavior.Behavior;

public class SelectAnyOpposingRows implements TargetAdaptor {
	private static final long serialVersionUID = -9155824143190781780L;

	@Override
	public void apply(PartyController controller, Behavior behavior) {
		controller.selectOpposition(behavior, new TargetFilter() {
			@Override
			public Actor[][] filter(Actor source, Actor[] targets) {
				return TargetUtils.splitRows(targets, 6);
			}
		});
	}

}
