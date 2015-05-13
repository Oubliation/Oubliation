package edu.ycp.cs320spring2015.oubliation.shared.targets;

import java.util.Random;

import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;
import edu.ycp.cs320spring2015.oubliation.shared.behavior.Behavior;

public class HazardAi implements PartyController {
	private static final long serialVersionUID = -5996294505700075201L;
	
	private Actor actorSource;
	private Actor[] allies;
	private ActionReciever reciever;
	
	public interface ActionReciever {
		public void apply(ActorAction action);
	}
	
	public HazardAi(Actor actorSource, Actor[] allies, ActionReciever reciever) {
		this.actorSource = actorSource;
		this.allies = allies;
		this.reciever = reciever;
	}
	
	public void select() {
		actorSource.selectAnyBehavior(this);
	}
	
	protected Actor getActorSource() {
		return actorSource;
	}
	protected Actor[] getAllies() {
		return allies;
	}
	protected ActionReciever getReciever() {
		return reciever;
	}

	@Override
	public void selectAllies(Behavior behavior, TargetFilter filter) {
		Actor[][] targets = filter.filter(actorSource, allies);
		reciever.apply(new ActorAction(actorSource, targets[(new Random()).nextInt(targets.length)], behavior));

	}

	@Override
	public void selectOpposition(Behavior behavior, TargetFilter filter) {
		throw new IllegalStateException();
	}

}
