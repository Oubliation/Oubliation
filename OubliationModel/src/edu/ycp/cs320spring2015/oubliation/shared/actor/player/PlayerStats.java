package edu.ycp.cs320spring2015.oubliation.shared.actor.player;

import java.io.Serializable;
import java.util.ArrayList;

import edu.ycp.cs320spring2015.oubliation.shared.effect.Utility;

public class PlayerStats implements Serializable {
	private int witchMp[];
	private int priestMp[];
	
	public PlayerStats(int[] witchMp, int[] priestMp) {
		this.witchMp = witchMp;
		this.priestMp = priestMp;
	}
	
	public int getWitchMp(int level) {
		return witchMp[level-1];
	}
	public int getPriestMp(int level) {
		return priestMp[level-1];
	}
	public void spendWitchMp(int level, int amount) {
		witchMp[level-1] -= amount;
	}
	public void spendPriestMp(int level, int amount) {
		priestMp[level-1] -= amount;
	}
}
