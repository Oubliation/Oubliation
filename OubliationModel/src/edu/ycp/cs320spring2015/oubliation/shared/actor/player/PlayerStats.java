package edu.ycp.cs320spring2015.oubliation.shared.actor.player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.LinkedList;

import edu.ycp.cs320spring2015.oubliation.shared.effect.Utility;
import edu.ycp.cs320spring2015.oubliation.shared.transfer.PlayerActorMemento;

/**
 * 
 * Miscellaneous statistics of Player Actors
 *
 */
public class PlayerStats implements Serializable {
	private static final long serialVersionUID = -6550379214140225472L;
	public PlayerStats() {}
	
	private int witchMp[]; //mana for each level of witch spells
	private int priestMp[]; //mana for each level of priest spells
	private ArrayList<Utility> autoEquipUtilities; //utilities to be automatically added to the battle equip queue
	private EnumMap<BruceScore, Integer> bonusScores; //extra bruce scores assigned to this character
	
	public PlayerStats(ArrayList<Utility> autoEquipUtilities, EnumMap<BruceScore, Integer> bonusScores, int[] witchMp, int[] priestMp) {
		this.autoEquipUtilities = autoEquipUtilities;
		this.bonusScores = bonusScores;
		this.witchMp = witchMp;
		this.priestMp = priestMp;
	}
	
	/**
	 * @param utility to be added to the auto equip
	 */
	public void autoEquipAdd(Utility utility) {
		autoEquipUtilities.add(utility);
	}
	/**
	 * @param utility to be removed from the auto equip
	 */
	public void autoEquipRemove(Utility utility) {
		autoEquipUtilities.remove(utility);
	}
	/**
	 * @return array of utilities in the auto equip
	 */
	public Utility[] getAutoEquip() {
		return autoEquipUtilities.toArray(new Utility[autoEquipUtilities.size()]);
	}
	
	/**
	 * @param score of bonus to check
	 * @return bonus to given score
	 */
	public int getBonusScore(BruceScore score) {
		return bonusScores.get(score);
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

	public void addTransferData(PlayerActorMemento transfer) {
		LinkedList<String> autoEquipNames = new LinkedList<String>();
		for (Utility utility : autoEquipUtilities) {
			autoEquipNames.add(utility.getName());
		}
		transfer.setStats(autoEquipNames, bonusScores, witchMp, priestMp);
		
	}
}
