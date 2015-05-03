package edu.ycp.cs320spring2015.oubliation.shared.actor;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.EnumMap;

import edu.ycp.cs320spring2015.oubliation.shared.EntityClass;
import edu.ycp.cs320spring2015.oubliation.shared.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.category.Element;
import edu.ycp.cs320spring2015.oubliation.shared.items.Headwear;
import edu.ycp.cs320spring2015.oubliation.shared.items.Shield;
import edu.ycp.cs320spring2015.oubliation.shared.items.Suit;
import edu.ycp.cs320spring2015.oubliation.shared.items.Utility;
import edu.ycp.cs320spring2015.oubliation.shared.items.Weapon;
import edu.ycp.cs320spring2015.oubliation.shared.statuses.ActionModifier;
import edu.ycp.cs320spring2015.oubliation.shared.statuses.Corpse;
import edu.ycp.cs320spring2015.oubliation.shared.statuses.Status;
import edu.ycp.cs320spring2015.oubliation.shared.targets.BattleController;

/**
 * Living/dead/undead entities within the game world
 */
public abstract class Actor extends EntityClass implements HasIdentity, Serializable {
	private static final long serialVersionUID = -1804243837789490964L;
	public Actor() {}

	private int health;
	private Status status;
	private Loadout loadout; // contains all equipment
	private EnumMap<Element, Double> elementalMods;
	
	/**
	 * 
	 * @param nameTag {@link NameTag}
	 * @param loadout {@link Loadout}All the equipment that the actor has on their body.
	 * @param health How much life-force that the actor has until death.
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public Actor(NameTag nameTag, int health, Status status, Loadout loadout, EnumMap<Element, Double> elementalMods) {
		super(nameTag);
		this.health = health;
		this.status = status.refresh();
		this.loadout = loadout;
		this.elementalMods = elementalMods;
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
	
	public abstract int getInitiative();
	
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
	
	public Status getStatus() {
		return status;
	}
	
	public String getStatusName() {
		return status.getName();
	}
	
	public ActionModifier getActionModifier(Actor target) {
		return status.getActionModifier(this, target);
	}
	public ActionModifier getTargetModifier() {
		return status.getTargetModifier(this);
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
	
	public abstract int getAttackMod();
	public abstract int getAccuracyMod();
	protected abstract int getEvasion();
	public abstract void selectAnyBattleBehavior(BattleController controller);
	
	
	/**
	 * @return whether attack has hit or missed
	 */
	public boolean hitTest(int accuracy) {
		return (0.70 + 0.05*(accuracy+getAccuracyMod()-getEvasion())) *2 >= Math.random()+Math.random();
	}
	
	/**
	 * @param amount amount of healing received
	 */
	public int receiveHealing(int amount) {
		health += amount;
		int maxHealth = getMaxHealth();
		if (health > maxHealth) {
			health = maxHealth;
		}
		return amount;
	}
	/**
	 * @param amount amount of damage received
	 */
	public int receiveDamage(int amount, Element element) {
		int finalAmount = Math.max(amount-getArmorRank(), 0)*elementalMods.get(element).intValue();
		health -= Math.max(amount-getArmorRank(), 0)*elementalMods.get(element);
		if (health <= 0) {
			health = 0;
			setStatus(new Corpse());
		}
		return finalAmount;
	}
	/**
	 * status to be afflicted with; not implemented yet
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
	
}
