package edu.ycp.cs320spring2015.oubliation.shared.actor.nonplayer;

import java.util.EnumMap;

import edu.ycp.cs320spring2015.oubliation.shared.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.actor.Loadout;
import edu.ycp.cs320spring2015.oubliation.shared.category.Element;
import edu.ycp.cs320spring2015.oubliation.shared.transfer.StatusMemento;

/**
 * 
 * Extends NonPlayerActor
 *
 */
public class AllyActor extends NonPlayerActor {
	private static final long serialVersionUID = -6250038243498902232L;

	/**
	 * 
	 * @param nameTag {@link NameTag}
	 * @param health An integer representing the life-force that the actor has until death.
	 * @param loadout {@link Loadout}
	 * @param identity {@link NonPlayerIdentity}
	 * @param stats {@link NonPlayerStats}
	 */
	public AllyActor(NameTag nameTag, StatusMemento status,
			Loadout loadout, EnumMap<Element, Double> elementalMods,
			NonPlayerIdentity identity, NonPlayerStats stats) {
		super(nameTag, status, loadout, elementalMods, identity, stats);
	}

}
