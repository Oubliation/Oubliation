package edu.ycp.cs320spring2015.shared.category;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

import edu.ycp.cs320spring2015.oubliation.shared.character.BruceScore;

public class Job implements Category {
	
	private Map<BruceScore, Integer> requiredScores;
	private int[] expChart;
	private int extraLvExp;
	private int hitCountGainLv;
	private int baseMaxHp;
	private int maxHpGain;
	private int utilitySlotCount;
	
	//TODO: implement spell schools
	
	public Job(EnumMap<BruceScore, Integer> requiredScores, int[] expChart, int extraLvExp,
			int hitCountGainLv, int baseMaxHp, int maxHpGain) {
		this.requiredScores = Collections.unmodifiableMap(requiredScores);
		this.expChart = expChart;
		this.extraLvExp = extraLvExp;
		this.hitCountGainLv = hitCountGainLv;
		this.baseMaxHp = baseMaxHp;
		this.maxHpGain = maxHpGain;
	}
	
	public int getRequirement(BruceScore score) {
		return requiredScores.get(score);
	} //TODO: requirement iterator? would iterate only over required scores

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
	
	public int getUtilitySlotCount() {
		return utilitySlotCount;
	}
	
	public void getSpells() {
		
	}
}
