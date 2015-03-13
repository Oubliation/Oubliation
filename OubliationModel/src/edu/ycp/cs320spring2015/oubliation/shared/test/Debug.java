package edu.ycp.cs320spring2015.oubliation.shared.test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.TreeSet;

import org.junit.Test;

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

public class Debug {
	private static PlayerJob makePlayerJob() {
		NameTag jobTag = new NameTag("Witch", "");
		EnumMap<BruceScore, Integer> attribReqValues = new EnumMap<BruceScore, Integer>(BruceScore.class);
		attribReqValues.put(BruceScore.mightily, 3);
		attribReqValues.put(BruceScore.healthily, 3);
		attribReqValues.put(BruceScore.intelligently, 3);
		attribReqValues.put(BruceScore.godly, 3);
		attribReqValues.put(BruceScore.quickly, 3);
		attribReqValues.put(BruceScore.luckily, 3);
		int[] expRequired = {100, 200, 400, 800, 1600, 3200, 6400};
		return new PlayerJob(jobTag, attribReqValues, expRequired, 6400, 1, 16, 8, 2);
	}
	
	private static PlayerBackground makePlayerBackground() {
		NameTag bgTag = new NameTag("Scholar", "");
		EnumMap<BruceScore, Double> attribGainRates = new EnumMap<BruceScore, Double>(BruceScore.class);
		attribGainRates.put(BruceScore.mightily, 1.0);
		attribGainRates.put(BruceScore.healthily, 1.2);
		attribGainRates.put(BruceScore.intelligently, 0.7);
		attribGainRates.put(BruceScore.godly, 0.5);
		attribGainRates.put(BruceScore.quickly, 1.5);
		attribGainRates.put(BruceScore.luckily, 1.3);
		return new PlayerBackground(bgTag, attribGainRates, new TreeSet<PlayerJob>());
	}
	
	private static PlayerSpecies makePlayerSpecies() {
		NameTag speciesTag = new NameTag("Fairy", "");
		EnumMap<BruceScore, Integer> attribBaseValues = new EnumMap<BruceScore, Integer>(BruceScore.class);
		attribBaseValues.put(BruceScore.mightily, 3);
		attribBaseValues.put(BruceScore.healthily, 3);
		attribBaseValues.put(BruceScore.intelligently, 3);
		attribBaseValues.put(BruceScore.godly, 3);
		attribBaseValues.put(BruceScore.quickly, 3);
		attribBaseValues.put(BruceScore.luckily, 3);
		return new PlayerSpecies(speciesTag, attribBaseValues);
	}
	
	private static PlayerIdentity makePlayerIdentity() {
		PlayerJob job = makePlayerJob();
		PlayerBackground bg = makePlayerBackground();
		PlayerSpecies species = makePlayerSpecies();
		
		return new PlayerIdentity(bg, species, job, 3, 1000);
	}
	
	private static Headwear makeHeadwear() {
		NameTag headwearTag = new NameTag("Leather Hood", "");
		return new Headwear(headwearTag, 100, new TreeSet<Job>(), 1);
	}
	
	private static Suit makeSuit() {
		NameTag suitTag = new NameTag("Plate Mail", "");
		return new Suit(suitTag, 100, new TreeSet<Job>(), 3);
	}
	
	private static Shield makeShield() {
		NameTag shieldTag = new NameTag("Dragon Shield", "");
		return new Shield(shieldTag, 100, new TreeSet<Job>(), 2);
	}
	
	private static Weapon makeWeapon() {
		NameTag weaponTag = new NameTag("Sword", "");
		return new Weapon(weaponTag, 100, new TreeSet<Job>(), null);
	}
	
	private static Loadout makeLoadout() {
		Headwear headwear = makeHeadwear();
		Suit suit = makeSuit();
		Shield shield = makeShield();
		Weapon weapon = makeWeapon();
		
		return new Loadout(headwear, suit, shield, weapon, new ArrayList<Utility>());
	}
	
	private static PlayerStats makePlayerStats() {
		int[] witchMp = {40, 36, 30, 24, 16, 8};
		int[] priestMp = {40, 36, 30, 24, 16, 8};
		return new PlayerStats(witchMp, priestMp,  new ArrayList<Utility>());
	}
	
	private static PlayerActor makePlayerActor() {
		PlayerIdentity identity = makePlayerIdentity();
		Loadout loadout = makeLoadout();
		PlayerStats stats = makePlayerStats();
		
		NameTag playerTag = new NameTag("Nevik", "A character controlled by the Player");
		return new PlayerActor(playerTag, loadout, 20, identity, stats);
	}
	
