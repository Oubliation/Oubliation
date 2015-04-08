package edu.ycp.cs320spring2015.oubliation.client.transfer;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320spring2015.oubliation.shared.actor.player.BruceScore;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.PlayerJob;

public class PlayerJobOverlay extends EntityOverlay {
	protected PlayerJobOverlay() { }
	
	static final public class ResourceMap extends EntityResourceMap<PlayerJobOverlay> {

		public ResourceMap(String[] filenames,
				AsyncCallback<EntityResourceMap<PlayerJobOverlay>> callback) {
			super(filenames, callback);
		}
	}
	static public Map<String, PlayerJob> remapHeadwear(Map<String, PlayerJobOverlay> overlayMap) {
		HashMap<String, PlayerJob> entityMap = new HashMap<String, PlayerJob>();
		for (String key : overlayMap.keySet()) {
			entityMap.put(key, overlayMap.get(key).getPlayerJob());
		}
		return entityMap;
	}
	
	protected final native int getRequiredScore(String score) /*-{
		return this.requiredScores[scoreName];
	}-*/;
	
	private final EnumMap<BruceScore, Integer> getScoreMap() {
		EnumMap<BruceScore, Integer> requiredScores = new EnumMap<BruceScore, Integer>(BruceScore.class);
		for (BruceScore score : BruceScore.values()) {
			requiredScores.put(score, getRequiredScore(score.name()));
		}
		return requiredScores;
	}
	
	protected final native JsArrayNumber getExpChart() /*-{
		return this.expChart;
	}-*/;

	private final Integer[] getExpArray() {
		JsArrayNumber expChart = getExpChart();
		ArrayList<Integer> expList = new ArrayList<Integer>();
		for (int count=0; count < expChart.length(); count+=1) {
			expList.add((int) expChart.get(count));
		}
		return expList.toArray(new Integer[expList.size()]);
	}

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
	
	public PlayerJob getPlayerJob() {
		return new PlayerJob(getNameTag(), getScoreMap(), getExpArray(), getExtraLvExp(), getBaseHitCount(), getBaseMaxHp(), getMaxHpGain(), getUtilitySlotCount());
	}
}
