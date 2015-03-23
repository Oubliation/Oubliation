package edu.ycp.cs320spring2015.oubliation.shared;

/**
 *  @param name Name of the entity
 *  @param description Description of the entity
 *  @functions {@link #getName()}, {@link #getDescription()}
 */
public class NameTag implements Entity{
	final private String name;
	final private String description;
	
	public NameTag(String name, String description) {
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
