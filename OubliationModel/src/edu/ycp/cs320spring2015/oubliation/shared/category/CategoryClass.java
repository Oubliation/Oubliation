package edu.ycp.cs320spring2015.oubliation.shared.category;

import edu.ycp.cs320spring2015.oubliation.shared.NameTag;

public abstract class CategoryClass implements Category {
	
	final private NameTag nameTag;

	public CategoryClass(NameTag nameTag) {
		this.nameTag = nameTag;
	}
	
	public String getName() {
		return nameTag.getName();
	}

	public String getDescription() {
		return nameTag.getDescription();
	}

}
