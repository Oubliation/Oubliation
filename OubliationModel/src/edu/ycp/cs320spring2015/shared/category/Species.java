package edu.ycp.cs320spring2015.shared.category;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

import edu.ycp.cs320spring2015.oubliation.shared.character.BruceScore;

public abstract class Species implements Category {
	private Map<BruceScore, Integer> baseScores;
	
	public Species(EnumMap<BruceScore, Integer> baseScores) {
		this.baseScores = Collections.unmodifiableMap(baseScores);
	}

	public int getBaseScore(BruceScore score) {
		return baseScores.get(score);
	}
}
