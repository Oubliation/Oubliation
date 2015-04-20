package edu.ycp.cs320spring2015.oubliation.client;

import java.util.PriorityQueue;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

import edu.ycp.cs320spring2015.oubliation.shared.BattleController;
import edu.ycp.cs320spring2015.oubliation.shared.Profile;
import edu.ycp.cs320spring2015.oubliation.shared.actor.nonplayer.EnemyActor;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.PlayerActor;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Effect;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Utility;
import edu.ycp.cs320spring2015.oubliation.shared.statuses.Healthy;

public class ViewBattle extends Composite implements BattleController {

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
	PriorityQueue<BattleAction> actionQueue;
	
	Integer playerIndex = null;

	public ViewBattle(Profile profile, EnemyActor[] enemies) {
		initWidget(uiBinder.createAndBindUi(this));
		
		this.profile = profile;
		this.enemies = enemies;
		next();
	}
	
	private void next() {
		if (playerIndex == null) {
			BattleAction action = actionQueue.poll();
			if (action != null) {
				updateAction(action);
			} else {
				playerIndex = 0;
				updateTurn();
			}
		} else if (playerIndex < profile.getParty().length) {
			playerIndex += 1;
			updateTurn();
		} else {
			playerIndex = null;
			next();
		}
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
			PlayerActor actor = party[count];
			playerStats.setWidget(0, count, new Label(actor.getName()));
			String buildText;
			if (actor.getStatusName() == (new Healthy(null)).getName()) {
				buildText = actor.getDescription();
			} else {
				buildText = actor.getStatusName();
			}
			playerStats.setWidget(1, count, new Label(buildText));
			playerStats.setWidget(2, count, new Label(actor.getHealth()+"/"+actor.getMaxHealth()));
		}
	}
	
	private void updateTurn() {
		updateGeneral();
		final PlayerActor actor = profile.getParty()[playerIndex];
		equipmentMenu.clear();
		Hyperlink weaponLink = new Hyperlink();
		equipmentMenu.add(weaponLink);
		weaponLink.setText(actor.getHand().getName());
		weaponLink.addHandler(new ClickHandler() {
			public void onClick(ClickEvent e) {
				actor.getHand().apply(ViewBattle.this);
			}
		}, ClickEvent.getType());
		for (final Utility utility : actor.getEquippedUtilities()) {
			Hyperlink utilityLink = new Hyperlink();
			utilityLink.setText(utility.getName());
			utilityLink.addHandler(new ClickHandler() {
				public void onClick(ClickEvent e) {
					utility.apply(ViewBattle.this);
				}
			}, ClickEvent.getType());
		}
		//spells
		
	}
	
	private void updateAction(BattleAction action) {
		updateGeneral();
		action.apply();
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
	
	public void moveParty(int x, int y) {
		
	}
}
