package edu.ycp.cs320spring2015.oubliation.shared.actor.nonplayer;


import edu.ycp.cs320spring2015.oubliation.shared.Inventory;
/**
 * 
 * Represents the rewards to the player for a successful battle
 *
 */
public class EnemySpoils {
	private int experienceGiven;
	private int moneyGiven;
	private Inventory itemsGiven;
	
	public EnemySpoils(int experienceGiven, int moneyGiven,
			Inventory itemsGiven) {
		this.experienceGiven = experienceGiven;
		this.moneyGiven = moneyGiven;
		this.itemsGiven = itemsGiven;
	}
	/**
	* @return The experience points the party deserves for defeating the enemy.
	*/
	public int getExpGiven() {
		return experienceGiven;
	}
	/**
	* @return The money the party deserves for defeating the enemy.
	*/
	public int getMoneyGiven() {
		return moneyGiven;
	}
	/**
	 * 
	 * @return Items that are to be given to the party.
	 */
	public Inventory getItemsGiven() {
		return itemsGiven;
	}
}
