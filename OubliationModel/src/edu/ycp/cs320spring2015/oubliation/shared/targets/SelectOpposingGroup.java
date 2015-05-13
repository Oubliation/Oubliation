package edu.ycp.cs320spring2015.oubliation.shared.targets;

import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;
import edu.ycp.cs320spring2015.oubliation.shared.behavior.Behavior;

public class SelectOpposingGroup implements TargetAdaptor {
	private static final long serialVersionUID = 7877565233298707664L;
	public SelectOpposingGroup() {}

	@Override
	public void apply(PartyController controller, Behavior behavior) {
		controller.selectOpposition(behavior, new TargetFilter() {
			@Override
			public Actor[][] filter(Actor source, Actor[] targets) {
				return TargetUtils.splitGroup(targets);
			}
			
		});
	}

}
