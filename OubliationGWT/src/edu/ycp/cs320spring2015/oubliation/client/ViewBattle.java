package edu.ycp.cs320spring2015.oubliation.client;

import java.util.Arrays;
import java.util.Comparator;
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

import edu.ycp.cs320spring2015.oubliation.shared.Profile;
import edu.ycp.cs320spring2015.oubliation.shared.actor.Actor;
import edu.ycp.cs320spring2015.oubliation.shared.actor.nonplayer.EnemyActor;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.PlayerActor;
import edu.ycp.cs320spring2015.oubliation.shared.behavior.Behavior;
import edu.ycp.cs320spring2015.oubliation.shared.items.Utility;
import edu.ycp.cs320spring2015.oubliation.shared.statuses.Healthy;
import edu.ycp.cs320spring2015.oubliation.shared.targets.BattleAi;
import edu.ycp.cs320spring2015.oubliation.shared.targets.ActorAction;
import edu.ycp.cs320spring2015.oubliation.shared.targets.PartyController;

//TODO: AI, deserialization, status cleanup, startturn (etc), enemy deserialization

public class ViewBattle extends Composite implements PartyController {
	private static final long serialVersionUID = 6360195270267057410L;
	
	private static ViewBattleUiBinder uiBinder = GWT
			.create(ViewBattleUiBinder.class);

	interface ViewBattleUiBinder extends UiBinder<Widget, ViewBattle> {
	}
	
	@UiField Label info;
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
		
