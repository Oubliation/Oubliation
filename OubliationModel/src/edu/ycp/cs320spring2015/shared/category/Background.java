package edu.ycp.cs320spring2015.shared.category;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;

import edu.ycp.cs320spring2015.oubliation.shared.character.BruceScore;

public class Background implements Category {
	private Map<BruceScore, Double> bruceGainRate;
	private Background rivalBackground;
	private NavigableSet<Job> jobBlacklist;
	
	public Background(EnumMap<BruceScore, Double> bruceGainRate,
			Background rivalBackground, TreeSet<Job> jobBlacklist) {
		this.bruceGainRate = Collections.unmodifiableMap(bruceGainRate);
		this.rivalBackground = rivalBackground;
		this.jobBlacklist = Collections.unmodifiableNavigableSet(jobBlacklist);
	}

	public int getScoreGain(BruceScore score, int level) {
		return (int) (bruceGainRate.get(score)*level);
	}
	
	public boolean isCompatibleBackground(Background bg) {
		return bg != rivalBackground;
	}
	public boolean isCompatibleJob(Job job) {
		return !jobBlacklist.contains(job);
	}
}
