package edu.ycp.cs320spring2015.oubliation.shared.targets;

import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;
import edu.ycp.cs320spring2015.oubliation.shared.behavior.Behavior;

public class SelectAlliedRows implements TargetAdaptor {
	private static final long serialVersionUID = -5756167498706216661L;

	@Override
	public void apply(PartyController controller, Behavior behavior) {
		controller.selectAllies(behavior, new TargetFilter() {
			@Override
			public Actor[][] filter(Actor source, Actor[] targets) {
				return TargetUtils.splitRows(targets, 6);
			}
		});
	}

}
