package edu.ycp.cs320spring2015.oubliation.shared.items;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

import edu.ycp.cs320spring2015.oubliation.shared.Inventory;
import edu.ycp.cs320spring2015.oubliation.shared.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.actor.CanEquip;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.PlayerActor;

/**
 * 
 * Items which can be equipped by an actor
 *
 */
public abstract class Equipment extends Item {
	private static final long serialVersionUID = -8434198402659462673L;
	public Equipment() {}
	
	private SortedSet<String> equippableBy;

	public Equipment(NameTag nameTag, int price, TreeSet<String> equippableBy) {
		super(nameTag, price);
		this.equippableBy = Collections.unmodifiableSortedSet(equippableBy);
	}
	
	public abstract void addTo(Inventory inventory);
	public abstract void removeFrom(Inventory inventory);
	
	/**
	 * @param loadout object to equip this item to
	 */
	public abstract void equipTo(CanEquip loadout);
	/**
	 * @param loadout object to unequip this item from
	 */
	public abstract void unequipFrom(CanEquip loadout);
	
	/**
	 * 
	 * @param actor to test for capability to equip this item
	 * @return whether or not item can be equipped
	 */
	public boolean isEquippable(PlayerActor actor) {
		return equippableBy.contains(actor.getJobName());
	}

}
