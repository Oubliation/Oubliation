package edu.ycp.cs320spring2015.oubliation.client.transfer;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320spring2015.oubliation.shared.effect.Suit;

public class SuitOverlay extends EquipmentOverlay {
	protected SuitOverlay() { }
	
	static final public class ResourceMap extends EntityResourceMap<SuitOverlay> {

		public ResourceMap(String[] filenames,
				AsyncCallback<EntityResourceMap<SuitOverlay>> callback) {
			super(filenames, callback);
		}
		
	}
	
	static public Map<String, Suit> remapSuit(Map<String, SuitOverlay> overlayMap) {
		HashMap<String, Suit> entityMap = new HashMap<String, Suit>();
		for (String key : overlayMap.keySet()) {
			entityMap.put(key, overlayMap.get(key).getSuit());
		}
		return entityMap;
	}
	
	public Suit getSuit() {
		return new Suit(getNameTag(), getPrice(), getJobSet(), getAr());
	}
}
