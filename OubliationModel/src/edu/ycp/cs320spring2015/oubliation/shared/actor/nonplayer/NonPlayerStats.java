package edu.ycp.cs320spring2015.oubliation.shared.actor.nonplayer;

import java.util.Random;

import edu.ycp.cs320spring2015.oubliation.shared.behavior.Behavior;
import edu.ycp.cs320spring2015.oubliation.shared.targets.BattleController;

/**
 * Miscellaneous statistics of Non-Player Actors
 *
 */
public class NonPlayerStats {
	private int maxHp = 0; 
	private int hitCount = 0;
	private int minInitiative;
	private int initiativeRange;
	private int attackMod;
	private int accuracyMod;
	private int evasion;
	private Behavior[] behaviors;
	
	/**
	 * 
	 * @param maxHp Maximum hit-points of the Non-Player Actor
	 * @param hitCount Number of times an actor can hit the enemy
	 * @param minInitiative minimum initiative the Non-Player Actor can roll
	 * @param initiativeRange rolled range of initiative for the Non-Player Character
	 * @param attackMod modifier to action's attack damage
	 * @param accuracyMod modifier to action's accuracy
	 * @param evasion ability to evade incoming attack
	 */
	public NonPlayerStats(int maxHp, int hitCount, int minInitiative,
			int initiativeRange, int attackMod, int accuracyMod, int evasion,
			Behavior[] behaviors) {
		this.maxHp = maxHp;
		this.hitCount = hitCount;
		this.minInitiative = minInitiative;
		this.initiativeRange = initiativeRange;
		this.attackMod = attackMod;
		this.accuracyMod = accuracyMod;
		this.evasion = evasion;
		this.behaviors = behaviors;
	}
	/**
	 * 
	 * @return Maximum hit-points of the NonPlayerActor
	 */
	public int getMaxHp() {
		return maxHp;
	}
	/**
	 * 
	 * @return Number of times an actor can hit the enemy
	 */
	public int getHitCount() {
		return hitCount;
	}
	
	public int getInitiative() {
		return minInitiative+(new Random()).nextInt(initiativeRange);
	}
	public int getAttackMod() {
		return attackMod;
	}
	public int getAccuracyMod() {
		return accuracyMod;
	}
	public int getEvasion() {
		return evasion;
	}
	public void selectBattleBehavior(BattleController controller) {
		behaviors[(new Random()).nextInt(behaviors.length)].select(controller);;
	}
}
