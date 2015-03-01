package edu.ycp.cs320spring2015.oubliation.shared.effect;

import java.util.TreeSet;

import edu.ycp.cs320spring2015.oubliation.shared.category.Job;

public class Utility extends Equipment {
	private Effect<?> effect;
	
	public Utility(String name, String description, int price,
			TreeSet<Job> equippableBy, Effect<?> effect) {
		super(name, description, price, equippableBy);
		this.effect = effect;
	}

	Effect<?> getEffect() { //TODO: consider exactly how effect works
		return effect;
	}
}
