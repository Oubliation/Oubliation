package edu.ycp.cs320spring2015.oubliation.shared.location;

import edu.ycp.cs320spring2015.oubliation.shared.Profile;
import edu.ycp.cs320spring2015.oubliation.shared.test.Debug;

public class Dungeon {
	
	private int playerX;
	private int playerY;
	private Cardinal facing;
	private Tile [][]map;
	private int level;
	
	public Dungeon(int floor) {
		this.facing = Cardinal.west;
		this.playerX = 1;
		this.playerY = 2;
		this.map = Debug.makeMap();
		this.level = floor;
	}
	
	public void move(Ordinal direction, Profile profile) {
		switch(direction) {
		case left: 
			facing = facing.rotateLeft();
			break;
		case right: 
			facing = facing.rotateRight();
			break;
		case forward: 
			playerX += facing.getX();
			playerY += facing.getY();
			break;
		case backward:
			playerX -= facing.getX();
			playerY -= facing.getY();
			break;
		}
	}
	
	public Cardinal getFacing(){
		return this.facing;
	}
	
	public Tile getRelTile(int parallelCoord, int perpendicularCoord){
		int x = playerX + facing.getX() * parallelCoord + facing.getY() * perpendicularCoord;
		int y = playerY + facing.getY() * parallelCoord + facing.getX() * perpendicularCoord;
		Tile relTile = this.map[x][y];
		return relTile;
	}
	
	public Tile[][] getMap(){
		return this.map;
	}
	
	public void setMap(Tile [][]map){
		this.map = map;
	}
	
	public Tile getCurrentMapTile(){
		return map[playerX][playerY];
	}
	
	public void setLevel(int level){
		this.level = level;
	}
	
	public int getLevel(){
		return this.level;
	}
	public int getPlayerX(){
		return this.playerX;
	}
	public int getPlayerY(){
		return this.playerY;
	}
	
}
