package edu.ycp.cs320spring2015.oubliation.shared.location;

import edu.ycp.cs320spring2015.oubliation.shared.Profile;

public class Dungeon {
	
	private int playerX;
	private int playerY;
	private Cardinal facing;
	private Tile [][]map;
	private int level;
	
	public Dungeon(int floor) {
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
	
	public Tile getRelTile(int parallelCoord, int perpendicularCoord){
		int x = playerX + facing.getX() * parallelCoord + facing.getY() * perpendicularCoord;
		int y = playerY + facing.getY() * parallelCoord + facing.getX() * perpendicularCoord;
		Tile relTile = map[x][y];
		return relTile;
	}
	
	public Tile[][] getMap(){
		return map;
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
	
}
