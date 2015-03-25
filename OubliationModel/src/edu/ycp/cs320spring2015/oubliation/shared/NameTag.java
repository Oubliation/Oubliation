package edu.ycp.cs320spring2015.oubliation.shared;

/**
 * Attachable name and description for entities	
 * implements {@link Entity} 
 *  @functions {@link #getName()}, {@link #getDescription()}
 */
public final class NameTag implements Entity{
	private static final long serialVersionUID = 1251479448538576281L;
	public NameTag() {}
	
	private String name;
	private String description;
	
	/**
	 * 
	 * @param name Name of the entity
	 * @param description Description of the entity
	 */
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
