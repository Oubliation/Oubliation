package edu.ycp.cs320spring2015.shared.category;

public abstract class CategoryClass implements Category {
	
	final private String name;
	final private String description;
	

	public CategoryClass(String name, String description) {
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
