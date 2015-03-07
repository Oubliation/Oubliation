package edu.ycp.cs320spring2015.oubliation.shared.category.identity;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;

import edu.ycp.cs320spring2015.oubliation.shared.actor.player.BruceScore;
import edu.ycp.cs320spring2015.oubliation.shared.category.NameTag;

public class PlayerBackground extends Background {
	final private Map<BruceScore, Double> bruceGainRate;
	final private PlayerBackground rivalBackground;
	final private NavigableSet<PlayerJob> jobBlacklist;
	
	public PlayerBackground(NameTag nameTag,
			EnumMap<BruceScore, Double> bruceGainRate,
			PlayerBackground rivalBackground,
			TreeSet<PlayerJob> jobBlacklist) {
		super(nameTag);
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
