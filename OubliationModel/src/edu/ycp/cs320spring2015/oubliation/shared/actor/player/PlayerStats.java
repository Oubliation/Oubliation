package edu.ycp.cs320spring2015.oubliation.shared.actor.player;

import java.io.Serializable;
import java.util.ArrayList;

import edu.ycp.cs320spring2015.oubliation.shared.effect.Utility;

/**
 * 
 * Miscellaneous statistics of Player Actors
 *
 */
public class PlayerStats implements Serializable {
	private int witchMp[]; //mana for each level of witch spells
	private int priestMp[]; //mana for each level of priest spells
	
	public PlayerStats(int[] witchMp, int[] priestMp) {
		this.witchMp = witchMp;
		this.priestMp = priestMp;
	}
	
	/**
	 * @param level spell level
	 * @return remaining mana for witch spell level x
	 */
	public int getWitchMp(int level) {
		return witchMp[level-1];
	}
	/**
	 * @param level spell level
	 * @return remaining mana for priest spell level x
	 */
	public int getPriestMp(int level) {
		return priestMp[level-1];
	}
	/**
	 * @param level spell level of witch mana to spend
	 * @param amount amount of mana to spend
	 */
	public void spendWitchMp(int level, int amount) {
		witchMp[level-1] -= amount;
	}
	/**
	 * @param level spell level of priest mana to spend
	 * @param amount amount of mana to spend
	 */
	public void spendPriestMp(int level, int amount) {
		priestMp[level-1] -= amount;
	}
}