		this.profile = profile;
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
		} else if (playerIndex < party.length) {
			playerIndex += 1;
			updateTurn();
		} else {
			playerIndex = null;
			for (EnemyActor actor : enemies) {
				new BattleAi(actor, enemies, party, actionQueue);
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
			playerStats.setWidget(0, count, new Label(actor.getName()));
			String buildText;
			if (actor.getStatusClass().equals(Healthy.class)) {
				buildText = actor.getDescription();
			} else {
				buildText = actor.getStatusName();
			}
			playerStats.setWidget(1, count, new Label(buildText));
			playerStats.setWidget(2, count, new Label(actor.getHealth()+"/"+actor.getMaxHealth()));
		}
		party = profile.getParty();
	}
	
	private void updateTurn() {
		updateGeneral();
		final PlayerActor actor = party[playerIndex];
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

	
	
	private void selectGivenUnits(final Actor source, final Actor[] targets, final Behavior behavior) {
		console.clear();
		for (final Actor target: targets) {
			Hyperlink targetOption = new Hyperlink();
			targetOption.setText("> "+target.getName());
			targetOption.addHandler(new ClickHandler() {
				public void onClick(ClickEvent e) {
					ViewBattle.this.actionQueue.add(new ActorAction(source, new Actor[] {target}, behavior));
					next();
				}
			}, ClickEvent.getType());
			console.add(targetOption);
		}
	}
	
	private void selectGivenGroup(final Actor source, final Actor[] targets, final Behavior behavior) {
		console.clear();
		String targetString = "> ";
		for (Actor target : targets) {
			targetString = targetString.concat(target.getName()+" ");
		}
		Hyperlink targetOption = new Hyperlink();
		targetOption.setText(targetString);
		targetOption.addHandler(new ClickHandler() {
			public void onClick(ClickEvent e) {
				ViewBattle.this.actionQueue.add(new ActorAction(source, targets, behavior));
				next();
			}
		}, ClickEvent.getType());
		console.add(targetOption);
	}
	
	private void selectGivenRows(final Actor source, final Actor[] targets, final Behavior behavior) {
		console.clear();
		int numRows = (targets.length + 2) / 3;
		Actor[][] targetRows = new Actor[numRows][];
		targetRows[0] = Arrays.copyOfRange(targets, 0, targets.length);
		if (numRows == 2) {
			 targetRows[1] = Arrays.copyOfRange(targets, 3, targets.length);
		}
		for (final Actor[] targetRow : targetRows) {
			String targetString = "> ";
			for (Actor target : targetRow) {
				targetString = targetString.concat(target.getName()+" ");
			}
			Hyperlink targetOption = new Hyperlink();
			targetOption.setText(targetString);
			targetOption.addHandler(new ClickHandler() {
				public void onClick(ClickEvent e) {
					ViewBattle.this.actionQueue.add(new ActorAction(source, targetRow, behavior));
					next();
				}
			}, ClickEvent.getType());
			console.add(targetOption);
		}
	}
	
	private void selectGivenColumns(final Actor source, final Actor[] targets, final Behavior behavior) {
		console.clear();
		int numCols = Math.min(targets.length, 3);
		Actor[][] targetCols = new Actor[numCols][];
		for (int count=0; count<numCols; count+=1) {
			if (targets.length < count+4) {
				targetCols[count] = new Actor[] { targets[count] };
			} else {
				targetCols[count] = new Actor[] { targets[count], targets[count+3] };
			}
		}
		for (final Actor[] targetCol : targetCols) {
			String targetString = "> ";
			for (Actor target : targetCol) {
				targetString = targetString.concat(target.getName()+" ");
			}
			Hyperlink targetOption = new Hyperlink();
			targetOption.setText(targetString);
			targetOption.addHandler(new ClickHandler() {
				public void onClick(ClickEvent e) {
					ViewBattle.this.actionQueue.add(new ActorAction(source, targetCol, behavior));
					next();
				}
			}, ClickEvent.getType());
			console.add(targetOption);
		}
		
	}
	
	public void selectBack() {
		Hyperlink back = new Hyperlink();
		back.setText("back");
		back.addHandler(new ClickHandler() {
			public void onClick(ClickEvent e) {
				updateTurn();
			}
		}, ClickEvent.getType());
	}
	
	public void selectAnyOpposingUnits(final Behavior behavior) {
		Actor source = party[playerIndex];
		Actor[] targets = Arrays.copyOfRange(enemies, 0, enemies.length);
		selectGivenUnits(source, targets, behavior);
		selectBack();
	}

	public void selectFrontOpposingUnits(Behavior behavior) {
		Actor source = party[playerIndex];
		Actor[] targets = Arrays.copyOfRange(enemies, 0, Math.min(2, enemies.length));
		selectGivenUnits(source, targets, behavior);
		selectBack();
	}
	
	public void selectAnyOpposingRows(Behavior behavior) {
		Actor source = party[playerIndex];
		Actor[] targets = Arrays.copyOfRange(enemies, 0, enemies.length);
		selectGivenRows(source, targets, behavior);
		selectBack();
	}
	
	public void selectFrontOpposingRow(Behavior behavior) {
		Actor source = party[playerIndex];
		Actor[] targets = Arrays.copyOfRange(enemies, 0, Math.min(2, enemies.length));
		selectGivenGroup(source, targets, behavior);
		selectBack();
	}
	
	public void selectAnyOpposingColumns(Behavior behavior) {
		Actor source = party[playerIndex];
		Actor[] targets = Arrays.copyOfRange(enemies, 0, enemies.length);
		selectGivenColumns(source, targets, behavior);
		selectBack();
	}
	
	public void selectOpposingGroup(Behavior behavior) {
		Actor source = party[playerIndex];
		Actor[] targets = Arrays.copyOfRange(enemies, 0, enemies.length);
		selectGivenGroup(source, targets, behavior);
		selectBack();
	}
	
	public void selectAlliedUnits(Behavior behavior) {
		Actor source = party[playerIndex];
		Actor[] targets = Arrays.copyOfRange(party, 0, party.length);
		selectGivenUnits(source, targets, behavior);
		selectBack();
	}
	
	public void selectAlliedRows(Behavior behavior) {
		Actor source = party[playerIndex];
		Actor[] targets = Arrays.copyOfRange(party, 0, party.length);
		selectGivenRows(source, targets, behavior);
		selectBack();
	}
	
	public void selectAlliedColumns(Behavior behavior) {
		Actor source = party[playerIndex];
		Actor[] targets = Arrays.copyOfRange(party, 0, party.length);
		selectGivenColumns(source, targets, behavior);
		selectBack();
	}
	
	public void selectAlliedGroup(Behavior behavior) {
		Actor source = party[playerIndex];
		Actor[] targets = Arrays.copyOfRange(party, 0, party.length);
		selectGivenGroup(source, targets, behavior);
		selectBack();
	}
	
	public void selectSelf(Behavior behavior) {
		Actor source = party[playerIndex];
		Actor[] targets = new Actor[] {source};
		selectGivenGroup(source, targets, behavior);
		selectBack();
	}
}
