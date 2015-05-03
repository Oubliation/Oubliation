package edu.ycp.cs320spring2015.oubliation.client.transfer.overlays;

import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityExtractor;
import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityOverlay;
import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityResourceMap;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.Background;

public class BackgroundOverlay extends EntityOverlay {
	protected BackgroundOverlay() { }
	
	static final public class ResourceMap extends EntityResourceMap<BackgroundOverlay> {

		public ResourceMap(String[] filenames,
				AsyncCallback<EntityResourceMap<BackgroundOverlay>> callback) {
			super(filenames, callback);
		}
	}
	
	static public Map<String, Background> remapBackgrounds(Map<String, BackgroundOverlay> overlayMap) {
		EntityExtractor<Background, BackgroundOverlay> extractor = new EntityExtractor<Background, BackgroundOverlay>() {
			public Background getEntity(BackgroundOverlay overlay) {
				return overlay.getBackground();
			}
		};
		return remapEntity(overlayMap, extractor);
	}
	
	final public Background getBackground() {
		return new Background(getNameTag());
	}
}
