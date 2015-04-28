package edu.ycp.cs320spring2015.oubliation.client.transfer.overlays;

import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityExtractor;
import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityOverlay;
import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityResourceMap;
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
		EntityExtractor<Species, SpeciesOverlay> extractor = new EntityExtractor<Species, SpeciesOverlay>() {
			public Species getEntity(SpeciesOverlay overlay) {
				return overlay.getSpecies();
			}
		};
		return EntityOverlay.remapEntity(overlayMap, extractor);
	}
	
	final public Species getSpecies() {
		return new Species(getNameTag());
	}
}
