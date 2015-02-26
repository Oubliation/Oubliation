package edu.ycp.cs320spring2015.shared.category;

import java.util.EnumMap;

import edu.ycp.cs320spring2015.oubliation.shared.character.BruceScore;

public abstract class Species implements Category {
	private EnumMap<BruceScore, Integer> baseScores;
	
	public Species(EnumMap<BruceScore, Integer> baseScores) {
		this.baseScores = baseScores;
	}

	public int getBaseScore(BruceScore score) {
		return baseScores.get(score);
	}
}
