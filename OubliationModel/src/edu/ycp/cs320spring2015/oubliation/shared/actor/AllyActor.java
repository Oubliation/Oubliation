package edu.ycp.cs320spring2015.oubliation.shared.actor;

import edu.ycp.cs320spring2015.oubliation.shared.NameTag;

/**
 * 
 * Extends NonPlayerActor
 *
 */
public class AllyActor extends NonPlayerActor {
	
	/**
	 * 
	 * @param nameTag {@link NameTag}
	 * @param health An integer representing the life-force that the actor has until death.
	 * @param loadout {@link Loadout}
	 * @param identity {@link Identity}
	 * @param stats {@link NonPlayerStats}
	 */
	public AllyActor(NameTag nameTag, int health, Loadout loadout, Identity identity, NonPlayerStats stats) {
		super(nameTag, loadout, identity, stats);
	}

}
