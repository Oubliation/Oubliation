package edu.ycp.cs320spring2015.oubliation.client.town;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityResourceMap;
import edu.ycp.cs320spring2015.oubliation.client.transfer.overlays.PlayerBackgroundOverlay;
import edu.ycp.cs320spring2015.oubliation.client.transfer.overlays.PlayerJobOverlay;
import edu.ycp.cs320spring2015.oubliation.client.transfer.overlays.PlayerSpeciesOverlay;
import edu.ycp.cs320spring2015.oubliation.shared.NameTag;
import edu.ycp.cs320spring2015.oubliation.shared.actor.Loadout;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.BruceScore;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.PlayerActor;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.PlayerIdentity;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.PlayerStats;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.PlayerBackground;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.PlayerJob;
import edu.ycp.cs320spring2015.oubliation.shared.category.identity.PlayerSpecies;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Utility;
import edu.ycp.cs320spring2015.oubliation.shared.transfer.StatusMemento;

public class TownRecruit extends Composite {

	private static TownRecruitUiBinder uiBinder = GWT
			.create(TownRecruitUiBinder.class);

	interface TownRecruitUiBinder extends UiBinder<Widget, TownRecruit> {
	}
	
	@UiField Label error;
	@UiField FlowPanel namePanel;
	@UiField TextBox name;
	@UiField FlowPanel gender;
	@UiField FlowPanel backgrounds;
	@UiField FlowPanel species;
	@UiField FlowPanel scores;
	@UiField Label points;
	@UiField FlowPanel jobs;
	
	private Map<String, PlayerJob> jobMap;
	private Map<String, PlayerBackground> backgroundMap;
	private Map<String, PlayerSpecies> speciesMap;

	private PlayerBackground chosenBackground;
	private PlayerSpecies chosenSpecies;
	private EnumMap<BruceScore, Integer> chosenScores = new EnumMap<BruceScore, Integer>(BruceScore.class);
	
	final private int maxPoints = 10; 
	private int pointsRemaining = maxPoints;
	
	final private ViewTown view;
	
	public TownRecruit(ViewTown view) {
		initWidget(uiBinder.createAndBindUi(this));
		this.view = view;
		for (BruceScore score : BruceScore.values()) {
			chosenScores.put(score, 0);
		}
		
		AsyncCallback<EntityResourceMap<PlayerBackgroundOverlay>> backgroundCallback = new AsyncCallback<EntityResourceMap<PlayerBackgroundOverlay>>() {
			public void onSuccess(EntityResourceMap<PlayerBackgroundOverlay> map) {
				backgroundMap = PlayerBackgroundOverlay.remapBackgrounds(map);
				tryStart();
			}
			
			public void onFailure(Throwable caught) {
				error.setText(caught.getMessage());
			}
		};
		AsyncCallback<EntityResourceMap<PlayerSpeciesOverlay>> speciesCallback = new AsyncCallback<EntityResourceMap<PlayerSpeciesOverlay>>() {
			public void onSuccess(EntityResourceMap<PlayerSpeciesOverlay> map) {
				speciesMap = PlayerSpeciesOverlay.remapSpecies(map);
				tryStart();
			}
			
			public void onFailure(Throwable caught) {
				error.setText(caught.getMessage());
			}
		};
		AsyncCallback<EntityResourceMap<PlayerJobOverlay>> jobCallback = new AsyncCallback<EntityResourceMap<PlayerJobOverlay>>() {
			public void onSuccess(EntityResourceMap<PlayerJobOverlay> map) {
				jobMap = PlayerJobOverlay.remapJobs(map);
				tryStart();
			}
			
			public void onFailure(Throwable caught) {
				error.setText(caught.getMessage());
			}
		};
		new PlayerBackgroundOverlay.ResourceMap(new String[] {"/data/player_background.json"}, backgroundCallback);
		new PlayerSpeciesOverlay.ResourceMap(new String[] {"/data/player_species.json"}, speciesCallback);
		new PlayerJobOverlay.ResourceMap(new String[] {"/data/player_job.json"}, jobCallback);
		
	}
	
