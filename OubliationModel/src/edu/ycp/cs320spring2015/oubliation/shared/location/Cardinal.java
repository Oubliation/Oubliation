package edu.ycp.cs320spring2015.oubliation.shared.location;

public enum Cardinal {
	north(0, -1), south(0, 1), east(-1, 0), west(1, 0);
	
	private int x;
	private int y;
	
	private Cardinal(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}

	public Cardinal rotateLeft() {
		switch(this) {
		case north:
			return west;
		case west:
			return south;
		case south:
			return east;
		case east:
			return north;
		default:
			throw new IllegalStateException();
		}
	}
	public Cardinal rotateRight() {
		switch(this) {
		case north:
			return east;
		case west:
			return north;
		case south:
			return west;
		case east:
			return south;
		default:
			throw new IllegalStateException();
		}
	}
}
