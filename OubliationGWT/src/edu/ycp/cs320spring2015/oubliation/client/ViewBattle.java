package edu.ycp.cs320spring2015.oubliation.client;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

import edu.ycp.cs320spring2015.oubliation.shared.Profile;
import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;
import edu.ycp.cs320spring2015.oubliation.shared.actor.nonplayer.EnemyActor;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.PlayerActor;
import edu.ycp.cs320spring2015.oubliation.shared.behavior.Behavior;
import edu.ycp.cs320spring2015.oubliation.shared.items.Utility;
import edu.ycp.cs320spring2015.oubliation.shared.statuses.Corpse;
import edu.ycp.cs320spring2015.oubliation.shared.statuses.Healthy;
import edu.ycp.cs320spring2015.oubliation.shared.targets.BattleAi;
import edu.ycp.cs320spring2015.oubliation.shared.targets.ActorAction;
import edu.ycp.cs320spring2015.oubliation.shared.targets.HazardAi;
import edu.ycp.cs320spring2015.oubliation.shared.targets.PartyController;
import edu.ycp.cs320spring2015.oubliation.shared.targets.TargetFilter;

//TODO: AI, deserialization, status cleanup, startturn (etc), enemy deserialization

public class ViewBattle extends Composite implements PartyController {
	private static final long serialVersionUID = 6360195270267057410L;
	
	private static ViewBattleUiBinder uiBinder = GWT
			.create(ViewBattleUiBinder.class);

	interface ViewBattleUiBinder extends UiBinder<Widget, ViewBattle> {
	}
	
	@UiField FlowPanel info;
	@UiField FlowPanel enemyStats;
	@UiField Grid playerStats;
	@UiField Label playerName;
	@UiField FlowPanel actionMenu;
	@UiField Hyperlink hide;
	@UiField Hyperlink dispell;
	@UiField Hyperlink run;
	@UiField FlowPanel equipmentMenu;
	@UiField FlowPanel spellMenu;
	@UiField Grid manaStats;
	@UiField Grid inventory;
	@UiField FlowPanel console;
	
	Profile profile;
	PlayerActor[] party;
	EnemyActor[] enemies;
	PriorityQueue<ActorAction> actionQueue = new PriorityQueue<ActorAction>(11, new Comparator<ActorAction>() {
		public int compare(ActorAction a, ActorAction b) {
			return a.getPriority()-b.getPriority();
		}
	});
	
	Integer playerIndex = null;

	public ViewBattle(Profile profile, EnemyActor[] enemies) {
		initWidget(uiBinder.createAndBindUi(this));
		playerStats.resizeRows(7);
		
		this.profile = profile;
		this.party = profile.getParty();
		this.enemies = enemies;
		next();
	}
	
	private void next() {
		if (playerIndex == null) {
			ActorAction action = actionQueue.poll();
			if (action != null) {
				updateAction(action);
			} else {
				playerIndex = 0;
				updateTurn();
			}
		} else if (playerIndex+1 < party.length) {
			playerIndex += 1;
			if (party[playerIndex].getStatusClass() != Corpse.class) {
				updateTurn();
			} else {
				next();
			}
		} else {
			playerIndex = null;
			HazardAi.ActionReciever reciever = new HazardAi.ActionReciever() {
				@Override
				public void apply(ActorAction action) {
					actionQueue.add(action);
				}
			};
			
			for (EnemyActor actor : enemies) {
				new BattleAi(actor, enemies, party, reciever);
			}
			next();
		}
	}
	
	private void updateGeneral() {
		info.setVisible(true);
		hide.setVisible(false);
		dispell.setVisible(false);
		
		console.clear();
		enemyStats.clear();
		for (EnemyActor enemy : enemies) {
			enemyStats.add(new Label(enemy.getName()));
		}
		for (int count=0; count<party.length; count += 1) {
			PlayerActor actor = party[count];
			playerStats.setWidget(count+1, 0, new Label(actor.getName()));
			String buildText;
			if (actor.getStatusClass().equals(Healthy.class)) {
				buildText = actor.getDescription();
			} else {
				buildText = actor.getStatusName();
			}
			playerStats.setWidget(count+1, 1, new Label(buildText));
			playerStats.setWidget(count+1, 2, new Label(actor.getHealth()+"/"+actor.getMaxHealth()));
		}
		party = profile.getParty();
	}
	
	private void updateTurn() {
		updateGeneral();
		final PlayerActor actor = party[playerIndex];
		playerName.setText(1+playerIndex+". "+actor.getName());
		
		if (actor.getJobName() == "Spy") { hide.setVisible(true); }
		if (actor.getJobName() == "Priest" || actor.getJobName() == "Templar") { dispell.setVisible(true); }
		equipmentMenu.clear();
		Hyperlink weaponLink = new Hyperlink();
		equipmentMenu.add(weaponLink);
		weaponLink.setText(actor.getHand().getName());
		weaponLink.addHandler(new ClickHandler() {
			public void onClick(ClickEvent e) {
				actor.getHand().select(ViewBattle.this);
			}
		}, ClickEvent.getType());
		for (final Utility utility : actor.getEquippedUtilities()) {
			Hyperlink utilityLink = new Hyperlink();
			utilityLink.setText(utility.getName());
			utilityLink.addHandler(new ClickHandler() {
				public void onClick(ClickEvent e) {
					utility.select(ViewBattle.this);
				}
			}, ClickEvent.getType());
		}
		//equip queue
		//spells
	}
	
	private void updateAction(ActorAction action) {
		String[] descriptions = action.apply();
		updateGeneral();
		info.setVisible(false);
		for (String description : descriptions) {
			console.add(new Label(description));
		}
		Hyperlink next = new Hyperlink();
		next.setText("continue");
		next.addHandler(new ClickHandler() {
			public void onClick(ClickEvent e) {
				next();
			}
		}, ClickEvent.getType());
		console.add(next);
	}
	
	private void selectSections(final Actor source, final Actor[][] targetSections, final Behavior behavior) {
		console.clear();
		for (final Actor[] targetSection : targetSections) {
			String targetString = "> ";
			for (Actor target : targetSection) {
				targetString = targetString.concat(target.getName()+" ");
			}
			Hyperlink targetOption = new Hyperlink();
			targetOption.setText(targetString);
			targetOption.addHandler(new ClickHandler() {
				public void onClick(ClickEvent e) {
					ViewBattle.this.actionQueue.add(new ActorAction(source, targetSection, behavior));
					next();
				}
			}, ClickEvent.getType());
			console.add(targetOption);
		}
	}
	
	@UiHandler("back")
	void onClickTurnBack(ClickEvent e) {
		playerIndex -= 1;
		//TODO: remove action from queue
		updateTurn();
	}
	
	public void selectBack() {
		info.setVisible(false); // target choice code always goes through here.
		Hyperlink back = new Hyperlink();
		back.setText("back");
		back.addHandler(new ClickHandler() {
			public void onClick(ClickEvent e) {
				updateTurn();
			}
		}, ClickEvent.getType());
		console.add(back);
	}
	
	public void selectOpposition(final Behavior behavior, TargetFilter filter) {
		Actor source = party[playerIndex];
		Actor[][] targetSections = filter.filter(source, enemies);
		selectSections(source, targetSections, behavior);
		selectBack();
	}
	
	public void selectAllies(final Behavior behavior, TargetFilter filter) {
		Actor source = party[playerIndex];
		Actor[][] targetSections = filter.filter(source, party);
		selectSections(source, targetSections, behavior);
		selectBack();
	}
}