	public static Profile makeProfile() {
		ArrayList<PlayerActor> party = new ArrayList<PlayerActor>();
		for (int count=0; count<6; count+=1) {
			party.add(makePlayerActor());
		}
		
		ArrayList<PlayerActor> roster = new ArrayList<PlayerActor>();
		for (int count=0; count<10; count+=1) {
			roster.add(makePlayerActor());
		}
		return new Profile(200, new ArrayList<Item>(), party, roster, new HashSet<String>());
	}

	@Test
	public void NameTag() {
		NameTag nameTag = new NameTag("Name", "Description");
		assertTrue(nameTag.getName() == "Name");
		assertTrue(nameTag.getDescription() == "Description");
	}
	
	@Test
	public void Job() {
		PlayerJob job = makePlayerJob();
		assertTrue(job.getLevel(300) == 3);
		assertTrue(job.getLevel(500) == 4);
		assertTrue(job.getLevel(20000) == 9);
		assertTrue(job.getLevel(50000) ==  13); 
		
		assertTrue(job.getMaxHp(3) == 32);
		assertTrue(job.getMaxHp(5) == 48);
		
		assertTrue(job.getHitCount() == 1);
		assertTrue(job.getUtilitySlotCount() == 2);
	}
	
	@Test
	public void Background() {
		PlayerBackground bg = makePlayerBackground();
		assertTrue(bg.getScoreGain(BruceScore.godly, 4) == 2);
		assertTrue(bg.getScoreGain(BruceScore.godly, 7) == 3);
		assertTrue(bg.getScoreGain(BruceScore.healthily, 5) == 6);
		assertTrue(bg.getScoreGain(BruceScore.healthily, 4) == 4);
		assertTrue(bg.getScoreGain(BruceScore.quickly, 4) == 6);
		assertTrue(bg.getScoreGain(BruceScore.quickly, 3) == 4);
	}
	
	@Test
	public void Species() {
		PlayerSpecies species = makePlayerSpecies();
		assertTrue(species.getBaseScore(BruceScore.mightily) == 3);
		assertTrue(species.getBaseScore(BruceScore.quickly) == 3);
		assertTrue(species.getBaseScore(BruceScore.luckily) == 3);
	}
	/**
	@Test
	public void Identity() {
		PlayerIdentity identity = makePlayerIdentity();
		//TODO: incomplete

		assertTrue(identity.getLevel(300) == 3);
		assertTrue(identity.getLevel(500) == 4);
		assertTrue(identity.getLevel(20000) == 9);
		assertTrue(identity.getLevel(50000) ==  13); 
		
		assertTrue(identity.getMaxHp() == 32);
		
		assertTrue(identity.getHitCount() == 1);
		assertTrue(identity.getUtilitySlotCount() == 2);

		assertTrue(identity.getScoreGain(BruceScore.godly, 4) == 2);
		assertTrue(identity.getScoreGain(BruceScore.godly, 7) == 3);
		assertTrue(identity.getScoreGain(BruceScore.healthily, 5) == 6);
		assertTrue(identity.getScoreGain(BruceScore.healthily, 4) == 4);
		assertTrue(identity.getScoreGain(BruceScore.quickly, 4) == 6);
		assertTrue(identity.getScoreGain(BruceScore.quickly, 3) == 4);

		assertTrue(identity.getBaseScore(BruceScore.mightily) == 3);
		assertTrue(identity.getBaseScore(BruceScore.quickly) == 3);
		assertTrue(identity.getBaseScore(BruceScore.luckily) == 3);
	}
	**/
	
	@Test
	public void equipment() {
		Headwear headwear = makeHeadwear();
		Suit suit = makeSuit();
		Shield shield = makeShield();
		Weapon weapon = makeWeapon();
		
		assertTrue(headwear.getArmorRank() == 1);
		assertTrue(suit.getArmorRank() == 3);
		assertTrue(shield.getArmorRank() == 2);

		assertTrue(headwear.getPrice() == 100);
		assertTrue(suit.getPrice() == 100);
		assertTrue(shield.getPrice() == 100);
		assertTrue(weapon.getPrice() == 100);
	}
	
	@Test
	public void loadout() {
		Loadout loadout = makeLoadout();
		
		//loadout.
	}
}