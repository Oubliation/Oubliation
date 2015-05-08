package edu.ycp.cs320spring2015.oubliation.shared.location;

import java.util.HashMap;
import java.util.Map;

public class Door extends Tile {

	public Door() {
		super("Door", true, "#000000");
	}
	
	public Map<String, Reaction> getControls(final DungeonController controller) {
		Map<String, Reaction> reactionMap = new HashMap<String, Reaction>();
		reactionMap.put("enter", new Reaction() {
			public void react() {
				controller.moveParty(2, 0);
			}
		});
		
		return reactionMap;
	}
}
