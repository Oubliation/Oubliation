package edu.ycp.cs320spring2015.oubliation.shared.category;

public class NameTag {
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
