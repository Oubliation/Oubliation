package edu.ycp.cs320spring2015.oubliation.shared.actor.player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

import edu.ycp.cs320spring2015.oubliation.shared.effect.Utility;
import edu.ycp.cs320spring2015.oubliation.shared.transfer.PlayerActorTransfer;

/**
 * 
 * Miscellaneous statistics of Player Actors
 *
 */
public class PlayerStats implements Serializable {
	private static final long serialVersionUID = -6550379214140225472L;
	public PlayerStats() {}
	
	private ArrayList<Utility> autoEquipUtilities; //utilities to be automatically added to the battle equip queue
	private int witchMp[]; //mana for each level of witch spells
	private int priestMp[]; //mana for each level of priest spells
	
	public PlayerStats(int[] witchMp, int[] priestMp, ArrayList<Utility> autoEquipUtilities) {
		this.witchMp = witchMp;
		this.priestMp = priestMp;
		this.autoEquipUtilities = autoEquipUtilities;
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

	public void addTransferData(PlayerActorTransfer transfer) {
		LinkedList<String> autoEquipNames = new LinkedList<String>();
		for (Utility utility : autoEquipUtilities) {
			autoEquipNames.add(utility.getName());
		}
		transfer.setStats(autoEquipNames, witchMp, priestMp);
		
	}
}
