package edu.ycp.cs320spring2015.oubliation.shared.actor;

import edu.ycp.cs320spring2015.oubliation.shared.effect.Equipment;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Headwear;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Shield;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Suit;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Utility;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Weapon;

public interface CanEquip {
	/**
	 * @param equipment article to equip 
	 */
	public void equip(Headwear equipment);
	public void equip(Suit equipment);
	public void equip(Shield equipment);
	public void equip(Weapon equipment);
	public void equip(Utility equipment);
	
	
	/**
	 * @param equipment article to remove
	 */
	public void unequip(Headwear equipment);
	public void unequip(Suit equipment);
	public void unequip(Shield equipment);
	public void unequip(Weapon equipment);
	public void unequip(Utility equipment);
}
