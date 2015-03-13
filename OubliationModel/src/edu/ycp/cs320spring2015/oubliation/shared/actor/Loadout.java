package edu.ycp.cs320spring2015.oubliation.shared.actor;

import java.io.Serializable;
import java.util.ArrayList;

import edu.ycp.cs320spring2015.oubliation.shared.effect.Equipment;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Headwear;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Shield;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Suit;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Utility;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Weapon;

/**
 * Equipped items on an Actor
 */
public class Loadout implements Serializable {

	public Loadout(Headwear helmet, Suit suit, Shield shield, Weapon hand,
			ArrayList<Utility> utilityBelt) {
		this.headwear = helmet;
		this.suit = suit;
		this.shield = shield;
		this.hand = hand;
		this.utilityBelt = utilityBelt;
	}
	
	protected Headwear headwear; //armor
	protected Suit suit; //armor
	protected Shield shield; //armor
	protected Weapon hand; //weapon
	protected ArrayList<Utility> utilityBelt; //utilities (usable items)
	//TODO: make two hands, hand and shield slots can also hold items
	
	/**
	 * @return the total of Armor Rank across equipped armor 
	 */
	
	public int getArmorRank() {
		int totalArmorRank = 0;
		if (headwear != null) { totalArmorRank += headwear.getArmorRank(); }
		if (suit != null) { totalArmorRank += suit.getArmorRank(); }
		if (shield != null) { totalArmorRank += shield.getArmorRank(); }
		return totalArmorRank;
	}
	
	public Headwear getHeadwear() {
		return headwear;
	}
	public Suit getSuit() {
		return suit;
	}
	public Shield getShield() {
		return shield;
	}
	public Weapon getHand() {
		return hand;
	}
	
	public Utility[] getEquippedUtilities() {
		return utilityBelt.toArray(new Utility[utilityBelt.size()]);
	}
	
	/**
	 * @param equipment article to equip 
	 */
	public void fieldEquip(Headwear equipment) {
		assert headwear == null;
		headwear = equipment;
	}
	public void fieldEquip(Suit equipment) {
		assert suit == null;
		suit = equipment;
	}
	public void fieldEquip(Weapon equipment) {
		assert hand == null;
		hand = equipment;
	}
	public void fieldEquip(Equipment equipment) {
		throw new UnsupportedOperationException();
	}
	public void battleEquip(Utility equipment) {
		utilityBelt.add(equipment);
	}
	public void battleEquip(Equipment equipment) {
		fieldEquip(equipment);
	}
	
	
	/**
	 * @param equipment article to remove
	 */
	public void fieldUnequip(Headwear equipment) {
		assert headwear == equipment;
		headwear = null;
	}
	public void fieldUnequip(Suit equipment) {
		assert suit == equipment;
		suit = null;
	}
	public void fieldUnequip(Weapon equipment) {
		assert hand == equipment;
		hand = null;
	}
	public void fieldUnequip(Equipment equipment) {
		throw new UnsupportedOperationException();
	}
	public void battleUnequip(Utility equipment) {
		boolean haveEquipment = utilityBelt.remove(equipment);
		assert haveEquipment;
	}
	public void battleUnequip(Equipment equipment) {
		fieldUnequip(equipment);
	}
}
