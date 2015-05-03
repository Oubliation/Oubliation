package edu.ycp.cs320spring2015.oubliation.shared.test;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.TreeSet;

import edu.ycp.cs320spring2015.oubliation.shared.Inventory;
import edu.ycp.cs320spring2015.oubliation.shared.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.Profile;
import edu.ycp.cs320spring2015.oubliation.shared.actor.Loadout;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.BruceScore;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.PlayerActor;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.PlayerIdentity;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.PlayerStats;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.PlayerBackground;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.PlayerJob;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.PlayerSpecies;
import edu.ycp.cs320spring2015.oubliation.shared.items.Headwear;
import edu.ycp.cs320spring2015.oubliation.shared.items.Shield;
import edu.ycp.cs320spring2015.oubliation.shared.items.Suit;
import edu.ycp.cs320spring2015.oubliation.shared.items.Utility;
import edu.ycp.cs320spring2015.oubliation.shared.items.Weapon;
import edu.ycp.cs320spring2015.oubliation.shared.location.Floor;
import edu.ycp.cs320spring2015.oubliation.shared.location.Tile;
import edu.ycp.cs320spring2015.oubliation.shared.statuses.Healthy;
import edu.ycp.cs320spring2015.oubliation.shared.transfer.ProfileMemento;

/**
 * 
 * Debug class for creating game objects to quickly test systems
 *
 */
public class Debug {
	/**
	 * @return arbitrary PlayerJob for testing
	 */
	public static PlayerJob makePlayerJob() {
		NameTag jobTag = new NameTag("Witch", "");
		EnumMap<BruceScore, Integer> attribReqValues = new EnumMap<BruceScore, Integer>(BruceScore.class);
		attribReqValues.put(BruceScore.mightily, 3);
		attribReqValues.put(BruceScore.healthily, 3);
		attribReqValues.put(BruceScore.intelligently, 3);
		attribReqValues.put(BruceScore.godly, 3);
		attribReqValues.put(BruceScore.quickly, 3);
		attribReqValues.put(BruceScore.luckily, 3);
		Integer[] expRequired = {100, 200, 400, 800, 1600, 3200, 6400};
		return new PlayerJob(jobTag, attribReqValues, expRequired, 6400, 1, 16, 8, 2);
	}
	
	/**
	 * @return arbitrary PlayerBackground for testing
	 */
	public static PlayerBackground makePlayerBackground() {
		NameTag bgTag = new NameTag("Scholar", "");
		EnumMap<BruceScore, Double> attribGainRates = new EnumMap<BruceScore, Double>(BruceScore.class);
		attribGainRates.put(BruceScore.mightily, 1.0);
		attribGainRates.put(BruceScore.healthily, 1.2);
		attribGainRates.put(BruceScore.intelligently, 0.7);
		attribGainRates.put(BruceScore.godly, 0.5);
		attribGainRates.put(BruceScore.quickly, 1.5);
		attribGainRates.put(BruceScore.luckily, 1.3);
		String backgroundRival = "Cartoonist";
		return new PlayerBackground(bgTag, attribGainRates, new TreeSet<String>(), backgroundRival);
	}

