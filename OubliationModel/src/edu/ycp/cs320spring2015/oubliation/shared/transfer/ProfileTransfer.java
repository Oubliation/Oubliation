package edu.ycp.cs320spring2015.oubliation.shared.transfer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

import edu.ycp.cs320spring2015.oubliation.shared.Profile;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.PlayerActor;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Item;

public class ProfileTransfer implements Serializable {
	private static final long serialVersionUID = 2470630709430676604L;
	public ProfileTransfer() {}
	
	private LinkedList<PlayerActorTransfer> partyTransfer;
	private LinkedList<PlayerActorTransfer> rosterTransfer;
	private LinkedList<String> inventoryTransfer;
	private int money;
	private HashSet<String> dungeonFlags;
	
	
	public ProfileTransfer(LinkedList<PlayerActorTransfer> partyTransfer,
			LinkedList<PlayerActorTransfer> rosterTransfer,
			LinkedList<String> inventoryTransfer, int money,
			HashSet<String> dungeonFlags) {
		super();
		this.partyTransfer = partyTransfer;
		this.rosterTransfer = rosterTransfer;
		this.inventoryTransfer = inventoryTransfer;
		this.money = money;
		this.dungeonFlags = dungeonFlags;
	}


	public Profile makeProfile() {
		ArrayList<PlayerActor> party = new ArrayList<PlayerActor>();
		ArrayList<PlayerActor> roster = new ArrayList<PlayerActor>();
		return new Profile(money, new ArrayList<Item>(), party, roster, dungeonFlags);
	}
}
