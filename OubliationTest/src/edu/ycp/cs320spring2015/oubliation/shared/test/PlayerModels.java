package edu.ycp.cs320spring2015.oubliation.shared.test;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ycp.cs320spring2015.oubliation.shared.actor.Loadout;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.BruceScore;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.PlayerActor;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.PlayerIdentity;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.PlayerStats;
import edu.ycp.cs320spring2015.oubliation.shared.category.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.PlayerBackground;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.PlayerJob;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.PlayerSpecies;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Headwear;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Shield;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Suit;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Weapon;

public class PlayerModels {
	@Test
	public void nameTag() {
		NameTag nameTag = new NameTag("Name", "Description");
		assertTrue(nameTag.getName() == "Name");
		assertTrue(nameTag.getDescription() == "Description");
	}
	
	@Test
	public void job() {
		PlayerJob job = Debug.makePlayerJob();
		
		
		assertTrue(job.getLevel(300) == 3);
		assertTrue(job.getLevel(500) == 4);
		assertTrue(job.getLevel(20000) == 9);
		assertTrue(job.getLevel(50000) ==  13); 
		
		assertTrue(job.getMaxHp(3) == 40);
		assertTrue(job.getMaxHp(5) == 56);
		
		assertTrue(job.getHitCount() == 1);
		assertTrue(job.getUtilitySlotCount() == 2);
	}
	
	@Test
	public void background() {
		PlayerBackground bg = Debug.makePlayerBackground();
		assertTrue(bg.getScoreGain(BruceScore.godly, 4) == 2);
		assertTrue(bg.getScoreGain(BruceScore.godly, 7) == 3);
		assertTrue(bg.getScoreGain(BruceScore.healthily, 5) == 6);
		assertTrue(bg.getScoreGain(BruceScore.healthily, 4) == 4);
		assertTrue(bg.getScoreGain(BruceScore.quickly, 4) == 6);
		assertTrue(bg.getScoreGain(BruceScore.quickly, 3) == 4);
	}
	
	@Test
	public void species() {
		PlayerSpecies species = Debug.makePlayerSpecies();
		assertTrue(species.getBaseScore(BruceScore.mightily) == 3);
		assertTrue(species.getBaseScore(BruceScore.quickly) == 3);
		assertTrue(species.getBaseScore(BruceScore.luckily) == 3);
	}

	@Test
	public void identity() {
		PlayerIdentity identity = Debug.makePlayerIdentity();
		
		assertTrue(identity.getMaxHealth() == 40);
		
		assertTrue(identity.getHitCount() == 1);
		assertTrue(identity.getUtilitySlotCount() == 2);
		
		assertTrue(identity.getLevel() == 3);
		assertTrue(identity.getExperience() == 100);
		assertTrue(identity.isLevelUpReady());
		
		identity.updateLevel();
		assertTrue(identity.getLevel() == 2);
		assertTrue(identity.getExperience() == 100);
		assertFalse(identity.isLevelUpReady());
		
		identity.incExperience(100);
		assertTrue(identity.getExperience() == 200);
		assertTrue(identity.isLevelUpReady());
		
		identity.updateLevel();
		assertTrue(identity.getLevel() == 3);
		
		identity.incExperience(100);
		assertTrue(identity.getExperience() == 300);
		assertFalse(identity.isLevelUpReady());
		
		identity.updateLevel();
		assertTrue(identity.getLevel() == 3);
	}
	
	@Test
	public void equipment() {
		Headwear headwear = Debug.makeHeadwear();
		Suit suit = Debug.makeSuit();
		Shield shield = Debug.makeShield();
		Weapon weapon = Debug.makeWeapon();
		
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
		Loadout loadout = Debug.makeLoadout();

		assertTrue(loadout.getHeadwear().getArmorRank() == 1);
		assertTrue(loadout.getSuit().getArmorRank() == 3);
		assertTrue(loadout.getShield().getArmorRank() == 2);
		
		assertTrue(loadout.getHeadwear().getPrice() == 100);
		assertTrue(loadout.getSuit().getPrice() == 100);
		assertTrue(loadout.getShield().getPrice() == 100);
		assertTrue(loadout.getHand().getPrice() == 100);
		
		Headwear headwear = loadout.getHeadwear();
		Suit suit = loadout.getSuit();
		Shield shield = loadout.getShield();
		Weapon weapon = loadout.getHand();

		assertTrue(loadout.getArmorRank() == 6);
		
		loadout.unequip(headwear);
		loadout.unequip(suit);
		assertTrue(loadout.getArmorRank() == 2);
		
		loadout.unequip(shield);
		loadout.unequip(weapon);
		assertTrue(loadout.getArmorRank() == 0);
		
		
		loadout.equip(headwear);
		loadout.equip(suit);
		assertTrue(loadout.getArmorRank() == 4);
		
		loadout.equip(shield);
		loadout.equip(weapon);
		assertTrue(loadout.getArmorRank() == 6);
		
		//assertTrue(loadout.getEquippedUtilities().equals(new Utility[0]));
	}
	
