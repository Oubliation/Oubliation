package edu.ycp.cs320spring2015.oubliation.client.transfer.overlays;

import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityExtractor;
import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityOverlay;
import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityResourceMap;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.Job;
import edu.ycp.cs320spring2015.oubliation.shared.location.Floor;
import edu.ycp.cs320spring2015.oubliation.shared.location.Tile;

public class FloorOverlay extends EntityOverlay {
	protected FloorOverlay() { }
	
	static final public class ResourceMap extends EntityResourceMap<FloorOverlay> {

		public ResourceMap(String[] filenames,
				AsyncCallback<EntityResourceMap<FloorOverlay>> callback) {
			super(filenames, callback);
		}
	}
	
	static public Map<String, Floor> remapMap(Map<String, FloorOverlay> overlayMap) {
		EntityExtractor<Floor, FloorOverlay> extractor = new EntityExtractor<Floor, FloorOverlay>() {
			public Floor getEntity(FloorOverlay overlay) {
				return overlay.getMap();
			}
		};
		return EntityOverlay.remapEntity(overlayMap, extractor);
	}
	
	private final native Tile[][] getTiles() /*-{
		return this;
	}-*/;
	
	final public Floor getMap() {
		return new Floor(getNameTag(), getTiles());
	}
}
