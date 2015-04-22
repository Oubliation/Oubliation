package edu.ycp.cs320spring2015.oubliation.shared;

import edu.ycp.cs320spring2015.oubliation.shared.items.Effect;

public interface BattleController extends PartyController {
	public void selectAnyOpposingUnits(final Effect effect);
	public void selectFrontOpposingUnits(Effect effect);
	public void selectAnyOpposingRows(Effect effect);
	public void selectFrontOpposingRow(Effect effect);
	public void selectAnyOpposingColumns(Effect effect);
	public void selectOpposingGroup(Effect effect);
}
