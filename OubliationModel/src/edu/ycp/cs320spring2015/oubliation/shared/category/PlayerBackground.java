package edu.ycp.cs320spring2015.oubliation.shared.category;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;

import edu.ycp.cs320spring2015.oubliation.shared.character.BruceScore;

public class PlayerBackground extends Background {
	final private Map<BruceScore, Double> bruceGainRate;
	final private PlayerBackground rivalBackground;
	final private NavigableSet<PlayerJob> jobBlacklist;
	
	public PlayerBackground(String name, String description,
			EnumMap<BruceScore, Double> bruceGainRate,
			PlayerBackground rivalBackground,
			TreeSet<PlayerJob> jobBlacklist) {
		super(name, description);
		this.bruceGainRate = Collections.unmodifiableMap(bruceGainRate);
		this.rivalBackground = rivalBackground;
		this.jobBlacklist = Collections.unmodifiableNavigableSet(jobBlacklist);
	}

	public int getScoreGain(BruceScore score, int level) {
		return (int) (bruceGainRate.get(score)*level);
	}

	public boolean isCompatibleBackground(PlayerBackground bg) {
		return bg != rivalBackground;
	}
	public boolean isCompatibleJob(PlayerJob job) {
		return !jobBlacklist.contains(job);
	}
}
