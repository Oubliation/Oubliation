package edu.ycp.cs320spring2015.oubliation.shared.effect;

import java.util.TreeSet;

import edu.ycp.cs320spring2015.oubliation.shared.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.actor.CanEquip;

/**
 * 
 * Armor equipped to the head
 *
 */
public class Headwear extends Armor {
	private static final long serialVersionUID = 1399598762358488552L;
	public Headwear() {}

	public Headwear(NameTag nameTag, int price,
			TreeSet<String> equippableBy, int ar) {
		super(nameTag, price, equippableBy, ar);
		// TODO Auto-generated constructor stub
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
