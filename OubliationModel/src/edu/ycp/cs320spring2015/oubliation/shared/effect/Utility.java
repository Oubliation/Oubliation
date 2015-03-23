package edu.ycp.cs320spring2015.oubliation.shared.effect;

import java.util.TreeSet;

import edu.ycp.cs320spring2015.oubliation.shared.actor.CanEquip;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.BattleController;
import edu.ycp.cs320spring2015.oubliation.shared.category.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.Job;

public class Utility extends Equipment {
	private Effect effect;
	
	public Utility(NameTag nameTag, int price,
			TreeSet<Job> equippableBy, Effect effect) {
		super(nameTag, price, equippableBy);
		this.effect = effect;
	}

	public void apply(BattleController controller) { //TODO: consider exactly how effect works
		
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
