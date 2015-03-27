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
	
	private String username;
	private LinkedList<PlayerActorTransfer> partyTransfer;
	private LinkedList<PlayerActorTransfer> rosterTransfer;
	private LinkedList<String> inventoryTransfer;
	private int money;
	private HashSet<String> dungeonFlags;

	
	public ProfileTransfer(String username) {
		this.username = username;
		partyTransfer = new LinkedList<PlayerActorTransfer>();
		rosterTransfer = new LinkedList<PlayerActorTransfer>();
		inventoryTransfer = new LinkedList<String>();
		money = 0;
		dungeonFlags = new HashSet<String>();
	}
	
	public ProfileTransfer(String username, int money,
			LinkedList<String> inventoryTransfer, 
			LinkedList<PlayerActorTransfer> partyTransfer,
			LinkedList<PlayerActorTransfer> rosterTransfer, 
			HashSet<String> dungeonFlags) {
		this.username = username;
		this.partyTransfer = partyTransfer;
		this.rosterTransfer = rosterTransfer;
		this.inventoryTransfer = inventoryTransfer;
		this.money = money;
		this.dungeonFlags = dungeonFlags;
	}

	public Profile constructProfile() {
		ArrayList<PlayerActor> party = new ArrayList<PlayerActor>();
		ArrayList<PlayerActor> roster = new ArrayList<PlayerActor>();
		ArrayList<Item> inventory = new ArrayList<Item>();

		for (PlayerActorTransfer actor : partyTransfer) {
			party.add(actor.constructPlayerActor());
		}
		for (PlayerActorTransfer actor : rosterTransfer) {
			roster.add(actor.constructPlayerActor());
		}
		return new Profile(username, money, inventory, party, roster, dungeonFlags);
	}
}
