package edu.ycp.cs320spring2015.oubliation.shared.items;

import java.util.TreeSet;

import edu.ycp.cs320spring2015.oubliation.shared.CreateInventory;
import edu.ycp.cs320spring2015.oubliation.shared.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.actor.CanEquip;
import edu.ycp.cs320spring2015.oubliation.shared.behavior.Behavior;

/**
 * 
 * Utility which can attack an enemy repeatedly
 *
 */
public class Weapon extends Utility {
	private static final long serialVersionUID = -7151504325373853962L;
	public Weapon() {}

	public Weapon(NameTag nameTag, int price,
			TreeSet<String> equippableBy, Behavior behavior) {
		super(nameTag, price, equippableBy, behavior);
	}
	
	@Override
	public void addTo(CreateInventory inventory) {
		inventory.createWeapon(this);
	}
	@Override
	public void removeFrom(CreateInventory inventory) {
		inventory.destroyWeapon(this);
	}
	

	@Override
	public void equipTo(CanEquip loadout) {
		loadout.equip(this);
		
	}

	@Override
	public void unequipFrom(CanEquip loadout) {
		loadout.unequip(this);
		
	}

}
