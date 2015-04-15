package edu.ycp.cs320spring2015.oubliation.client.transfer.overlays;

import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityExtractor;
import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityOverlay;
import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityResourceMap;
import edu.ycp.cs320spring2015.oubliation.client.transfer.JsBruceMap;
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
		EntityExtractor<PlayerBackground, PlayerBackgroundOverlay> extractor = new EntityExtractor<PlayerBackground, PlayerBackgroundOverlay>() {
			public PlayerBackground getEntity(PlayerBackgroundOverlay overlay) {
				return overlay.getPlayerBackground();
			}
		};
		return remapEntity(overlayMap, extractor);
	}
	
	static public native JsBruceMap<Double> getBruceGainRate() /*-{
		return this.bruceGainRate;
	}-*/;
	
	static public native String[] getJobBlacklist() /*-{
		return this.jobBlacklist;
	}-*/;
	
	static public native String getBackgroundRival() /*-{
		return this.backgroundRival;
	}-*/;
	
	public PlayerBackground getPlayerBackground() {
		return new PlayerBackground(getNameTag(), getBruceMap(getBruceGainRate()), getStringSet(getJobBlacklist()), getBackgroundRival());
	}
}
