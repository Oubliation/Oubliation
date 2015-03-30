package edu.ycp.cs320spring2015.oubliation.client.transfer;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320spring2015.oubliation.shared.effect.Headwear;

final public class HeadwearOverlay extends EquipmentOverlay<Headwear> {
	protected HeadwearOverlay() { }
	
	final public class ResourceMap extends EntityResourceMap<Headwear, HeadwearOverlay> {

		ResourceMap(String[] filenames,
				AsyncCallback<EntityResourceMap<Headwear, HeadwearOverlay>> callback) {
			super(filenames, callback);
		}
		
	}
	
	public Headwear getData() {
		
		return new Headwear(getNameTag(), getPrice(), getJobSet(), getAr());
	}
}
