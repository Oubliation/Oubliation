package edu.ycp.cs320spring2015.oubliation.shared.transfer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;

import edu.ycp.cs320spring2015.oubliation.shared.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.actor.Loadout;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.PlayerActor;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.PlayerIdentity;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.PlayerStats;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.Job;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Headwear;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Shield;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Suit;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Utility;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Weapon;

public class PlayerActorTransfer implements Serializable {
	private static final long serialVersionUID = 6140506450106292650L;
	public PlayerActorTransfer() {}
	NameTag nameTag;
	
	PlayerIdentity identity;
	String headwearName;
	String suitName;
	String shieldName;
	String weaponName;
	LinkedList<String> autoEquipUtilities;
	int[] witchMp;
	int[] priestMp;
	int health;

	public PlayerActorTransfer(NameTag nameTag, int health, PlayerIdentity identity) {
		this.nameTag = nameTag;
		this.health = health;
		this.identity = identity;
	}
	
	public void setLoadout(String headwearName, String suitName, String shieldName, String weaponName) {
		assert this.headwearName == null && this.suitName == null && this.shieldName == null && weaponName == null;
		this.headwearName = headwearName;
		this.suitName = suitName;
		this.shieldName = shieldName;
		this.weaponName = weaponName;
		
	}
	public void setStats(LinkedList<String> autoEquipUtilities, int[] witchMp, int[] priestMp) {
		assert this.autoEquipUtilities == null && this.witchMp == null && this.priestMp == null;
		this.autoEquipUtilities = autoEquipUtilities;
		this.witchMp = witchMp;
		this.priestMp = priestMp;
	}
	

	/**
	 * @return arbitrary PlayerActor for testing
	 */
	public PlayerActor makePlayerActor() {
		Loadout loadout = makeLoadout();
		PlayerStats stats = new PlayerStats(witchMp, priestMp, new ArrayList<Utility>());
		return new PlayerActor(nameTag, loadout, 20, identity, stats);
	}
	

	/**
	 * @return arbitrary Headwear for testing
	 */
	public static Headwear makeHeadwear() {
		NameTag headwearTag = new NameTag("Leather Hood", "");
		return new Headwear(headwearTag, 100, new TreeSet<Job>(), 1);
	}

	/**
	 * @return arbitrary Suit for testing
	 */
	public static Suit makeSuit() {
		NameTag suitTag = new NameTag("Plate Mail", "");
		return new Suit(suitTag, 100, new TreeSet<Job>(), 3);
	}

	/**
	 * @return arbitrary Shield for testing
	 */
	public static Shield makeShield() {
		NameTag shieldTag = new NameTag("Dragon Shield", "");
		return new Shield(shieldTag, 100, new TreeSet<Job>(), 2);
	}

	/**
	 * @return arbitrary Weapon for testing
	 */
	public static Weapon makeWeapon() {
		NameTag weaponTag = new NameTag("Sword", "");
		return new Weapon(weaponTag, 100, new TreeSet<Job>(), null);
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
}
