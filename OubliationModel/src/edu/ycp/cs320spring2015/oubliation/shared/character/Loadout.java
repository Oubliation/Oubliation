package edu.ycp.cs320spring2015.oubliation.shared.character;

import java.util.ArrayList;

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
	
	public int getAc() {
		int totalAc = 0;
		if (helmet != null) { totalAc += helmet.getAc(); }
		if (suit != null) { totalAc += suit.getAc(); }
		if (shield != null) { totalAc += shield.getAc(); }
		return totalAc;
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
}
