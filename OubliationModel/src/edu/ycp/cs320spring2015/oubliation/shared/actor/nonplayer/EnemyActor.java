package edu.ycp.cs320spring2015.oubliation.shared.actor.nonplayer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import edu.ycp.cs320spring2015.oubliation.shared.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.actor.Loadout;
import edu.ycp.cs320spring2015.oubliation.shared.items.Item;
import edu.ycp.cs320spring2015.oubliation.shared.transfer.StatusMemento;

public class EnemyActor extends NonPlayerActor {
	private static final long serialVersionUID = 1948800440853986420L;
	
	private EnemySpoils enemySpoils;
	private int minInitiative;
	private int initiativeRange;
	
	/**
	 * 
	 * @param nameTag {@link NameTag}
	 * @param health An int representing the remaining life-force of a Non-player Actor before death.
	 * @param loadout {@link Loadout}
	 * @param identity {@link NonPlayerIdentity}
	 * @param stats {@link NonPlayerStats}
	 * @param enemySpoils {@link EnemySpoils}
	 */
	public EnemyActor(NameTag nameTag, StatusMemento status, Loadout loadout,
			NonPlayerIdentity identity, NonPlayerStats stats, EnemySpoils enemySpoils,
			int initiativeBase, int initiativeRange) {
		super(nameTag, status, loadout, identity, stats);
		this.minInitiative = initiativeBase;
		this.initiativeRange = initiativeRange;
		this.enemySpoils = enemySpoils;
	}
	public int getInitiative() {
		return minInitiative+(new Random()).nextInt(initiativeRange);
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
