package edu.ycp.cs320spring2015.oubliation.shared.character;

import java.util.ArrayList;

import edu.ycp.cs320spring2015.oubliation.shared.category.Background;
import edu.ycp.cs320spring2015.oubliation.shared.category.Job;
import edu.ycp.cs320spring2015.oubliation.shared.category.Species;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Helmet;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Shield;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Suit;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Utility;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Weapon;

public class AllyActor extends NonPlayerActor {

	public AllyActor(String name, String description, int health, Helmet helmet, Suit suit,
			Shield shield, Weapon hand, ArrayList<Utility> utilityBelt,
			Background background, Species species, Job job, int maxHp,
			int hitCount) {
		super(name, description, health, helmet, suit, shield, hand, utilityBelt, background,
				species, job, maxHp, hitCount);
	}

}
