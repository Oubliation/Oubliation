package edu.ycp.cs320spring2015.oubliation.shared.effect;

public class MagicCoat implements UsableItem<Item>, Equipment {
	final Item transformTo = this;

	@Override
	public void apply(Item args) {
		// TODO Auto-generated method stub
	}
	
	private int applyToItem(Object arg) {
		return Item.price;
	}
}
