package edu.ycp.cs320spring2015.oubliation.shared.category;

import edu.ycp.cs320spring2015.oubliation.shared.EntityClass;
import edu.ycp.cs320spring2015.oubliation.shared.NameTag;

/**
 * implements {@link Category}
 *
 */
public abstract class CategoryClass extends EntityClass implements Category {

	public CategoryClass(NameTag nameTag) {
		super(nameTag);
	}

}
