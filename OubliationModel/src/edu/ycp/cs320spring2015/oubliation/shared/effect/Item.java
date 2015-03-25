package edu.ycp.cs320spring2015.oubliation.shared.effect;
import edu.ycp.cs320spring2015.oubliation.shared.EntityClass;
import edu.ycp.cs320spring2015.oubliation.shared.NameTag;

/**
 * 
 * object which may be held by actors
 *
 */
public class Item extends EntityClass {
	private static final long serialVersionUID = 6238883918558663956L;
	public Item() {}
	
	private int price;
	
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
