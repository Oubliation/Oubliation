/**
 * 
 */
package edu.ycp.cs320spring2015.oubliation.client.town;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

import edu.ycp.cs320spring2015.oubliation.shared.Profile;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.PlayerActor;
import edu.ycp.cs320spring2015.oubliation.shared.statuses.Healthy;


public class TownBarracks extends Composite {

	private static TownBarracksUiBinder uiBinder = GWT
			.create(TownBarracksUiBinder.class);

	interface TownBarracksUiBinder extends UiBinder<Widget, TownBarracks> {
	}
	
	@UiField FlowPanel barracks;
	@UiField Button buttonHeal;
	@UiField Button buttonRest;
	
	final private Profile profile;
	
	public TownBarracks(ViewTown view) {
		initWidget(uiBinder.createAndBindUi(this));
		this.profile = view.getProfile();
	}
	
	/**
	 * Heals the entire party
	 * @param profile
	 */
	public void townHealParty(Profile profile){
		profile.healParty(Integer.MAX_VALUE);
	}
	
	/**
	 * not implemented yet
	 * @param actor
	 */
	public void removeStatus(PlayerActor actor){
		actor.setStatus(new Healthy());
	}
	
	/**
	 * Heals and levels up the party
	 * @param profile
	 */
	public void townRestParty(Profile profile){
		for (PlayerActor actor : profile.getParty()){
			if(actor.isLevelUpReady()){actor.updateLevel();}
		}
		profile.healParty(Integer.MAX_VALUE);
	}
	
	/**
	 * not implemented yet
	 */
	public void resurrection(){
		
	}

	@UiHandler("buttonHeal")
	void onClickHeal(ClickEvent e){townHealParty(profile);}
	
	@UiHandler("buttonRest")
	void onClickRest(ClickEvent e){townRestParty(profile);}


}
