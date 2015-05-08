package edu.ycp.cs320spring2015.oubliation.client.transfer;

import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320spring2015.oubliation.client.transfer.overlays.EnemyActorOverlay;
import edu.ycp.cs320spring2015.oubliation.client.transfer.overlays.FloorOverlay;
import edu.ycp.cs320spring2015.oubliation.shared.InventoryMapTuple;
import edu.ycp.cs320spring2015.oubliation.shared.actor.nonplayer.EnemyActor;
import edu.ycp.cs320spring2015.oubliation.shared.location.Floor;


public class DungeonResourceLoader extends ProfileLoader {
	private InventoryMapTuple invMaps;
	private Map<String, EnemyActorOverlay> enemyMap;
	private Map<String, FloorOverlay> floorMap;

	public DungeonResourceLoader(final AsyncCallback<DungeonResourceLoader> externalCallback) {
		super();
		
		loadResources(new AsyncCallback<Void>() {
			public void onSuccess(Void _) {
				if (enemyMap != null && floorMap != null) {
					invMaps = new InventoryMapTuple(getItemMap(), getHeadwearMap(), getSuitMap(), getShieldMap(), getUtilityMap(), getWeaponMap());
					externalCallback.onSuccess(DungeonResourceLoader.this);
				}
			}
			
			public void onFailure(Throwable caught) {
				externalCallback.onFailure(caught);
			}
		});
		
		AsyncCallback<EntityResourceMap<FloorOverlay>> floorCallback = new AsyncCallback<EntityResourceMap<FloorOverlay>>() {
			public void onSuccess(EntityResourceMap<FloorOverlay> data) {
				floorMap = data;
				tryConstruction();
				

			}
			
			public void onFailure(Throwable caught) {
				externalCallback.onFailure(caught);

			}
		};		
		AsyncCallback<EntityResourceMap<EnemyActorOverlay>> enemyCallback = new AsyncCallback<EntityResourceMap<EnemyActorOverlay>>() {
			public void onSuccess(EntityResourceMap<EnemyActorOverlay> data) {
				enemyMap = data;
				tryConstruction();
			}
			
			public void onFailure(Throwable caught) {
				externalCallback.onFailure(caught);
			}
		};		
		
		new FloorOverlay.ResourceMap(new String[] {"/data/dungeon.json"}, floorCallback);
		new EnemyActorOverlay.ResourceMap(new String[] {"/data/enemies.json"}, enemyCallback);
	}
	
	public Map<String, EnemyActor> getEnemyMap() {
		return EnemyActorOverlay.remapEnemyActors(enemyMap, invMaps);
	}
	
	public Map<String, Floor> getFloorMap() {
		return FloorOverlay.remapFloors(floorMap);
	}

}
