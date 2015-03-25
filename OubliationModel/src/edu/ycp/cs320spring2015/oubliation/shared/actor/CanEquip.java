package edu.ycp.cs320spring2015.oubliation.shared.actor;

import edu.ycp.cs320spring2015.oubliation.shared.effect.Headwear;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Shield;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Suit;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Utility;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Weapon;

/**
 * Interface for equipping items.
 */
public interface CanEquip {
/* Adding items */
	/**
	 * @param Headwear article to equip 
	 */
	public void equip(Headwear equipment);
	/**
	 * @param Suit to equip 
	 */
	public void equip(Suit equipment);
	/**
	 * @param Shield to equip 
	 */
	public void equip(Shield equipment);
	/**
	 * @param Weapon to equip 
	 */
	public void equip(Weapon equipment);
	/**
	 * @param Utility item to equip 
	 */
	public void equip(Utility equipment);
/* Removing items */
	/**
	 * @param Headwear article to remove
	 */
	public void unequip(Headwear equipment);
	/**
	 * @param Suit article to remove
	 */
	public void unequip(Suit equipment);
	/**
	 * @param Shield article to remove
	 */
	public void unequip(Shield equipment);
	/**
	 * @param Weapon article to remove
	 */
	public void unequip(Weapon equipment);
	/**
	 * @param Utility article to remove
	 */
	public void unequip(Utility equipment);
}
