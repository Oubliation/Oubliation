package edu.ycp.cs320spring2015.oubliation.client.transfer.overlays;

import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityExtractor;
import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityResourceMap;
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
		EntityExtractor<Suit, SuitOverlay> extractor = new EntityExtractor<Suit, SuitOverlay>() {
			public Suit getEntity(SuitOverlay overlay) {
				return overlay.getSuit();
			}
		};
		return remapEntity(overlayMap, extractor);
	}
	
	public Suit getSuit() {
		return new Suit(getNameTag(), getPrice(), getStringSet(getEquippableBy()), getAr());
	}
}
