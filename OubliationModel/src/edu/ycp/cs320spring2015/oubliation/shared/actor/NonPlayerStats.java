package edu.ycp.cs320spring2015.oubliation.shared.actor;

import java.io.Serializable;

public class NonPlayerStats implements Serializable {
	private int maxHp = 0;
	private int hitCount = 0;
	
	public NonPlayerStats(int maxHp, int hitCount) {
		super();
		this.maxHp = maxHp;
		this.hitCount = hitCount;
	}
	
	public int getMaxHp() {
		return maxHp;
	}
	public int getHitCount() {
		return hitCount;
	}
}
