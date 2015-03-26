package edu.ycp.cs320spring2015.oubliation.shared.category.identity;

import java.util.EnumMap;
import java.util.TreeSet;

import edu.ycp.cs320spring2015.oubliation.shared.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.BruceScore;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.PlayerActor;

/**
 * 
 * Background context which an player actor might come from
 *
 */
public class PlayerBackground extends Background {
	private static final long serialVersionUID = 5665319881433223605L;
	public PlayerBackground() {}
	
	private EnumMap<BruceScore, Double> bruceGainRate;
	private TreeSet<String> jobBlacklist;
	private String backgroundRival;
	
	public PlayerBackground(NameTag nameTag,
			EnumMap<BruceScore, Double> bruceGainRate,
			TreeSet<String> jobBlacklist,
			String backgroundRival) {
		super(nameTag);
		this.bruceGainRate = bruceGainRate;
		this.jobBlacklist = jobBlacklist;
		this.backgroundRival = backgroundRival;
	}
	
	/**
	 * @param score B.R.U.C.E. score (attribute) to evaluate
	 * @param level experience level to match
	 * @return value of the attribute gained at level x provided this background 
	 */
	public int getScoreGain(BruceScore score, int level) {
		return (int) (bruceGainRate.get(score)*level);
	}
	
	/**
	 * @param job to test
	 * @return whether or not job is compatible with this background
	 */
	public boolean isCompatibleJob(PlayerJob job) {
		return !jobBlacklist.contains(job.getName());
	}
	
	public boolean hasCompatibleBackground(PlayerActor actor) {
		return backgroundRival != actor.getBackgroundName();
	}
}
