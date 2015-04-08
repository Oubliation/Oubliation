package edu.ycp.cs320spring2015.oubliation.client.transfer;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320spring2015.oubliation.shared.category.identity.Species;

public class SpeciesOverlay extends EntityOverlay {
	protected SpeciesOverlay() { }
	
	static final public class ResourceMap extends EntityResourceMap<SpeciesOverlay> {

		public ResourceMap(String[] filenames,
				AsyncCallback<EntityResourceMap<SpeciesOverlay>> callback) {
			super(filenames, callback);
		}
	}
	
	static public Map<String, Species> remapSpecies(Map<String, SpeciesOverlay> overlayMap) {
		HashMap<String, Species> entityMap = new HashMap<String, Species>();
		for (String key : overlayMap.keySet()) {
			entityMap.put(key, overlayMap.get(key).getSpecies());
		}
		return entityMap;
	}
	
	public Species getSpecies() {
		return new Species(getNameTag());
	}
}
