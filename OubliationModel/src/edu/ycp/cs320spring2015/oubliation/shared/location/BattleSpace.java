package edu.ycp.cs320spring2015.oubliation.shared.location;

public class BattleSpace extends Tile {
	
	String[] enemies;
	
	public BattleSpace(String[] enemies) {
		super("Battle area", false, "#FFFFFF");
		this.enemies = enemies;
	}
	

	public Reaction getOnEnterDelay(final DungeonController controller) {
		return new Reaction() {
			public void react() {
				if (!controller.isFlagActive(controller.getX()+","+controller.getY())) {
					controller.battle(enemies);
				}
			}
		};
	}
}
