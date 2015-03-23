package edu.ycp.cs320spring2015.oubliation.shared.actor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.ycp.cs320spring2015.oubliation.shared.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Item;

public class EnemyActor extends NonPlayerActor {
	private EnemySpoils enemySpoils;
	
	/**
	 * 
	 * @param nameTag {@link NameTag}
	 * @param health An int representing the remaining life-force of a Non-player Actor before death.
	 * @param loadout {@link Loadout}
	 * @param identity {@link Identity}
	 * @param stats {@link NonPlayerStats}
	 * @param enemySpoils {@link EnemySpoils}
	 */
	public EnemyActor(NameTag nameTag, int health, Loadout loadout,
			Identity identity, NonPlayerStats stats, EnemySpoils enemySpoils) {
		super(nameTag, loadout, identity, stats);
		this.enemySpoils = enemySpoils;
	}
	/**
	 * @see EnemySpoils#getExpGiven()
	 *
	 */
	public int getExpGiven() {
		return enemySpoils.getExpGiven();
	}
	/**
	 * @see EnemySpoils#getMoneyGiven()
	 *
	 */
	public int getMoneyGiven() {
		return enemySpoils.getMoneyGiven();
	}
	/**
	 * @return All the times that are to be given to the party.
	 */
	public Item[] getItemsGiven() {
		Item[] itemArray = enemySpoils.getItemsGiven();
		Item[] utilityArray = getLoadout().getEquippedUtilities();

	    List<Item> allItemsGiven = new ArrayList<Item>(itemArray.length + utilityArray.length);
	    Collections.addAll(allItemsGiven, itemArray);
	    Collections.addAll(allItemsGiven, utilityArray);
	    return allItemsGiven.toArray(new Item[allItemsGiven.size()]);
	}
}
