package edu.ycp.cs320spring2015.oubliation.client.transfer.overlays;

import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityExtractor;
import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityOverlay;
import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityResourceMap;
import edu.ycp.cs320spring2015.oubliation.shared.location.Door;
import edu.ycp.cs320spring2015.oubliation.shared.location.EmptyTile;
import edu.ycp.cs320spring2015.oubliation.shared.location.Floor;
import edu.ycp.cs320spring2015.oubliation.shared.location.Tile;
import edu.ycp.cs320spring2015.oubliation.shared.location.ToOutskirts;
import edu.ycp.cs320spring2015.oubliation.shared.location.Wall;

public class FloorOverlay extends EntityOverlay {
	protected FloorOverlay() { }
	
	static final public class ResourceMap extends EntityResourceMap<FloorOverlay> {

		public ResourceMap(String[] filenames,
				AsyncCallback<EntityResourceMap<FloorOverlay>> callback) {
			super(filenames, callback);
		}
	}
	
	static public Map<String, Floor> remapFloors(Map<String, FloorOverlay> overlayMap) {
		EntityExtractor<Floor, FloorOverlay> extractor = new EntityExtractor<Floor, FloorOverlay>() {
			public Floor getEntity(FloorOverlay overlay) {
				return overlay.getMap();
			}
		};
		return EntityOverlay.remapEntity(overlayMap, extractor);
	}
	
	private final native String[] getRows() /*-{
		return this.data;
	}-*/;
	
	private final Tile[][] getTiles() {
		String[] textTiles = getRows();
		Tile[][] tileTiles = new Tile[textTiles.length][];
		for (int row=0; row<textTiles.length; row+=1) {
			tileTiles[row] = new Tile[textTiles[row].length()];
			for (int col=0; col<textTiles[row].length(); col+=1) {
				switch (textTiles[row].charAt(col)) {
				case  'W' :
					tileTiles[row][col] = new Wall();
					break;
				case  'H' :
					tileTiles[row][col] = new ToOutskirts();
					break;
				case '+' :
					tileTiles[row][col] = new Door();
					break;
				case 't' :
				case 'l' :	
				case 'A' :
				case 'D' :
				case 'T' :
				case '~' :
				case 'f' :
				case 'F' :
				case '#' :
				case '%' :
				case '9' :
				case '6' :
				case 'B' :
				case '&' :
				case '7' :
				case 'L' :
					tileTiles[row][col] = new EmptyTile();
					break;
				case ' ' :
					tileTiles[row][col] = new EmptyTile();
					break;
				default:
					throw new IllegalStateException();
				
				}
			}
		}
		return tileTiles;
	}
	
	final public Floor getMap() {
		return new Floor(getNameTag(), getTiles());
	}
}
