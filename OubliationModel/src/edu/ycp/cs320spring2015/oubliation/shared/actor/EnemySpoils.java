package edu.ycp.cs320spring2015.oubliation.shared.actor;

import java.util.ArrayList;

import edu.ycp.cs320spring2015.oubliation.shared.effect.Item;
/**
 * 
 * Represents the rewards to the player for a successful battle
 *
 */
public class EnemySpoils {
	private int experienceGiven;
	private int moneyGiven;
	private final ArrayList<Item> itemsGiven;
	
	public EnemySpoils(int experienceGiven, int moneyGiven,
			ArrayList<Item> itemsGiven) {
		super();
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
	public Item[] getItemsGiven() {
		return itemsGiven.toArray(new Item[itemsGiven.size()]);
	}
}
