package edu.ycp.cs320spring2015.oubliation.shared.location;

import java.util.HashMap;
import java.util.Map;

import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;
import edu.ycp.cs320spring2015.oubliation.shared.category.Element;
import edu.ycp.cs320spring2015.oubliation.shared.statuses.ActionModifier;
import edu.ycp.cs320spring2015.oubliation.shared.statuses.Healthy;
import edu.ycp.cs320spring2015.oubliation.shared.targets.PartyController;
import edu.ycp.cs320spring2015.oubliation.shared.targets.ActionTarget;

//TODO: Change back to abstract
public abstract class Tile implements ActionTarget {
	private String name;
	private boolean isSolid;
	String htmlColor;
	
	public Tile(String name, Boolean isSolid, String htmlColor) {
		this.name = name;
		this.isSolid = isSolid;
		this.htmlColor = htmlColor;
	}
	
	public boolean isSolid(){
		return this.isSolid;
	}
	
	public String getHtmlColor() {
		return htmlColor;
	}
	
	public void getNormalTexture() {}
	public void getFrontTexture() {}
	
	public interface Reaction {
		public void react();
		
	}
	
	public void onEnterInstant(final DungeonController controller) {
		
	}
	public Reaction getOnEnterDelay(final DungeonController controller) {
		return new Reaction() {
			public void react() {
				
			}
		};
	}
	public Map<String, Reaction> getControls(final DungeonController controller) {
		return new HashMap<String, Reaction>();
	}

	@Override
	public void selectAnyBehavior(PartyController controller) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getInitiative() {
		return 0;
	}

	@Override
	public ActionModifier getTargetModifier() {
		return new Healthy().getTargetModifier(this);
	}

	@Override
	public ActionModifier getActionModifier(Actor target) {
		return new Healthy().getActionModifier(this, target);
	}

	@Override
	public boolean hitTest(int accuracy) {
		return false;
	}

	@Override
	public int receiveDamage(int damage, Element element) {
		return 0;
	}

	@Override
	public int receiveHealing(int amount) {
		return 0;
	}

}

