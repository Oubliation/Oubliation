package edu.ycp.cs320spring2015.oubliation.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

import edu.ycp.cs320spring2015.oubliation.shared.Profile;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Effect;

public class ViewBattle extends Composite {

	private static ViewBattleUiBinder uiBinder = GWT
			.create(ViewBattleUiBinder.class);

	interface ViewBattleUiBinder extends UiBinder<Widget, ViewBattle> {
	}
	
	@UiField Label info;
	@UiField FlowPanel enemyStats;
	@UiField Grid playerStats;
	@UiField Label playerName;
	@UiField FlowPanel actionMenu;
	@UiField FlowPanel equipmentMenu;
	@UiField FlowPanel spellMenu;
	@UiField Grid manaStats;
	@UiField Grid inventory;
	
	Profile profile;
	
	int playerIndex = 0;

	public ViewBattle(Profile profile) {
		initWidget(uiBinder.createAndBindUi(this));
		
		this.profile = profile;
	}
	
	public void selectOpposingUnit(Effect effect) {
		
	}
	
	public void selectOpposingRow(Effect effect) {
		
	}
	
	public void selectOpposingColumn(Effect effect) {
		
	}
	
	public void selectOpposingGroup(Effect effect) {
		
	}
	

	public void selectAlliedUnit(Effect effect) {
		
	}
	
	public void selectAlliedRow(Effect effect) {
		
	}
	
	public void selectAlliedColumn(Effect effect) {
		
	}
	
	public void selectAlliedGroup(Effect effect) {
		
	}
}
