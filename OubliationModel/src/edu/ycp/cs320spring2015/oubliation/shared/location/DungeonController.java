package edu.ycp.cs320spring2015.oubliation.shared.location;

public interface DungeonController {
	public void teleportAbsolute(int x, int y);
	public void teleportRelative(int forward, int side);
	
	//TODO: profile proxys
}
