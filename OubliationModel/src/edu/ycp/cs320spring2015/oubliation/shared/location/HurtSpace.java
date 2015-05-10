package edu.ycp.cs320spring2015.oubliation.shared.location;

import edu.ycp.cs320spring2015.oubliation.shared.behavior.Behavior;
import edu.ycp.cs320spring2015.oubliation.shared.behavior.NoEffect;
import edu.ycp.cs320spring2015.oubliation.shared.category.Element;
import edu.ycp.cs320spring2015.oubliation.shared.targets.SelectAlliedGroup;

public class HurtSpace extends Tile {
	public HurtSpace() {
		super("Trap", false, "#FF00FF");
	}
	
	@Override
	public void onEnterInstant(final DungeonController controller) {
		controller.selectAlliedGroup(new Behavior(
				new NoEffect(), new SelectAlliedGroup(), -10, 0, Integer.MAX_VALUE, Element.physical, new NoEffect(), 0, "", "", "")
		);
	}
}
	
	