	/**
	 * @return arbitrary PlayerSpecies for testing
	 */
	public static PlayerSpecies makePlayerSpecies() {
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

	/**
	 * @return arbitrary PlayerIdentity for testing
	 */
	public static PlayerIdentity makePlayerIdentity() {
		PlayerJob job = makePlayerJob();
		PlayerBackground bg = makePlayerBackground();
		PlayerSpecies species = makePlayerSpecies();
		
		return new PlayerIdentity(bg, species, job, 3, 100);
	}

	/**
	 * @return arbitrary Headwear for testing
	 */
	public static Headwear makeHeadwear() {
		NameTag headwearTag = new NameTag("Leather Hood", "");
		return new Headwear(headwearTag, 100, new TreeSet<String>(), 1);
	}

	/**
	 * @return arbitrary Suit for testing
	 */
	public static Suit makeSuit() {
		NameTag suitTag = new NameTag("Plate Mail", "");
		return new Suit(suitTag, 100, new TreeSet<String>(), 3);
	}

	/**
	 * @return arbitrary Shield for testing
	 */
	public static Shield makeShield() {
		NameTag shieldTag = new NameTag("Dragon Shield", "");
		return new Shield(shieldTag, 100, new TreeSet<String>(), 2);
	}

	/**
	 * @return arbitrary Weapon for testing
	 */
	public static Weapon makeWeapon() {
		NameTag weaponTag = new NameTag("Sword", "");
		return new Weapon(weaponTag, 100, new TreeSet<String>(), null);
	}

	/**
	 * @return arbitrary Loadout for testing
	 */
	public static Loadout makeLoadout() {
		Headwear headwear = makeHeadwear();
		Suit suit = makeSuit();
		Shield shield = makeShield();
		Weapon weapon = makeWeapon();
		
		return new Loadout(headwear, suit, shield, weapon, new ArrayList<Utility>());
	}

	/**
	 * @return arbitrary PlayerStats for testing
	 */
	public static PlayerStats makePlayerStats() {
		EnumMap<BruceScore, Integer> PaBonusScores = new EnumMap<BruceScore, Integer>(BruceScore.class);
		PaBonusScores.put(BruceScore.mightily, 0);
		PaBonusScores.put(BruceScore.healthily, 0);
		PaBonusScores.put(BruceScore.intelligently, 0);
		PaBonusScores.put(BruceScore.godly, 0);
		PaBonusScores.put(BruceScore.quickly, 0);
		PaBonusScores.put(BruceScore.luckily, 0);
		int[] witchMp = {40, 36, 30, 24, 16, 8};
		int[] priestMp = {40, 36, 30, 24, 16, 8};
		return new PlayerStats(new ArrayList<Utility>(), PaBonusScores, witchMp, priestMp);
	}

	/**
	 * @return arbitrary PlayerActor for testing
	 */
	public static PlayerActor makePlayerActor() {
		PlayerIdentity identity = makePlayerIdentity();
		Loadout loadout = makeLoadout();
		PlayerStats stats = makePlayerStats();
		
		NameTag playerTag = new NameTag("Nevik", "A character controlled by the Player");
		return new PlayerActor(playerTag, 20, new Healthy(), loadout, identity, stats);
	}
	
	public static Inventory makeInventory() {
		//TODO: insert items for testing
		return new Inventory();
	}

	/**
	 * @return arbitrary Profile for testing
	 */
	public static Profile makeProfile() {
		return makeProfile("username");
	}
	/**
	 * @param username of profile
	 * @return arbitrary Profile for testing
	 */
	public static Profile makeProfile(String username) {
		ArrayList<PlayerActor> party = new ArrayList<PlayerActor>();
		for (int count=0; count<6; count+=1) {
			party.add(makePlayerActor());
		}
		
		ArrayList<PlayerActor> roster = new ArrayList<PlayerActor>();
		for (int count=0; count<10; count+=1) {
			roster.add(makePlayerActor());
		}
		return new Profile(username, 200, makeInventory(), party, roster, new HashSet<String>());
	}
	
	/**
	 * @return easily serialized form of Profile
	 */
	public static ProfileMemento makeProfileTransfer() {
		return makeProfileTransfer("username");
	}
	/**
	 * @param username of profile
	 * @return easily serialized form of Profile
	 */
	public static ProfileMemento makeProfileTransfer(String username) {
		return makeProfile(username).getTransferData();
	}
	
	public static Floor makeMap(){		
		Floor map = new Floor(new NameTag("floor one", "first floor"), new Tile[20][20]);
		for(int i = 0; i < map.getMapWidth(); i++){
			map.setTile(i, new Tile[20]);
			for(int j = 0; j < map.getMapHeight(); j++){
				map.createTile(i, j);
				if(j == 0){map.getTile(i, j).setIsSolid(true);}
				else if(i == 0){map.getTile(i, j).setIsSolid(true);}
				else if(i == 1 && j == 1){map.getTile(i, j).setIsToOutskirts(true);}
				else if(i == 18 && j == 18){map.getTile(i, j).setIsStairsUp(true);}
				else if(i == 19){map.getTile(i, j).setIsSolid(true);}
				else if(j == 19){map.getTile(i, j).setIsSolid(true);}
				else if(i == 5 && j == 5){map.getTile(i, j).setIsSolid(true);}
			}
		}
		return map;
	}
}