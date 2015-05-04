package edu.ycp.cs320spring2015.oubliation.shared.location;

import edu.ycp.cs320spring2015.oubliation.shared.targets.PartyController;

public class ToOutskirts extends Tile {

	public ToOutskirts() {
		super(false, "#00FF00");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onEnterInstant(PartyController controller) {
		controller.toTown();
	}
}
