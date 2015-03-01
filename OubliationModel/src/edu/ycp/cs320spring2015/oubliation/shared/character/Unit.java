package edu.ycp.cs320spring2015.oubliation.shared.character;

import java.util.ArrayList;

import edu.ycp.cs320spring2015.oubliation.shared.category.EntityClass;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Helmet;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Shield;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Suit;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Utility;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Weapon;

public abstract class Unit extends EntityClass {
	
	private int hp;
	
	protected Helmet helmet;
	protected Suit suit;
	protected Shield shield;
	protected Weapon hand; 
	protected ArrayList<Utility> utilityBelt;
	//TODO: make two hands, hand and shield slots can also hold items
	
	public Unit(String name, String description, Helmet helmet, Suit suit,
			Shield shield, Weapon hand, ArrayList<Utility> utilityBelt) {
		super(name, description);
		this.helmet = helmet;
		this.suit = suit;
		this.shield = shield;
		this.hand = hand;
		this.utilityBelt = utilityBelt;
		hp = getMaxHp(); //TODO: what about loading savegames with PCs with less hp than max?
	}
	//TODO: public abstract int startTurn();
	public abstract int getHitCount();
	public abstract int getMaxHp();
	
	public int getAc() {
		int totalAc = 0;
		if (helmet != null) { totalAc += helmet.getAc(); }
		if (suit != null) { totalAc += suit.getAc(); }
		if (shield != null) { totalAc += shield.getAc(); }
		return totalAc;
	}
	
	public int getHp() {
		return hp;
	}
	
	public Utility[] getEquippedUtilities() {
		return utilityBelt.toArray(new Utility[utilityBelt.size()]);
	}
	
	public boolean hitTest(int accuracy) {
		return false;
	}
	
	public void recieveHealing(int amount) {
		
	}
	public void recieveDamage(int amount) {
		
	}
	public void recieveStatus() {
		
	} //TODO: what if it's a magic drain attack?
	
}
