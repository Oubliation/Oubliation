package edu.ycp.cs320spring2015.oubliation.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class ViewStats extends Composite {

	private static ViewStatsUiBinder uiBinder = GWT
			.create(ViewStatsUiBinder.class);

	interface ViewStatsUiBinder extends UiBinder<Widget, ViewStats> {
	}
	
	@UiField Label name;
	@UiField Label description;
	@UiField Label hand;
	@UiField Label helm;
	@UiField Label suit;
	@UiField Label shield;
	
	public ViewStats() {
		initWidget(uiBinder.createAndBindUi(this));
		name.setText("Garglemouth");
		description.setText("Lookit this thing.");
		hand.setText("Sword");
		helm.setText("Hood");
		suit.setText("Plate Mail");
		shield.setText("Dragon Shield");
	}


	@UiHandler("name")
	void onClick(ClickEvent e) {
		Window.alert("Hello!");
	}

}
