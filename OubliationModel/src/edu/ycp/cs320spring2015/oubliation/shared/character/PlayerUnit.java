package edu.ycp.cs320spring2015.oubliation.shared.character;

import edu.ycp.cs320spring2015.shared.category.Background;
import edu.ycp.cs320spring2015.shared.category.Job;
import edu.ycp.cs320spring2015.shared.category.Species;

public class PlayerUnit extends Unit {
	
	private Job job;
	private Species species;
	private Background background;
	
	private int experience;
	
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
