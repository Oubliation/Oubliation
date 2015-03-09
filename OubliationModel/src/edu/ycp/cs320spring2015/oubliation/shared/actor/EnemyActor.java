package edu.ycp.cs320spring2015.oubliation.shared.actor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.ycp.cs320spring2015.oubliation.shared.category.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Item;

public class EnemyActor extends NonPlayerActor {
	private EnemySpoils enemySpoils;
	
	public EnemyActor(NameTag nameTag, int health, Loadout loadout,
			Identity identity, NonPlayerStats stats, EnemySpoils enemySpoils) {
		super(nameTag, loadout, identity, stats);
		this.enemySpoils = enemySpoils;
	}
	public int getExpGiven() {
		return enemySpoils.getExpGiven();
	}
	public int getMoneyGiven() {
		return enemySpoils.getMoneyGiven();
	}
	public Item[] getItemsGiven() {
		Item[] itemArray = enemySpoils.getItemsGiven();
		Item[] utilityArray = getLoadout().getEquippedUtilities();

	    List<Item> allItemsGiven = new ArrayList<Item>(itemArray.length + utilityArray.length);
	    Collections.addAll(allItemsGiven, itemArray);
	    Collections.addAll(allItemsGiven, utilityArray);
	    return allItemsGiven.toArray(new Item[allItemsGiven.size()]);
	}
}
