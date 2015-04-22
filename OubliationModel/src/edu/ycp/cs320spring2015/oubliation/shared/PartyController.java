package edu.ycp.cs320spring2015.oubliation.shared;

import edu.ycp.cs320spring2015.oubliation.shared.behavior.Effect;

public interface PartyController {
	public void selectAlliedUnits(Effect effect);
	public void selectAlliedRows(Effect effect);
	public void selectAlliedColumns(Effect effect);
	public void selectAlliedGroup(Effect effect);
	public void moveParty(int x, int y);
}
