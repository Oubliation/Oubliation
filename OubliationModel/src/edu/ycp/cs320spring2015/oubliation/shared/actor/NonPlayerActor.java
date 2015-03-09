package edu.ycp.cs320spring2015.oubliation.shared.actor;

import edu.ycp.cs320spring2015.oubliation.shared.category.NameTag;

public abstract class NonPlayerActor extends Actor {

	final private Identity identity;
	
	private NonPlayerStats stats;
	
	public NonPlayerActor(NameTag nameTag, Loadout loadout, Identity identity, NonPlayerStats stats) {
		super(nameTag, loadout, stats.getMaxHp());
		this.identity = identity;
		this.stats = stats;
	}
	
	public String getBackgroundName() {
		return identity.getBackgroundName();
	}
	public String getBackgroundDescription() {
		return identity.getBackgroundDescription();
	}
	public String getSpeciesName() {
		return identity.getSpeciesName();
	}
	public String getSpeciesDescription() {
		return identity.getSpeciesDescription();
	}
	public String getJobName() {
		return identity.getJobName();
	}
	public String getJobDescription() {
		return identity.getJobDescription();
	}

	public int getMaxHealth() {
		return stats.getMaxHp();
	}
	public int getHitCount() {
		return stats.getHitCount();
	}
}