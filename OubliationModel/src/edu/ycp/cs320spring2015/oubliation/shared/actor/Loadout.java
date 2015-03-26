package edu.ycp.cs320spring2015.oubliation.shared.actor;

import java.io.Serializable;
import java.util.ArrayList;

import edu.ycp.cs320spring2015.oubliation.shared.effect.Headwear;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Shield;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Suit;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Utility;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Weapon;
import edu.ycp.cs320spring2015.oubliation.shared.transfer.PlayerActorTransfer;

/**
 * Equipped items on an Actor; implements CanEquip, Serializable
 */
final public class Loadout implements CanEquip, Serializable {
	private static final long serialVersionUID = -3436712080673262727L;
	public Loadout() {}

	/**
	 * 
	 * @param helmet {@link Headwear}
	 * @param suit {@link Suit}
	 * @param shield {@link Shield}
	 * @param hand {@link Weapon}
	 * @param utilityBelt List of utility items
	 */
	public Loadout(Headwear helmet, Suit suit, Shield shield, Weapon hand,
			ArrayList<Utility> utilityBelt) {
		this.headwear = helmet;
		this.suit = suit;
		this.shield = shield;
		this.hand = hand;
		this.utilityBelt = utilityBelt;
	}
	
	private Headwear headwear; //armor
	private Suit suit; //armor
	private Shield shield; //armor
	private Weapon hand; //weapon
	private ArrayList<Utility> utilityBelt; //utilities (usable items)
	
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
	/**
	 * 
	 * @return The equipped item on the characters head.
	 */
	public Headwear getHeadwear() {
		return headwear;
	}
	/**
	 * 
	 * @return The equipped suit of armor.
	 */
	public Suit getSuit() {
		return suit;
	}
	/**
	 * 
	 * @return The equipped shield
	 */
	public Shield getShield() {
		return shield;
	}
	/**
	 * 
	 * @return The equipped item in the characters hand.
	 */
	public Weapon getHand() {
		return hand;
	}
	/**
	 * 
	 * @return The equipped items on the characters utility section.
	 */
	public Utility[] getEquippedUtilities() {
		return utilityBelt.toArray(new Utility[utilityBelt.size()]);
	}
	
	/**
	 * @param equipment to wear on the head.
	 */
	public void equip(Headwear equipment) {
		assert headwear == null;
		headwear = equipment;
	}
	/**
	 * @param equipment to wear on the body.
	 */
	public void equip(Suit equipment) {
		assert suit == null;
		suit = equipment;
	}
	/**
	 * @param equipment to wield as a shield.
	 */
	public void equip(Shield equipment) {
		assert shield == null;
		shield = equipment;
	}
	/**
	 * @param equipment to wield as a weapon.
	 */
	public void equip(Weapon equipment) {
		assert hand == null;
		hand = equipment;
	}
	/**
	 * @param equipment to ready as a utility.
	 */
	public void equip(Utility equipment) {
		utilityBelt.add(equipment);
	}
	
/* Removing Items */
	/**
	 * @param equipment to take off of the head
	 */
	public void unequip(Headwear equipment) {
		assert headwear == equipment;
		headwear = null;
	}
	/**
	 * @param equipment to take off of the body
	 */
	public void unequip(Suit equipment) {
		assert suit == equipment;
		suit = null;
	}
	/**
	 * @param equipment to take out of the shield hand
	 */
	public void unequip(Shield equipment) {
		assert shield == equipment;
		shield = null;
	}
	/**
	 * @param equipment to take out of the weapon hand
	 */
	public void unequip(Weapon equipment) {
		assert hand == equipment;
		hand = null;
	}
	/**
	 * @param equipment to dis-ready as a utility
	 */
	public void unequip(Utility equipment) {
		boolean haveEquipment = utilityBelt.remove(equipment);
		assert haveEquipment;
	}

	public void addTransferData(PlayerActorTransfer transfer) {
		transfer.setLoadout(headwear.getName(), suit.getName(), shield.getName(), hand.getName());
	}
}
