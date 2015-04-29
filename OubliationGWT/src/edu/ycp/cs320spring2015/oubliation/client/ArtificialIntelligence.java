package edu.ycp.cs320spring2015.oubliation.client;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;
import edu.ycp.cs320spring2015.oubliation.shared.behavior.Behavior;
import edu.ycp.cs320spring2015.oubliation.shared.targets.BattleController;



public class ArtificialIntelligence implements BattleController {
	
	Actor source;
	Actor[] allies;
	Actor[] opponents;
	PriorityQueue<BattleAction> actionQueue;
	ViewBattle battle;
	
	public ArtificialIntelligence(Actor source, Actor[] allies,
			Actor[] opponents, PriorityQueue<BattleAction> actionQueue,
			ViewBattle battle) {
		this.source = source;
		this.allies = allies;
		this.opponents = opponents;
		this.actionQueue = actionQueue;
		this.battle = battle;
		
		source.selectAnyBattleBehavior(this);
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
		actionQueue.add(new BattleAction(source, new Actor[] {source}, behavior));
	}

	@Override
	public void selectAlliedUnits(Behavior behavior) {
		actionQueue.add(new BattleAction(source, new Actor[] {allies[(new Random()).nextInt(allies.length)]}, behavior));
	}

	@Override
	public void selectAlliedRows(Behavior behavior) {
		Actor[][] targetRows = splitRows(allies);
		actionQueue.add(new BattleAction(source, targetRows[(new Random()).nextInt(targetRows.length)], behavior));

	}

	@Override
	public void selectAlliedColumns(Behavior behavior) {
		Actor[][] targetCols = splitColumns(allies);
		actionQueue.add(new BattleAction(source, targetCols[(new Random()).nextInt(targetCols.length)], behavior));

	}

	@Override
	public void selectAlliedGroup(Behavior behavior) {
		actionQueue.add(new BattleAction(source, allies, behavior));

	}

	@Override
	public void selectAnyOpposingUnits(Behavior behavior) {
		actionQueue.add(new BattleAction(source, new Actor[] {opponents[(new Random()).nextInt(opponents.length)]}, behavior));

	}

	@Override
	public void selectFrontOpposingUnits(Behavior behavior) {
		actionQueue.add(new BattleAction(source, new Actor[] {opponents[(new Random()).nextInt(Math.min(opponents.length, 3))]}, behavior));

	}

	@Override
	public void selectAnyOpposingRows(Behavior behavior) {
		Actor[][] targetRows = splitRows(opponents);
		actionQueue.add(new BattleAction(source, targetRows[(new Random()).nextInt(targetRows.length)], behavior));

	}

	@Override
	public void selectFrontOpposingRow(Behavior behavior) {
		actionQueue.add(new BattleAction(source, Arrays.copyOfRange(opponents, 0, Math.min(opponents.length, 3)), behavior));

	}

	@Override
	public void selectAnyOpposingColumns(Behavior behavior) {
		Actor[][] targetCols = splitColumns(opponents);
		actionQueue.add(new BattleAction(source, targetCols[(new Random()).nextInt(targetCols.length)], behavior));

	}

	@Override
	public void selectOpposingGroup(Behavior behavior) {
		actionQueue.add(new BattleAction(source, opponents, behavior));

	}

	@Override
	public void moveParty(int x, int y) {
		// TODO Auto-generated method stub

	}

}
