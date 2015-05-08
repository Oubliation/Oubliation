package edu.ycp.cs320spring2015.oubliation.shared.targets;

import java.io.Serializable;

import edu.ycp.cs320spring2015.oubliation.shared.behavior.Behavior;

public interface PartyController extends Serializable {
	public void selectSelf(Behavior behavior);
	public void selectAlliedUnits(Behavior behavior);
	public void selectAlliedRows(Behavior behavior);
	public void selectAlliedColumns(Behavior behavior);
	public void selectAlliedGroup(Behavior behavior);
	public void selectAnyOpposingUnits(Behavior behavior);
	public  void selectFrontOpposingUnits(Behavior behavior);
	public  void selectAnyOpposingRows(Behavior behavior);
	public  void selectFrontOpposingRow(Behavior behavior);
	public  void selectAnyOpposingColumns(Behavior behavior);
	public  void selectOpposingGroup(Behavior behavior);
}
