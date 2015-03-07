package edu.ycp.cs320spring2015.oubliation.shared.effect;

import java.util.TreeSet;

import edu.ycp.cs320spring2015.oubliation.shared.category.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.Job;

public class Weapon extends Utility {

	public Weapon(NameTag nameTag, int price,
			TreeSet<Job> equippableBy, Effect<?> effect) {
		super(nameTag, price, equippableBy, effect);
	}

}
