package edu.ycp.cs320spring2015.oubliation.shared;

import java.util.ArrayList;

import edu.ycp.cs320spring2015.oubliation.shared.items.Headwear;
import edu.ycp.cs320spring2015.oubliation.shared.items.Item;
import edu.ycp.cs320spring2015.oubliation.shared.items.Shield;
import edu.ycp.cs320spring2015.oubliation.shared.items.Suit;
import edu.ycp.cs320spring2015.oubliation.shared.items.Utility;
import edu.ycp.cs320spring2015.oubliation.shared.items.Weapon;
import edu.ycp.cs320spring2015.oubliation.shared.transfer.InventoryMemento;

public class Inventory {
	private ArrayList<Item> itemInv;
	private ArrayList<Headwear> headwearInv;
	private ArrayList<Suit> suitInv;
	private ArrayList<Shield> shieldInv;
	private ArrayList<Utility> utilityInv;
	private ArrayList<Weapon> weaponInv;
	
	public Inventory() {
		this.itemInv = new ArrayList<Item>();;
		this.headwearInv = new ArrayList<Headwear>();
		this.suitInv = new ArrayList<Suit>();
		this.shieldInv = new ArrayList<Shield>();
		this.utilityInv = new ArrayList<Utility>();
		this.weaponInv = new ArrayList<Weapon>();
	}
	
	public Inventory(ArrayList<Item> itemInv,
			ArrayList<Headwear> headwearInv, ArrayList<Suit> suitInv,
			ArrayList<Shield> shieldInv, ArrayList<Utility> utilityInv,
			ArrayList<Weapon> weaponInv) {
		this.itemInv = itemInv;
		this.headwearInv = headwearInv;
		this.suitInv = suitInv;
		this.shieldInv = shieldInv;
		this.utilityInv = utilityInv;
		this.weaponInv = weaponInv;
	}


	public Item[] getItemInv() {
		return itemInv.toArray(new Item[itemInv.size()]);
	}
	public Headwear[] getHeadwearInv() {
		return headwearInv.toArray(new Headwear[headwearInv.size()]);
	}
	public Suit[] getSuitInv() {
		return suitInv.toArray(new Suit[suitInv.size()]);
	}
	public Shield[] getShieldInv() {
		return shieldInv.toArray(new Shield[shieldInv.size()]);
	}
	public Utility[] getUtilityInv() {
		return utilityInv.toArray(new Utility[utilityInv.size()]);
	}
	public Weapon[] getWeaponInv() {
		return weaponInv.toArray(new Weapon[weaponInv.size()]);
	}
	
	public void createInventory(Inventory inv) {
		for (Item item : inv.getItemInv()) {
			createItem(item);
		}
		for (Headwear headwear : inv.getHeadwearInv()) {
			createHeadwear(headwear);
		}
		for (Suit suit : inv.getSuitInv()) {
			createSuit(suit);
		}
		for (Shield shield : inv.getShieldInv()) {
			createShield(shield);
		}
		for (Utility utility : inv.getUtilityInv()) {
			createUtility(utility);
		}
		for (Weapon weapon : inv.getWeaponInv()) {
			createWeapon(weapon);
		}
	}
	
	/**
	 * 
	 * @param item to add to the inventory
	 */
	public void createItem(Item item){
		itemInv.add(item);
	}
	/**
	 * 
	 * @param headwear to add to the inventory
	 */
	public void createHeadwear(Headwear headwear){
		headwearInv.add(headwear);
	}
	/**
	 * 
	 * @param suit to add to the inventory
	 */
	public void createSuit(Suit suit){
		suitInv.add(suit);
	}
	/**
	 * 
	 * @param shield to add to the inventory
	 */
	public void createShield(Shield shield){
		shieldInv.add(shield);
	}
	/**
	 * 
	 * @param utility to add to the inventory
	 */
	public void createUtility(Utility utility){
		utilityInv.add(utility);
	}
	/**
	 * 
	 * @param weapon to add to the inventory
	 */
	public void createWeapon(Weapon weapon){
		weaponInv.add(weapon);
	}
	/**
	 * 
	 * @param item to be removed from the inventory
	 */
	public void destroyItem(Item item) {
		boolean hadItem = itemInv.remove(item);
		assert hadItem;
	}
	/**
	 * 
	 * @param headwear to add to the inventory
	 */
	public void destroyHeadwear(Headwear headwear){
		boolean hadItem = headwearInv.remove(headwear);
		assert hadItem;
	}
	/**
	 * 
	 * @param suit to add to the inventory
	 */
	public void destroySuit(Suit suit){
		boolean hadItem = suitInv.remove(suit);
		assert hadItem;
	}
	/**
	 * 
	 * @param shield to add to the inventory
	 */
	public void destroyShield(Shield shield){
		boolean hadItem = shieldInv.remove(shield);
		assert hadItem;
	}
	/**
	 * 
	 * @param utility to add to the inventory
	 */
	public void destroyUtility(Utility utility){
		boolean hadItem = utilityInv.remove(utility);
		assert hadItem;
	}
	/**
	 * 
	 * @param weapon to add to the inventory
	 */
	public void destroyWeapon(Weapon weapon){
		boolean hadItem = weaponInv.remove(weapon);
		assert hadItem;
	}
	/**
	 * 
	 * @return a InventoryMemento
	 */
	public InventoryMemento getTransfer() {
		return new InventoryMemento(itemInv, headwearInv, suitInv,
				shieldInv, utilityInv, weaponInv);
	}
}
