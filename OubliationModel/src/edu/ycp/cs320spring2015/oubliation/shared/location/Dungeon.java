package edu.ycp.cs320spring2015.oubliation.shared.location;

import java.util.Map;
import java.util.PriorityQueue;

import edu.ycp.cs320spring2015.oubliation.shared.Profile;
import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;
import edu.ycp.cs320spring2015.oubliation.shared.behavior.Behavior;
import edu.ycp.cs320spring2015.oubliation.shared.targets.BattleAction;
import edu.ycp.cs320spring2015.oubliation.shared.targets.HazardAi;

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
		int destX, destY;
		switch(direction) {
		case left: 
			facing = facing.rotateLeft();
			return null;
		case right: 
			facing = facing.rotateRight();
			return null;
		case forward: 
			destX = playerX + facing.getX();
			destY = playerY + facing.getY();
			return moveTo(destX, destY, profile);
		case backward:
			destX = playerX - facing.getX();
			destY = playerY - facing.getY();
			return moveTo(destX, destY, profile);
		default:
			throw new IllegalStateException();
		}
	}
	
	public Tile.Reaction moveTo(int destX, int destY, final Profile profile) {
		playerX = destX;
		playerY = destY;
		
		final Tile tile = map.getTile(playerX, playerY);
		final DungeonController controller = getDungeonController(tile, profile);
		tile.onEnterInstant(controller);
		return tile.getOnEnterDelay(controller);
	}
	
	public Cardinal getFacing(){
		return this.facing;
	}
	
	public Tile getRelTile(int forwardDist, int sideDist){
		int tileX = playerX + facing.getX() * forwardDist + facing.rotateRight().getX() * sideDist;
		int tileY = playerY + facing.getY() * forwardDist + facing.rotateRight().getY() * sideDist;
		Tile relTile = this.map.getTile(tileX, tileY);
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
	
	public Map<String, Tile.Reaction> getControls(Profile profile) {
		int tileX = playerX + facing.getX();
		int tileY = playerY + facing.getY();
		Tile tile = map.getTile(tileX, tileY);
		return tile.getControls(getDungeonController(tile, profile));
	}
	
	private DungeonController getDungeonController(final Tile tile, final Profile profile) {
		final Actor[] party = profile.getParty();
		final PriorityQueue<BattleAction> actionQueue = new PriorityQueue<BattleAction>();
		return new DungeonController() {

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
				int destX = playerX + facing.getX() * forwardDist + facing.rotateRight().getX() * sideDist;
				int destY = playerY + facing.getY() * forwardDist + facing.rotateRight().getY() * sideDist;
				
				moveTo(destX, destY, profile);
			}

			@Override
			public void teleportParty(int destX, int destY) {
				moveTo(destX, destY, profile);
			}
			
			@Override
			public void setFacing(Cardinal facing) {
				Dungeon.this.facing = facing;
			}

			@Override
			public void toTown() {
				toTown.exit();
			}
		};
	}
	
}
