package edu.ycp.cs320spring2015.oubliation.shared.actor;

import java.io.Serializable;

import edu.ycp.cs320spring2015.oubliation.shared.category.identity.Background;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.Job;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.Species;

/**
 * 
 * An actor's identifying characteristics
 *
 */
public class Identity {
	final private Background background;
	final private Species species;
	final private Job job;
	
	/**
	 * 
	 * @param background {@link Background}
	 * @param species {@link Species}
	 * @param job {@link Job}
	 */
	public Identity(Background background, Species species, Job job) {
		this.background = background;
		this.species = species;
		this.job = job;
	}
	
	/**
	 * 
	 * @return The actors background name
	 */
	public String getBackgroundName() {
		return background.getName();
	}
	/**
	 * 
	 * @return The actors background description
	 */
	public String getBackgroundDescription() {
		return background.getDescription();
	}
	/**
	 * 
	 * @return The actors species name
	 */
	public String getSpeciesName() {
		return species.getName();
	}
	/**
	 * 
	 * @return The actors species description.
	 */
	public String getSpeciesDescription() {
		return species.getDescription();
	}
	/**
	 * 
	 * @return The actors job name
	 */
	public String getJobName() {
		return job.getName();
	}
	/**
	 * 
	 * @return The actors job description
	 */
	public String getJobDescription() {
		return job.getDescription();
	}
}
