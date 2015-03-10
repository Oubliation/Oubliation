package edu.ycp.cs320spring2015.oubliation.shared.actor.player;

import java.util.LinkedList;

import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;
import edu.ycp.cs320spring2015.oubliation.shared.actor.Loadout;
import edu.ycp.cs320spring2015.oubliation.shared.category.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Equipment;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Utility;

final public class PlayerActor extends Actor {
	
	final private PlayerIdentity identity;
	private PlayerStats stats;
	
	private LinkedList<Equipment> battleEquipQueue;
	
	public PlayerActor(NameTag nameTag, Loadout loadout, int health,
			PlayerIdentity identity, PlayerStats stats) {
		super(nameTag, loadout, health);
		this.identity = identity;
		this.stats = stats;
	}
	
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

	public int getWitchMp(int level) {
		return stats.getWitchMp(level);
	}
	public int getPriestMp(int level) {
		return stats.getPriestMp(level);
	}
	
	public int getMaxWitchMp(int level) {
		//TODO: implement
		return stats.getWitchMp(level);
	}
	public int getMaxPriestMp(int level) {
		//TODO: implement
		return stats.getPriestMp(level);
	}
	
	
	public void fieldEquip(Utility equipment) {
		stats.addUtility(equipment);
		assert stats.getUtilityQueue().length <= identity.getUtilitySlotCount();
	}
	public void fieldEquip(Equipment equipment) {
		getLoadout().fieldEquip(equipment);
	}
	public void battleEquip(Equipment equipment) {
		getLoadout().battleEquip(equipment);
		assert getLoadout().getEquippedUtilities().length <= identity.getUtilitySlotCount();
	}
	
	public void advanceBattleQueue() {
		getLoadout().battleEquip(battleEquipQueue.pop());
	}
	public void queueEquipment(Equipment equipment) {
		battleEquipQueue.add(equipment);
		//TODO: a test to make sure nothing will overflow?
	}
	public void dequeueEquipment(Equipment equipment) {
		boolean hadEquipment = battleEquipQueue.remove(equipment);
		assert hadEquipment;
	}
	
	public void fieldUnequip(Utility equipment) {
		stats.removeUtility(equipment);
	}
	public void fieldUnequip(Equipment equipment) {
		getLoadout().fieldUnequip(equipment);
	}
	public void battleUnequip(Equipment equipment) {
		getLoadout().fieldUnequip(equipment);
	}
	
	public int getScore(BruceScore score) {
		return identity.getScores(score);
	}
	public int getHitCount() {
		return identity.getHitCount();
	}

	public int getMaxHealth() {
		return identity.getMaxHp();
	}
	
	public void incExperience(int amount) {
		identity.incExperience(amount);
	}
	public int getExperience() {
		return identity.getExperience();
	}
}
