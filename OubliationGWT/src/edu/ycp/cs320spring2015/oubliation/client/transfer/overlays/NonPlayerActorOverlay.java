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
import edu.ycp.cs320spring2015.oubliation.shared.InventoryMapTuple;
import edu.ycp.cs320spring2015.oubliation.shared.actor.nonplayer.NonPlayerActor;
import edu.ycp.cs320spring2015.oubliation.shared.actor.nonplayer.NonPlayerStats;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.Loadout;
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
	final protected native int getArmorRank() /*-{
	return this.armorRank;
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
		return new NonPlayerStats(getMaxHp(), getHitCount(), getInitiativeMin(), getInitiativeRange(), getAttackMod(), getAccuracyMod(), getArmorRank(), getEvasion(), getBehaviors());
	}
	
//	final public NonPlayerActor getNonPlayerActor(InventoryMapTuple invMaps, IdentityMapTuple identityMaps) {
//		return new NonPlayerActor(getNameTag(), new Healthy(), getLoadout(invMaps), getElementMap(getElementalMods()), getStats());
//	}
}
