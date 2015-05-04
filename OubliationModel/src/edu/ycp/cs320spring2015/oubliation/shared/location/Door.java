package edu.ycp.cs320spring2015.oubliation.shared.location;

import java.util.HashMap;
import java.util.Map;

import edu.ycp.cs320spring2015.oubliation.shared.targets.PartyController;

public class Door extends Tile {

	public Door() {
		super(true, "#000000");
	}
	
	public Map<String, Reaction> getControls(final PartyController controller) {
		Map<String, Reaction> reactionMap = new HashMap<String, Reaction>();
		reactionMap.put("enter", new Reaction() {
			public void react() {
				controller.moveParty(2, 0);
			}
		});
		
		return reactionMap;
	}
}
