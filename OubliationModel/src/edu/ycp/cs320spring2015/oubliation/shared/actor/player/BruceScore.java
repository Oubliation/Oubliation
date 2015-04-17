package edu.ycp.cs320spring2015.oubliation.shared.actor.player;

import java.io.Serializable;

/**
 * 
 * Enumeration for the attributes for a player actor
 *
 */
public enum BruceScore implements Serializable {
	mightily, //damage
	healthily, //max hp
	intelligently, //max witch mp
	godly, //max priest mp
	quickly, //turn order, dodge chance
	luckily; //hit chance, status chance
	
	BruceScore() {}
}
