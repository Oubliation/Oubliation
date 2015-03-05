package edu.ycp.cs320spring2015.oubliation.shared.character;

import java.util.ArrayList;

import edu.ycp.cs320spring2015.oubliation.shared.category.Background;
import edu.ycp.cs320spring2015.oubliation.shared.category.Job;
import edu.ycp.cs320spring2015.oubliation.shared.category.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.category.Species;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Helmet;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Item;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Shield;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Suit;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Utility;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Weapon;

public class EnemyActor extends NonPlayerActor {
	private int experienceGiven;
	private int moneyGiven;
	private ArrayList<Item> itemsGiven;
	
	public EnemyActor(NameTag nameTag, int health, Loadout loadout,
			Identity identity, int maxHp,
			int hitCount, int experienceGiven, int moneyGiven,
			ArrayList<Item> itemsGiven) {
		super(nameTag, health, loadout, identity, maxHp, hitCount);
		this.experienceGiven = experienceGiven;
		this.moneyGiven = moneyGiven;
		this.itemsGiven = itemsGiven;
	}
	public int getExpGiven() {
		return experienceGiven;
	}
	public int getMoneyGiven() {
		return moneyGiven;
	}
	public Item[] getItemsGiven() {
		ArrayList<Item> allItemsGiven = new ArrayList<Item>(itemsGiven);
		allItemsGiven.addAll(loadout.getEquippedUtilities());
		return allItemsGiven.toArray(new Item[allItemsGiven.size()]);
	}
}
