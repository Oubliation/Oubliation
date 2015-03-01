package edu.ycp.cs320spring2015.oubliation.shared.effect;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

import edu.ycp.cs320spring2015.oubliation.shared.category.Job;
import edu.ycp.cs320spring2015.oubliation.shared.character.PlayerUnit;

public abstract class Equipment extends Item {
	private SortedSet<Job> equippableBy;

	public Equipment(String name, String description, int price, TreeSet<Job> equippableBy) {
		super(name, description, price);
		this.equippableBy = Collections.unmodifiableSortedSet(equippableBy);
	}
	
	public boolean canEquip(PlayerUnit unit) {
		return equippableBy.contains(unit);
	}

}
