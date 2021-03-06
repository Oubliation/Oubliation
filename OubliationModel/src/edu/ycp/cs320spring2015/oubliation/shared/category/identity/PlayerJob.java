package edu.ycp.cs320spring2015.oubliation.shared.category.identity;

import java.util.EnumMap;

import edu.ycp.cs320spring2015.oubliation.shared.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.BruceScore;

/**
 * 
 * Job (class) which an actor may hold
 *
 */
public class PlayerJob extends Job {
	private static final long serialVersionUID = -8431500043835535609L;
	public PlayerJob() {}
	
	private EnumMap<BruceScore, Integer> requiredScores; // attributes required to aquire this job
	private Integer[] expChart; //experience needed to reach each level
	private int extraLvExp; //experience needed to reach levels beyond expChart
	private int baseHitCount; //base number of hits performed by this job
	private int baseMaxHp; //base maximum health provided by this job
	private int maxHpGain; //maximum health gained on each level up
	private int utilitySlotCount; //number of slots for utilities this class may have
	
	//TODO: implement spell schools
	
	public PlayerJob(NameTag nameTag,
			EnumMap<BruceScore, Integer> requiredScores, Integer[] expChart,
			int extraLvExp, int baseHitCount, int baseMaxHp, int maxHpGain,
			int utilitySlotCount) {
		super(nameTag);
		this.requiredScores = requiredScores;
		this.expChart = expChart;
		this.extraLvExp = extraLvExp;
		this.baseHitCount = baseHitCount;
		this.baseMaxHp = baseMaxHp;
		this.maxHpGain = maxHpGain;
		this.utilitySlotCount = utilitySlotCount;
	}
	
	/**
	 * 
	 * @param score B.R.U.C.E. score (attribute) who value is checked
	 * @param amount value to test against requirements
	 * @return whether or not 
	 */
	public boolean meetsRequirement(BruceScore score, int amount) {
		return requiredScores.get(score) <= amount;
	} //TODO: requirement iterator? would iterate only over required scores
	
	/**
	 * @param experience value to match
	 * @return experience level actor with x experience could achieve
	 */
	public int getLevel(int experience) {
		int maxLevel = expChart.length-1;
		for (int level=0; level<maxLevel; level++) {
			if (expChart[level] > experience) { return level+1; }
		}
		
		int maxExp = expChart[maxLevel];
		return maxLevel+1 + (experience-maxExp)/extraLvExp;
	}
	
	/**
	 * 
	 * @return base number of hits this class could strike
	 */
	public int getHitCount() {
		return baseHitCount;
	}
	
	/**
	 * @param level experience level to match
	 * @return base maximum health held at experience x
	 */
	public int getMaxHp(int level) {
		return baseMaxHp + (level*maxHpGain);
	}
	
	/**
	 * 
	 * @return base number of slots for equipped utilities provided by class
	 */
	public int getUtilitySlotCount() {
		return utilitySlotCount;
	}
	
	//TODO:
	public void getSpells() {
		
	}
}
