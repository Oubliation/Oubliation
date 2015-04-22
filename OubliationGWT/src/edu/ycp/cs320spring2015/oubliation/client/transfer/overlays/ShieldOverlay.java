package edu.ycp.cs320spring2015.oubliation.client.transfer.overlays;

import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityExtractor;
import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityResourceMap;
import edu.ycp.cs320spring2015.oubliation.shared.items.Shield;

public class ShieldOverlay extends EquipmentOverlay {

	protected ShieldOverlay() { }
	
	static final public class ResourceMap extends EntityResourceMap<ShieldOverlay> {

		public ResourceMap(String[] filenames,
				AsyncCallback<EntityResourceMap<ShieldOverlay>> callback) {
			super(filenames, callback);
		}
		
	}
	
	static public Map<String, Shield> remapShield(Map<String, ShieldOverlay> overlayMap) {
		EntityExtractor<Shield, ShieldOverlay> extractor = new EntityExtractor<Shield, ShieldOverlay>() {
			public Shield getEntity(ShieldOverlay overlay) {
				return overlay.getShield();
			}
		};
		return remapEntity(overlayMap, extractor);
	}
	
	public final Shield getShield() {
		return new Shield(getNameTag(), getPrice(), getStringSet(getEquippableBy()), getAr());
	}
}
