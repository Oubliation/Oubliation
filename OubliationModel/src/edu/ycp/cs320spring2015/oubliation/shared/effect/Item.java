package edu.ycp.cs320spring2015.oubliation.shared.effect;
import edu.ycp.cs320spring2015.oubliation.shared.EntityClass;
import edu.ycp.cs320spring2015.oubliation.shared.NameTag;

public class Item extends EntityClass {
	final private int price;
	
	public Item(NameTag nameTag, int price) {
		super(nameTag);
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
}
