package edu.ycp.cs320spring2015.oubliation.shared.effect;

import java.util.TreeSet;

import edu.ycp.cs320spring2015.oubliation.shared.category.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.Job;

public abstract class Armor extends Equipment {
	private int armorRank;
	
	public Armor(NameTag nameTag, int price,
			TreeSet<Job> equippableBy, int armorRank) {
		super(nameTag, price, equippableBy);
		this.armorRank = armorRank;
	}

	public int getArmorRank() {
		return armorRank;
	}
}
