package edu.ycp.cs320spring2015.oubliation.client.transfer;

import edu.ycp.cs320spring2015.oubliation.shared.Entity;

public interface EntityExtractor<E extends Entity, O extends EntityOverlay> {
	public E getEntity(O overlay);
}
