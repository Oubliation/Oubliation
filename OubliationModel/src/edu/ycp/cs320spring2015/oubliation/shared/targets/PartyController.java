package edu.ycp.cs320spring2015.oubliation.shared.targets;

import edu.ycp.cs320spring2015.oubliation.shared.behavior.Behavior;

public interface PartyController {
	public void selectSelf(Behavior behavior);
	public void selectAlliedUnits(Behavior behavior);
	public void selectAlliedRows(Behavior behavior);
	public void selectAlliedColumns(Behavior behavior);
	public void selectAlliedGroup(Behavior behavior);
	public void moveParty(int forwardDist, int sideDist);
	public void toTown();
}
