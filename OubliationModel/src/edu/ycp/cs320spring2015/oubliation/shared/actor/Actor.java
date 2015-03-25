package edu.ycp.cs320spring2015.oubliation.shared.actor;

import java.io.Serializable;

import edu.ycp.cs320spring2015.oubliation.shared.EntityClass;
import edu.ycp.cs320spring2015.oubliation.shared.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Headwear;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Shield;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Suit;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Utility;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Weapon;

/**
 * Living/dead/undead entities within the game world
 */
public abstract class Actor extends EntityClass implements HasIdentity, Serializable {
	private static final long serialVersionUID = -1804243837789490964L;
	public Actor() {}

	private int health;

	private Loadout loadout; // contains all equipment
	
	/**
	 * 
	 * @param nameTag {@link NameTag}
	 * @param loadout {@link Loadout}All the equipment that the actor has on their body.
	 * @param health How much life-force that the actor has until death.
	 */
	public Actor(NameTag nameTag, Loadout loadout, int health) {
		super(nameTag);
		this.loadout = loadout;
		this.health = health;
	}
	
	//TODO: public abstract int startTurn();
	
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
	 * @return the equipped items 
	 */
	protected Loadout getLoadout() {
		return loadout;
	}
	/**
	 * @return the equipped headwear
	 */
	public Headwear getHeadwear() {
		return loadout.getHeadwear();
	}
	/**
	 * @return the equipped suit 
	 */
	public Suit getSuit() {
		return loadout.getSuit();
	}
	/**
	 * @return the equipped shield 
	 */
	public Shield getShield() {
		return loadout.getShield();
	}
	/**
	 * @return the equipped item in the hand slot
	 */
	public Weapon getHand() {
		return loadout.getHand();
	}
	/**
	 * @return the equipped utility belt
	 */
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
