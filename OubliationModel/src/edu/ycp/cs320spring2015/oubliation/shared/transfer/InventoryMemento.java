package edu.ycp.cs320spring2015.oubliation.shared.transfer;

import java.io.Serializable;
import java.util.ArrayList;

import edu.ycp.cs320spring2015.oubliation.shared.CreateInventory;
import edu.ycp.cs320spring2015.oubliation.shared.items.Headwear;
import edu.ycp.cs320spring2015.oubliation.shared.items.Item;
import edu.ycp.cs320spring2015.oubliation.shared.items.Shield;
import edu.ycp.cs320spring2015.oubliation.shared.items.Suit;
import edu.ycp.cs320spring2015.oubliation.shared.items.Utility;
import edu.ycp.cs320spring2015.oubliation.shared.items.Weapon;

public class InventoryMemento implements Serializable {
	private static final long serialVersionUID = -1510893449438032734L;
	protected InventoryMemento() {}
	
	private ArrayList<String> itemInv;
	private ArrayList<String> headwearInv;
	private ArrayList<String> suitInv;
	private ArrayList<String> shieldInv;
	private ArrayList<String> utilityInv;
	private ArrayList<String> weaponInv;
	
	public InventoryMemento(ArrayList<Item> itemInv,
			ArrayList<Headwear> headwearInv, ArrayList<Suit> suitInv,
			ArrayList<Shield> shieldInv, ArrayList<Utility> utilityInv,
			ArrayList<Weapon> weaponInv) {
		this.itemInv = new ArrayList<String>();
		for (Item item : itemInv) {
			this.itemInv.add(item.getName());
		}
		this.headwearInv = new ArrayList<String>();
		for (Headwear item : headwearInv) {
			this.headwearInv.add(item.getName());
		}
		this.suitInv = new ArrayList<String>();
		for (Suit item : suitInv) {
			this.suitInv.add(item.getName());
		}
		this.shieldInv = new ArrayList<String>();
		for (Shield item : shieldInv) {
			this.shieldInv.add(item.getName());
		}
		this.utilityInv = new ArrayList<String>();
		for (Utility item : utilityInv) {
			this.utilityInv.add(item.getName());
		}
		this.weaponInv = new ArrayList<String>();
		for (Weapon item : weaponInv) {
			this.weaponInv.add(item.getName());
		}
	}
	
	public CreateInventory constructInventory(LoadoutLoader loader) {
		ArrayList<Item> itemList = new ArrayList<Item>();
		for (String name : itemInv) {
			itemList.add(loader.getItemMap().get(name));
		}
		ArrayList<Headwear> headwearList = new ArrayList<Headwear>();
		for (String name : headwearInv) {
			headwearList.add(loader.getHeadwearMap().get(name));
		}
		ArrayList<Suit> suitList = new ArrayList<Suit>();
		for (String name : suitInv) {
			suitList.add(loader.getSuitMap().get(name));
		}
		ArrayList<Shield> shieldList = new ArrayList<Shield>();
		for (String name : shieldInv) {
			shieldList.add(loader.getShieldMap().get(name));
		}
		ArrayList<Utility> utilityList = new ArrayList<Utility>();
		for (String name : utilityInv) {
			utilityList.add(loader.getUtilityMap().get(name));
		}
		ArrayList<Weapon> weaponList = new ArrayList<Weapon>();
		for (String name : weaponInv) {
			weaponList.add(loader.getWeaponMap().get(name));
		}
		return new CreateInventory(itemList, headwearList, suitList, shieldList, utilityList, weaponList);
	}
}
