package edu.ycp.cs320spring2015.oubliation.shared.actor;

import java.io.Serializable;
import java.util.ArrayList;

import edu.ycp.cs320spring2015.oubliation.shared.effect.Item;

public class EnemySpoils implements Serializable {
	private int experienceGiven;
	private int moneyGiven;
	private ArrayList<Item> itemsGiven;
	

	public int getExpGiven() {
		return experienceGiven;
	}
	public int getMoneyGiven() {
		return moneyGiven;
	}
	public Item[] getItemsGiven() {
		return itemsGiven.toArray(new Item[itemsGiven.size()]);
	}
}
