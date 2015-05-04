package edu.ycp.cs320spring2015.oubliation.shared.targets;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;
import edu.ycp.cs320spring2015.oubliation.shared.behavior.Behavior;

public class HazardAi implements PartyController {
	
	private HasBehavior<PartyController> behaviorSource;
	private Actor actorSource;
	private Actor[] allies;
	private PriorityQueue<BattleAction> actionQueue;
	
	public HazardAi(Actor actorSource, Actor[] allies, PriorityQueue<BattleAction> actionQueue) {
		this.behaviorSource = null;
		this.actorSource = actorSource;
		this.allies = allies;
		this.actionQueue = actionQueue;
	}
	
	public HazardAi(HasBehavior<PartyController> behaviorSource, Actor[] allies, PriorityQueue<BattleAction> actionQueue) {
		this.behaviorSource = behaviorSource;
		this.actorSource = null;
		this.allies = allies;
		this.actionQueue = actionQueue;
	}
	
	public void select() {
		behaviorSource.selectAnyBehavior(this);
	}
	
	protected Actor getActorSource() {
		return actorSource;
	}
	protected Actor[] getAllies() {
		return allies;
	}
	protected PriorityQueue<BattleAction> getActionQueue() {
		return actionQueue;
	}
	
	private Actor[][] splitRows(Actor[] targets) {
		int numRows = (targets.length + 2) / 3;
		Actor[][] targetRows = new Actor[numRows][];
		targetRows[0] = Arrays.copyOfRange(targets, 0, targets.length);
		if (numRows == 2) {
			 targetRows[1] = Arrays.copyOfRange(targets, 3, targets.length);
		}
		return targetRows;
	}
	private Actor[][] splitColumns(Actor[] targets) {
		int numCols = Math.min(targets.length, 3);
		Actor[][] targetCols = new Actor[numCols][];
		for (int count=0; count<numCols; count+=1) {
			if (targets.length < count+4) {
				targetCols[count] = new Actor[] { targets[count] };
			} else {
				targetCols[count] = new Actor[] { targets[count], targets[count+3] };
			}
		}
		return targetCols;
	}


	@Override
	public void selectSelf(Behavior behavior) {
		actionQueue.add(new BattleAction(actorSource, new Actor[] {actorSource}, behavior));
	}

	@Override
	public void selectAlliedUnits(Behavior behavior) {
		actionQueue.add(new BattleAction(actorSource, new Actor[] {allies[(new Random()).nextInt(allies.length)]}, behavior));
	}

	@Override
	public void selectAlliedRows(Behavior behavior) {
		Actor[][] targetRows = splitRows(allies);
		actionQueue.add(new BattleAction(actorSource, targetRows[(new Random()).nextInt(targetRows.length)], behavior));

	}

	@Override
	public void selectAlliedColumns(Behavior behavior) {
		Actor[][] targetCols = splitColumns(allies);
		actionQueue.add(new BattleAction(actorSource, targetCols[(new Random()).nextInt(targetCols.length)], behavior));

	}

	@Override
	public void selectAlliedGroup(Behavior behavior) {
		actionQueue.add(new BattleAction(actorSource, allies, behavior));

	}

	@Override
	public void moveParty(int forwardDist, int sideDist) {
		throw new IllegalStateException();
	}

	@Override
	public void toTown() {
		// TODO Auto-generated method stub
		
	}

}
