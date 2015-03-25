package edu.ycp.cs320spring2015.oubliation.shared.actor;

import java.io.Serializable;
/**
 * Miscellaneous statistics of Non-Player Actors
 *
 */
public class NonPlayerStats {
	private int maxHp = 0; 
	private int hitCount = 0;
	
	/**
	 * 
	 * @param maxHp Maximum hit-points of the Non-Player Actor
	 * @param hitCount Number of times an actor can hit the enemy
	 */
	public NonPlayerStats(int maxHp, int hitCount) {
		super();
		this.maxHp = maxHp;
		this.hitCount = hitCount;
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
}
