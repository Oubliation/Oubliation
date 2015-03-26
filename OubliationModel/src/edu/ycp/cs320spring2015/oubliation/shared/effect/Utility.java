package edu.ycp.cs320spring2015.oubliation.shared.effect;

import java.util.TreeSet;

import edu.ycp.cs320spring2015.oubliation.shared.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.actor.CanEquip;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.BattleController;

/**
 * 
 * Equipment with a usable effect
 *
 */
public class Utility extends Equipment {
	private static final long serialVersionUID = -4845314151894554625L;
	public Utility() {}
	
	private Effect effect;
	
	public Utility(NameTag nameTag, int price,
			TreeSet<String> equippableBy, Effect effect) {
		super(nameTag, price, equippableBy);
		this.effect = effect;
	}

	/**
	 * @param controller used to effect state
	 */
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
