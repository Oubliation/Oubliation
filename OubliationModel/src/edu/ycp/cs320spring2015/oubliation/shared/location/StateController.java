package edu.ycp.cs320spring2015.oubliation.shared.location;

import edu.ycp.cs320spring2015.oubliation.shared.actor.nonplayer.EnemyActor;

public interface StateController {
	public void battle(EnemyActor[] enemies);
	public void exit();
}
