package edu.ycp.cs320spring2015.oubliation.shared.actor;

import java.io.Serializable;
import java.util.ArrayList;

import edu.ycp.cs320spring2015.oubliation.shared.effect.Item;
/**
 * 
 * Represents the rewards to the player for a successful battle; implements Serializable
 *
 */
public class EnemySpoils implements Serializable {
	private int experienceGiven;
	private int moneyGiven;
	private ArrayList<Item> itemsGiven;
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
