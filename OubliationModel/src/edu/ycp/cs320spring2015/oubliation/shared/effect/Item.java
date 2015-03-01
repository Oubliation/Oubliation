package edu.ycp.cs320spring2015.oubliation.shared.effect;
import edu.ycp.cs320spring2015.oubliation.shared.category.EntityClass;

public class Item extends EntityClass {
	final private int price;
	
	public Item(String name, String description, int price) {
		super(name, description);
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
}
