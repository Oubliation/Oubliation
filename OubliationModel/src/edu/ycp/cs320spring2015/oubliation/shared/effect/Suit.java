package edu.ycp.cs320spring2015.oubliation.shared.effect;

import java.util.TreeSet;

import edu.ycp.cs320spring2015.oubliation.shared.CreateInventory;
import edu.ycp.cs320spring2015.oubliation.shared.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.actor.CanEquip;

/**
 * 
 * Armor which is worn on the torso
 *
 */
public class Suit extends Armor {
	private static final long serialVersionUID = 5832506045474733159L;
	public Suit() {}

	public Suit(NameTag nameTag, int price,
			TreeSet<String> equippableBy, int ac) {
		super(nameTag, price, equippableBy, ac);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void addTo(CreateInventory inventory) {
		inventory.createSuit(this);
	}
	@Override
	public void removeFrom(CreateInventory inventory) {
		inventory.destroySuit(this);
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
