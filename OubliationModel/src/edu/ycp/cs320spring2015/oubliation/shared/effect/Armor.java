package edu.ycp.cs320spring2015.oubliation.shared.effect;

import java.util.TreeSet;

import edu.ycp.cs320spring2015.oubliation.shared.NameTag;
/**
 * 
 * {@link Equipment} which protects an actor from damage 
 *
 */
public abstract class Armor extends Equipment {
	private static final long serialVersionUID = 3117431489237651964L;
	public Armor() {}
	
	private int armorRank;
	
	public Armor(NameTag nameTag, int price,
			TreeSet<String> equippableBy, int armorRank) {
		super(nameTag, price, equippableBy);
		this.armorRank = armorRank;
	}
	
	/**
	 * @return armor rank protection provided by this armor
	 */
	public int getArmorRank() {
		return armorRank;
	}
}
