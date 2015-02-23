package edu.ycp.cs320spring2015.oubliation.shared.effect;

public interface UsableItem<T> extends Effect<T>, Item {
	final Item transformTo = null;
}
