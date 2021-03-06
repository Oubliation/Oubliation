package edu.ycp.cs320spring2015.oubliation.client.transfer.overlays;

import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityExtractor;
import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityResourceMap;
import edu.ycp.cs320spring2015.oubliation.client.transfer.JsBehaviorData;
import edu.ycp.cs320spring2015.oubliation.shared.behavior.Behavior;
import edu.ycp.cs320spring2015.oubliation.shared.items.Utility;

public class UtilityOverlay extends EquipmentOverlay {

	protected UtilityOverlay() { }
	
	static final public class ResourceMap extends EntityResourceMap<UtilityOverlay> {

		public ResourceMap(String[] filenames,
				AsyncCallback<EntityResourceMap<UtilityOverlay>> callback) {
			super(filenames, callback);
		}
	}
	
	static public Map<String, Utility> remapUtility(Map<String, UtilityOverlay> overlayMap) {
		EntityExtractor<Utility, UtilityOverlay> extractor = new EntityExtractor<Utility, UtilityOverlay>() {
			public Utility getEntity(UtilityOverlay overlay) {
				return overlay.getUtility();
			}
		};
		return remapEntity(overlayMap, extractor);
	}
	
	final protected native JsBehaviorData getBehaviorData() /*-{
		return this.behavior;
	}-*/;
	
	final protected Behavior getBehavior() {
		return getBehaviorData().getBehavior();
	}

	final public String[] getEffectNames() {
		JsBehaviorData data = getBehaviorData();
		return new String[] {data.getPrimaryEffectName(), data.getSecondaryEffectName()};
	}

	final public String[] getTargetNames() {
		return new String[] { getBehaviorData().getTargetName() };
	}
	
	final public Utility getUtility() {
		return new Utility(getNameTag(), getPrice(), getStringSet(getEquippableBy()), getBehavior());
	}
}
