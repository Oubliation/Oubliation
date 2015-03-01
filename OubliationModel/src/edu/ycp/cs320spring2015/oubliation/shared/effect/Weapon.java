package edu.ycp.cs320spring2015.oubliation.shared.effect;

import java.util.TreeSet;

import edu.ycp.cs320spring2015.oubliation.shared.category.Job;

public class Weapon extends Utility {

	public Weapon(String name, String description, int price,
			TreeSet<Job> equippableBy, Effect<?> effect) {
		super(name, description, price, equippableBy, effect);
	}

}
