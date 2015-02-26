package edu.ycp.cs320spring2015.shared.category;

import java.util.EnumMap;
import java.util.TreeSet;

import edu.ycp.cs320spring2015.oubliation.shared.character.BruceScore;

public class Background implements Category {
	private EnumMap<BruceScore, Double> bruceGainRate;
	private Background backgroundRival;
	private TreeSet<Job> jobBlacklist;
	
	public int getScoreGain(BruceScore score, int level) {
		return (int) (bruceGainRate.get(score)*level);
	}
	
	public boolean isCompatibleBackground(Background bg) {
		return bg != backgroundRival;
	}
	public boolean isCompatibleJob(Job job) {
		return !jobBlacklist.contains(job);
	}
}
