package edu.ycp.cs320spring2015.oubliation.shared.transfer;

import java.io.Serializable;

import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;
import edu.ycp.cs320spring2015.oubliation.shared.statuses.Corpse;
import edu.ycp.cs320spring2015.oubliation.shared.statuses.Healthy;
import edu.ycp.cs320spring2015.oubliation.shared.statuses.Status;

public class StatusMemento implements Serializable {
	private static final long serialVersionUID = -4037908614220711720L;
	
	String statusName;
	int param;
	
	public StatusMemento(String statusName, int param) {
		this.statusName = statusName;
		this.param = param;
	}
	
	public Status constructStatus(Actor actor) {
		switch (statusName) {
		case "Healthy": return new Healthy(actor);
		case "Corpse": return new Corpse(actor);
	}
	throw new UnsupportedOperationException("Status not implemented in getStatus");
	}
}
