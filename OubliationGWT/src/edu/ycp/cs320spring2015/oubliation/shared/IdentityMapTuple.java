package edu.ycp.cs320spring2015.oubliation.shared;

import java.util.Map;

import edu.ycp.cs320spring2015.oubliation.shared.category.identity.Background;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.Job;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.Species;

public class IdentityMapTuple {
	private Map<String, Background> backgroundMap;
	private Map<String, Species> speciesMap;
	private Map<String, Job> jobMap;
	
	public IdentityMapTuple(Map<String, Background> backgroundMap,
			Map<String, Species> speciesMap, Map<String, Job> jobMap) {
		this.backgroundMap = backgroundMap;
		this.speciesMap = speciesMap;
		this.jobMap = jobMap;
	}
	

	public Map<String, Background> getBackgroundMap() {
		return backgroundMap;
	}
	public Map<String, Species> getSpeciesMap() {
		return speciesMap;
	}
	public Map<String, Job> getJobMap() {
		return jobMap;
	}
}
