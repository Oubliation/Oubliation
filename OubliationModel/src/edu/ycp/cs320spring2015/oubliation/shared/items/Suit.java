package edu.ycp.cs320spring2015.oubliation.shared.items;

import java.util.TreeSet;

import edu.ycp.cs320spring2015.oubliation.shared.Inventory;
import edu.ycp.cs320spring2015.oubliation.shared.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.CanEquip;

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
	public void addTo(Inventory inventory) {
		inventory.createSuit(this);
	}
	@Override
	public void removeFrom(Inventory inventory) {
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
