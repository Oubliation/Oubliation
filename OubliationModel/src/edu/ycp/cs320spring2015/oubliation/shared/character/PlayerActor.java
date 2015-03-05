package edu.ycp.cs320spring2015.oubliation.shared.character;

import java.util.ArrayList;
import java.util.LinkedList;

import edu.ycp.cs320spring2015.oubliation.shared.category.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.category.PlayerBackground;
import edu.ycp.cs320spring2015.oubliation.shared.category.PlayerJob;
import edu.ycp.cs320spring2015.oubliation.shared.category.PlayerSpecies;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Equipment;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Utility;

final public class PlayerActor extends Actor {
	
	final private PlayerBackground background;
	final private PlayerSpecies species;
	final private PlayerJob job;
	
	private int level;
	private int witchMp[];
	private int priestMp[];
	
	private LinkedList<Equipment> battleEquipQueue;
	private ArrayList<Utility> utilityQueue;
	private int experience;
	
	public PlayerActor(NameTag nameTag, int health, Loadout loadout,
			PlayerBackground background, PlayerSpecies species, PlayerJob job,
			int level, int[] witchMp, int[] priestMp, ArrayList<Utility> utilityQueue,
			int experience) {
		super(nameTag, health, loadout);
		this.background = background;
		this.species = species;
		this.job = job;
		this.level = level;
		this.witchMp = witchMp;
		this.priestMp = priestMp;
		this.utilityQueue = utilityQueue;
		this.experience = experience;
	}
	
	public void updateLevel() {
		level = job.getLevel(experience);
	}
	public int getLevel() {
		return level;
	}
	
	public String getBackgroundName() {
		return background.getName();
	}
	public String getBackgroundDescription() {
		return background.getDescription();
	}
	public String getSpeciesName() {
		return species.getName();
	}
	public String getSpeciesDescription() {
		return species.getDescription();
	}
	public String getJobName() {
		return job.getName();
	}
	public String getJobDescription() {
		return job.getDescription();
	}

	public int getWitchMp(int level) {
		return witchMp[level];
	}
	public int getPriestMp(int level) {
		return priestMp[level];
	}
	
	public int getMaxWitchMp(int level) {
		return witchMp[level];
	}
	public int getMaxPriestMp(int level) {
		return priestMp[level];
	}
	
	
	public void fieldEquip(Utility equipment) {
		utilityQueue.add(equipment);
		assert utilityQueue.size() <= job.getUtilitySlotCount();
	}
	public void fieldEquip(Equipment equipment) {
		getLoadout().fieldEquip(equipment);
	}
	public void battleEquip(Equipment equipment) {
		getLoadout().battleEquip(equipment);
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
		boolean haveEquipment = utilityQueue.remove(equipment);
		assert haveEquipment;
	}
	public void fieldUnequip(Equipment equipment) {
		getLoadout().fieldUnequip(equipment);
	}
	public void battleUnequip(Equipment equipment) {
		getLoadout().fieldUnequip(equipment);
	}
	
	public int getScores(BruceScore score) {
		int baseAmount = species.getBaseScore(score);
		int gainAmount = background.getScoreGain(score, getLevel());
		
		return baseAmount+gainAmount;
	}
	
	public int getHitCount() {
		int level = getLevel();
		return job.getHitCount(level);
	}

	public boolean isCompatibleBackground(PlayerBackground bg) {
		return background.isCompatibleBackground(bg);
	}

	public int getMaxHp() {
		int level = getLevel();
		return job.getMaxHp(level);
	}
	
	public void incExperience(int amount) {
		experience += amount;
	}
	public int getExperience() {
		return experience;
	}
}
