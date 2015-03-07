package edu.ycp.cs320spring2015.oubliation.shared.actor.player;

import edu.ycp.cs320spring2015.oubliation.shared.category.identity.PlayerBackground;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.PlayerJob;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.PlayerSpecies;

public class PlayerIdentity {
	final private PlayerBackground background;
	final private PlayerSpecies species;
	final private PlayerJob job;
	int level;
	int experience;
	
	public PlayerIdentity(PlayerBackground background, PlayerSpecies species, PlayerJob job, int level, int experience) {
		this.background = background;
		this.species = species;
		this.job = job;
		this.level = level;
		this.experience = experience;
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
	

	public void updateLevel() {
		level = job.getLevel(experience);
	}
	public int getLevel() {
		return level;
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
	public int getUtilitySlotCount() {
		return job.getUtilitySlotCount();
	}
	public void getSpells() {
		job.getSpells();
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
