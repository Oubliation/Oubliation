package edu.ycp.cs320spring2015.oubliation.client.transfer;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320spring2015.oubliation.shared.effect.Effect;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Utility;

public class UtilityOverlay extends EquipmentOverlay {

	protected UtilityOverlay() { }
	
	static final public class ResourceMap extends EntityResourceMap<UtilityOverlay> {

		public ResourceMap(String[] filenames,
				AsyncCallback<EntityResourceMap<UtilityOverlay>> callback) {
			super(filenames, callback);
		}
	}
	
	static public Map<String, Utility> remapUtility(Map<String, UtilityOverlay> overlayMap, Map<String, Effect> effectMap) {
		HashMap<String, Utility> entityMap = new HashMap<String, Utility>();
		for (String key : overlayMap.keySet()) {
			entityMap.put(key, overlayMap.get(key).getUtility(effectMap));
		}
		return entityMap;
	}

	final protected native String getEffectName() /*-{
		return this.effect;
	}-*/;
	
	final public Utility getUtility(Map<String, Effect> effectMap) {
		return new Utility(getNameTag(), getPrice(), getJobSet(), effectMap.get(getEffectName()));
	}
}
