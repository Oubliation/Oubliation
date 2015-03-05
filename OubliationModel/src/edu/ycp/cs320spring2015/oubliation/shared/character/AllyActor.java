package edu.ycp.cs320spring2015.oubliation.shared.character;

import edu.ycp.cs320spring2015.oubliation.shared.category.NameTag;

public class AllyActor extends NonPlayerActor {

	public AllyActor(NameTag nameTag, int health, Loadout loadout, Identity identity, int maxHp, int hitCount) {
		super(nameTag, health, loadout, identity, maxHp, hitCount);
	}

}
