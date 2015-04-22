package edu.ycp.cs320spring2015.oubliation.client.transfer.overlays;

import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityExtractor;
import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityResourceMap;
import edu.ycp.cs320spring2015.oubliation.shared.items.Effect;
import edu.ycp.cs320spring2015.oubliation.shared.items.Utility;

public class UtilityOverlay extends EquipmentOverlay {

	protected UtilityOverlay() { }
	
	static final public class ResourceMap extends EntityResourceMap<UtilityOverlay> {

		public ResourceMap(String[] filenames,
				AsyncCallback<EntityResourceMap<UtilityOverlay>> callback) {
			super(filenames, callback);
		}
	}
	
	static public Map<String, Utility> remapUtility(Map<String, UtilityOverlay> overlayMap, final Map<String, Effect> effectMap) {
		EntityExtractor<Utility, UtilityOverlay> extractor = new EntityExtractor<Utility, UtilityOverlay>() {
			public Utility getEntity(UtilityOverlay overlay) {
				return overlay.getUtility(effectMap);
			}
		};
		return remapEntity(overlayMap, extractor);
	}

	final protected native String getEffectName() /*-{
		return this.effect;
	}-*/;
	
	final public Utility getUtility(Map<String, Effect> effectMap) {
		return new Utility(getNameTag(), getPrice(), getStringSet(getEquippableBy()), effectMap.get(getEffectName()));
	}
}
