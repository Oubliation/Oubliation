package edu.ycp.cs320spring2015.oubliation.client;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.TreeSet;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

import edu.ycp.cs320spring2015.oubliation.shared.actor.Loadout;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.BruceScore;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.PlayerActor;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.PlayerIdentity;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.PlayerStats;
import edu.ycp.cs320spring2015.oubliation.shared.category.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.Job;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.PlayerBackground;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.PlayerJob;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.PlayerSpecies;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Headwear;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Shield;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Suit;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Utility;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Weapon;

public class Oubliation implements EntryPoint {
	
	//private ViewStats statScreen = new ViewStats(profile);
	
	public void onModuleLoad() {
		NameTag jobTag = new NameTag("Witch", "");
		PlayerJob job = new PlayerJob(jobTag, new EnumMap<BruceScore, Integer>(BruceScore.class), new int[0], 0, 0, 0, 0, 0);
		
		NameTag bgTag = new NameTag("Scholar", "");
		PlayerBackground bg = new PlayerBackground(bgTag, new EnumMap<BruceScore, Double>(BruceScore.class), null, new TreeSet<PlayerJob>());
		
		NameTag speciesTag = new NameTag("Fairy", "");
		PlayerSpecies species = new PlayerSpecies(speciesTag, new EnumMap<BruceScore, Integer>(BruceScore.class));
		
		PlayerIdentity identity = new PlayerIdentity(bg, species, job, 0, 0);

		NameTag headwearTag = new NameTag("Leather Hood", "");
		Headwear headwear = new Headwear(headwearTag, 100, new TreeSet<Job>(), 1);
		NameTag suitTag = new NameTag("Plate Mail", "");
		Suit suit = new Suit(suitTag, 100, new TreeSet<Job>(), 3);
		NameTag shieldTag = new NameTag("Dragon Shield", "");
		Shield shield = new Shield(shieldTag, 100, new TreeSet<Job>(), 2);
		NameTag weaponTag = new NameTag("Sword", "");
		Weapon weapon = new Weapon(weaponTag, 100, new TreeSet<Job>(), null);
		Loadout loadout = new Loadout(headwear, suit, shield, weapon, new ArrayList<Utility>());
		
		PlayerStats stats = new PlayerStats(new int[0], new int[0],  new ArrayList<Utility>());
		
		NameTag playerTag = new NameTag("Nevik", "A character controlled by the Player");
		PlayerActor actor = new PlayerActor(playerTag, loadout, 20, identity, stats);
		//RootPanel.get("gwtapp").add(statScreen);
	}
}
