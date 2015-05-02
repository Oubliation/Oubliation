package edu.ycp.cs320spring2015.oubliation.shared.items;

import java.util.TreeSet;

import edu.ycp.cs320spring2015.oubliation.shared.Inventory;
import edu.ycp.cs320spring2015.oubliation.shared.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.actor.CanEquip;

/**
 * 
 * Armor which shields actor from incoming blows
 *
 */
public class Shield extends Armor {
	private static final long serialVersionUID = 4149608150769377245L;
	public Shield() {}

	public Shield(NameTag nameTag, int price,
			TreeSet<String> equippableBy, int ac) {
		super(nameTag, price, equippableBy, ac);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void addTo(Inventory inventory) {
		inventory.createShield(this);
	}
	@Override
	public void removeFrom(Inventory inventory) {
		inventory.destroyShield(this);
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
