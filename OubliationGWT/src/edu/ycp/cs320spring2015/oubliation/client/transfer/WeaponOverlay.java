package edu.ycp.cs320spring2015.oubliation.client.transfer;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320spring2015.oubliation.shared.effect.Effect;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Weapon;

public class WeaponOverlay extends UtilityOverlay {


	protected WeaponOverlay() { }
	
	static final public class ResourceMap extends EntityResourceMap<WeaponOverlay> {

		public ResourceMap(String[] filenames,
				AsyncCallback<EntityResourceMap<WeaponOverlay>> callback) {
			super(filenames, callback);
		}
	}
	
	static public Map<String, Weapon> remapWeapon(Map<String, WeaponOverlay> overlayMap, Map<String, Effect> effectMap) {
		HashMap<String, Weapon> entityMap = new HashMap<String, Weapon>();
		for (String key : overlayMap.keySet()) {
			entityMap.put(key, overlayMap.get(key).getWeapon(effectMap));
		}
		return entityMap;
	}
	
	final public Weapon getWeapon(Map<String, Effect> effectMap) {
		return new Weapon(getNameTag(), getPrice(), getJobSet(), effectMap.get(getEffectName()));
	}
}
