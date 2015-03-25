package edu.ycp.cs320spring2015.oubliation.shared.effect;

import java.util.TreeSet;

import edu.ycp.cs320spring2015.oubliation.shared.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.actor.CanEquip;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.Job;

/**
 * 
 * Utility which can attack an enemy repeatedly
 *
 */
public class Weapon extends Utility {
	private static final long serialVersionUID = -7151504325373853962L;
	public Weapon() {}

	public Weapon(NameTag nameTag, int price,
			TreeSet<Job> equippableBy, Effect effect) {
		super(nameTag, price, equippableBy, effect);
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
