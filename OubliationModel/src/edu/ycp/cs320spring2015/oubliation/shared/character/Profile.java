package edu.ycp.cs320spring2015.oubliation.shared.character;

import edu.ycp.cs320spring2015.oubliation.shared.effect.Item;

public class Profile {
	private int money = 0;
	private Item[] inventory;
	private Unit[] party;
	private Unit[] roster;
	//TODO: profile
	
	private int floor = 0;
	private int xPos;
	private int yPos;
	
	public void setPosition(int x, int y) {
		xPos = x;
		yPos = y;
	}
	public void setFloor(int z) {
		floor = z; 
	}
	public void move() {
		
	}
	public void incMoney(int amount) {
		money += amount;
	}
	public boolean checkMoney(int amount) {
		return money >= amount;
	}
	public void decMoney(int amount) {
		if (money >= amount) { money -= amount; }
		else { money = 0; }
	}
}
