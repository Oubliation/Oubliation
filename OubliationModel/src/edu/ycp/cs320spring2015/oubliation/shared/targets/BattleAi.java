package edu.ycp.cs320spring2015.oubliation.shared.targets;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;
import edu.ycp.cs320spring2015.oubliation.shared.behavior.Behavior;



public class BattleAi extends HazardAi implements BattleController {
	
	Actor[] opponents;
	
	public BattleAi(Actor source, Actor[] allies,
			Actor[] opponents, PriorityQueue<BattleAction> actionQueue) {
		super(source, allies, actionQueue);
		this.opponents = opponents;
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
	public void select() {
		getActorSource().selectAnyBehavior(this);
	}

	@Override
	public void selectAnyOpposingUnits(Behavior behavior) {
		getActionQueue().add(new BattleAction(getActorSource(), new Actor[] {opponents[(new Random()).nextInt(opponents.length)]}, behavior));

	}

	@Override
	public void selectFrontOpposingUnits(Behavior behavior) {
		getActionQueue().add(new BattleAction(getActorSource(), new Actor[] {opponents[(new Random()).nextInt(Math.min(opponents.length, 3))]}, behavior));

	}

	@Override
	public void selectAnyOpposingRows(Behavior behavior) {
		Actor[][] targetRows = splitRows(opponents);
		getActionQueue().add(new BattleAction(getActorSource(), targetRows[(new Random()).nextInt(targetRows.length)], behavior));

	}

	@Override
	public void selectFrontOpposingRow(Behavior behavior) {
		getActionQueue().add(new BattleAction(getActorSource(), Arrays.copyOfRange(opponents, 0, Math.min(opponents.length, 3)), behavior));

	}

	@Override
	public void selectAnyOpposingColumns(Behavior behavior) {
		Actor[][] targetCols = splitColumns(opponents);
		getActionQueue().add(new BattleAction(getActorSource(), targetCols[(new Random()).nextInt(targetCols.length)], behavior));

	}

	@Override
	public void selectOpposingGroup(Behavior behavior) {
		getActionQueue().add(new BattleAction(getActorSource(), opponents, behavior));

	}

}
