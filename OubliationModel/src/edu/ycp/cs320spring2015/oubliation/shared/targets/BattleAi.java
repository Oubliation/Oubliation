package edu.ycp.cs320spring2015.oubliation.shared.targets;

import java.util.Random;

import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;
import edu.ycp.cs320spring2015.oubliation.shared.behavior.Behavior;



public class BattleAi extends HazardAi {
	private static final long serialVersionUID = 1680367725368864809L;
	
	Actor[] opponents;
	
	public BattleAi(Actor source, Actor[] allies,
			Actor[] opponents, ActionReciever reciever) {
		super(source, allies, reciever);
		this.opponents = opponents;
	}
	
	@Override
	public void select() {
		getActorSource().selectAnyBehavior(this);
	}

	@Override
	public void selectOpposition(Behavior behavior, TargetFilter filter) {
		Actor[][] targets = filter.filter(getActorSource(), opponents);
		getReciever().apply( new ActorAction(getActorSource(), targets[(new Random()).nextInt(targets.length)], behavior));
	}

}
