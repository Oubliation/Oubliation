package edu.ycp.cs320spring2015.oubliation.shared.character;

import edu.ycp.cs320spring2015.shared.category.Background;
import edu.ycp.cs320spring2015.shared.category.Job;
import edu.ycp.cs320spring2015.shared.category.Species;

public abstract class NonPlayerUnit extends Unit {

	private Background background;
	private Species species;
	private Job job;
	
	private int maxHp = 0;
	private int hitCount = 0;
	
	public int getMaxHp() {
		return maxHp;
	}
	
	public int getHitCount() {
		return hitCount;
	}

}
