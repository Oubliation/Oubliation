package edu.ycp.cs320spring2015.oubliation.shared.character;

import java.util.ArrayList;

import edu.ycp.cs320spring2015.oubliation.shared.effect.Equipment;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Item;

public class Profile {
	final int maxPartySize = 6;
			
	private int money = 0;
	private ArrayList<Item> inventory;
	private ArrayList<PlayerUnit> party;
	private ArrayList<PlayerUnit> roster;
	//TODO: profile

	public void createUnit(PlayerUnit unit) {
		roster.add(unit);
	}
	public void destroyUnit(PlayerUnit unit) {
		boolean hadUnit = roster.remove(unit);
		assert hadUnit;
	}
	
	public void addUnit(PlayerUnit unit) {
		boolean haveUnit = roster.remove(unit);
		party.add(unit);
		
		assert haveUnit && party.size()<=maxPartySize;
	}
	public void removeUnit(PlayerUnit unit) {
		boolean haveUnit = party.remove(unit);
		roster.add(unit);
		
		assert haveUnit;
	}

	public void createItem(Item item) {
		inventory.add(item);
	}
	public void destroyItem(Item item) {
		boolean hadItem = inventory.remove(item);
		assert hadItem;
	}
	
	public void fieldEquipUnit(PlayerUnit unit, Equipment equipment) {
		boolean haveEquipment = inventory.remove(equipment);
		unit.fieldEquip(equipment);
		assert haveEquipment;
	}
	public void fieldUnequipUnit(PlayerUnit unit, Equipment equipment) {
		unit.fieldUnequip(equipment);
		inventory.add(equipment);
	}
	public void battleUnequipUnit(PlayerUnit unit, Equipment equipment) {
		unit.battleUnequip(equipment);
		inventory.add(equipment);
	}
	
	public void unitQueueEquipment(PlayerUnit unit, Equipment equipment) {
		boolean haveEquipment = inventory.remove(equipment);
		unit.queueEquipment(equipment);
		assert haveEquipment;
	}
	public void unitDequeEquipment(PlayerUnit unit, Equipment equipment) {
		unit.dequeueEquipment(equipment);
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
}
