package edu.ycp.cs320spring2015.oubliation.shared.transfer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.LinkedList;
import java.util.Map;

import edu.ycp.cs320spring2015.oubliation.shared.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.actor.Loadout;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.BruceScore;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.PlayerActor;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.PlayerIdentity;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.PlayerStats;
import edu.ycp.cs320spring2015.oubliation.shared.items.Utility;

/**
 * 
 * Store and reconstruct PlayerActor data for transfer
 *
 */
public class PlayerActorMemento implements Serializable {
	private static final long serialVersionUID = 6140506450106292650L;
	
	public PlayerActorMemento() { }
	
	//data
	NameTag nameTag;
	int health;
	StatusMemento status;
	PlayerIdentity identity;
	String headwearName;
	String suitName;
	String shieldName;
	String weaponName;
	LinkedList<String> autoEquipUtilities;
	EnumMap<BruceScore, Integer> bonusScores;
	int[] witchMp;
	int[] priestMp;

	public PlayerActorMemento(NameTag nameTag, int health, StatusMemento status, PlayerIdentity identity) {
		this.nameTag = nameTag;
		this.health = health;
		this.status = status;
		this.identity = identity;
	}
	
	/**
	 * @param headwearName name of equipped headwear to serialize
	 * @param suitName name of equipped suit to serialize
	 * @param shieldName name of equipped shield to serialize
	 * @param weaponName name of equipped weapon to serialize
	 */
	public void setLoadout(String headwearName, String suitName, String shieldName, String weaponName) {
		assert this.headwearName == null && this.suitName == null && this.shieldName == null && this.weaponName == null;
		this.headwearName = headwearName;
		this.suitName = suitName;
		this.shieldName = shieldName;
		this.weaponName = weaponName;
		
	}
	/**
	 * @param autoEquipUtilities names of equipped autoEquipUtilities to serialize
	 * @param witchMp current witch mana count for each level to serialize 
	 * @param priestMp current priest mana count for each level to serialize 
	 */
	public void setStats(LinkedList<String> autoEquipUtilities, EnumMap<BruceScore, Integer> bonusScores, int[] witchMp, int[] priestMp) {
		assert this.autoEquipUtilities == null && this.bonusScores == null && this.witchMp == null && this.priestMp == null;
		this.autoEquipUtilities = autoEquipUtilities;
		this.bonusScores = bonusScores;
		this.witchMp = witchMp;
		this.priestMp = priestMp;
	}
	
	/**
	 * @return reconstruct PlayerActor from stored transfer data
	 */
	public PlayerActor constructPlayerActor(LoadoutLoader loader) {
		ArrayList<Utility> utilityBelt = new ArrayList<Utility>();
		Map<String, Utility> utilityMap = loader.getUtilityMap();
		for (String utilityName : autoEquipUtilities) {
			utilityBelt.add(utilityMap.get(utilityName));
		}
		Loadout loadout = new Loadout(loader.getHeadwearMap().get(headwearName), loader.getSuitMap().get(suitName),
				loader.getShieldMap().get(shieldName), loader.getWeaponMap().get(weaponName), utilityBelt);
		PlayerStats stats = new PlayerStats(new ArrayList<Utility>(), bonusScores, witchMp, priestMp);
		return new PlayerActor(nameTag, 20, status, loadout, identity, stats);
	}
}
