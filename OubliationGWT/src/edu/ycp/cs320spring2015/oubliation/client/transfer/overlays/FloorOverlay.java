package edu.ycp.cs320spring2015.oubliation.client.transfer.overlays;

import java.util.Map;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityExtractor;
import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityOverlay;
import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityResourceMap;
import edu.ycp.cs320spring2015.oubliation.shared.location.Floor;
import edu.ycp.cs320spring2015.oubliation.shared.location.Tile;

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
				tileTiles[row][col] = new Tile();
				switch (textTiles[row].charAt(col)) {
				case  'W' :
					tileTiles[row][col].setIsSolid(true);
					break;
				case  'H' :
					tileTiles[row][col].setIsToOutskirts(true);
					break;
				case '+' :
					tileTiles[row][col].setIsDoor(true);
					tileTiles[row][col].setIsSolid(true);
					tileTiles[row][col].setIsLocked(true);
					break;
				case 't' :
					tileTiles[row][col].setIsTrap(true);
					break;
				case 'l' :	
					tileTiles[row][col].setIsLever(true);
					break;
				case 'A' :
					tileTiles[row][col].setIsStairsUp(true);
					break;
				case 'D' :
					tileTiles[row][col].setIsStairsDown(true);
					break;
				case 'T' :
					tileTiles[row][col].setIsTreasure(true);
					break;
				case '~' :
					tileTiles[row][col].setIsSolid(false);
					break;
				case 'f' :
					tileTiles[row][col].setIsSolid(false);
					break;
				case 'F' :
					tileTiles[row][col].setIsSolid(false);
					break;
				case '#' :
					tileTiles[row][col].setIsSolid(false);
					break;
				case '%' :
					tileTiles[row][col].setIsSolid(false);
					break;
				case '9' :
					tileTiles[row][col].setIsSolid(false);
					break;
				case '6' :
					tileTiles[row][col].setIsSolid(false);
					break;
				case 'B' :
					tileTiles[row][col].setIsSolid(false);
					break;
				case '&' :
					tileTiles[row][col].setIsSolid(false);
					break;
				case '7' :
					tileTiles[row][col].setIsSolid(false);
					break;
				case 'L' :
					tileTiles[row][col].setIsSolid(false);
					break;
				case ' ' :
					tileTiles[row][col].setIsSolid(false);
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
