package edu.ycp.cs320spring2015.oubliation.client.transfer;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320spring2015.oubliation.shared.effect.Headwear;

final public class HeadwearOverlay extends EquipmentOverlay {
	protected HeadwearOverlay() { }
	
	static final public class ResourceMap extends EntityResourceMap<HeadwearOverlay> {

		public ResourceMap(String[] filenames,
				AsyncCallback<EntityResourceMap<HeadwearOverlay>> callback) {
			super(filenames, callback);
		}
	}
	
	static public Map<String, Headwear> remapHeadwear(Map<String, HeadwearOverlay> overlayMap) {
		HashMap<String, Headwear> entityMap = new HashMap<String, Headwear>();
		for (String key : overlayMap.keySet()) {
			entityMap.put(key, overlayMap.get(key).getHeadwear());
		}
		return entityMap;
	}
	
	public Headwear getHeadwear() {
		return new Headwear(getNameTag(), getPrice(), getJobSet(), getAr());
	}
}
