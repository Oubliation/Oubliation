package edu.ycp.cs320spring2015.oubliation.shared.actor;

import edu.ycp.cs320spring2015.oubliation.shared.EntityClass;
import edu.ycp.cs320spring2015.oubliation.shared.category.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Headwear;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Shield;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Suit;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Utility;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Weapon;

/**
 * Entities which can fight in battle
 */
public abstract class Actor extends EntityClass {
	
	private int health;
	
	private Loadout loadout; // contains all equipment
	
	public Actor(NameTag nameTag, Loadout loadout, int health) {
		super(nameTag);
		this.loadout = loadout;
		this.health = health;
	}
	
	//TODO: public abstract int startTurn();
	public abstract String getBackgroundName();
	public abstract String getBackgroundDescription();
	public abstract String getSpeciesName();
	public abstract String getSpeciesDescription();
	public abstract String getJobName();
	public abstract String getJobDescription();
	
	//battle info
	
	/**
	 * @return number of times actor will hit an enemy by themselves
	 */
	public abstract int getHitCount();
	
	/**
	 * @return Maximum amount of health actor can have
	 */
	public abstract int getMaxHealth();
	
	
	/**
	 * @return the total of Armor Rank across equipped armor 
	 */
	public int getArmorRank() {
		return loadout.getArmorRank();
	}
	
	/**
	 * @return remaining health points 
	 */
	public int getHealth() {
		return health;
	}
	
	/**
	 * @return equipped items 
	 */
	protected Loadout getLoadout() {
		return loadout;
	}
	public Headwear getHeadwear() {
		return loadout.getHeadwear();
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
	
	
	/**
	 * @return whether attack has hit or missed
	 */
	public boolean hitTest(int accuracy) {
		return false;
	}
	
	/**
	 * @param amount amount of healing received
	 */
	public void receiveHealing(int amount) {
		
	}
	/**
	 * @param amount amount of damage received
	 */
	public void receiveDamage(int amount) {
		
	}
	/**
	 * status to be afflicted with
	 */
	public void receiveStatus() {
		
	} //TODO: what if it's a magic drain attack?
	
}
