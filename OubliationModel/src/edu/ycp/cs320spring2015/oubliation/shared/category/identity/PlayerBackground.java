package edu.ycp.cs320spring2015.oubliation.shared.category.identity;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import edu.ycp.cs320spring2015.oubliation.shared.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.BruceScore;

/**
 * 
 * Background context which an player actor might come from
 *
 */
public class PlayerBackground extends Background {
	final private Map<BruceScore, Double> bruceGainRate;
	final private Set<PlayerJob> jobBlacklist;
	
	public PlayerBackground(NameTag nameTag,
			EnumMap<BruceScore, Double> bruceGainRate,
			TreeSet<PlayerJob> jobBlacklist) {
		super(nameTag);
		this.bruceGainRate = Collections.unmodifiableMap(bruceGainRate);
		this.jobBlacklist = Collections.unmodifiableSet(jobBlacklist);
	}
	
	/**
	 * @param score B.R.U.C.E. score (attribute) to check
	 * @param level experience level to match
	 * @return value of the attribute background gained at level x 
	 */
	public int getScoreGain(BruceScore score, int level) {
		return (int) (bruceGainRate.get(score)*level);
	}
	
	/**
	 * @param job to test
	 * @return whether or not job is compatible with this background
	 */
	public boolean isCompatibleJob(PlayerJob job) {
		return !jobBlacklist.contains(job);
	}
}
