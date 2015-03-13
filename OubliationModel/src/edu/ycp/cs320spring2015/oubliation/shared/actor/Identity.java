package edu.ycp.cs320spring2015.oubliation.shared.actor;

import java.io.Serializable;

import edu.ycp.cs320spring2015.oubliation.shared.category.identity.Background;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.Job;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.Species;

public class Identity implements Serializable {
	final private Background background;
	final private Species species;
	final private Job job;
	
	public Identity(Background background, Species species, Job job) {
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
