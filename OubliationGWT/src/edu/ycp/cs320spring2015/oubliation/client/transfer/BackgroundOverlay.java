package edu.ycp.cs320spring2015.oubliation.client.transfer;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320spring2015.oubliation.shared.category.identity.Background;

public class BackgroundOverlay extends EntityOverlay {
	protected BackgroundOverlay() { }
	
	static final public class ResourceMap extends EntityResourceMap<BackgroundOverlay> {

		public ResourceMap(String[] filenames,
				AsyncCallback<EntityResourceMap<BackgroundOverlay>> callback) {
			super(filenames, callback);
		}
	}
	
	static public Map<String, Background> remapBackground(Map<String, BackgroundOverlay> overlayMap) {
		HashMap<String, Background> entityMap = new HashMap<String, Background>();
		for (String key : overlayMap.keySet()) {
			entityMap.put(key, overlayMap.get(key).getBackground());
		}
		return entityMap;
	}
	
	public Background getBackground() {
		return new Background(getNameTag());
	}
}
