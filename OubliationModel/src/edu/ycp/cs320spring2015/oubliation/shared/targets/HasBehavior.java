package edu.ycp.cs320spring2015.oubliation.shared.targets;

public interface HasBehavior<T extends PartyController> {
	public void selectAnyBehavior(T controller);
}
