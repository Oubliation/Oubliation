package edu.ycp.cs320spring2015.oubliation.shared.statuses;

import edu.ycp.cs320spring2015.oubliation.shared.EntityClass;
import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.BattleController;

public class Healthy extends EntityClass {
	
	public Healthy() {
	}
	
	
	public BattleController onTurn(Actor actor) {
		return null;
	}
	
	public int onAttackHitTest(int accuracy) {
		return accuracy;
	}
	public int onDefendHitTest(int accuracy) {
		return accuracy;
	}
	
	public int onAttackHurt(int damage) {
		return damage;
	}
	public int onDefendHurt(int damage) {
		return damage;
	}
	
	public void onAttack(Actor actor) {
	}
	public void onDefend(Actor actor) {
	}
}
