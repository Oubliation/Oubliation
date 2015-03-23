package edu.ycp.cs320spring2015.oubliation.shared.effect;
import edu.ycp.cs320spring2015.oubliation.shared.EntityClass;
import edu.ycp.cs320spring2015.oubliation.shared.NameTag;

/**
 * 
 * object which could be held by actors
 *
 */
public class Item extends EntityClass {
	final private int price;
	
	public Item(NameTag nameTag, int price) {
		super(nameTag);
		this.price = price;
	}
	
	/**
	 * 
	 * @return monetary value of this item
	 */
	public int getPrice() {
		return price;
	}
}
