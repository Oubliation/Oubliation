package edu.ycp.cs320spring2015.oubliation.shared;

import java.io.Serializable;

/**
 * implements {@link Entity}
 */
public abstract class EntityClass implements Entity, Serializable {
	private static final long serialVersionUID = 5438401186682378274L;
	public EntityClass() {}
	
	private NameTag nameTag;
	/**
	 * @param nameTag
	 */
	public EntityClass(NameTag nameTag) {
		this.nameTag = nameTag;
	}
	
	public String getName() {
		return nameTag.getName();
	}

	public String getDescription() {
		return nameTag.getDescription();
	}
	
	protected NameTag getNameTag() {
		return nameTag;
	}
}
