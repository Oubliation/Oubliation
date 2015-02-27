package edu.ycp.cs320spring2015.oubliation.shared.character;

import java.util.ArrayList;

import edu.ycp.cs320spring2015.oubliation.shared.effect.Item;

public class EnemyUnit extends NonPlayerUnit {
	private int ExperienceGiven;
	private int moneyGiven;
	private ArrayList<Item> itemsGiven;
	
	public int getExpGiven() {
		return ExperienceGiven;
	}
	public int getMoneyGiven() {
		return moneyGiven;
	}
	public Item[] getItemsGiven() {
		ArrayList<Item> allItemsGiven = new ArrayList<Item>(itemsGiven);
		allItemsGiven.addAll(utilityBelt);
		return allItemsGiven.toArray(new Item[allItemsGiven.size()]);
	}
}
