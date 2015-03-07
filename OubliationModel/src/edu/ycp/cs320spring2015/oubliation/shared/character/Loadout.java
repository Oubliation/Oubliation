package edu.ycp.cs320spring2015.oubliation.shared.character;

import java.util.ArrayList;

import edu.ycp.cs320spring2015.oubliation.shared.effect.Equipment;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Helmet;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Shield;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Suit;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Utility;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Weapon;

public class Loadout {

	public Loadout(Helmet helmet, Suit suit, Shield shield, Weapon hand,
			ArrayList<Utility> utilityBelt) {
		this.helmet = helmet;
		this.suit = suit;
		this.shield = shield;
		this.hand = hand;
		this.utilityBelt = utilityBelt;
	}

	protected Helmet helmet;
	protected Suit suit;
	protected Shield shield;
	protected Weapon hand; 
	protected ArrayList<Utility> utilityBelt;
	
	/**
	 * 
	 * @return the total of Ar on the armor 
	 */
	
	public int getArmorRank() {
		int totalArmorRank = 0;
		if (helmet != null) { totalArmorRank += helmet.getArmorRank(); }
		if (suit != null) { totalArmorRank += suit.getArmorRank(); }
		if (shield != null) { totalArmorRank += shield.getArmorRank(); }
		return totalArmorRank;
	}
	
	public Helmet getHelmet() {
		return helmet;
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
	
	public void fieldEquip(Helmet equipment) {
		assert helmet == null;
		helmet = equipment;
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
	 * @param equipment equipment to remove
	 */
	public void fieldUnequip(Helmet equipment) {
		assert helmet == equipment;
		helmet = null;
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
