package edu.ycp.cs320spring2015.oubliation.shared.actor.nonplayer;

import java.util.EnumMap;

import edu.ycp.cs320spring2015.oubliation.shared.Inventory;
import edu.ycp.cs320spring2015.oubliation.shared.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.Loadout;
import edu.ycp.cs320spring2015.oubliation.shared.category.Element;
import edu.ycp.cs320spring2015.oubliation.shared.statuses.Status;

public class EnemyActor extends NonPlayerActor {
	private static final long serialVersionUID = 1948800440853986420L;
	
	private EnemySpoils enemySpoils;
	
	/**
	 * 
	 * @param nameTag {@link NameTag}
	 * @param health An int representing the remaining life-force of a Non-player Actor before death.
	 * @param loadout {@link Loadout}
	 * @param identity {@link NonPlayerIdentity}
	 * @param stats {@link NonPlayerStats}
	 * @param enemySpoils {@link EnemySpoils}
	 */
	public EnemyActor(NameTag nameTag, Status status,
			EnumMap<Element, Double> elementalMods,
			NonPlayerStats stats, EnemySpoils enemySpoils) {
		super(nameTag, status, elementalMods, stats);
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
	public Inventory getItemsGiven() {
		return enemySpoils.getItemsGiven();
	}
}
