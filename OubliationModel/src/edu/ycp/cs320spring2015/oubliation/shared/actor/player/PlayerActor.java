package edu.ycp.cs320spring2015.oubliation.shared.actor.player;

import java.util.LinkedList;

import edu.ycp.cs320spring2015.oubliation.shared.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;
import edu.ycp.cs320spring2015.oubliation.shared.actor.Loadout;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Equipment;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Headwear;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Shield;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Suit;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Utility;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Weapon;

/**
 * TODO: Come back here! Complete JavaDoc
 * An actor controlled by the player;extends Actor
 *
 */
final public class PlayerActor extends Actor {
	
	final private PlayerIdentity identity;
	private PlayerStats stats;
	
	private LinkedList<Equipment> battleEquipQueue;
	
	/**
	 * 
	 * @param nameTag {@link NameTag}
	 * @param loadout {@link Loadout}
	 * @param health The amount of life-force that an actor has before death.
	 * @param identity {@link PlayerIdentity}
	 * @param stats {@link PlayerStats}
	 */
	public PlayerActor(NameTag nameTag, Loadout loadout, int health,
			PlayerIdentity identity, PlayerStats stats) {
		super(nameTag, loadout, health);
		this.identity = identity;
		this.stats = stats;
	}
	/**
	 * 
	 * @see PlayerIdentity#getLevel()
	 */
	public int getLevel() {
		return identity.getLevel();
	}
	public void updateLevel() {
		identity.updateLevel();
	}
	public boolean isLevelUpReady() {
		return identity.isLevelUpReady();
	}
	
	public String getBackgroundName() {
		return identity.getBackgroundName();
	}
	public String getBackgroundDescription() {
		return identity.getBackgroundDescription();
	}

	public String getSpeciesName() {
		return identity.getSpeciesName();
	}
	public String getSpeciesDescription() {
		return identity.getSpeciesDescription();
	}
	public String getJobName() {
		return identity.getJobName();
	}
	public String getJobDescription() {
		return identity.getJobDescription();
	}
	/**
	 * 
	 * @see PlayerStats#getMaxWitchMp()
	 */
	public int getMaxWitchMp(int level) {
		//TODO: implement
		return stats.getWitchMp(level);
	}
	/**
	 * 
	 * @see PlayerStats#getMaxPriestMp()
	 */
	public int getMaxPriestMp(int level) {
		//TODO: implement
		return stats.getPriestMp(level);
	}

	public int getWitchMp(int level) {
		return stats.getWitchMp(level);
	}
	public int getPriestMp(int level) {
		return stats.getPriestMp(level);
	}
	
	
	public void equip(Equipment equipment) {
		equipment.equipTo(getLoadout());
	}
	
	public void unequip(Equipment equipment) {
		equipment.unequipFrom(getLoadout());
	}
	
	//FIXME:
//	public void advanceBattleQueue() {
//		getLoadout().battleEquip(battleEquipQueue.pop());
//	}
	

	
	
	
	
	public int getScore(BruceScore score) {
		return identity.getScores(score);
	}
	public int getHitCount() {
		return identity.getHitCount();
	}

	public int getMaxHealth() {
		return identity.getMaxHealth();
	}
	
	public void incExperience(int amount) {
		identity.incExperience(amount);
	}
	public int getExperience() {
		return identity.getExperience();
	}
}
