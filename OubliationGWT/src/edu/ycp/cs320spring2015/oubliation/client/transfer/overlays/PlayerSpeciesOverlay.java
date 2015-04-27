package edu.ycp.cs320spring2015.oubliation.client.transfer.overlays;

import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityExtractor;
import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityOverlay;
import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityResourceMap;
import edu.ycp.cs320spring2015.oubliation.client.transfer.JsBruceMap;
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
		EntityExtractor<PlayerSpecies, PlayerSpeciesOverlay> extractor = new EntityExtractor<PlayerSpecies, PlayerSpeciesOverlay>() {
			public PlayerSpecies getEntity(PlayerSpeciesOverlay overlay) {
				return overlay.getPlayerSpecies();
			}
		};
		return remapEntity(overlayMap, extractor);
	}
	
	protected final native JsBruceMap<Integer> getBaseScores() /*-{
		return this.baseScores;
	}-*/;
	
	final public PlayerSpecies getPlayerSpecies() {
		return new PlayerSpecies(getNameTag(), getBruceMap(getBaseScores()));
	}
}