	@Test
	public void stats() {
		PlayerStats stats = Debug.makePlayerStats();
		
		//assertTrue(stats.getUtilityQueue().equals(new Utility[0]));
		
		assertTrue(stats.getWitchMp(1) == 40);
		assertTrue(stats.getWitchMp(2) == 36);
		assertTrue(stats.getWitchMp(3) == 30);
		assertTrue(stats.getWitchMp(4) == 24);
		assertTrue(stats.getWitchMp(5) == 16);
		assertTrue(stats.getWitchMp(6) == 8);

		assertTrue(stats.getPriestMp(1) == 40);
		assertTrue(stats.getPriestMp(2) == 36);
		assertTrue(stats.getPriestMp(3) == 30);
		assertTrue(stats.getPriestMp(4) == 24);
		assertTrue(stats.getPriestMp(5) == 16);
		assertTrue(stats.getPriestMp(6) == 8);
	}
	
	@Test
	public void playerActor() {
		PlayerActor actor = Debug.makePlayerActor();
		
		assertTrue(actor.getMaxHealth() == 40);
		
		assertTrue(actor.getHitCount() == 1);
		
		assertTrue(actor.getLevel() == 3);
		assertTrue(actor.getExperience() == 100);
		assertTrue(actor.isLevelUpReady());
		
		actor.updateLevel();
		assertTrue(actor.getLevel() == 2);
		assertTrue(actor.getExperience() == 100);
		assertFalse(actor.isLevelUpReady());
		
		actor.incExperience(100);
		assertTrue(actor.getExperience() == 200);
		assertTrue(actor.isLevelUpReady());
		
		actor.updateLevel();
		assertTrue(actor.getLevel() == 3);
		
		actor.incExperience(100);
		assertTrue(actor.getExperience() == 300);
		assertFalse(actor.isLevelUpReady());
		
		actor.updateLevel();
		assertTrue(actor.getLevel() == 3);

		assertTrue(actor.getWitchMp(1) == 40);
		assertTrue(actor.getWitchMp(2) == 36);
		assertTrue(actor.getWitchMp(3) == 30);
		assertTrue(actor.getWitchMp(4) == 24);
		assertTrue(actor.getWitchMp(5) == 16);
		assertTrue(actor.getWitchMp(6) == 8);

		assertTrue(actor.getPriestMp(1) == 40);
		assertTrue(actor.getPriestMp(2) == 36);
		assertTrue(actor.getPriestMp(3) == 30);
		assertTrue(actor.getPriestMp(4) == 24);
		assertTrue(actor.getPriestMp(5) == 16);
		assertTrue(actor.getPriestMp(6) == 8);

		assertTrue(actor.getHeadwear().getArmorRank() == 1);
		assertTrue(actor.getSuit().getArmorRank() == 3);
		assertTrue(actor.getShield().getArmorRank() == 2);
		
		assertTrue(actor.getHeadwear().getPrice() == 100);
		assertTrue(actor.getSuit().getPrice() == 100);
		assertTrue(actor.getShield().getPrice() == 100);
		assertTrue(actor.getHand().getPrice() == 100);
		
		Headwear headwear = actor.getHeadwear();
		Suit suit = actor.getSuit();
		Shield shield = actor.getShield();
		Weapon weapon = actor.getHand();

		assertTrue(actor.getArmorRank() == 6);
		
		actor.unequip(headwear);
		actor.unequip(suit);
		assertTrue(actor.getArmorRank() == 2);
		
		actor.unequip(shield);
		actor.unequip(weapon);
		assertTrue(actor.getArmorRank() == 0);
		
		
		actor.equip(headwear);
		actor.equip(suit);
		assertTrue(actor.getArmorRank() == 4);
		
		actor.equip(shield);
		actor.equip(weapon);
		assertTrue(actor.getArmorRank() == 6);
		
		//assertTrue(actor.getEquippedUtilities().equals(new Utility[0]));
	}
	
	//TODO: profile test
}
