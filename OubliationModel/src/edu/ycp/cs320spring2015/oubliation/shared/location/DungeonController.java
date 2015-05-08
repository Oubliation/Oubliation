package edu.ycp.cs320spring2015.oubliation.shared.location;

import edu.ycp.cs320spring2015.oubliation.shared.targets.PartyController;

public interface DungeonController extends PartyController {
	public void moveParty(int forwardDist, int sideDist);
	public void teleportParty(int destX, int destY);
	public void setFacing(Cardinal facing);
	public void battle(String[] enemies);
	public void toTown();
}
