package edu.ycp.cs320spring2015.oubliation.shared.actor.player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

import edu.ycp.cs320spring2015.oubliation.shared.effect.Equipment;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Item;

/**
 * maintains data concerning player state
 */
public class Profile implements Serializable {
	final int maxPartySize = 6;
			
	private int money = 0; 
	private ArrayList<Item> inventory;
	private ArrayList<PlayerActor> party;  //active player actors
	private ArrayList<PlayerActor> roster; //reserve player actors
	private HashSet<String> dungeonFlags; //active dungeon flags
	
	public Profile(int money, ArrayList<Item> inventory,
			ArrayList<PlayerActor> party, ArrayList<PlayerActor> roster,
			HashSet<String> dungeonFlags) {
		this.money = money;
		this.inventory = inventory;
		this.party = party;
		this.roster = roster;
		this.dungeonFlags = dungeonFlags;
	}

	//TODO: profile (saving, loading, logging in)
	
	/**
	 * @param actor PlayerActor to add to roster
	 */
	public void createActor(PlayerActor actor) {
		roster.add(actor);
	}
	
	/**
	 * @param actor PlayerActor to remove from roster
	 */
	public void destroyActor(PlayerActor actor) {
		boolean hadUnit = roster.remove(actor);
		assert hadUnit;
	}
	public PlayerActor[] getRoster() {
		return roster.toArray(new PlayerActor[roster.size()]);
	}
	
	public void addActor(PlayerActor actor) {
		boolean haveUnit = roster.remove(actor);
		party.add(actor);
		
		assert haveUnit && party.size()<=maxPartySize;
	}
	public void removeActor(PlayerActor actor) {
		boolean haveUnit = party.remove(actor);
		roster.add(actor);
		
		assert haveUnit;
	}
	public PlayerActor[] getParty() {
		return party.toArray(new PlayerActor[party.size()]);
	}

	public void createItem(Item item) {
		inventory.add(item);
	}
	public void destroyItem(Item item) {
		boolean hadItem = inventory.remove(item);
		assert hadItem;
	}
	
	public void fieldEquipActor(PlayerActor actor, Equipment equipment) {
		boolean haveEquipment = inventory.remove(equipment);
		actor.fieldEquip(equipment);
		assert haveEquipment;
	}
	public void fieldUnequipActor(PlayerActor actor, Equipment equipment) {
		actor.fieldUnequip(equipment);
		inventory.add(equipment);
	}
	public void battleUnequipActor(PlayerActor actor, Equipment equipment) {
		actor.battleUnequip(equipment);
		inventory.add(equipment);
	}
	
	public void actorQueueEquipment(PlayerActor actor, Equipment equipment) {
		boolean haveEquipment = inventory.remove(equipment);
		actor.queueEquipment(equipment);
		assert haveEquipment;
	}
	public void actorDequeEquipment(PlayerActor actor, Equipment equipment) {
		actor.dequeueEquipment(equipment);
		inventory.add(equipment);
	}
	
	public void incMoney(int amount) {
		money += amount;
	}
	public boolean checkMoney(int amount) {
		return money >= amount;
	}
	/**
	 * @param amount amount of money to remove (stops at zero)
	 */
	public void decMoney(int amount) {
		if (money >= amount) { money -= amount; }
		else { money = 0; }
	}
	/**
	 * @return amount of money owned by player
	 */
	public int getMoney() {
		return money;
	}
	
	/**
	 * 
	 * @param flag flag to check state of
	 * @return current state of flag
	 */
	public boolean isFlagActive(String flag) {
		return dungeonFlags.contains(flag);
	}
	/**
	 * @param flag flag to activate
	 */
	public void setFlag(String flag) {
		dungeonFlags.add(flag);
	}
	/**
	 * @param flag flag to clear
	 */
	public void clearFlag(String flag) {
		dungeonFlags.remove(flag);
	}
	
	/**
	 * @param flag flag to toggle
	 */
	public void toggleFlag(String flag) {
		if (isFlagActive(flag)) {
			setFlag(flag);
		} else {
			clearFlag(flag);
		}
	}
}
