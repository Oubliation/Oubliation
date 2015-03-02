package edu.ycp.cs320spring2015.oubliation.shared.character;

import java.util.ArrayList;

import edu.ycp.cs320spring2015.oubliation.shared.effect.Equipment;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Item;

public class Profile {
	final int maxPartySize = 6;
			
	private int money = 0;
	private ArrayList<Item> inventory;
	private ArrayList<PlayerActor> party;
	private ArrayList<PlayerActor> roster;
	//TODO: profile

	public void createActor(PlayerActor actor) {
		roster.add(actor);
	}
	public void destroyActor(PlayerActor actor) {
		boolean hadUnit = roster.remove(actor);
		assert hadUnit;
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
	public void decMoney(int amount) {
		if (money >= amount) { money -= amount; }
		else { money = 0; }
	}
	public int getMoney() {
		return money;
	}
}
