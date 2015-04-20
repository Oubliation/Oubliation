package edu.ycp.cs320spring2015.oubliation.shared;

import edu.ycp.cs320spring2015.oubliation.shared.effect.Effect;

public interface PartyController {
	public void moveParty(int x, int y);
	public void selectAlliedUnit(Effect effect);
	public void selectAlliedRow(Effect effect);
	public void selectAlliedColumn(Effect effect);
	public void selectAlliedGroup(Effect effect);
}
