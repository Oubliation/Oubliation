package com.cs320spring2015.oubliation.shared.effect;

public class MagicCoat implements UsableItem, Equipment {
	final Item transformTo = this;

	@Override
	public Item apply(Object... args) {
		// TODO Auto-generated method stub
		int count = applyToItem(args);
		if (count > 0) {
			return new MagicCoat();
		} else {
			return null;
		}
	}
	
	private int applyToItem(Object target) {
		return Item.price;
	}
}
