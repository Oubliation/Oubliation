package edu.ycp.cs320spring2015.oubliation.shared.transfer;

import java.util.Map;

import edu.ycp.cs320spring2015.oubliation.shared.effect.Headwear;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Shield;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Suit;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Utility;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Weapon;

public interface LoadoutLoader {
	public Map<String, Headwear> getHeadwearMap();
	public Map<String, Suit> getSuitMap();
	public Map<String, Shield> getShieldMap();
	public Map<String, Utility> getUtilityMap();
	public Map<String, Weapon> getWeaponMap();
}
