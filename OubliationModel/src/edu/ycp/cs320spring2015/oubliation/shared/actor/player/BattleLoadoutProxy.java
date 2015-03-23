package edu.ycp.cs320spring2015.oubliation.shared.actor.player;

import java.util.ArrayList;

import edu.ycp.cs320spring2015.oubliation.shared.actor.CanEquip;
import edu.ycp.cs320spring2015.oubliation.shared.actor.Loadout;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Equipment;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Headwear;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Shield;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Suit;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Utility;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Weapon;
/**
 * TODO: Come back to this
 * A wrapper for {@link Loadout}; Implements CanEquip
 *
 */
public class BattleLoadoutProxy implements CanEquip {
	Loadout loadout;
	ArrayList<Utility> readiedUtilities;
	
	
	public BattleLoadoutProxy(Loadout loadout) {
		this.loadout = loadout;
	}

	public void equip(Utility equipment) {
		readiedUtilities.add(equipment);
	}
	public void unequip(Utility equipment) {
		readiedUtilities.remove(equipment);
	}
	public Utility[] getReadiedUtilities() {
		return readiedUtilities.toArray(new Utility[readiedUtilities.size()]);
	}
	

	public void equip(Headwear equipment) {
		loadout.equip(equipment);
	}

	public void equip(Suit equipment) {
		loadout.equip(equipment);
	}

	public void equip(Shield equipment) {
		loadout.equip(equipment);
	}

	public void equip(Weapon equipment) {
		loadout.equip(equipment);
	}

	public void unequip(Headwear equipment) {
		loadout.unequip(equipment);
	}

	public void unequip(Suit equipment) {
		loadout.unequip(equipment);
	}

	public void unequip(Shield equipment) {
		loadout.unequip(equipment);
	}

	public void unequip(Weapon equipment) {
		loadout.unequip(equipment);
	}
}
