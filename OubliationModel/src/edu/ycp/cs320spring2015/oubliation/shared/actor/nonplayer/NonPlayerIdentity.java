package edu.ycp.cs320spring2015.oubliation.shared.actor.nonplayer;

import edu.ycp.cs320spring2015.oubliation.shared.actor.HasIdentity;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.Background;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.Job;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.Species;

/**
 * 
 * A non-player actor's identifying characteristics
 *
 */
public class NonPlayerIdentity implements HasIdentity {
	final private Background background;
	final private Species species;
	final private Job job;
	
	/**
	 * 
	 * @param background {@link Background}
	 * @param species {@link Species}
	 * @param job {@link Job}
	 */
	public NonPlayerIdentity(Background background, Species species, Job job) {
		this.background = background;
		this.species = species;
		this.job = job;
	}
	public String getBackgroundName() {
		return background.getName();
	}
	public String getBackgroundDescription() {
		return background.getDescription();
	}
	public String getSpeciesName() {
		return species.getName();
	}
	public String getSpeciesDescription() {
		return species.getDescription();
	}
	public String getJobName() {
		return job.getName();
	}
	public String getJobDescription() {
		return job.getDescription();
	}
}
