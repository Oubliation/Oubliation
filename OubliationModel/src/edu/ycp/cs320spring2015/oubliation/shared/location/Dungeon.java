package edu.ycp.cs320spring2015.oubliation.shared.location;

import java.util.Map;
import java.util.PriorityQueue;

import edu.ycp.cs320spring2015.oubliation.shared.Profile;
import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;
import edu.ycp.cs320spring2015.oubliation.shared.behavior.Behavior;
import edu.ycp.cs320spring2015.oubliation.shared.targets.BattleAction;
import edu.ycp.cs320spring2015.oubliation.shared.targets.HazardAi;
import edu.ycp.cs320spring2015.oubliation.shared.targets.PartyController;

public class Dungeon {
	
	private int playerX;
	private int playerY;
	private Cardinal facing;
	private Map<String, Floor> dungeon;
	private Floor map;
	private Exitable toTown;
	
	public Dungeon(int level, Map<String, Floor> dungeon, Exitable toTown) {
		this.facing = Cardinal.west;
		this.playerX = 1;
		this.playerY = 2;
		this.dungeon = dungeon;
		this.toTown = toTown;
		setLevel(level);
	}
	
	public Tile.Reaction move(Ordinal direction, final Profile profile) {
		switch(direction) {
		case left: 
			facing = facing.rotateLeft();
			break;
		case right: 
			facing = facing.rotateRight();
			break;
		case forward: 
			playerX += facing.getX();
			playerY += facing.getY();
			break;
		case backward:
			playerX -= facing.getX();
			playerY -= facing.getY();
			break;
		}
		final Tile tile = map.getTile(playerX, playerY);
		final PartyController controller = getPartyController(tile, profile.getParty());
		tile.onEnterInstant(controller);
		return tile.getOnEnterDelay(controller);
		
		
	}
	
	public Cardinal getFacing(){
		return this.facing;
	}
	
	public Tile getRelTile(int parallelCoord, int perpendicularCoord){
		int x = playerX + facing.getX() * parallelCoord + facing.getY() * perpendicularCoord;
		int y = playerY + facing.getY() * parallelCoord + facing.getX() * perpendicularCoord;
		Tile relTile = this.map.getTile(x, y);
		return relTile;
	}
	
	public Floor getMap(){
		return this.map;
	}
	
	public void setLevel(int level){
		map = dungeon.get(String.valueOf(level));
	}
	
	public Tile getCurrentMapTile(){
		return map.getTile(playerX, playerY);
	}
	
	public String getLevel(){
		return map.getName();
	}
	public String getTitle(){
		return map.getDescription();
	}
	public int getPlayerX(){
		return this.playerX;
	}
	public int getPlayerY(){
		return this.playerY;
	}
	
	public Map<String, Tile.Reaction> getControls(Actor[] party) {
		int tileX = playerX + facing.getX();
		int tileY = playerY + facing.getY();
		Tile tile = map.getTile(tileX, tileY);
		return tile.getControls(getPartyController(tile, party));
	}
	
	private PartyController getPartyController(final Tile tile, final Actor[] party) {
		final PriorityQueue<BattleAction> actionQueue = new PriorityQueue<BattleAction>();
		return new PartyController() {

			@Override
			public void selectSelf(Behavior behavior) {
				throw new IllegalStateException();
			}

			@Override
			public void selectAlliedUnits(Behavior behavior) {
				new HazardAi(tile, party, actionQueue).selectAlliedUnits(behavior);;
				actionQueue.poll().apply();
				
			}

			@Override
			public void selectAlliedRows(Behavior behavior) {
				new HazardAi(tile, party, actionQueue).selectAlliedRows(behavior);;
				actionQueue.poll().apply();
			}

			@Override
			public void selectAlliedColumns(Behavior behavior) {
				new HazardAi(tile, party, actionQueue).selectAlliedColumns(behavior);;
				actionQueue.poll().apply();
			}

			@Override
			public void selectAlliedGroup(Behavior behavior) {
				new HazardAi(tile, party, actionQueue).selectAlliedGroup(behavior);;
				actionQueue.poll().apply();
			}

			@Override
			public void moveParty(int forwardDist, int sideDist) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void toTown() {
				toTown.exit();
			}
			
		};
	}
	
}
