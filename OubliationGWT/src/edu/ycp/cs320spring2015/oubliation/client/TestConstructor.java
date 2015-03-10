package edu.ycp.cs320spring2015.oubliation.client;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.TreeSet;

import edu.ycp.cs320spring2015.oubliation.shared.actor.Loadout;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.BruceScore;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.PlayerActor;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.PlayerIdentity;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.PlayerStats;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.Profile;
import edu.ycp.cs320spring2015.oubliation.shared.category.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.Job;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.PlayerBackground;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.PlayerJob;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.PlayerSpecies;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Headwear;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Item;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Shield;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Suit;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Utility;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Weapon;

public final class TestConstructor {
	public static Profile makeTestProfile() {
		ArrayList<PlayerActor> party = new ArrayList<PlayerActor>();
		for (int count=0; count<6; count+=1) {
			party.add(TestConstructor.makePlayerActor());
		}
		
		ArrayList<PlayerActor> roster = new ArrayList<PlayerActor>();
		for (int count=0; count<10; count+=1) {
			roster.add(TestConstructor.makePlayerActor());
		}
		Profile profile = new Profile(200, new ArrayList<Item>(), party, roster, new HashSet<String>());
		
		return profile;
	}
	
	private static PlayerActor makePlayerActor() {
		NameTag jobTag = new NameTag("Witch", "");
		PlayerJob job = new PlayerJob(jobTag, new EnumMap<BruceScore, Integer>(BruceScore.class), new int[0], 0, 0, 0, 0, 0);
		
		NameTag bgTag = new NameTag("Scholar", "");
		EnumMap<BruceScore, Double> attribGainRates = new EnumMap<BruceScore, Double>(BruceScore.class);
		attribGainRates.put(BruceScore.mightily, 1.0);
		attribGainRates.put(BruceScore.healthily, 1.2);
		attribGainRates.put(BruceScore.intelligently, 0.7);
		attribGainRates.put(BruceScore.godly, 0.5);
		attribGainRates.put(BruceScore.quickly, 1.5);
		attribGainRates.put(BruceScore.luckily, 1.3);
		PlayerBackground bg = new PlayerBackground(bgTag, attribGainRates, new TreeSet<PlayerJob>());
		
		NameTag speciesTag = new NameTag("Fairy", "");
		EnumMap<BruceScore, Integer> attribBaseValues = new EnumMap<BruceScore, Integer>(BruceScore.class);
		attribBaseValues.put(BruceScore.mightily, 3);
		attribBaseValues.put(BruceScore.healthily, 3);
		attribBaseValues.put(BruceScore.intelligently, 3);
		attribBaseValues.put(BruceScore.godly, 3);
		attribBaseValues.put(BruceScore.quickly, 3);
		attribBaseValues.put(BruceScore.luckily, 3);
		PlayerSpecies species = new PlayerSpecies(speciesTag, attribBaseValues);
		
		PlayerIdentity identity = new PlayerIdentity(bg, species, job, 3, 1000);
		
		NameTag headwearTag = new NameTag("Leather Hood", "");
		Headwear headwear = new Headwear(headwearTag, 100, new TreeSet<Job>(), 1);
		NameTag suitTag = new NameTag("Plate Mail", "");
		Suit suit = new Suit(suitTag, 100, new TreeSet<Job>(), 3);
		NameTag shieldTag = new NameTag("Dragon Shield", "");
		Shield shield = new Shield(shieldTag, 100, new TreeSet<Job>(), 2);
		NameTag weaponTag = new NameTag("Sword", "");
		Weapon weapon = new Weapon(weaponTag, 100, new TreeSet<Job>(), null);
		Loadout loadout = new Loadout(headwear, suit, shield, weapon, new ArrayList<Utility>());

		int[] witchMp = {40, 36, 30, 24, 16, 8};
		int[] priestMp = {40, 36, 30, 24, 16, 8};
		PlayerStats stats = new PlayerStats(witchMp, priestMp,  new ArrayList<Utility>());
		
		NameTag playerTag = new NameTag("Nevik", "A character controlled by the Player");
		PlayerActor actor = new PlayerActor(playerTag, loadout, 20, identity, stats);
		return actor;
	}
}
