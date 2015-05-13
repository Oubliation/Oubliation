package edu.ycp.cs320spring2015.oubliation.shared.location;

import java.util.LinkedList;
import java.util.Map;

import edu.ycp.cs320spring2015.oubliation.shared.Profile;
import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;
import edu.ycp.cs320spring2015.oubliation.shared.actor.NoActor;
import edu.ycp.cs320spring2015.oubliation.shared.actor.nonplayer.EnemyActor;
import edu.ycp.cs320spring2015.oubliation.shared.behavior.Behavior;
import edu.ycp.cs320spring2015.oubliation.shared.targets.ActorAction;
import edu.ycp.cs320spring2015.oubliation.shared.targets.HazardAi;
import edu.ycp.cs320spring2015.oubliation.shared.targets.TargetFilter;

public class Dungeon {
	
	private int playerX;
	private int playerY;
	private Cardinal facing;
	private Map<String, Floor> dungeon;
	private Map<String, EnemyActor> enemyMap;
	private Floor map;
	private StateController stateController;
	
	public Dungeon(int level, Map<String, Floor> dungeon, Map<String, EnemyActor> enemyMap, StateController stateController) {
		this.facing = Cardinal.west;
		this.playerX = 1;
		this.playerY = 2;
		this.dungeon = dungeon;
		this.enemyMap = enemyMap;
		this.stateController = stateController;
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
		final HazardAi.ActionReciever reciever = new HazardAi.ActionReciever() {

			@Override
			public void apply(ActorAction action) {
				action.apply();
			}
		};
		return new DungeonController() {
			private static final long serialVersionUID = -6748656140030697039L;

			@Override
			public void selectAllies(Behavior behavior, TargetFilter filter) {
				new HazardAi(new NoActor(tile), party, reciever).selectAllies(behavior, filter);
				
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
			public void battle(String[] enemies) {
				LinkedList<EnemyActor> enemyList = new LinkedList<EnemyActor>();
				for (String enemy : enemies) {
					enemyList.add(enemyMap.get(enemy));
				}
				stateController.battle(enemyList.toArray(new EnemyActor[enemyList.size()]));
			}

			@Override
			public void toTown() {
				stateController.exit();
			}

			@Override
			public void selectOpposition(Behavior behavior, TargetFilter filter) {
				throw new IllegalStateException();
				
			}

			@Override
			public int getX() {
				return playerY;
			}

			@Override
			public int getY() {
				return playerX;
			}

			@Override
			public Cardinal getFacing() {
				return facing;
			}

			@Override
			public boolean isFlagActive(String flag) {
				return profile.isFlagActive(flag);
			}

			@Override
			public void setFlag(String flag) {
				profile.setFlag(flag);
			}

			@Override
			public void clearFlag(String flag) {
				profile.clearFlag(flag);
			}

			@Override
			public void toggleFlag(String flag) {
				profile.toggleFlag(flag);
			}
		};
	}
	
}
