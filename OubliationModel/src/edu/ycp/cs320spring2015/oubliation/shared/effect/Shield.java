package edu.ycp.cs320spring2015.oubliation.shared.effect;

import java.util.TreeSet;

import edu.ycp.cs320spring2015.oubliation.shared.actor.CanEquip;
import edu.ycp.cs320spring2015.oubliation.shared.category.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.Job;

public class Shield extends Armor {

	public Shield(NameTag nameTag, int price,
			TreeSet<Job> equippableBy, int ac) {
		super(nameTag, price, equippableBy, ac);
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
