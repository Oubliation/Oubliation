package edu.ycp.cs320spring2015.oubliation.shared.location;

import edu.ycp.cs320spring2015.oubliation.shared.EntityClass;
import edu.ycp.cs320spring2015.oubliation.shared.NameTag;

public class Floor extends EntityClass {
	private static final long serialVersionUID = 6033124528247964345L;
	Tile[][] map;
	
	public Floor(NameTag nameTag, Tile[][] map) {
		super(nameTag);
		this.map = map;
	}
	
	public Tile getTile(int x, int y) {
		return map[x][y];
	}
}
