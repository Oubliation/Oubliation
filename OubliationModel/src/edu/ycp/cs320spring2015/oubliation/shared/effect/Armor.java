package edu.ycp.cs320spring2015.oubliation.shared.effect;

import java.util.TreeSet;

import edu.ycp.cs320spring2015.oubliation.shared.category.Job;
import edu.ycp.cs320spring2015.oubliation.shared.category.NameTag;

public abstract class Armor extends Equipment {
	private int Ac;
	
	public Armor(NameTag nameTag, int price,
			TreeSet<Job> equippableBy, int ac) {
		super(nameTag, price, equippableBy);
		Ac = ac;
	}

	public int getAc() {
		return Ac;
	}
}
