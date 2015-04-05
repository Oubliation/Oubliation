package edu.ycp.cs320spring2015.oubliation.shared.transfer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

import edu.ycp.cs320spring2015.oubliation.shared.Profile;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.PlayerActor;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Headwear;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Item;

public class ProfileMemento implements Serializable {
	private static final long serialVersionUID = 2470630709430676604L;
	public ProfileMemento() {}
	
	private String username;
	private LinkedList<PlayerActorMemento> partyTransfer;
	private LinkedList<PlayerActorMemento> rosterTransfer;
	private LinkedList<String> inventoryTransfer;
	private int money;
	private HashSet<String> dungeonFlags;

	
	public ProfileMemento(String username) {
		this.username = username;
		partyTransfer = new LinkedList<PlayerActorMemento>();
		rosterTransfer = new LinkedList<PlayerActorMemento>();
		inventoryTransfer = new LinkedList<String>();
		money = 0;
		dungeonFlags = new HashSet<String>();
	}
	
	public ProfileMemento(String username, int money,
			LinkedList<String> inventoryTransfer, 
			LinkedList<PlayerActorMemento> partyTransfer,
			LinkedList<PlayerActorMemento> rosterTransfer, 
			HashSet<String> dungeonFlags) {
		this.username = username;
		this.partyTransfer = partyTransfer;
		this.rosterTransfer = rosterTransfer;
		this.inventoryTransfer = inventoryTransfer;
		this.money = money;
		this.dungeonFlags = dungeonFlags;
	}

	public Profile constructProfile(Map<String, Headwear> headwearMap) {
		ArrayList<PlayerActor> party = new ArrayList<PlayerActor>();
		ArrayList<PlayerActor> roster = new ArrayList<PlayerActor>();
		ArrayList<Item> inventory = new ArrayList<Item>();

		for (PlayerActorMemento actor : partyTransfer) {
			party.add(actor.constructPlayerActor(headwearMap));
		}
		for (PlayerActorMemento actor : rosterTransfer) {
			roster.add(actor.constructPlayerActor(headwearMap));
		}
		return new Profile(username, money, inventory, party, roster, dungeonFlags);
	}
}