	public void tryStart() {
		if (backgroundMap != null && speciesMap != null && jobMap != null) {
			start();
		}
	}
	
	public void start() {
		scores.setVisible(false);
		jobs.setVisible(false);
		for (final PlayerBackground backgroundId : backgroundMap.values()) {
			RadioButton button = new RadioButton("background", backgroundId.getName());
			button.addHandler(new ValueChangeHandler<Boolean>() {
				public void onValueChange(ValueChangeEvent<Boolean> e) {
					chosenBackground = backgroundId;
					update();
				}
			}, ValueChangeEvent.getType());
			backgrounds.add(button);
		}
		for (final PlayerSpecies speciesId : speciesMap.values()) {
			RadioButton button = new RadioButton("species", speciesId.getName());
			button.addHandler(new ValueChangeHandler<Boolean>() {
				public void onValueChange(ValueChangeEvent<Boolean> e) {
					chosenSpecies = speciesId;
					update();
				}
			}, ValueChangeEvent.getType());
			species.add(button);
		}
		update();
	}
	
	public void update() {
		if (name.getText() == "" || chosenBackground == null || chosenSpecies == null) {
			scores.setVisible(false);
			jobs.setVisible(false);
		} else {
			scores.setVisible(true);
			jobs.setVisible(true);
			
			scores.clear();
			for (final BruceScore score : BruceScore.values()) {
				scores.add(new Label(score.name()+": "));
				Button minus = new Button("-");
				Button plus = new Button("+");
				minus.addHandler(new ClickHandler() {
					public void onClick(ClickEvent e) {
						if (pointsRemaining < maxPoints) {
							pointsRemaining += 1;
							chosenScores.put(score, chosenScores.get(score)-1);
							update();
						}
					}
				}, ClickEvent.getType());
				plus.addHandler(new ClickHandler() {
					public void onClick(ClickEvent e) {
						if (pointsRemaining > 0) {
							pointsRemaining -= 1;
							chosenScores.put(score, chosenScores.get(score)+1);
							update();
						}
					}
				}, ClickEvent.getType());
				
				scores.add(minus);
				scores.add(new Label(String.valueOf(chosenSpecies.getBaseScore(score)+chosenScores.get(score))));
				scores.add(plus);
			}
			
			points.setText(String.valueOf(pointsRemaining));
			jobs.clear();
			for (final PlayerJob job : jobMap.values()) {
				for (BruceScore score : BruceScore.values()) {
					if (chosenBackground.isCompatibleJob(job) && job.meetsRequirement(score,
							chosenSpecies.getBaseScore(score)+chosenScores.get(score))) {
						Hyperlink jobLink = new Hyperlink();
						jobLink.setText(job.getName());

						jobLink.addHandler(new ClickHandler() {
							public void onClick(ClickEvent e) {
								NameTag nameTag = new NameTag(name.getText(), "Player controlled actor");
								StatusMemento status = new StatusMemento("Healthy");
								Loadout loadout = new Loadout(null, null, null, null, new ArrayList<Utility>());
								PlayerIdentity identity = new PlayerIdentity(chosenBackground, chosenSpecies, job, 1, 0);
								int[] witchMp = {0, 0, 0, 0, 0, 0};
								int[] priestMp = {0, 0, 0, 0, 0, 0};
								PlayerStats stats = new PlayerStats(new ArrayList<Utility>(), chosenScores, witchMp, priestMp);
								view.getProfile().createActor(new PlayerActor(nameTag, identity.getMaxHealth(), status, loadout, identity, stats));
								
								view.enterLocation(new TownGuild(view));
							}
						}, ClickEvent.getType());
						jobs.add(jobLink);
					} else {
						jobs.add( new Label(job.getName()) );
					}
				}
			}
		}
		
	}

	@UiHandler("back")
	void onClickBack(ClickEvent e) {
		view.enterLocation(new TownGuild(view));
	}
}
