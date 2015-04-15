package edu.ycp.cs320spring2015.oubliation.client.transfer.overlays;

import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityExtractor;
import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityResourceMap;
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
		EntityExtractor<Headwear, HeadwearOverlay> extractor = new EntityExtractor<Headwear, HeadwearOverlay>() {
			public Headwear getEntity(HeadwearOverlay overlay) {
				return overlay.getHeadwear();
			}
		};
		return remapEntity(overlayMap, extractor);
	}
	
	public Headwear getHeadwear() {
		return new Headwear(getNameTag(), getPrice(), getStringSet(getEquippableBy()), getAr());
	}
}
