package edu.ycp.cs320spring2015.oubliation.shared.items;

import java.util.TreeSet;

import edu.ycp.cs320spring2015.oubliation.shared.BattleController;
import edu.ycp.cs320spring2015.oubliation.shared.CreateInventory;
import edu.ycp.cs320spring2015.oubliation.shared.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.actor.CanEquip;
import edu.ycp.cs320spring2015.oubliation.shared.targets.TargetAdaptor;

/**
 * 
 * Equipment with a usable effect
 *
 */
public class Utility extends Equipment {
	private static final long serialVersionUID = -4845314151894554625L;
	public Utility() {}
	
	private Effect effect;
	private TargetAdaptor<BattleController> target;
	
	public Utility(NameTag nameTag, int price,
			TreeSet<String> equippableBy, Effect effect,
			TargetAdaptor<BattleController> target) {
		super(nameTag, price, equippableBy);
		this.effect = effect;
		this.target = target;
	}

	/**
	 * @param controller used to effect state
	 */
	public void apply(BattleController controller) { //TODO: consider exactly how effect works
		target.apply(controller, effect);
	}
	
	@Override
	public void addTo(CreateInventory inventory) {
		inventory.createUtility(this);
	}
	@Override
	public void removeFrom(CreateInventory inventory) {
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