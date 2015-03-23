package edu.ycp.cs320spring2015.oubliation.shared;

import java.io.Serializable;

/**
 * an interface for objects which exist within the fiction
 * @functions {@link #getName()}, {@link #getDescription()}
 */
public interface Entity extends Serializable {
	
	/**
	 * @return The name of the entity
	 */
	public String getName();
	/**
	 * @return The description of the entity
	 */
	public String getDescription();
}
