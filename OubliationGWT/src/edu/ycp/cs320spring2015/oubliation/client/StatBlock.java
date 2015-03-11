package edu.ycp.cs320spring2015.oubliation.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

import edu.ycp.cs320spring2015.oubliation.shared.Entity;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.BruceScore;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.PlayerActor;
import edu.ycp.cs320spring2015.oubliation.shared.effect.Utility;

public class StatBlock extends Composite {

	private static ViewStatsUiBinder uiBinder = GWT
			.create(ViewStatsUiBinder.class);

	interface ViewStatsUiBinder extends UiBinder<Widget, StatBlock> {
	}
	
	@UiField Label health;
	@UiField Label armorRank;
	@UiField Label experience;
	
	@UiField Label witchA;
	@UiField Label witchB;
	@UiField Label witchC;
	@UiField Label witchD;
	@UiField Label witchE;
	@UiField Label witchF;
	@UiField Label priestA;
	@UiField Label priestB;
	@UiField Label priestC;
	@UiField Label priestD;
	@UiField Label priestE;
	@UiField Label priestF;
	
	@UiField Label name;
	@UiField Label description;
	@UiField Label hand;
	@UiField Label headwear;
	@UiField Label suit;
	@UiField Label shield;
	@UiField Label itemA;
	@UiField Label itemB;
	@UiField Label itemC;
	
	@UiField Label mightily;
	@UiField Label healthily;
	@UiField Label intelligently;
	@UiField Label godly;
	@UiField Label quickly;
	@UiField Label luckily;
	
	final NumberFormat twoDigit = NumberFormat.getFormat("00");
	
	public StatBlock(PlayerActor actor) {
		initWidget(uiBinder.createAndBindUi(this));
		
		name.setText(actor.getName());
		description.setText("Level "+actor.getLevel()+" "+actor.getSpeciesName()+" "+actor.getJobName()+" "+actor.getBackgroundName());
		
		health.setText(getNumOfMax(actor.getHealth(), actor.getMaxHealth()));
		armorRank.setText("-"+actor.getArmorRank());
		experience.setText(Integer.toString(actor.getExperience()));
		
		witchA.setText(getNumOfMax(actor.getWitchMp(1), actor.getMaxWitchMp(1)));
		witchB.setText(getNumOfMax(actor.getWitchMp(2), actor.getMaxWitchMp(2)));
		witchC.setText(getNumOfMax(actor.getWitchMp(3), actor.getMaxWitchMp(3)));
		witchD.setText(getNumOfMax(actor.getWitchMp(4), actor.getMaxWitchMp(4)));
		witchE.setText(getNumOfMax(actor.getWitchMp(5), actor.getMaxWitchMp(5)));
		witchF.setText(getNumOfMax(actor.getWitchMp(6), actor.getMaxWitchMp(6)));
		priestA.setText(getNumOfMax(actor.getPriestMp(1), actor.getMaxPriestMp(1)));
		priestB.setText(getNumOfMax(actor.getPriestMp(2), actor.getMaxPriestMp(2)));
		priestC.setText(getNumOfMax(actor.getPriestMp(3), actor.getMaxPriestMp(3)));
		priestD.setText(getNumOfMax(actor.getPriestMp(4), actor.getMaxPriestMp(4)));
		priestE.setText(getNumOfMax(actor.getPriestMp(5), actor.getMaxPriestMp(5)));
		priestF.setText(getNumOfMax(actor.getPriestMp(6), actor.getMaxPriestMp(6)));
		
		hand.setText(getNameSafely(actor.getHand()));
		headwear.setText(getNameSafely(actor.getHeadwear()));
		suit.setText(getNameSafely(actor.getSuit()));
		shield.setText(getNameSafely(actor.getShield()));
		
		Utility[] items = actor.getEquippedUtilities();
		if (items.length >= 1) {
			itemA.setText(items[0].getName());
		} else {
			itemA.setText("--");
		}

		if (items.length >= 2) {
			itemB.setText(items[1].getName());
		} else {
			itemB.setText("--");
		}

		if (items.length >= 3) {
			itemC.setText(items[2].getName());
		} else {
			itemC.setText("--");
		}
		
		mightily.setText(twoDigit.format(actor.getScore(BruceScore.mightily)));
		healthily.setText(twoDigit.format(actor.getScore(BruceScore.healthily)));
		intelligently.setText(twoDigit.format(actor.getScore(BruceScore.intelligently)));
		godly.setText(twoDigit.format(actor.getScore(BruceScore.godly)));
		quickly.setText(twoDigit.format(actor.getScore(BruceScore.quickly)));
		luckily.setText(twoDigit.format(actor.getScore(BruceScore.luckily)));
	}
	
	private String getNumOfMax(int num, int max) {
		return twoDigit.format(num) +"/"+ twoDigit.format(max);
	}
	
	private String getNameSafely(Entity entity) {
		if (entity != null) {
			return entity.getName();
		} else {
			return "--";
		}
	}
}
