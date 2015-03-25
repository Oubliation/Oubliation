package edu.ycp.cs320spring2015.oubliation.shared.actor.player;

import java.util.LinkedList;

import edu.ycp.cs320spring2015.oubliation.shared.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;
import edu.ycp.cs320spring2015.oubliation.shared.actor.Loadout;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Equipment;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Utility;

/**
 * TODO: Come back here! Complete JavaDoc
 * An actor controlled by the player;extends Actor
 *
 */
final public class PlayerActor extends Actor {
	private static final long serialVersionUID = -6349964020742433276L;
	@SuppressWarnings("unused") private PlayerActor () { super(); }
	
	private PlayerIdentity identity;
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
	 * @see PlayerIdentity#getLevel()
	 */
	public int getLevel() {
		return identity.getLevel();
	}
	/**
	 * @see PlayerIdentity#updateLevel()
	 */
	public void updateLevel() {
		identity.updateLevel();
	}
	/**
	 * @see PlayerIdentity#isLevelUpReady()
	 */
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
	
	/**
	 * @see PlayerStats#getWitchMp(int)
	 */
	public int getWitchMp(int level) {
		return stats.getWitchMp(level);
	}
	/**
	 * @see PlayerStats#getPriestMp(int)
	 */
	public int getPriestMp(int level) {
		return stats.getPriestMp(level);
	}

	/**
	 * @param equipment to equip outside battle
	 */
	public void fieldEquip(Equipment equipment) {
		equipment.equipTo(new FieldLoadoutAdaptor(getLoadout(), stats));
	}
	
	/**
	 * @param equipment to unequip outside battle
	 */
	public void fieldUnequip(Equipment equipment) {
		equipment.unequipFrom(new FieldLoadoutAdaptor(getLoadout(), stats));
	}
	/**
	 * @param add equipment to the battle equip queue
	 */
	public void queueEquipment(Equipment equipment) {
		battleEquipQueue.add(equipment);
	}
	/**
	 * @param remove equipment from the battle equip queue
	 */
	public void dequeueEquipment(Equipment equipment) {
		battleEquipQueue.remove(equipment);
	}
	/**
	 * equip next equipment in the battle equip queue
	 */
	public void advanceBattleQueue() {
		battleEquipQueue.pop().equipTo(getLoadout());
	}
	/**
	 * @param equipment to unequip
	 */
	public void battleUnequip(Equipment equipment) {
		equipment.unequipFrom(getLoadout());
	}
	
	public Utility[] getAutoEquip() {
		return stats.getAutoEquip();
	}
	
	public void startBattle() {
		
	}
	public void endBattle() {
		
	}
	
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
