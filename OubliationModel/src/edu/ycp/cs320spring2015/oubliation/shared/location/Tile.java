package edu.ycp.cs320spring2015.oubliation.shared.location;

//import java.util.HashMap;
//import java.util.Map;

//TODO: Change back to abstract
public class Tile {
	private boolean isSolid = false;
	private boolean isStairsUp = false;
	private boolean isStairsDown = false;
	private boolean isTreasure = false;
	private boolean isLever = false;
	private boolean isWall = false;
	private boolean isToOutskirts = false;
	private boolean isLocked = false;
	private boolean isDoor = false;
	private boolean isMagDoor = false;
	private boolean isTrap = false;
	private boolean isFight = false;
	private boolean leverIsOn = false;
	
	public void getNormalTexture() {}
	public void getFrontTexture() {}
	public void interact(DungeonController controller){}
	
//	public interface TileReaction {
//		public void react();
//		
//	}
//	
//	public Map<String, TileReaction> getControls() {
//		Map<String, TileReaction> reactionMap = new HashMap<String, TileReaction>();
//		reactionMap.put("enter", new TileReaction() {
//			public void react(PartyController controller) {
//				controller.move(2, 0);
//			}
//		});
//		
//		return reactionMap;
//	}
	
	public boolean isSolid(){return this.isSolid;}
	public boolean isStairsUp(){return this.isStairsUp;}
	public boolean isStairsDown(){return this.isStairsDown;}
	public boolean isTreasure(){return this.isTreasure;}
	public boolean isLever(){return this.isLever;}
	public boolean leverIsOn(){return this.leverIsOn;}
	public boolean isWall(){return this.isWall;}
	public boolean isToOutskirts(){return this.isToOutskirts;}
	public boolean isLocked(){return this.isLocked;}
	public boolean isDoor(){return this.isDoor;}
	public boolean isMagDoor(){return this.isMagDoor;}
	public boolean isTrap(){return this.isTrap;}
	public boolean isFight(){return this.isFight;}	

	public void setIsSolid(boolean solid){this.isSolid = solid;}
	public void setIsStairsUp(boolean isStairsUp){this.isStairsUp = isStairsUp;}
	public void setIsStairsDown(boolean isStairsDown){this.isStairsDown = isStairsDown;}
	public void setIsTreasure(boolean isTreasure){this.isTreasure = isTreasure;}
	public void setIsLever(boolean lever){this.isLever = lever;}
	public void setIsWall(boolean wall){this.isWall = wall;}
	public void setIsToOutskirts(boolean isToOutskirts){this.isToOutskirts = isToOutskirts;}
	public void setIsLocked(boolean isLocked){this.isLocked = isLocked;}
	public void setIsDoor(boolean door){this.isDoor = door;}
	public void setIsMagDoor(boolean magDoor){this.isMagDoor = magDoor;}
	public void setIsTrap(boolean trap){this.isTrap = trap;}
	public void setIsFight(boolean fight){this.isFight = fight;}
	public void setLeverIsOn(boolean onOff){this.leverIsOn = onOff;}

}

