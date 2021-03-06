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
import edu.ycp.cs320spring2015.oubliation.shared.items.Headwear;
import edu.ycp.cs320spring2015.oubliation.shared.items.Item;
import edu.ycp.cs320spring2015.oubliation.shared.items.Shield;
import edu.ycp.cs320spring2015.oubliation.shared.items.Suit;
import edu.ycp.cs320spring2015.oubliation.shared.items.Utility;
import edu.ycp.cs320spring2015.oubliation.shared.items.Weapon;
import edu.ycp.cs320spring2015.oubliation.shared.transfer.LoadoutLoader;
import edu.ycp.cs320spring2015.oubliation.shared.transfer.ProfileMemento;

public class ProfileLoader implements LoadoutLoader {
	
	private AsyncCallback<Void> callback;
	private ProfileMemento transfer;
	private Map<String, ItemOverlay> itemMap;
	private Map<String, HeadwearOverlay> headwearMap;
	private Map<String, SuitOverlay> suitMap;
	private Map<String, ShieldOverlay> shieldMap;
	private Map<String, UtilityOverlay> utilityMap;
	private Map<String, WeaponOverlay> weaponMap;
	
	protected ProfileLoader() {}
	
	public ProfileLoader(String usernameInput, final AsyncCallback<Profile> externalCallback) {
		final AsyncCallback<Void> callback = new AsyncCallback<Void>() {
			public void onSuccess(Void _) {
				if (transfer != null) {
					externalCallback.onSuccess(transfer.constructProfile(ProfileLoader.this));
				}
			}
			
			public void onFailure(Throwable caught) {
				externalCallback.onFailure(caught);
			}
		};
		
		AsyncCallback<ProfileMemento> transferCallback = new AsyncCallback<ProfileMemento>() {
			public void onSuccess(ProfileMemento transfer) {
				ProfileLoader.this.transfer = transfer;
				tryConstruction();
			}
			
			public void onFailure(Throwable caught) {
				callback.onFailure(caught);
			}
		};
		Oubliation.getDataKeeper().loadProfile(usernameInput, transferCallback);
		
		loadResources(callback);
	}
	
	protected void loadResources(final AsyncCallback<Void> callback) {
		this.callback = callback;
		
		AsyncCallback<EntityResourceMap<ItemOverlay>>
			itemMapCallback = new AsyncCallback<EntityResourceMap<ItemOverlay>>() {
				public void onSuccess(EntityResourceMap<ItemOverlay> entityMap) {
					ProfileLoader.this.itemMap = entityMap;
					tryConstruction();
				}
				
				public void onFailure(Throwable caught) {
					callback.onFailure(caught);
				}
		};
		AsyncCallback<EntityResourceMap<HeadwearOverlay>>
			headwearMapCallback = new AsyncCallback<EntityResourceMap<HeadwearOverlay>>() {
				public void onSuccess(EntityResourceMap<HeadwearOverlay> entityMap) {
					ProfileLoader.this.headwearMap = entityMap;
					tryConstruction();
				}
				
				public void onFailure(Throwable caught) {
					callback.onFailure(caught);
				}
		};
		AsyncCallback<EntityResourceMap<SuitOverlay>>
			suitMapCallback = new AsyncCallback<EntityResourceMap<SuitOverlay>>() {
				public void onSuccess(EntityResourceMap<SuitOverlay> entityMap) {
					ProfileLoader.this.suitMap = entityMap;
					tryConstruction();
				}
				
				public void onFailure(Throwable caught) {
					callback.onFailure(caught);
				}
		};
		AsyncCallback<EntityResourceMap<ShieldOverlay>>
			shieldMapCallback = new AsyncCallback<EntityResourceMap<ShieldOverlay>>() {
				public void onSuccess(EntityResourceMap<ShieldOverlay> entityMap) {
					ProfileLoader.this.shieldMap = entityMap;
					tryConstruction();
				}
				
				public void onFailure(Throwable caught) {
					callback.onFailure(caught);
				}
		};
		AsyncCallback<EntityResourceMap<UtilityOverlay>>
			utilityMapCallback = new AsyncCallback<EntityResourceMap<UtilityOverlay>>() {
				public void onSuccess(EntityResourceMap<UtilityOverlay> entityMap) {
					ProfileLoader.this.utilityMap = entityMap;
					tryConstruction();
				}
				
				public void onFailure(Throwable caught) {
					callback.onFailure(caught);
				}
		};
		AsyncCallback<EntityResourceMap<WeaponOverlay>>
		weaponMapCallback = new AsyncCallback<EntityResourceMap<WeaponOverlay>>() {
			public void onSuccess(EntityResourceMap<WeaponOverlay> entityMap) {
				ProfileLoader.this.weaponMap = entityMap;
				tryConstruction();
			}
			
			public void onFailure(Throwable caught) {
				callback.onFailure(caught);
			}
	};
	
		new ItemOverlay.ResourceMap(new String[] {"/data/items.json"}, itemMapCallback);
		new HeadwearOverlay.ResourceMap(new String[] {"/data/headwear.json"}, headwearMapCallback);
		new SuitOverlay.ResourceMap(new String[] {"/data/suits.json"}, suitMapCallback);
		new ShieldOverlay.ResourceMap(new String[] {"/data/shields.json"}, shieldMapCallback);
		new UtilityOverlay.ResourceMap(new String[] {"/data/utilities.json"}, utilityMapCallback);
		new WeaponOverlay.ResourceMap(new String[] {"/data/weapons.json"}, weaponMapCallback);
	}
	
	protected void tryConstruction() {
		if (headwearMap != null && suitMap != null && utilityMap != null && weaponMap != null) { //reflectionMaps means utilityMap & weaponMap are loaded
			callback.onSuccess(null);
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
		return UtilityOverlay.remapUtility(utilityMap);
	}
	@Override
	public Map<String, Weapon> getWeaponMap() {
		return WeaponOverlay.remapWeapon(weaponMap);
	}
}
