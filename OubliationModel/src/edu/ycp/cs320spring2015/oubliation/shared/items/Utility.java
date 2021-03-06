package edu.ycp.cs320spring2015.oubliation.shared.items;

import java.util.TreeSet;

import edu.ycp.cs320spring2015.oubliation.shared.Inventory;
import edu.ycp.cs320spring2015.oubliation.shared.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.CanEquip;
import edu.ycp.cs320spring2015.oubliation.shared.behavior.Behavior;
import edu.ycp.cs320spring2015.oubliation.shared.targets.PartyController;

/**
 * 
 * Equipment with a usable effect
 *
 */
public class Utility extends Equipment {
	private static final long serialVersionUID = -4845314151894554625L;
	public Utility() {}
	
	private Behavior behavior;
	
	public Utility(NameTag nameTag, int price,
			TreeSet<String> equippableBy, Behavior behavior) {
		super(nameTag, price, equippableBy);
		this.behavior = behavior;
	}

	/**
	 * @param controller used to effect state
	 */
	public void select(PartyController controller) {
		behavior.select(controller);
	}
	
	@Override
	public void addTo(Inventory inventory) {
		inventory.createUtility(this);
	}
	@Override
	public void removeFrom(Inventory inventory) {
		inventory.destroyUtility(this);
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
