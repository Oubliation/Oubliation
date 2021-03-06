package edu.ycp.cs320spring2015.oubliation.shared.location;

import java.util.HashMap;
import java.util.Map;

import edu.ycp.cs320spring2015.oubliation.shared.targets.HasBehavior;
import edu.ycp.cs320spring2015.oubliation.shared.targets.PartyController;

//TODO: Change back to abstract
public abstract class Tile implements HasBehavior {
	private boolean isSolid;
	String htmlColor;
	
	public Tile(String name, Boolean isSolid, String htmlColor) {
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

}

