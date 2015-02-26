package edu.ycp.cs320spring2015.shared.category;

import java.util.TreeMap;

import edu.ycp.cs320spring2015.oubliation.shared.character.BruceScore;

public class Job implements Category {
	
	private TreeMap<BruceScore, Integer> requiredScores;
	private int[] expChart;
	private int extraLvExp;
	private int hitCountGainLv;
	private int baseMaxHp;
	private int maxHpGain;
	
	//TODO: implement spell schools
	
	public Job(TreeMap<BruceScore, Integer> requiredScores, int[] expChart, int extraLvExp,
			int hitCountGainLv, int baseMaxHp, int maxHpGain) {
		this.requiredScores = requiredScores;
		this.expChart = expChart;
		this.extraLvExp = extraLvExp;
		this.hitCountGainLv = hitCountGainLv;
		this.baseMaxHp = baseMaxHp;
		this.maxHpGain = maxHpGain;
	}
	
	public TreeMap<BruceScore, Integer> getRequirements() {
		return requiredScores;
	}

	public int getLevel(int experience) {
		int maxLevel = expChart.length-1;
		for (int level=0; level<maxLevel; level++) {
			if (expChart[level] < experience) { return level+1; }
		}
		
		int maxExp = expChart[maxLevel];
		return maxLevel+1 + (experience-maxExp)/extraLvExp;
	}
	
	public int getHitCount(int level) {
		return level/hitCountGainLv + 1;
	}
	
	public int getMaxHp(int level) {
		return baseMaxHp + level*maxHpGain;
	}
	
	public void getSpells() {
		
	}
}
