package edu.ycp.cs320spring2015.oubliation.shared.location;

import edu.ycp.cs320spring2015.oubliation.shared.Profile;

public class Dungeon {
	
	private int x;
	private int y;
	private Cardinal facing;
	
	public Dungeon(int floor) {
	}
	
	public void move(Ordinal direction, Profile profile) {
		switch(direction) {
		case left: 
			facing = facing.rotateLeft();
		}
	}
	
	public void getRelTile(int depth, int horizontal) {
		
	}
}
