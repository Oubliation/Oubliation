package edu.ycp.cs320spring2015.oubliation.shared.character;

import java.util.ArrayList;

import edu.ycp.cs320spring2015.oubliation.shared.effect.*;
import edu.ycp.cs320spring2015.shared.category.Entity;

public abstract class Unit implements Entity {
	//TODO: background, class, species
	
	private int hp;
	
	protected Helmet helmet;
	protected Suit suit;
	protected Shield shield;
	protected Weapon hand; 
	protected ArrayList<Utility> utilityBelt;
	//TODO: make two hands, hand and shield slots can also hold items
	
	//TODO: public abstract int startTurn();
	public abstract int getHitCount();
	public abstract int getMaxHp();
	
	public int getAc() {
		return 0;
	}
	
	public int getHp() {
		return hp;
	}
	
	public Utility[] getEquippedUtilities() {
		return utilityBelt.toArray(new Utility[utilityBelt.size()]);
	}
	
	public void recieveDamage(int amount) {
		
	}
	
	public void recieveStatus() {
		
	} //TODO: what if it's a magic drain attack?
	
}
