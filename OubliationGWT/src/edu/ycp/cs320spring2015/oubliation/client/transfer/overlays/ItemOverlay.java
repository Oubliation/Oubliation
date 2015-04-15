package edu.ycp.cs320spring2015.oubliation.client.transfer.overlays;

import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityExtractor;
import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityOverlay;
import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityResourceMap;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Item;

public class ItemOverlay extends EntityOverlay {
	protected ItemOverlay() {}
	
	static final public class ResourceMap extends EntityResourceMap<ItemOverlay> {

		public ResourceMap(String[] filenames,
				AsyncCallback<EntityResourceMap<ItemOverlay>> callback) {
			super(filenames, callback);
		}
	}
	
	static public Map<String, Item> remapItems(Map<String, ItemOverlay> overlayMap) {
		EntityExtractor<Item, ItemOverlay> extractor = new EntityExtractor<Item, ItemOverlay>() {
			public Item getEntity(ItemOverlay overlay) {
				return overlay.getItem();
			}
		};
		return remapEntity(overlayMap, extractor);
	}
	
	protected final native int getPrice() /*-{
		return this.price;
	}-*/;
	
	public final Item getItem() {
		return new Item(getNameTag(), getPrice());
	}
}
