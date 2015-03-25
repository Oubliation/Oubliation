package edu.ycp.cs320spring2015.oubliation.shared.actor.player;

import java.io.Serializable;

import edu.ycp.cs320spring2015.oubliation.shared.actor.HasIdentity;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.PlayerBackground;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.PlayerJob;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.PlayerSpecies;

/**
 * 
 * An player actor's identifying characteristics; implements serializable
 *
 */
public class PlayerIdentity implements HasIdentity, Serializable {
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
	
	/**
	 * @return current experience level
	 */
	public int getLevel() {
		return level;
	}
	/**
	 * level up to appropriate level given current amount of experience
	 */
	public void updateLevel() {
		level = job.getLevel(experience);
	}
	/**
	 * @return whether or not actor could level up
	 */
	public boolean isLevelUpReady() {
		return (job.getLevel(experience) != level);
	}

	/**
	 * @param score B.R.U.C.E. score (attribute) to evaluate
	 * @return value of attribute given current level and this species and background
	 */
	public int getScores(BruceScore score) {
		int baseAmount = species.getBaseScore(score);
		int gainAmount = background.getScoreGain(score, getLevel());
		
		return baseAmount+gainAmount;
	}
	
	/**
	 * @see PlayerJob#getHitCount()
	 */
	public int getHitCount() {
		return job.getHitCount();
	}
	/**
	 * @see PlayerJob#getUtilitySlotCount()
	 */
	public int getUtilitySlotCount() {
		return job.getUtilitySlotCount();
	}
	/**
	 * @see PlayerJob#getSpells()
	 */
	public void getSpells() {
		job.getSpells();
	}
	
	/**
	 * @return maximum health given current level and job
	 */
	public int getMaxHealth() {
		int level = getLevel();
		return job.getMaxHp(level);
	}
	
	/**
	 * @param amount to increase experience
	 */
	public void incExperience(int amount) {
		experience += amount;
	}
	/**
	 * @return current amount of experience
	 */
	public int getExperience() {
		return experience;
	}
}
