package edu.ycp.cs320spring2015.oubliation.client;

import java.io.Serializable;

import edu.ycp.cs320spring2015.oubliation.shared.EntityClass;
import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.PlayerActor;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.BruceScore;

public class _Dummy implements Serializable {
	private static final long serialVersionUID = 7428017883960637180L;
	public _Dummy() {}
	
	public BruceScore score;
	public Actor actor;
	public EntityClass entity;
	public PlayerActor actorPlayer;
}
