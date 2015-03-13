package edu.ycp.cs320spring2015.oubliation.shared.actor.player;

import java.util.LinkedList;

import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;
import edu.ycp.cs320spring2015.oubliation.shared.actor.Loadout;
import edu.ycp.cs320spring2015.oubliation.shared.category.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Equipment;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Headwear;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Shield;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Suit;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Utility;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Weapon;

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
	
	//FIXME:
//	public void advanceBattleQueue() {
//		getLoadout().battleEquip(battleEquipQueue.pop());
//	}
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
	
	
	//TODO: get rid of this awful hack
	public void fieldEquip(Headwear equipment) {
		getLoadout().fieldEquip(equipment);
	}

	public void fieldEquip(Suit equipment) {
		getLoadout().fieldEquip(equipment);
	}

	public void fieldEquip(Shield equipment) {
		getLoadout().fieldEquip(equipment);
	}

	public void fieldEquip(Weapon equipment) {
		getLoadout().fieldEquip(equipment);
	}

	public void battleEquip(Utility equipment) {
		getLoadout().battleEquip(equipment);
	}

	public void battleEquip(Headwear equipment) {
		getLoadout().battleEquip(equipment);
	}

	public void battleEquip(Suit equipment) {
		getLoadout().battleEquip(equipment);
	}

	public void battleEquip(Shield equipment) {
		getLoadout().battleEquip(equipment);
	}

	public void battleEquip(Weapon equipment) {
		getLoadout().battleEquip(equipment);
	}

	public void fieldUnequip(Headwear equipment) {
		getLoadout().fieldUnequip(equipment);
	}

	public void fieldUnequip(Suit equipment) {
		getLoadout().fieldUnequip(equipment);
	}

	public void fieldUnequip(Shield equipment) {
		getLoadout().fieldUnequip(equipment);
	}

	public void fieldUnequip(Weapon equipment) {
		getLoadout().fieldUnequip(equipment);
	}

	public void battleUnequip(Utility equipment) {
		getLoadout().battleUnequip(equipment);
	}

	public void battleUnequip(Headwear equipment) {
		getLoadout().battleUnequip(equipment);
	}

	public void battleUnequip(Suit equipment) {
		getLoadout().battleUnequip(equipment);
	}

	public void battleUnequip(Shield equipment) {
		getLoadout().battleUnequip(equipment);
	}

	public void battleUnequip(Weapon equipment) {
		getLoadout().battleUnequip(equipment);
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
