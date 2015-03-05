package edu.ycp.cs320spring2015.oubliation.shared.character;

import edu.ycp.cs320spring2015.oubliation.shared.category.NameTag;

public abstract class NonPlayerActor extends Actor {

	final private Identity identity;
	
	private int maxHp = 0;
	private int hitCount = 0;
	
	public NonPlayerActor(NameTag nameTag, int health, Loadout loadout, Identity identity, int maxHp, int hitCount) {
		super(nameTag, health, loadout);
		this.identity = identity;
		this.maxHp = maxHp;
		this.hitCount = hitCount;
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

	public int getMaxHp() {
		return maxHp;
	}
	public int getHitCount() {
		return hitCount;
	}
}