package edu.ycp.cs320spring2015.oubliation.client.transfer;

import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320spring2015.oubliation.client.Oubliation;
import edu.ycp.cs320spring2015.oubliation.client.transfer.overlays.HeadwearOverlay;
import edu.ycp.cs320spring2015.oubliation.client.transfer.overlays.ItemOverlay;
import edu.ycp.cs320spring2015.oubliation.client.transfer.overlays.ShieldOverlay;
import edu.ycp.cs320spring2015.oubliation.client.transfer.overlays.SuitOverlay;
import edu.ycp.cs320spring2015.oubliation.client.transfer.overlays.UtilityOverlay;
import edu.ycp.cs320spring2015.oubliation.client.transfer.overlays.WeaponOverlay;
import edu.ycp.cs320spring2015.oubliation.shared.Profile;
import edu.ycp.cs320spring2015.oubliation.shared.items.Effect;
import edu.ycp.cs320spring2015.oubliation.shared.items.Headwear;
import edu.ycp.cs320spring2015.oubliation.shared.items.Item;
import edu.ycp.cs320spring2015.oubliation.shared.items.Shield;
import edu.ycp.cs320spring2015.oubliation.shared.items.Suit;
import edu.ycp.cs320spring2015.oubliation.shared.items.Utility;
import edu.ycp.cs320spring2015.oubliation.shared.items.Weapon;
import edu.ycp.cs320spring2015.oubliation.shared.transfer.LoadoutLoader;
import edu.ycp.cs320spring2015.oubliation.shared.transfer.ProfileMemento;

public class ProfileLoader implements LoadoutLoader {
	
	private ProfileMemento transfer;
	private Map<String, ItemOverlay> itemMap;
	private Map<String, HeadwearOverlay> headwearMap;
	private Map<String, SuitOverlay> suitMap;
	private Map<String, ShieldOverlay> shieldMap;
	private Map<String, Effect> effectMap;
	private Map<String, UtilityOverlay> utilityMap;
	private Map<String, WeaponOverlay> weaponMap;
	
	public ProfileLoader(String usernameInput, final AsyncCallback<Profile> callback) {
		
		AsyncCallback<ProfileMemento> transferCallback = new AsyncCallback<ProfileMemento>() {
			public void onSuccess(ProfileMemento transfer) {
				ProfileLoader.this.transfer = transfer;
				tryBoot(callback);
			}
			
			public void onFailure(Throwable caught) {
				callback.onFailure(caught);
			}
		};
		AsyncCallback<EntityResourceMap<ItemOverlay>>
			itemMapCallback = new AsyncCallback<EntityResourceMap<ItemOverlay>>() {
				public void onSuccess(EntityResourceMap<ItemOverlay> entityMap) {
					ProfileLoader.this.itemMap = entityMap;
					tryBoot(callback);
				}
				
				public void onFailure(Throwable caught) {
					callback.onFailure(caught);
				}
		};
		AsyncCallback<EntityResourceMap<HeadwearOverlay>>
			headwearMapCallback = new AsyncCallback<EntityResourceMap<HeadwearOverlay>>() {
				public void onSuccess(EntityResourceMap<HeadwearOverlay> entityMap) {
					ProfileLoader.this.headwearMap = entityMap;
					tryBoot(callback);
				}
				
				public void onFailure(Throwable caught) {
					callback.onFailure(caught);
				}
		};
		AsyncCallback<EntityResourceMap<SuitOverlay>>
			suitMapCallback = new AsyncCallback<EntityResourceMap<SuitOverlay>>() {
				public void onSuccess(EntityResourceMap<SuitOverlay> entityMap) {
					ProfileLoader.this.suitMap = entityMap;
					tryBoot(callback);
				}
				
				public void onFailure(Throwable caught) {
					callback.onFailure(caught);
				}
		};
		AsyncCallback<EntityResourceMap<ShieldOverlay>>
			shieldMapCallback = new AsyncCallback<EntityResourceMap<ShieldOverlay>>() {
				public void onSuccess(EntityResourceMap<ShieldOverlay> entityMap) {
					ProfileLoader.this.shieldMap = entityMap;
					tryBoot(callback);
				}
				
				public void onFailure(Throwable caught) {
					callback.onFailure(caught);
				}
		};
		AsyncCallback<Map<String, Effect>> effectCallback = new AsyncCallback<Map<String, Effect>>() {
			public void onSuccess(Map<String, Effect> effectMap) {
				ProfileLoader.this.effectMap = effectMap;
				tryBoot(callback);
			}
			
			public void onFailure(Throwable caught) {
				callback.onFailure(caught);
			}
		};
		AsyncCallback<EntityResourceMap<UtilityOverlay>>
			utilityMapCallback = new AsyncCallback<EntityResourceMap<UtilityOverlay>>() {
				public void onSuccess(EntityResourceMap<UtilityOverlay> entityMap) {
					ProfileLoader.this.utilityMap = entityMap;
					tryBoot(callback);
				}
				
				public void onFailure(Throwable caught) {
					callback.onFailure(caught);
				}
		};
		AsyncCallback<EntityResourceMap<WeaponOverlay>>
		weaponMapCallback = new AsyncCallback<EntityResourceMap<WeaponOverlay>>() {
			public void onSuccess(EntityResourceMap<WeaponOverlay> entityMap) {
				ProfileLoader.this.weaponMap = entityMap;
				tryBoot(callback);
			}
			
			public void onFailure(Throwable caught) {
				callback.onFailure(caught);
			}
	};
		Oubliation.getDataKeeper().loadProfile(usernameInput, transferCallback);
		new ItemOverlay.ResourceMap(new String[] {"/data/items.json"}, itemMapCallback);
		new HeadwearOverlay.ResourceMap(new String[] {"/data/headwear.json"}, headwearMapCallback);
		new SuitOverlay.ResourceMap(new String[] {"/data/suits.json"}, suitMapCallback);
		new ShieldOverlay.ResourceMap(new String[] {"/data/shields.json"}, shieldMapCallback);
		Oubliation.getDataKeeper().getEffectMap(new String[] {}, effectCallback);
		new UtilityOverlay.ResourceMap(new String[] {"/data/utilities.json"}, utilityMapCallback);
		new WeaponOverlay.ResourceMap(new String[] {"/data/weapons.json"}, weaponMapCallback);
	}
	
	private void tryBoot(AsyncCallback<Profile> callback) {
		if (transfer != null && headwearMap != null && suitMap != null && utilityMap != null && weaponMap != null) {
			callback.onSuccess(transfer.constructProfile(this));
		}
	}
	
	@Override
	public Map<String, Item> getItemMap() {
		return ItemOverlay.remapItems(itemMap);
	}
	@Override
	public Map<String, Headwear> getHeadwearMap() {
		return HeadwearOverlay.remapHeadwear(headwearMap);
	}
	@Override
	public Map<String, Suit> getSuitMap() {
		return SuitOverlay.remapSuit(suitMap);
	}
	@Override
	public Map<String, Shield> getShieldMap() {
		return ShieldOverlay.remapShield(shieldMap);
	}
	@Override
	public Map<String, Utility> getUtilityMap() {
		return UtilityOverlay.remapUtility(utilityMap, effectMap);
	}
	@Override
	public Map<String, Weapon> getWeaponMap() {
		return WeaponOverlay.remapWeapon(weaponMap, effectMap);
	}
}
