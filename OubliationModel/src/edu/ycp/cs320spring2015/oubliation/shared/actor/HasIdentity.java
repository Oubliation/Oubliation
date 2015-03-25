package edu.ycp.cs320spring2015.oubliation.shared.actor;

public interface HasIdentity {
	/**
	 * 
	 * @return Name of the background identity
	 */
	public abstract String getBackgroundName();
	/**
	 * 
	 * @return Description of the background identity
	 */
	public abstract String getBackgroundDescription();
	/**
	 * 
	 * @return Name of the species identity
	 */
	public abstract String getSpeciesName();
	/**
	 * 
	 * @return Description of the species identity
	 */
	public abstract String getSpeciesDescription();
	/**
	 * 
	 * @return Name of the current job identity
	 */
	public abstract String getJobName();
	/**
	 * 
	 * @return Description of the current job identity
	 */
	public abstract String getJobDescription();
}
