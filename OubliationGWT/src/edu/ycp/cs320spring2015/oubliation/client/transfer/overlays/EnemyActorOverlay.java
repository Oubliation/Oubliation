package edu.ycp.cs320spring2015.oubliation.client.transfer.overlays;

import java.util.ArrayList;
import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityExtractor;
import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityOverlay;
import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityResourceMap;
import edu.ycp.cs320spring2015.oubliation.client.transfer.JsInventoryData;
import edu.ycp.cs320spring2015.oubliation.shared.Inventory;
import edu.ycp.cs320spring2015.oubliation.shared.InventoryMapTuple;
import edu.ycp.cs320spring2015.oubliation.shared.actor.nonplayer.EnemyActor;
import edu.ycp.cs320spring2015.oubliation.shared.actor.nonplayer.EnemySpoils;
import edu.ycp.cs320spring2015.oubliation.shared.items.Headwear;
import edu.ycp.cs320spring2015.oubliation.shared.items.Item;
import edu.ycp.cs320spring2015.oubliation.shared.items.Shield;
import edu.ycp.cs320spring2015.oubliation.shared.items.Suit;
import edu.ycp.cs320spring2015.oubliation.shared.items.Utility;
import edu.ycp.cs320spring2015.oubliation.shared.items.Weapon;
import edu.ycp.cs320spring2015.oubliation.shared.statuses.Healthy;

public class EnemyActorOverlay extends NonPlayerActorOverlay {
	protected EnemyActorOverlay() {}
	
	static final public class ResourceMap extends EntityResourceMap<EnemyActorOverlay> {

		public ResourceMap(String[] filenames,
				AsyncCallback<EntityResourceMap<EnemyActorOverlay>> callback) {
			super(filenames, callback);
		}
	}
	
	static public Map<String, EnemyActor> remapEnemyActors(Map<String, EnemyActorOverlay> overlayMap, final InventoryMapTuple invMaps) {
		EntityExtractor<EnemyActor, EnemyActorOverlay> extractor = new EntityExtractor<EnemyActor, EnemyActorOverlay>() {
			public EnemyActor getEntity(EnemyActorOverlay overlay) {
				return overlay.getEnemyActor(invMaps);
			}
		};
		return EntityOverlay.remapEntity(overlayMap, extractor);
	}
	
	final protected native int getExpGiven() /*-{
		return this.expGiven;
	}-*/;
	final protected native int getMoneyGiven() /*-{
		return this.moneyGiven;
	}-*/;
	final protected native JsInventoryData getItemGivenNames() /*-{
		return this.itemsGiven;
	}-*/;
	final protected Inventory getItemsGiven(InventoryMapTuple invMaps) {
		JsInventoryData data = getItemGivenNames();
		
		ArrayList<Item> itemInv = new ArrayList<Item>();
		ArrayList<Headwear> headwearInv = new ArrayList<Headwear>();
		ArrayList<Suit> suitInv = new ArrayList<Suit>();
		ArrayList<Shield> shieldInv = new ArrayList<Shield>();
		ArrayList<Utility> utilityInv = new ArrayList<Utility>();
		ArrayList<Weapon> weaponInv = new ArrayList<Weapon>();
		
		if (invMaps.getItemMap() != null) {
			for (String name : data.getItems()) {
				itemInv.add(invMaps.getItemMap().get(name));
			}
		}
		if (invMaps.getHeadwearMap() != null) {
			for (String name : data.getHeadwear()) {
				headwearInv.add(invMaps.getHeadwearMap().get(name));
			}
		} 
		if (invMaps.getSuitMap() != null) {
			for (String name : data.getSuits()) {
				suitInv.add(invMaps.getSuitMap().get(name));
			}
		}
		if (invMaps.getShieldMap() != null) {
			for (String name : data.getShields()) {
				shieldInv.add(invMaps.getShieldMap().get(name));
			}
		}
		if (invMaps.getUtilityMap() != null) {
			for (String name : data.getUtilities()) {
				utilityInv.add(invMaps.getUtilityMap().get(name));
			}
		}
		if (invMaps.getWeaponMap() != null) {
			for (String name : data.getWeapons()) {
				weaponInv.add(invMaps.getWeaponMap().get(name));
			}
		}
		
		return new Inventory(itemInv, headwearInv, suitInv, shieldInv, utilityInv, weaponInv);
	}
	
	final protected EnemySpoils getEnemySpoils(InventoryMapTuple invMaps) {
		return new EnemySpoils(getExpGiven(), getMoneyGiven(), getItemsGiven(invMaps));
	}
	
	final public EnemyActor getEnemyActor(InventoryMapTuple invMaps) {
		return new EnemyActor(getNameTag(), new Healthy(), getElementMap(getElementalMods()), getStats(), getEnemySpoils(invMaps));
	}
}
