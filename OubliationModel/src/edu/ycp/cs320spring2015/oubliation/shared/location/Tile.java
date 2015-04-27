package edu.ycp.cs320spring2015.oubliation.shared.location;

//TODO: Change back to abstract
public class Tile {
	boolean isSolid;
	boolean isStairsUp;
	boolean isStairsDown;
	boolean isWall;
	boolean isToOutskirts;
	public void getNormalTexture() {
		
	}
	public void getFrontTexture() {
		
	}
	/**
	 * 
	 * @return if the tile is solid
	 */
	public boolean isSolid() {
		return this.isSolid;
	}
	/**
	 * 
	 * @return if the tile is a wall
	 */
	public boolean isWall(){
		return this.isWall;
	}
	/**
	 * 
	 * @return if the tile is a set of stairs going up
	 */
	public boolean isStairsUp(){
		return this.isStairsUp;
	}
	/**
	 * 
	 * @return if the tile is a set of stairs going down
	 */
	public boolean isStairsDown(){
		return this.isStairsDown;
	}
	public boolean isToOutskirts(){
		return this.isToOutskirts;
	}
	public void interact(DungeonController controller) {
		
	}
	public void setIsSolid(boolean solid){
		this.isSolid = solid;
	}
	public void setIsStairsUp(boolean isStairsUp){
		this.isStairsUp = isStairsUp;
	}
	public void setIsStairsDown(boolean isStairsDown){
		this.isStairsDown = isStairsDown;
	}
	public void setIsToOutskirts(boolean isToOutskirts){
		this.isToOutskirts = isToOutskirts;
	}
}
