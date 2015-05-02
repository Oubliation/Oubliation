package edu.ycp.cs320spring2015.oubliation.shared;

import java.io.Serializable;
import java.util.Map;

import edu.ycp.cs320spring2015.oubliation.shared.items.Headwear;
import edu.ycp.cs320spring2015.oubliation.shared.items.Item;
import edu.ycp.cs320spring2015.oubliation.shared.items.Shield;
import edu.ycp.cs320spring2015.oubliation.shared.items.Suit;
import edu.ycp.cs320spring2015.oubliation.shared.items.Utility;
import edu.ycp.cs320spring2015.oubliation.shared.items.Weapon;

public class InventoryMapTuple implements Serializable {
	private static final long serialVersionUID = -1524884415827909907L;
	protected InventoryMapTuple() {}
	
	private Map<String, Item> itemMap;
	private Map<String, Headwear> headwearMap;
	private Map<String, Suit> suitMap;
	private Map<String, Shield> shieldMap;
	private Map<String, Utility> utilityMap;
	private Map<String, Weapon> weaponMap;
	
	public InventoryMapTuple(Map<String, Item> itemMap, Map<String, Headwear> headwearMap,
			Map<String, Suit> suitMap, Map<String, Shield> shieldMap,
			Map<String, Utility> utilityMap, Map<String, Weapon> weaponMap) {
		this.headwearMap = headwearMap;
		this.suitMap = suitMap;
		this.shieldMap = shieldMap;
		this.utilityMap = utilityMap;
		this.weaponMap = weaponMap;
	}
	public Map<String, Item> getItemMap() {
		return itemMap;
	}
	public Map<String, Headwear> getHeadwearMap() {
		return headwearMap;
	}
	public Map<String, Suit> getSuitMap() {
		return suitMap;
	}
	public Map<String, Shield> getShieldMap() {
		return shieldMap;
	}
	public Map<String, Utility> getUtilityMap() {
		return utilityMap;
	}
	public Map<String, Weapon> getWeaponMap() {
		return weaponMap;
	}
}
