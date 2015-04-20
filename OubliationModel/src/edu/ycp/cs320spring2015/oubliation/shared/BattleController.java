package edu.ycp.cs320spring2015.oubliation.shared;

import edu.ycp.cs320spring2015.oubliation.shared.effect.Effect;

public interface BattleController extends PartyController {
	public void selectOpposingUnit(Effect effect);
	public void selectOpposingRow(Effect effect);
	public void selectOpposingColumn(Effect effect);
	public void selectOpposingGroup(Effect effect);
}
