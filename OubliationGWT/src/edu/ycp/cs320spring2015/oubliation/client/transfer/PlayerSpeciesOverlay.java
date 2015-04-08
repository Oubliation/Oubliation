package edu.ycp.cs320spring2015.oubliation.client.transfer;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320spring2015.oubliation.shared.category.identity.PlayerSpecies;

public class PlayerSpeciesOverlay extends EntityOverlay {
	protected PlayerSpeciesOverlay() { }
	
	static final public class ResourceMap extends EntityResourceMap<PlayerSpeciesOverlay> {

		public ResourceMap(String[] filenames,
				AsyncCallback<EntityResourceMap<PlayerSpeciesOverlay>> callback) {
			super(filenames, callback);
		}
	}
	
	static public Map<String, PlayerSpecies> remapSpecies(Map<String, PlayerSpeciesOverlay> overlayMap) {
		HashMap<String, PlayerSpecies> entityMap = new HashMap<String, PlayerSpecies>();
		for (String key : overlayMap.keySet()) {
			entityMap.put(key, overlayMap.get(key).getPlayerSpecies());
		}
		return entityMap;
	}
	
	public PlayerSpecies getPlayerSpecies() {
		return new PlayerSpecies(getNameTag());
	}
}
