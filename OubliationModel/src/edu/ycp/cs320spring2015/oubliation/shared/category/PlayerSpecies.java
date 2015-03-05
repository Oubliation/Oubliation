package edu.ycp.cs320spring2015.oubliation.shared.category;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

import edu.ycp.cs320spring2015.oubliation.shared.character.BruceScore;

public abstract class PlayerSpecies extends Species {
	final private Map<BruceScore, Integer> baseScores;

	public PlayerSpecies(NameTag nameTag,
			EnumMap<BruceScore, Integer> baseScores) {
		super(nameTag);
		this.baseScores = Collections.unmodifiableMap(baseScores);
	}

	public int getBaseScore(BruceScore score) {
		return baseScores.get(score);
	}
}
