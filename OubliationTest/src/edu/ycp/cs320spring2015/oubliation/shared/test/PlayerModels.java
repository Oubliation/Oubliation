package edu.ycp.cs320spring2015.oubliation.shared.test;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ycp.cs320spring2015.oubliation.shared.Inventory;
import edu.ycp.cs320spring2015.oubliation.shared.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.Profile;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.BruceScore;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.Loadout;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.PlayerActor;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.PlayerIdentity;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.PlayerStats;
import edu.ycp.cs320spring2015.oubliation.shared.category.Element;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.PlayerBackground;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.PlayerJob;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.PlayerSpecies;
import edu.ycp.cs320spring2015.oubliation.shared.items.Headwear;
import edu.ycp.cs320spring2015.oubliation.shared.items.Item;
import edu.ycp.cs320spring2015.oubliation.shared.items.Shield;
import edu.ycp.cs320spring2015.oubliation.shared.items.Suit;
import edu.ycp.cs320spring2015.oubliation.shared.items.Weapon;
import edu.ycp.cs320spring2015.oubliation.shared.statuses.Corpse;
import edu.ycp.cs320spring2015.oubliation.shared.statuses.Healthy;
import edu.ycp.cs320spring2015.oubliation.shared.transfer.ProfileMemento;

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
		anyPlayerActor(Debug.makePlayerActor());
	}
	
	public void anyPlayerActor(PlayerActor actor) {
		assertTrue(actor.getName() == "Nevik");
		assertTrue(actor.getDescription() == "A character controlled by the Player");
		
		assertTrue(actor.getJobName() == "Witch");
		assertTrue(actor.getBackgroundName() == "Scholar");
		assertTrue(actor.getSpeciesName() == "Fairy");
		assertTrue(actor.getJobDescription() == "");
		assertTrue(actor.getBackgroundDescription() == "");
		assertTrue(actor.getSpeciesDescription() == "Tiny people with wings");
		
		assertTrue(actor.getMaxHealth() == 42);
		
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
		
		Inventory inventory = new Inventory();
		
		assertTrue(actor.getArmorRank() == 6);
		actor.fieldUnequip(headwear, inventory);
		assertTrue(actor.getArmorRank() == 5);
		actor.fieldUnequip(suit, inventory);
		assertTrue(actor.getArmorRank() == 2);
		actor.fieldUnequip(shield, inventory);
		assertTrue(actor.getArmorRank() == 0);

		actor.fieldEquip(headwear, inventory);
		assertTrue(actor.getArmorRank() == 1);
		actor.fieldEquip(suit, inventory);
		assertTrue(actor.getArmorRank() == 4);
		actor.fieldEquip(shield, inventory);
		assertTrue(actor.getArmorRank() == 6);

		actor.fieldUnequip(weapon, inventory);
		assertTrue(actor.getHand() == null);
		actor.fieldEquip(weapon, inventory);
		assertTrue(actor.getHand() == weapon);
		
		actor.receiveDamage(9999, Element.physical);
		assertTrue(actor.getHealth() == 0);
		assertTrue(actor.getStatusClass() == Corpse.class);
		assertTrue(actor.getStatusName() == "Corpse");
		
		actor.receiveDamage(9999, Element.physical);
		actor.revive(9999);
		assertTrue(actor.getStatusClass() == Healthy.class);
		assertTrue(actor.getHealth() == 42);
		
		actor.receiveDamage(20, Element.physical);
		assertTrue(actor.getHealth() != 42);
		
		actor.setStatus(new Healthy());
		assertTrue(actor.getStatusClass() == Healthy.class);
		
		int initiative = actor.getInitiative();
		int quickly = actor.getScore(BruceScore.quickly);
		assertTrue(initiative >= quickly && initiative <= quickly + actor.getScore(BruceScore.luckily));
		assertTrue(actor.getAttackMod() == actor.getScore(BruceScore.mightily)/3);
		assertTrue(actor.getAccuracyMod() == actor.getScore(BruceScore.luckily)/3);
		assertTrue(actor.getEvasion() == actor.getScore(BruceScore.quickly));
		
		
//		PriorityQueue<BattleAction> actionQueue = new PriorityQueue<BattleAction>();
//		weapon.select(new BattleAi(actor, new Actor[] {actor}, new Actor[] {actor}, actionQueue));
//		actionQueue.poll().apply();
	}

	@Test
	public void profile() {
		Profile profile = Debug.makeProfile();
		
		assertTrue(profile.getUsername() == "username");
		assertTrue(profile.checkMoney(200));
		profile.decMoney(100);
		assertTrue(profile.checkMoney(100));
		profile.decMoney(200);
		assertTrue(profile.getMoney() == 0);
		profile.incMoney(500);
		assertTrue(profile.checkMoney(300));
		assertTrue(profile.getMoney() == 500);
		
		assertTrue(profile.hasMaxParty());
		PlayerActor[] party = profile.getParty();
		PlayerActor[] roster = profile.getRoster();
		assertTrue(party.length == 6);
		assertTrue(roster.length == 10);
		
		PlayerActor actor = party[0];
		
		profile.removeActor(actor);
		assertFalse(profile.hasMaxParty());
		
		party = profile.getParty();
		assertTrue(party.length == 5);
		roster = profile.getRoster();
		assertTrue(roster[roster.length-1] == actor);
		assertTrue(roster.length == 11);
		
		actor = Debug.makePlayerActor();
		profile.createActor(actor);
		roster = profile.getRoster();
		assertTrue(roster.length == 12);
		assertTrue(roster[roster.length-1] == actor);
		
		profile.addActor(actor);
		assertTrue(profile.hasMaxParty());
		assertTrue(profile.getRoster().length == 11);
		party = profile.getParty();
		assertTrue(party[party.length-1] == actor);
		assertTrue(party.length == 6);
		
		for (PlayerActor test : profile.getParty()) {
			anyPlayerActor(test);
		}
		for (PlayerActor test : profile.getRoster()) {
			anyPlayerActor(test);
		}
		
		profile.healParty(999999);
		assertTrue(actor.getHealth() == actor.getMaxHealth());
		int experience = actor.getExperience();
		profile.increasePartyXP(200);
		assertTrue(actor.getExperience() == experience + 200);
		
		actor = profile.getRoster()[0];
		profile.destroyActor(actor);
		roster = profile.getRoster();
		assertTrue(actor != roster[0]);
		assertTrue(roster.length == 10);
		
		assertFalse(profile.isFlagActive("foo"));
		profile.setFlag("foo");
		assertTrue(profile.isFlagActive("foo"));
		profile.setFlag("foo");
		assertTrue(profile.isFlagActive("foo"));
		profile.toggleFlag("foo");
		assertFalse(profile.isFlagActive("foo"));
		profile.toggleFlag("foo");
		assertTrue(profile.isFlagActive("foo"));
		profile.clearFlag("foo");
		assertFalse(profile.isFlagActive("foo"));
		profile.clearFlag("foo");
		assertFalse(profile.isFlagActive("foo"));
		
		Inventory inventory = profile.getInventory();

		inventory.createInventory(inventory);
		Item[] itemInv = inventory.getItemInv();
		Headwear[] headwearInv = inventory.getHeadwearInv();
		Suit[] suitInv = inventory.getSuitInv();
		Shield[] shieldInv = inventory.getShieldInv();
		Weapon[] weaponInv = inventory.getWeaponInv();
		
		assertTrue(itemInv.length == 0);
		assertTrue(headwearInv.length == 0);
		assertTrue(suitInv.length == 0);
		assertTrue(shieldInv.length == 0);
		assertTrue(weaponInv.length == 0);
		
		Item item = Debug.makeItem();
		inventory.createItem(item);
		actor.getHeadwear().addTo(inventory);
		actor.getSuit().addTo(inventory);
		actor.getShield().addTo(inventory);
		actor.getHand().addTo(inventory);
		
		inventory.createInventory(inventory);
		itemInv = inventory.getItemInv();
		headwearInv = inventory.getHeadwearInv();
		suitInv = inventory.getSuitInv();
		shieldInv = inventory.getShieldInv();
		weaponInv = inventory.getWeaponInv();

		assertTrue(itemInv.length == 2);
		assertTrue(headwearInv.length == 2);
		assertTrue(suitInv.length == 2);
		assertTrue(shieldInv.length == 2);
		assertTrue(weaponInv.length == 2);
		
		for (Item inv : itemInv) {
			assertTrue(inv == item);
		}
		for (Headwear inv : headwearInv) {
			assertTrue(inv == actor.getHeadwear());
		}
		for (Suit inv : suitInv) {
			assertTrue(inv == actor.getSuit());
		}
		for (Shield inv : shieldInv) {
			assertTrue(inv == actor.getShield());
		}
		for (Weapon inv : weaponInv) {
			assertTrue(inv == actor.getHand());
		}
		
		inventory.destroyItem(item);
		actor.getHeadwear().removeFrom(inventory);
		actor.getSuit().removeFrom(inventory);
		actor.getShield().removeFrom(inventory);
		actor.getHand().removeFrom(inventory);
		
		itemInv = inventory.getItemInv();
		headwearInv = inventory.getHeadwearInv();
		suitInv = inventory.getSuitInv();
		shieldInv = inventory.getShieldInv();
		weaponInv = inventory.getWeaponInv();

		assertTrue(itemInv.length == 1);
		assertTrue(headwearInv.length == 1);
		assertTrue(suitInv.length == 1);
		assertTrue(shieldInv.length == 1);
		assertTrue(weaponInv.length == 1);

		for (Item inv : itemInv) {
			assertTrue(inv == item);
		}
		for (Headwear inv : headwearInv) {
			assertTrue(inv == actor.getHeadwear());
		}
		for (Suit inv : suitInv) {
			assertTrue(inv == actor.getSuit());
		}
		for (Shield inv : shieldInv) {
			assertTrue(inv == actor.getShield());
		}
		for (Weapon inv : weaponInv) {
			assertTrue(inv == actor.getHand());
		}
		
		profile.getTransferData();
	}
	//TODO: profile test
}
