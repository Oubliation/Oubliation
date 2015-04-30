package edu.ycp.cs320spring2015.oubliation.shared.location;

import java.util.Map;

import edu.ycp.cs320spring2015.oubliation.shared.Profile;

public class Dungeon {
	
	private int playerX;
	private int playerY;
	private Cardinal facing;
	private Map<String, Floor> dungeon;
	private Floor map;
	
	public Dungeon(int level, Map<String, Floor> dungeon) {
		this.facing = Cardinal.west;
		this.playerX = 1;
		this.playerY = 2;
		this.dungeon = dungeon;
		setLevel(level);
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
		Tile relTile = this.map.getTile(x, y);
		return relTile;
	}
	
	public Floor getMap(){
		return this.map;
	}
	
	public void setLevel(int level){
		map = dungeon.get(String.valueOf(level));
	}
	
	public Tile getCurrentMapTile(){
		return map.getTile(playerX, playerY);
	}
	
	public String getLevel(){
		return map.getName();
	}
	public String getTitle(){
		return map.getDescription();
	}
	public int getPlayerX(){
		return this.playerX;
	}
	public int getPlayerY(){
		return this.playerY;
	}
	
}
