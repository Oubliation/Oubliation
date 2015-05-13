package edu.ycp.cs320spring2015.oubliation.shared.location;

import edu.ycp.cs320spring2015.oubliation.shared.targets.PartyController;

public interface DungeonController extends PartyController {
	public void moveParty(int forwardDist, int sideDist);
	public void teleportParty(int destX, int destY);
	public void setFacing(Cardinal facing);
	
	public int getX();
	public int getY();
	public Cardinal getFacing();
	
	public boolean isFlagActive(String flag);
	public void setFlag(String flag);
	public void clearFlag(String flag);
	public void toggleFlag(String flag);
	
	public void battle(String[] enemies);
	public void toTown();
}
