package edu.ycp.cs320spring2015.oubliation.shared.character;

import edu.ycp.cs320spring2015.oubliation.shared.category.Background;
import edu.ycp.cs320spring2015.oubliation.shared.category.Job;
import edu.ycp.cs320spring2015.oubliation.shared.category.Species;

public class Identity {
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
