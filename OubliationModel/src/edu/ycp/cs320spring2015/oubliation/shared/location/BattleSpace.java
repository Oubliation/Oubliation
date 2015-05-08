package edu.ycp.cs320spring2015.oubliation.shared.location;

public class BattleSpace extends Tile {

	public BattleSpace() {
		super("Battle area", false, "#0026FF");
	}
	

	public Reaction getOnEnterDelay(DungeonController controller) {
		return new Reaction() {
			public void react() {
				
			}
		};
	}
}
