package edu.ycp.cs320spring2015.oubliation.shared.transfer;

import java.util.Map;

import edu.ycp.cs320spring2015.oubliation.shared.items.Headwear;
import edu.ycp.cs320spring2015.oubliation.shared.items.Item;
import edu.ycp.cs320spring2015.oubliation.shared.items.Shield;
import edu.ycp.cs320spring2015.oubliation.shared.items.Suit;
import edu.ycp.cs320spring2015.oubliation.shared.items.Utility;
import edu.ycp.cs320spring2015.oubliation.shared.items.Weapon;
public interface LoadoutLoader {
	public Map<String, Item> getItemMap();
	public Map<String, Headwear> getHeadwearMap();
	public Map<String, Suit> getSuitMap();
	public Map<String, Shield> getShieldMap();
	public Map<String, Utility> getUtilityMap();
	public Map<String, Weapon> getWeaponMap();
}
