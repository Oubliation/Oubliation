package edu.ycp.cs320spring2015.oubliation.shared.actor.player;

import java.util.ArrayList;

import edu.ycp.cs320spring2015.oubliation.shared.effect.Utility;

public class PlayerStats {
	private int witchMp[];
	private int priestMp[];
	private ArrayList<Utility> utilityQueue;
	
	public PlayerStats(int[] witchMp, int[] priestMp, ArrayList<Utility> utilityQueue) {
		this.witchMp = witchMp;
		this.priestMp = priestMp;
		this.utilityQueue = utilityQueue;
	}
	
	public int getWitchMp(int level) {
		return witchMp[level-1];
	}
	public int getPriestMp(int level) {
		return priestMp[level-1];
	}
	public void addUtility(Utility utility) {
		utilityQueue.add(utility);
	}
	public void removeUtility(Utility utility) {
		boolean haveUtility = utilityQueue.remove(utility);
		assert haveUtility;
	}
	public Utility[] getUtilityQueue() {
		return utilityQueue.toArray(new Utility[utilityQueue.size()]);
	}
}
