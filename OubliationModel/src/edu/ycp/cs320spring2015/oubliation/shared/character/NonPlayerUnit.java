package edu.ycp.cs320spring2015.oubliation.shared.character;

import java.util.ArrayList;

import edu.ycp.cs320spring2015.oubliation.shared.category.Background;
import edu.ycp.cs320spring2015.oubliation.shared.category.Job;
import edu.ycp.cs320spring2015.oubliation.shared.category.Species;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Helmet;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Shield;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Suit;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Utility;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Weapon;

public abstract class NonPlayerUnit extends Unit {

	final private Background background;
	final private Species species;
	final private Job job;
	
	private int maxHp = 0;
	private int hitCount = 0;
	
	public NonPlayerUnit(String name, String description, Helmet helmet,
			Suit suit, Shield shield, Weapon hand,
			ArrayList<Utility> utilityBelt, Background background,
			Species species, Job job, int maxHp, int hitCount) {
		super(name, description, helmet, suit, shield, hand, utilityBelt);
		this.background = background;
		this.species = species;
		this.job = job;
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
