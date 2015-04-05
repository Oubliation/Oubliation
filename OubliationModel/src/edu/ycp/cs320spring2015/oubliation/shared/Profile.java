package edu.ycp.cs320spring2015.oubliation.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

import edu.ycp.cs320spring2015.oubliation.shared.actor.player.PlayerActor;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Equipment;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Item;
import edu.ycp.cs320spring2015.oubliation.shared.transfer.PlayerActorMemento;
import edu.ycp.cs320spring2015.oubliation.shared.transfer.ProfileMemento;

/**
 * maintains data concerning player state
 */
public final class Profile implements Serializable {
	private static final long serialVersionUID = 6002185655350502612L;
	public Profile() {}

	final int maxPartySize = 6;
	
	private String username;
	private int money = 0; 
	private ArrayList<Item> inventory;
	private ArrayList<PlayerActor> party;  //active player actors
	private ArrayList<PlayerActor> roster; //reserve player actors
	private HashSet<String> dungeonFlags; //active dungeon flags
	
	/**
	 * Maintains data concerning player state.
	 * @param money accrued by the party
	 * @param inventory items obtained by the party
	 * @param party i.e. the characters in the party
	 * @param roster characters waiting in the guild
	 * @param dungeonFlags flags triggered by the party inside the dungeon.
	 */
	public Profile(String username, int money, ArrayList<Item> inventory,
			ArrayList<PlayerActor> party, ArrayList<PlayerActor> roster,
			HashSet<String> dungeonFlags) {
		this.username = username;
		this.money = money;
		this.inventory = inventory;
		this.party = party;
		this.roster = roster;
		this.dungeonFlags = dungeonFlags;
	}
	
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
	/**
	 * 
	 * @return array of roster members
	 */
	public PlayerActor[] getRoster() {
		return roster.toArray(new PlayerActor[roster.size()]);
	}
	/**
	 * 
	 * @return True if the party is full, false if the party is not full
	 */
	public boolean hasMaxParty() {
		return party.size()>=maxPartySize;
	}
	/**
	 * 
	 * @param actor to add to the party
	 */
	public void addActor(PlayerActor actor) {
		assert !hasMaxParty();
		boolean haveUnit = roster.remove(actor);
		party.add(actor);
		
		assert haveUnit;
	}
	/**
	 * 
	 * @param actor to remove from the party
	 */
	public void removeActor(PlayerActor actor) {
		boolean haveUnit = party.remove(actor);
		roster.add(actor);
		
		assert haveUnit;
	}
	/**
	 * 
	 * @return array of party members
	 */
	public PlayerActor[] getParty() {
		return party.toArray(new PlayerActor[party.size()]);
	}
	/**
	 * 
	 * @param item to add to the inventory
	 */
	public void createItem(Item item) {
		inventory.add(item);
	}
	/**
	 * 
	 * @param item to be removed from the inventory
	 */
	public void destroyItem(Item item) {
		boolean hadItem = inventory.remove(item);
		assert hadItem;
	}
	/**
	 * 
	 * @param actor to equip the item on.
	 * @param equipment to equip onto the actor
	 */
	public void fieldEquipActor(PlayerActor actor, Equipment equipment) {
		boolean haveEquipment = inventory.remove(equipment);
		actor.fieldEquip(equipment);
		assert haveEquipment;
	}
	/**
	 * 
	 * @param actor to un-equip the item from.
	 * @param equipment to take from the actor and place in the inventory.
	 */
	public void fieldUnequipActor(PlayerActor actor, Equipment equipment) {
		actor.fieldUnequip(equipment);
		inventory.add(equipment);
	}
	/**
	 * 
	 * @param actor to un-equip the item from.
	 * @param equipment to take from the actor and place in the inventory.
	 */
	public void battleUnequipActor(PlayerActor actor, Equipment equipment) {
		actor.battleUnequip(equipment);
		inventory.add(equipment);
	}
	/**
	 * 
	 * @param actor who is to be equipped when the turn in queue comes
	 * @param equipment to equip onto the actor
	 */
	public void actorQueueEquipment(PlayerActor actor, Equipment equipment) {
		boolean haveEquipment = inventory.remove(equipment);
		actor.queueEquipment(equipment);
		assert haveEquipment;
	}
	/**
	 * Removes the two params from queue
	 * @param actor who is to be equipped when the turn in queue comes
	 * @param equipment to equip onto the actor
	 */
	public void actorDequeEquipment(PlayerActor actor, Equipment equipment) {
		actor.dequeueEquipment(equipment);
		inventory.add(equipment);
	}
	/**
	 * 
	 * @param amount amount of money to add
	 */
	public void incMoney(int amount) {
		money += amount;
	}
	/**
	 * 
	 * @param amount The amount of money for the required operation, to check against how much money accrued by the party.
	 * @return True if money is the correct amount needed; false if otherwise
	 */
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
	/**
	 * @return the username.
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * @return serializable form of this profile
	 */
	public ProfileMemento getTransferData() {
		LinkedList<PlayerActorMemento> partyTransfer = new LinkedList<PlayerActorMemento>();
		LinkedList<PlayerActorMemento> rosterTransfer = new LinkedList<PlayerActorMemento>();
		LinkedList<String> inventory = new LinkedList<String>();
		for (PlayerActor actor : party) {
			partyTransfer.add(actor.getTransfer());
		}
		for (PlayerActor actor : roster) {
			rosterTransfer.add(actor.getTransfer());
		}
		return new ProfileMemento(username, money, inventory, partyTransfer, rosterTransfer, dungeonFlags);
	}
	/**
	 * Goes through the party healing each person
	 * by the specified amount.
	 * @param amount
	 */
	public void healParty(int amount){
		for(PlayerActor actor : party){actor.receiveHealing(amount);}
	}
	/**
	 * Goes through the party 
	 * increasing the xp of each person
	 * by the specified amount.
	 * @param amount
	 */
	public void increasePartyXP(int amount){
		for(PlayerActor actor : party){actor.incExperience(amount);}
	}
	
}
