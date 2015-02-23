package edu.ycp.cs320spring2015.oubliation.shared.character;

import edu.ycp.cs320spring2015.oubliation.shared.effect.Effect;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Item;

public abstract class Character {
	//TODO: background, class, species
	
	private Effect[] abilities;
	private Item helm;
	private Item armor;
	private Item shield;
	private Item leftHand;
	private Item rightHand;
	private Item[] itemBelt;
	
	private int hp;
	protected abstract int getMaxHp();
	
}
