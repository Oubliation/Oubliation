package edu.ycp.cs320spring2015.oubliation.client.transfer;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320spring2015.oubliation.shared.effect.Shield;

public class ShieldOverlay extends EquipmentOverlay {

	protected ShieldOverlay() { }
	
	static final public class ResourceMap extends EntityResourceMap<ShieldOverlay> {

		public ResourceMap(String[] filenames,
				AsyncCallback<EntityResourceMap<ShieldOverlay>> callback) {
			super(filenames, callback);
		}
		
	}
	
	static public Map<String, Shield> remapShield(Map<String, ShieldOverlay> overlayMap) {
		HashMap<String, Shield> entityMap = new HashMap<String, Shield>();
		for (String key : overlayMap.keySet()) {
			entityMap.put(key, overlayMap.get(key).getShield());
		}
		return entityMap;
	}
	
	public Shield getShield() {
		return new Shield(getNameTag(), getPrice(), getJobSet(), getAr());
	}
}
