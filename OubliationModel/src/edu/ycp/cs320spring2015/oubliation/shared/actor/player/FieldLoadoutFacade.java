package edu.ycp.cs320spring2015.oubliation.shared.actor.player;


import edu.ycp.cs320spring2015.oubliation.shared.actor.CanEquip;
import edu.ycp.cs320spring2015.oubliation.shared.actor.Loadout;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Headwear;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Shield;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Suit;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Utility;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Weapon;
/**
 * A wrapper for {@link Loadout}; Implements CanEquip
 *
 */
public class FieldLoadoutFacade implements CanEquip {
	Loadout loadout; //actual loadout
	PlayerStats stats; //stat object for redirecting utilities
	
	
	public FieldLoadoutFacade(Loadout loadout, PlayerStats stats) {
		this.loadout = loadout;
		this.stats = stats;
	}
	
	/**
	 * @param equipment utility to ready
	 */
	public void equip(Utility equipment) {
		stats.autoEquipAdd(equipment);
	}
	/**
	 * @param equipment utility to unready
	 */
	public void unequip(Utility equipment) {
		stats.autoEquipRemove(equipment);
	}
	
	/**
	 *  @see {@link Loadout#equip(Headwear)}
	 */
	public void equip(Headwear equipment) {
		loadout.equip(equipment);
	}

	/**
	 *  @see {@link Loadout#equip(Suit)}
	 */
	public void equip(Suit equipment) {
		loadout.equip(equipment);
	}

	/**
	 *  @see {@link Loadout#equip(Shield)}
	 */
	public void equip(Shield equipment) {
		loadout.equip(equipment);
	}

	/**
	 *  @see {@link Loadout#equip(Weapon)}
	 */
	public void equip(Weapon equipment) {
		loadout.equip(equipment);
	}

	/**
	 *  @see {@link Loadout#unequip(Headwear)}
	 */
	public void unequip(Headwear equipment) {
		loadout.unequip(equipment);
	}

	/**
	 *  @see {@link Loadout#unequip(Suit)}
	 */
	public void unequip(Suit equipment) {
		loadout.unequip(equipment);
	}

	/**
	 *  @see {@link Loadout#unequip(Shield)}
	 */
	public void unequip(Shield equipment) {
		loadout.unequip(equipment);
	}

	/**
	 *  @see {@link Loadout#unequip(Weapon)}
	 */
	public void unequip(Weapon equipment) {
		loadout.unequip(equipment);
	}
}
