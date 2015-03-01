package edu.ycp.cs320spring2015.oubliation.shared.effect;

import java.util.TreeSet;

import edu.ycp.cs320spring2015.oubliation.shared.category.Job;

public abstract class Armor extends Equipment {
	private int Ac;
	
	public Armor(String name, String description, int price,
			TreeSet<Job> equippableBy, int ac) {
		super(name, description, price, equippableBy);
		Ac = ac;
	}

	public int getAc() {
		return Ac;
	}
}
