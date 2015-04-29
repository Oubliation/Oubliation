package edu.ycp.cs320spring2015.oubliation.shared.targets;

import edu.ycp.cs320spring2015.oubliation.shared.behavior.Behavior;

public interface BattleController extends PartyController {
	public void selectAnyOpposingUnits(Behavior behavior);
	public void selectFrontOpposingUnits(Behavior behavior);
	public void selectAnyOpposingRows(Behavior behavior);
	public void selectFrontOpposingRow(Behavior behavior);
	public void selectAnyOpposingColumns(Behavior behavior);
	public void selectOpposingGroup(Behavior behavior);
}
