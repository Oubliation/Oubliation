package edu.ycp.cs320spring2015.oubliation.shared.effect;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

import edu.ycp.cs320spring2015.oubliation.shared.actor.player.PlayerActor;
import edu.ycp.cs320spring2015.oubliation.shared.category.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.Job;

public abstract class Equipment extends Item {
	private SortedSet<Job> equippableBy;

	public Equipment(NameTag nameTag, int price, TreeSet<Job> equippableBy) {
		super(nameTag, price);
		this.equippableBy = Collections.unmodifiableSortedSet(equippableBy);
	}
	
	public boolean canEquip(PlayerActor actor) {
		return equippableBy.contains(actor); //TODO: needs job, not actor
	}

}
