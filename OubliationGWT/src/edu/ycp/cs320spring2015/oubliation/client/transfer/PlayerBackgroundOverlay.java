package edu.ycp.cs320spring2015.oubliation.client.transfer;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sun.javafx.geom.Vec2d;

import edu.ycp.cs320spring2015.oubliation.shared.category.identity.PlayerBackground;

public class PlayerBackgroundOverlay extends EntityOverlay {
	protected PlayerBackgroundOverlay() { }
	
	static final public class ResourceMap extends EntityResourceMap<PlayerBackgroundOverlay> {

		public ResourceMap(String[] filenames,
				AsyncCallback<EntityResourceMap<PlayerBackgroundOverlay>> callback) {
			super(filenames, callback);
		}
	}
	
	static public Map<String, PlayerBackground> remapBackground(Map<String, PlayerBackgroundOverlay> overlayMap) {
		HashMap<String, PlayerBackground> entityMap = new HashMap<String, PlayerBackground>();
		for (String key : overlayMap.keySet()) {
			entityMap.put(key, overlayMap.get(key).getPlayerBackground());
		}
		return entityMap;
	}
	
	public PlayerBackground getPlayerBackground() {
		return new PlayerBackground(getNameTag());
	}
}
