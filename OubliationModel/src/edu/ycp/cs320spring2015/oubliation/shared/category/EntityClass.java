package edu.ycp.cs320spring2015.oubliation.shared.category;

public abstract class EntityClass implements Entity {
	final private NameTag nameTag;

	public EntityClass(NameTag nameTag) {
		this.nameTag = nameTag;
	}
	
	public String getName() {
		return nameTag.getName();
	}

	public String getDescription() {
		return nameTag.getDescription();
	}

}
