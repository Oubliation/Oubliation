package edu.ycp.cs320spring2015.oubliation.shared.category;

public abstract class EntityClass implements Entity {
	final private String name;
	final private String description;
	
	public EntityClass(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

}
