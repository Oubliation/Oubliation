package edu.ycp.cs320spring2015.oubliation.shared.character;

import java.util.ArrayList;
import java.util.LinkedList;

import edu.ycp.cs320spring2015.oubliation.shared.category.PlayerBackground;
import edu.ycp.cs320spring2015.oubliation.shared.category.PlayerJob;
import edu.ycp.cs320spring2015.oubliation.shared.category.PlayerSpecies;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Equipment;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Helmet;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Shield;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Suit;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Utility;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Weapon;

final public class PlayerUnit extends Unit {
	
	final private PlayerBackground background;
	final private PlayerSpecies species;
	final private PlayerJob job;
	
	private int witchMp[];
	private int priestMp[];
	
	private LinkedList<Equipment> battleEquipQueue;
	private ArrayList<Utility> utilityQueue;
	private int experience;
	
	public PlayerUnit(String name, String description, Helmet helmet,
			Suit suit, Shield shield, Weapon hand,
			ArrayList<Utility> utilityBelt, PlayerBackground background,
			PlayerSpecies species, PlayerJob job, int[] witchMp,
			int[] priestMp, LinkedList<Equipment> battleEquipQueue,
			ArrayList<Utility> utilityQueue, int experience) {
		super(name, description, helmet, suit, shield, hand, utilityBelt);
		this.background = background;
		this.species = species;
		this.job = job;
		this.witchMp = witchMp;
		this.priestMp = priestMp;
		this.battleEquipQueue = battleEquipQueue;
		this.utilityQueue = utilityQueue;
		this.experience = experience;
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

	public void fieldEquip(Helmet equipment) {
		assert helmet == null;
		helmet = equipment;
	}
	public void fieldEquip(Suit equipment) {
		assert suit == null;
		suit = equipment;
	}
	public void fieldEquip(Weapon equipment) {
		assert hand == null;
		hand = equipment;
	}
	public void fieldEquip(Utility equipment) {
		utilityQueue.add(equipment);
		assert utilityQueue.size() <= job.getUtilitySlotCount();
	}
	public void fieldEquip(Equipment equipment) {
		throw new UnsupportedOperationException();
	}
	public void battleEquip(Utility equipment) {
		utilityBelt.add(equipment);
		assert utilityBelt.size() <= job.getUtilitySlotCount();
	}
	public void battleEquip(Equipment equipment) {
		fieldEquip(equipment);
	}
	
	public void advanceBattleQueue() {
		battleEquip(battleEquipQueue.pop());
	}
	public void queueEquipment(Equipment equipment) {
		battleEquipQueue.add(equipment);
		//TODO: a test to make sure nothing will overflow?
	}
	public void dequeueEquipment(Equipment equipment) {
		boolean hadEquipment = battleEquipQueue.remove(equipment);
		assert hadEquipment;
	}
	

	public void fieldUnequip(Helmet equipment) {
		assert helmet == equipment;
		helmet = null;
	}
	public void fieldUnequip(Suit equipment) {
		assert suit == equipment;
		suit = null;
	}
	public void fieldUnequip(Weapon equipment) {
		assert hand == equipment;
		hand = null;
	}
	public void fieldUnequip(Utility equipment) {
		boolean haveEquipment = utilityQueue.remove(equipment);
		assert haveEquipment;
	}
	public void fieldUnequip(Equipment equipment) {
		throw new UnsupportedOperationException();
	}
	public void battleUnequip(Utility equipment) {
		boolean haveEquipment = utilityBelt.remove(equipment);
		assert haveEquipment;
	}
	public void battleUnequip(Equipment equipment) {
		fieldUnequip(equipment);
	}
	
	public int getScores(BruceScore score) {
		int baseAmount = species.getBaseScore(score);
		int gainAmount = background.getScoreGain(score, getLevel());
		
		return baseAmount+gainAmount;
	}
	
	public int getLevel() {
		return job.getLevel(experience);
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
}
