package edu.ycp.cs320spring2015.oubliation.client.transfer.overlays;

import java.util.ArrayList;
import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityExtractor;
import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityOverlay;
import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityResourceMap;
import edu.ycp.cs320spring2015.oubliation.client.transfer.JsBruceMap;
import edu.ycp.cs320spring2015.oubliation.client.transfer.JsElementMap;
import edu.ycp.cs320spring2015.oubliation.shared.InventoryMapTuple;
import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;
import edu.ycp.cs320spring2015.oubliation.shared.actor.Loadout;
import edu.ycp.cs320spring2015.oubliation.shared.items.Headwear;
import edu.ycp.cs320spring2015.oubliation.shared.items.Shield;
import edu.ycp.cs320spring2015.oubliation.shared.items.Suit;
import edu.ycp.cs320spring2015.oubliation.shared.items.Utility;
import edu.ycp.cs320spring2015.oubliation.shared.items.Weapon;
import edu.ycp.cs320spring2015.oubliation.shared.statuses.Healthy;

public class ActorOverlay extends EntityOverlay {
	protected ActorOverlay() { }
	
	static final public class ResourceMap extends EntityResourceMap<ActorOverlay> {

		public ResourceMap(String[] filenames,
				AsyncCallback<EntityResourceMap<ActorOverlay>> callback) {
			super(filenames, callback);
		}
	}
	
//	static public Map<String, Actor> remapActors(Map<String, ActorOverlay> overlayMap, final LoadoutMapTuple loadoutMaps) {
//		EntityExtractor<Actor, ActorOverlay> extractor = new EntityExtractor<Actor, ActorOverlay>() {
//			public Actor getEntity(ActorOverlay overlay) {
//				return overlay.getActor(loadoutMaps);
//			}
//		};
//		return EntityOverlay.remapEntity(overlayMap, extractor);
//	}
	
	//can't implement statuses here
	
	final protected native String getHeadwearName() /*-{
		return this.headwear;
	}-*/;
	
	final protected Headwear getHeadwear(Map<String, Headwear> headwearMap) {
		return headwearMap.get(getHeadwearName());
	}
	
	final protected native String getSuitName() /*-{
		return this.suit;
	}-*/;
	
	final protected Suit getSuit(Map<String, Suit> suitMap) {
		return suitMap.get(getSuitName());
	}
	
	final protected native String getShieldName() /*-{
		return this.shield;
	}-*/;
	
	final protected Shield getShield(Map<String, Shield> shieldMap) {
		return shieldMap.get(getShieldName());
	}
	
	final protected native String[] getUtilityNames() /*-{
		return this.utilities;
	}-*/;
	
	final protected ArrayList<Utility> getUtilities(Map<String, Utility> utilityMap) {
		ArrayList<Utility> utilityBelt = new ArrayList<Utility>();
		for (String utilityName : getUtilityNames()) {
			utilityBelt.add(utilityMap.get(utilityName));
		}
		return utilityBelt;
	}
	
	final protected native Weapon getWeaponName() /*-{
		return this.weapon;
	}-*/;
	
	final protected Weapon getWeapon(Map<String, Weapon> weaponMap) {
		return weaponMap.get(getWeaponName());
	}
	
	final protected Loadout getLoadout(InventoryMapTuple loadoutMaps) {
		return new Loadout(getHeadwear(loadoutMaps.getHeadwearMap()), getSuit(loadoutMaps.getSuitMap()),
				getShield(loadoutMaps.getShieldMap()), getWeapon(loadoutMaps.getWeaponMap()), getUtilities(loadoutMaps.getUtilityMap()));
	}
	
	static public native JsElementMap<Double> getElementalMods() /*-{
		return this.bruceGainRate;
	}-*/;
	
//	final public Actor getActor(LoadoutMapTuple loadoutMaps) {
//		return new Actor(getNameTag(), Integer.MAX_VALUE, new Healthy(), getLoadout(loadoutMaps), getElementMap(getElementalMods()));
//	}
}
