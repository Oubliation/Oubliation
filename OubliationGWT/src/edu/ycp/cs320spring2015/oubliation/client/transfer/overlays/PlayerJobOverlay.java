package edu.ycp.cs320spring2015.oubliation.client.transfer.overlays;

import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityExtractor;
import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityOverlay;
import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityResourceMap;
import edu.ycp.cs320spring2015.oubliation.client.transfer.JsBruceMap;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.PlayerJob;

public class PlayerJobOverlay extends EntityOverlay {
	protected PlayerJobOverlay() { }
	
	static final public class ResourceMap extends EntityResourceMap<PlayerJobOverlay> {

		public ResourceMap(String[] filenames,
				AsyncCallback<EntityResourceMap<PlayerJobOverlay>> callback) {
			super(filenames, callback);
		}
	}
	static public Map<String, PlayerJob> remapJobs(Map<String, PlayerJobOverlay> overlayMap) {
		EntityExtractor<PlayerJob, PlayerJobOverlay> extractor = new EntityExtractor<PlayerJob, PlayerJobOverlay>() {
			public PlayerJob getEntity(PlayerJobOverlay overlay) {
				return overlay.getPlayerJob();
			}
		};
		return remapEntity(overlayMap, extractor);
	}
	
	protected final native JsBruceMap<Integer> getRequiredScore() /*-{
		return this.requiredScores;
	}-*/;
	
	protected final native Integer[] getExpChart() /*-{
		return this.expChart;
	}-*/;

	protected final native int getExtraLvExp() /*-{
		return this.extraLvExp;
	}-*/;
	
	protected final native int getBaseHitCount() /*-{
		return this.baseHitCount;
	}-*/;
	
	protected final native int getBaseMaxHp() /*-{
		return this.baseMaxHp;
	}-*/;
	
	protected final native int getMaxHpGain() /*-{
		return this.maxHpGain;
	}-*/;
	
	protected final native int getUtilitySlotCount() /*-{
		return this.utilitySlotCount;
	}-*/;
	
	final public PlayerJob getPlayerJob() {
		return new PlayerJob(getNameTag(), getBruceMap(getRequiredScore()), getExpChart(), getExtraLvExp(),
				getBaseHitCount(), getBaseMaxHp(), getMaxHpGain(), getUtilitySlotCount());
	}
}
