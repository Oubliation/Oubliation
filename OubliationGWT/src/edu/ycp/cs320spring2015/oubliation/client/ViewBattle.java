package edu.ycp.cs320spring2015.oubliation.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

import edu.ycp.cs320spring2015.oubliation.shared.Profile;
import edu.ycp.cs320spring2015.oubliation.shared.actor.nonplayer.EnemyActor;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.PlayerActor;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Effect;

public class ViewBattle extends Composite {

	private static ViewBattleUiBinder uiBinder = GWT
			.create(ViewBattleUiBinder.class);

	interface ViewBattleUiBinder extends UiBinder<Widget, ViewBattle> {
	}
	
	@UiField Label info;
	@UiField Hyperlink confirm;
	@UiField FlowPanel enemyStats;
	@UiField Grid playerStats;
	@UiField Label playerName;
	@UiField FlowPanel actionMenu;
	@UiField Hyperlink hide;
	@UiField Hyperlink dispell;
	@UiField Hyperlink run;
	@UiField Hyperlink back;
	@UiField FlowPanel equipmentMenu;
	@UiField FlowPanel spellMenu;
	@UiField Grid manaStats;
	@UiField Grid inventory;
	
	Profile profile;
	EnemyActor[] enemies;
	LinkedList<BattleAction> actionQueue;
	
	int playerIndex = 0;

	public ViewBattle(Profile profile, EnemyActor[] enemies) {
		initWidget(uiBinder.createAndBindUi(this));
		
		this.profile = profile;
		this.enemies = enemies;
		updateAction();
	}
	
	private void next() {
		
		playerIndex += 1;
	}
	
	private void updateGeneral() {
		info.setVisible(true);
		confirm.setVisible(false);
		hide.setVisible(false);
		dispell.setVisible(false);
		
		enemyStats.clear();
		for (EnemyActor enemy : enemies) {
			enemyStats.add(new Label(enemy.getName()));
		}
		PlayerActor[] party = profile.getParty();
		for (int count=0; count<party.length; count += 1) {
			playerStats.add(new Label(party[count].getName()));
		}
	}
	
	private void updateAction() {
		updateGeneral();
		
	}
	
	private void updateTurn() {
		
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
