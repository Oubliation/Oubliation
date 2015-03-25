package edu.ycp.cs320spring2015.oubliation.shared.category.identity;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

import edu.ycp.cs320spring2015.oubliation.shared.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.BruceScore;

/**
 * 
 * Kind of creature a player actor may be
 *
 */
public class PlayerSpecies extends Species {
	private static final long serialVersionUID = 82279970986527165L;
	
	private Map<BruceScore, Integer> baseScores; //base attribute value provided by this species
	
	public PlayerSpecies(NameTag nameTag,
			EnumMap<BruceScore, Integer> baseScores) {
		super(nameTag);
		this.baseScores = Collections.unmodifiableMap(baseScores);
	}
	
	/**
	 * 
	 * @param score attribute to evaluate  
	 * @return base attribute value provided this species
	 */
	public int getBaseScore(BruceScore score) {
		return baseScores.get(score);
	}
}
