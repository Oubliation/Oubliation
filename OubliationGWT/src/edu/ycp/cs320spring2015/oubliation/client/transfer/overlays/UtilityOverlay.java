package edu.ycp.cs320spring2015.oubliation.client.transfer.overlays;

import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityExtractor;
import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityResourceMap;
import edu.ycp.cs320spring2015.oubliation.shared.BehaviorOrder;
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
	
	static public Map<String, Utility> remapUtility(Map<String, UtilityOverlay> overlayMap, final Map<String, Behavior> behaviorMap) {
		EntityExtractor<Utility, UtilityOverlay> extractor = new EntityExtractor<Utility, UtilityOverlay>() {
			public Utility getEntity(UtilityOverlay overlay) {
				return overlay.getUtility(behaviorMap);
			}
		};
		return remapEntity(overlayMap, extractor);
	}

	final protected native String getEffectName() /*-{
		return this.effect;
	}-*/;

	final protected native String getTargetName() /*-{
		return this.target;
	}-*/;

	final protected native int getPower() /*-{
		return this.power;
	}-*/;

	final protected native int getAccuracy() /*-{
		return this.accuracy;
	}-*/;

	final protected native String getElementName() /*-{
		return this.element;
	}-*/;

	final protected native String getStatusName() /*-{
		return this.status;
	}-*/;

	final protected native int getPotency() /*-{
		return this.potency;
	}-*/;
	
	final public BehaviorOrder getBehaviorOrder() {
		return new BehaviorOrder(getName(), getEffectName(), getTargetName(), getPower(), getAccuracy(), getElementName(), getStatusName(), getPotency());
	}
	
	final public Utility getUtility(Map<String, Behavior> behaviorMap) {
		return new Utility(getNameTag(), getPrice(), getStringSet(getEquippableBy()), behaviorMap.get(getName()));
	}
}
