package edu.ycp.cs320spring2015.oubliation.client.transfer.overlays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityExtractor;
import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityOverlay;
import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityResourceMap;
import edu.ycp.cs320spring2015.oubliation.client.transfer.JsBehaviorData;
import edu.ycp.cs320spring2015.oubliation.client.transfer.JsElementMap;
import edu.ycp.cs320spring2015.oubliation.shared.IdentityMapTuple;
import edu.ycp.cs320spring2015.oubliation.shared.InventoryMapTuple;
import edu.ycp.cs320spring2015.oubliation.shared.actor.Loadout;
import edu.ycp.cs320spring2015.oubliation.shared.actor.nonplayer.NonPlayerActor;
import edu.ycp.cs320spring2015.oubliation.shared.actor.nonplayer.NonPlayerIdentity;
import edu.ycp.cs320spring2015.oubliation.shared.actor.nonplayer.NonPlayerStats;
import edu.ycp.cs320spring2015.oubliation.shared.behavior.Behavior;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.Background;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.Job;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.Species;
import edu.ycp.cs320spring2015.oubliation.shared.items.Headwear;
import edu.ycp.cs320spring2015.oubliation.shared.items.Shield;
import edu.ycp.cs320spring2015.oubliation.shared.items.Suit;
import edu.ycp.cs320spring2015.oubliation.shared.items.Utility;
import edu.ycp.cs320spring2015.oubliation.shared.items.Weapon;
import edu.ycp.cs320spring2015.oubliation.shared.statuses.Healthy;

public class NonPlayerActorOverlay extends ActorOverlay {
	protected NonPlayerActorOverlay() { }
	
//	static final public class ResourceMap extends EntityResourceMap<NonPlayerActorOverlay> {
//
//		public ResourceMap(String[] filenames,
//				AsyncCallback<EntityResourceMap<ActorOverlay>> callback) {
//			super(filenames, callback);
//		}
//	}
//	
//	static public Map<String, NonPlayerActor> remapActors(Map<String, NonPlayerActorOverlay> overlayMap, final InventoryMapTuple invMaps, final IdentityMapTuple identityMaps) {
//		EntityExtractor<NonPlayerActor, NonPlayerActorOverlay> extractor = new EntityExtractor<NonPlayerActor, NonPlayerActorOverlay>() {
//			public NonPlayerActor getEntity(NonPlayerActorOverlay overlay) {
//				return overlay.getNonPlayerActor(invMaps, identityMaps);
//			}
//		};
//		return EntityOverlay.remapEntity(overlayMap, extractor);
//	}
	
	final protected native String getBackgroundName() /*-{
		return this.background;
	}-*/;
	final protected Background getBackground(Map<String, Background> backgroundMap) {
		return backgroundMap.get(getBackgroundName());
	}
	
	final protected native String getSpeciesName() /*-{
		return this.species;
	}-*/;
	final protected Species getSpecies(Map<String, Species> speciesMap) {
		return speciesMap.get(getSpeciesName());
	}
	
	final protected native String getJobName() /*-{
		return this.job;
	}-*/;
	final protected Job getJob(Map<String, Job> jobMap) {
		return jobMap.get(getJobName());
	}
	
	final protected NonPlayerIdentity getIdentity(IdentityMapTuple identityMaps) {
		return new NonPlayerIdentity(getBackground(identityMaps.getBackgroundMap()), getSpecies(identityMaps.getSpeciesMap()), getJob(identityMaps.getJobMap()));
	}
	
	final protected native int getMaxHp() /*-{
		return this.maxHp;
	}-*/;
	final protected native int getHitCount() /*-{
	return this.hitCount;
}-*/;
	final protected native int getInitiativeMin() /*-{
		return this.initiativeMin;
	}-*/;
	final protected native int getInitiativeRange() /*-{
		return this.initiativeRange;
	}-*/;
	final protected native int getAttackMod() /*-{
		return this.attackMod;
	}-*/;
	final protected native int getAccuracyMod() /*-{
		return this.accuracyMod;
	}-*/;
	final protected native int getEvasion() /*-{
		return this.evasion;
	}-*/;
	final protected native JsBehaviorData[] getBehaviorData() /*-{
		return this.behavior;
	}-*/;
	
	final protected Behavior[] getBehaviors() {
		JsBehaviorData[] data = getBehaviorData();
		LinkedList<Behavior> value = new LinkedList<Behavior>();
		for (JsBehaviorData spec : data) {
			value.add(spec.getBattleBehavior());
		}
		return value.toArray(new Behavior[value.size()]);
	}

	final public String[] getEffectNames() {
		JsBehaviorData[] data = getBehaviorData();
		LinkedList<String> value = new LinkedList<String>();
		for (JsBehaviorData spec : data) {
			value.add(spec.getPrimaryEffectName());
			value.add(spec.getSecondaryEffectName());
		}
		return value.toArray(new String[value.size()]);
	}

	final public String[] getTargetNames() {
		JsBehaviorData[] data = getBehaviorData();
		LinkedList<String> value = new LinkedList<String>();
		for (JsBehaviorData spec : data) {
			value.add(spec.getTargetName());
		}
		return value.toArray(new String[value.size()]);
	}
	
	final protected NonPlayerStats getStats() {
		return new NonPlayerStats(getMaxHp(), getHitCount(), getInitiativeMin(), getInitiativeRange(), getAttackMod(), getAccuracyMod(), getEvasion(), getBehaviors());
	}
	
//	final public NonPlayerActor getNonPlayerActor(InventoryMapTuple invMaps, IdentityMapTuple identityMaps) {
//		return new NonPlayerActor(getNameTag(), new Healthy(), getLoadout(invMaps), getElementMap(getElementalMods()), getIdentity(identityMaps), getStats());
//	}
}
