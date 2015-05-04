package edu.ycp.cs320spring2015.oubliation.shared.location;

public class ToOutskirts extends Tile {

	public ToOutskirts() {
		super(false, "#00FF00");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onEnterInstant(DungeonController controller) {
		controller.toTown();
	}
}
