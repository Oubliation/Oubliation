package edu.ycp.cs320spring2015.oubliation.shared.location;

import edu.ycp.cs320spring2015.oubliation.shared.EntityClass;
import edu.ycp.cs320spring2015.oubliation.shared.NameTag;

public class Floor extends EntityClass {
	private static final long serialVersionUID = 6033124528247964345L;
	Tile[][] map;
	private int mapHeight = 20;
	private int mapWidth = 20;

	public int getMapHeight() {
		return this.mapHeight;
	}

	public int getMapWidth() {
		return mapWidth;
	}
	
	public void setMapHeight(int height) {
		this.mapHeight = height;
	}

	public void setMapWidth(int width) {
		this.mapWidth = width;
	}

	public Floor(NameTag nameTag, Tile[][] map) {
		super(nameTag);
		this.map = map;
	}
	
	public Tile getTile(int x, int y) {
		return this.map[x][y];
	}
	
	public void setTile(int x, Tile[] tile) {
		this.map[x] = tile;
	}
}
