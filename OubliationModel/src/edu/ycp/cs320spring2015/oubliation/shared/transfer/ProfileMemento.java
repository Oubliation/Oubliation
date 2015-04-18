package edu.ycp.cs320spring2015.oubliation.shared.transfer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

import edu.ycp.cs320spring2015.oubliation.shared.CreateInventory;
import edu.ycp.cs320spring2015.oubliation.shared.Profile;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.PlayerActor;

public class ProfileMemento implements Serializable {
	private static final long serialVersionUID = 2470630709430676604L;
	public ProfileMemento() {}
	
	private String username;
	private LinkedList<PlayerActorMemento> partyTransfer;
	private LinkedList<PlayerActorMemento> rosterTransfer;
	private InventoryMemento inventoryTransfer;
	private int money;
	private HashSet<String> dungeonFlags;

	
	public ProfileMemento(String username) {
		this.username = username;
		partyTransfer = new LinkedList<PlayerActorMemento>();
		rosterTransfer = new LinkedList<PlayerActorMemento>();
		inventoryTransfer = new InventoryMemento();
		money = 0;
		dungeonFlags = new HashSet<String>();
	}
	
	public ProfileMemento(String username, int money,
			InventoryMemento inventoryTransfer, 
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

	public Profile constructProfile(LoadoutLoader loader) {
		ArrayList<PlayerActor> party = new ArrayList<PlayerActor>();
		ArrayList<PlayerActor> roster = new ArrayList<PlayerActor>();
		CreateInventory inventory = inventoryTransfer.constructInventory(loader);

		for (PlayerActorMemento actor : partyTransfer) {
			party.add(actor.constructPlayerActor(loader));
		}
		for (PlayerActorMemento actor : rosterTransfer) {
			roster.add(actor.constructPlayerActor(loader));
		}
		return new Profile(username, money, inventory, party, roster, dungeonFlags);
	}
}
