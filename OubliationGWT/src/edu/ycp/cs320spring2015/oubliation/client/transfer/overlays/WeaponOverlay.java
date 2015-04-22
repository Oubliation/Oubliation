package edu.ycp.cs320spring2015.oubliation.client.transfer.overlays;

import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityExtractor;
import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityResourceMap;
import edu.ycp.cs320spring2015.oubliation.shared.items.Effect;
import edu.ycp.cs320spring2015.oubliation.shared.items.Weapon;

public class WeaponOverlay extends UtilityOverlay {


	protected WeaponOverlay() { }
	
	static final public class ResourceMap extends EntityResourceMap<WeaponOverlay> {

		public ResourceMap(String[] filenames,
				AsyncCallback<EntityResourceMap<WeaponOverlay>> callback) {
			super(filenames, callback);
		}
	}
	
	static public Map<String, Weapon> remapWeapon(Map<String, WeaponOverlay> overlayMap, final Map<String, Effect> effectMap) {
		EntityExtractor<Weapon, WeaponOverlay> extractor = new EntityExtractor<Weapon, WeaponOverlay>() {
			public Weapon getEntity(WeaponOverlay overlay) {
				return overlay.getWeapon(effectMap);
			}
		};
		return remapEntity(overlayMap, extractor);
	}
	
	final public Weapon getWeapon(Map<String, Effect> effectMap) {
		return new Weapon(getNameTag(), getPrice(), getStringSet(getEquippableBy()), effectMap.get(getEffectName()));
	}
}
