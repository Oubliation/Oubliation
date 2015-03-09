package edu.ycp.cs320spring2015.oubliation.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

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
	@UiField Label helmet;
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
	
	public StatBlock() {
		initWidget(uiBinder.createAndBindUi(this));
		name.setText("Garglemouth");
		description.setText("Level 5 Fairy Witch Scholar");
		health.setText("20/20");
		armorRank.setText("-4");
		experience.setText("12115");
		
		witchA.setText("20/20");
		witchB.setText("16/16");
		witchC.setText("08/08");
		witchD.setText("04/04");
		witchE.setText("02/02");
		witchF.setText("01/01");
		priestA.setText("20/20");
		priestB.setText("16/16");
		priestC.setText("08/08");
		priestD.setText("04/04");
		priestE.setText("02/02");
		priestF.setText("01/01");
		
		hand.setText("Sword");
		helmet.setText("Hood");
		suit.setText("Plate Mail");
		shield.setText("Dragon Shield");
		itemA.setText("Potion");
		itemB.setText("Fire Scroll");
		itemC.setText("Potion");
		
		mightily.setText("05");
		healthily.setText("07");
		intelligently.setText("04");
		godly.setText("03");
		quickly.setText("11");
		luckily.setText("09");
	}
}
