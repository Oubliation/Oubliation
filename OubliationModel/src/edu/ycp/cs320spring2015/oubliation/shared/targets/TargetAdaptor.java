package edu.ycp.cs320spring2015.oubliation.shared.targets;

import edu.ycp.cs320spring2015.oubliation.shared.PartyController;
import edu.ycp.cs320spring2015.oubliation.shared.items.Effect;

public interface TargetAdaptor<T extends PartyController> {
	public void apply(T controller, Effect effect);
}
