package edu.ycp.cs320spring2015.oubliation.shared.character;

public abstract class NonPlayerUnit extends Unit {
	
	private int maxHp = 0;
	private int hitCount = 0;
	
	public int getMaxHp() {
		return maxHp;
	}
	
	public int getHitCount() {
		return hitCount;
	}

}
