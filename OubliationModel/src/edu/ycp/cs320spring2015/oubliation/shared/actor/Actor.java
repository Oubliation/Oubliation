package edu.ycp.cs320spring2015.oubliation.shared.actor;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.EnumMap;

import edu.ycp.cs320spring2015.oubliation.shared.EntityClass;
import edu.ycp.cs320spring2015.oubliation.shared.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.Loadout;
import edu.ycp.cs320spring2015.oubliation.shared.category.Element;
import edu.ycp.cs320spring2015.oubliation.shared.statuses.ActionModifier;
import edu.ycp.cs320spring2015.oubliation.shared.statuses.Corpse;
import edu.ycp.cs320spring2015.oubliation.shared.statuses.Healthy;
import edu.ycp.cs320spring2015.oubliation.shared.statuses.Status;
import edu.ycp.cs320spring2015.oubliation.shared.targets.HasBehavior;
import edu.ycp.cs320spring2015.oubliation.shared.targets.PartyController;

/**
 * Living/dead/undead entities within the game world
 */
public abstract class Actor extends EntityClass implements Serializable, HasBehavior {
	private static final long serialVersionUID = -1804243837789490964L;
	public Actor() {}

	private int health;
	private Status status;
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
	public Actor(NameTag nameTag, int health, Status status, EnumMap<Element, Double> elementalMods) {
		super(nameTag);
		this.health = health;
		this.status = status.refresh();
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
	 * @return remaining health points 
	 */
	public int getHealth() {
		return health;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public Class<? extends Status> getStatusClass() {
		return status.getClass();
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
	
	public abstract int getAttackMod();
	public abstract int getAccuracyMod();
	public abstract int getArmorRank();
	protected abstract int getEvasion();
	public abstract void selectAnyBehavior(PartyController controller);
	
	
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
		assert(getStatusClass() != Corpse.class);
		this.status = status;
	}
	
	public void revive(int healing) {
		assert(getStatusClass() == Corpse.class);
		receiveHealing(healing);
		this.status = new Healthy();
	}
	
}
