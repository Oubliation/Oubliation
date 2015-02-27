package edu.ycp.cs320spring2015.oubliation.shared.character;

import java.util.ArrayList;
import java.util.LinkedList;

import edu.ycp.cs320spring2015.oubliation.shared.effect.Equipment;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Helmet;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Item;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Suit;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Utility;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Weapon;
import edu.ycp.cs320spring2015.shared.category.Background;
import edu.ycp.cs320spring2015.shared.category.Job;
import edu.ycp.cs320spring2015.shared.category.Species;

public class PlayerUnit extends Unit {
	
	private Job job;
	private Species species;
	private Background background;
	
	private int witchMp[];
	private int priestMp[];
	
	private LinkedList<Item> battleEquipQueue;
	private ArrayList<Item> utilityQueue;
	private int experience;
	
	public int getWitchMp(int level) {
		return witchMp[level];
	}
	public int getPriestMp(int level) {
		return priestMp[level];
	}

	public void equip(Helmet equipment) {
		assert helmet == null;
		helmet = equipment;
	}
	public void equip(Suit equipment) {
		assert suit == null;
		suit = equipment;
	}
	public void equip(Weapon equipment) {
		assert hand == null;
		hand = equipment;
	}
	public void equip(Utility equipment) {
		utilityQueue.add(equipment);
		assert utilityBelt.size() <= job.getUtilitySlotCount();
	}
	public void equip(Equipment equipment) {
		throw new UnsupportedOperationException();
	}
	public void battleEquip(Utility equipment) {
		utilityBelt.add(equipment);
		assert utilityBelt.size() <= job.getUtilitySlotCount();
	}
	public void battleEquip(Equipment equipment) {
		equip(equipment);
	}
	
	public void queueEquipment(Equipment equipment) {
		battleEquipQueue.add(equipment);
		//TODO: a test to make sure nothing will overflow?
	}
	public void dequeueEquipment(Equipment equipment) {
		boolean hadEquipment = battleEquipQueue.remove(equipment);
		assert hadEquipment;
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

	public boolean isCompatibleBackground(Background bg) {
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
