package edu.ycp.cs320spring2015.oubliation.shared.character;

import edu.ycp.cs320spring2015.oubliation.shared.category.EntityClass;
import edu.ycp.cs320spring2015.oubliation.shared.category.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Helmet;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Shield;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Suit;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Utility;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Weapon;

public abstract class Actor extends EntityClass {
	
	private int hp;
	
	private Loadout loadout;
	//TODO: make two hands, hand and shield slots can also hold items
	
	public Actor(NameTag nameTag, int health, Loadout loadout) {
		super(nameTag);
		this.loadout = loadout;
		hp = getMaxHp(); //TODO: what about loading savegames with PCs with less hp than max?
	}
	
	//TODO: public abstract int startTurn();
	public abstract String getBackgroundName();
	public abstract String getBackgroundDescription();
	public abstract String getSpeciesName();
	public abstract String getSpeciesDescription();
	public abstract String getJobName();
	public abstract String getJobDescription();
	public abstract int getHitCount();
	public abstract int getMaxHp();
	
	
	public int getArmorRank() {
		return loadout.getArmorRank();
	}
	
	public int getHp() {
		return hp;
	}
	
	protected Loadout getLoadout() {
		return loadout;
	}
	public Helmet getHelmet() {
		return loadout.getHelmet();
	}
	public Suit getSuit() {
		return loadout.getSuit();
	}
	public Shield getShield() {
		return loadout.getShield();
	}
	public Weapon getHand() {
		return loadout.getHand();
	}
	
	public Utility[] getEquippedUtilities() {
		return loadout.getEquippedUtilities();
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
