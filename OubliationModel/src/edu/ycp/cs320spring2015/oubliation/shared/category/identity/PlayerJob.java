package edu.ycp.cs320spring2015.oubliation.shared.category.identity;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

import edu.ycp.cs320spring2015.oubliation.shared.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.BruceScore;

public class PlayerJob extends Job {
	
	final private Map<BruceScore, Integer> requiredScores;
	final private int[] expChart;
	final private int extraLvExp;
	final private int baseHitCount;
	final private int baseMaxHp;
	final private int maxHpGain;
	final private int utilitySlotCount;
	
	//TODO: implement spell schools
	
	public PlayerJob(NameTag nameTag,
			EnumMap<BruceScore, Integer> requiredScores, int[] expChart,
			int extraLvExp, int baseHitCount, int baseMaxHp, int maxHpGain,
			int utilitySlotCount) {
		super(nameTag);
		this.requiredScores = Collections.unmodifiableMap(requiredScores);
		this.expChart = expChart;
		this.extraLvExp = extraLvExp;
		this.baseHitCount = baseHitCount;
		this.baseMaxHp = baseMaxHp;
		this.maxHpGain = maxHpGain;
		this.utilitySlotCount = utilitySlotCount;
	}

	public boolean meetsRequirement(BruceScore score, int amount) {
		return requiredScores.get(score) <= amount;
	} //TODO: requirement iterator? would iterate only over required scores

	public int getLevel(int experience) {
		int maxLevel = expChart.length-1;
		for (int level=0; level<maxLevel; level++) {
			if (expChart[level] > experience) { return level+1; }
		}
		
		int maxExp = expChart[maxLevel];
		return maxLevel+1 + (experience-maxExp)/extraLvExp;
	}
	
	public int getHitCount() {
		return baseHitCount;
	}
	
	public int getMaxHp(int level) {
		return baseMaxHp + (level*maxHpGain);
	}
	
	public int getUtilitySlotCount() {
		return utilitySlotCount;
	}
	
	public void getSpells() {
		
	}
}
