package edu.ycp.cs320spring2015.oubliation.shared.character;

import edu.ycp.cs320spring2015.oubliation.shared.category.NameTag;

public class AllyActor extends NonPlayerActor {

	public AllyActor(NameTag nameTag, int health, Loadout loadout, Identity identity, NonPlayerStats stats) {
		super(nameTag, health, loadout, identity, stats);
	}

}