package edu.ycp.cs320spring2015.oubliation.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

import edu.ycp.cs320spring2015.oubliation.shared.actor.player.PlayerActor;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.Profile;

public class ViewStats extends Composite {

	private static ViewStatsUiBinder uiBinder = GWT
			.create(ViewStatsUiBinder.class);

	interface ViewStatsUiBinder extends UiBinder<Widget, ViewStats> {
	}
	
	@UiField FlowPanel statContainer;
	
	public ViewStats() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public void setProfile(Profile profile) {
		
		for (PlayerActor actor : profile.getParty()) {
			StatBlock stats = new StatBlock();
			stats.setActor(actor);
			statContainer.add(stats);
		}
	}

	@UiHandler("backLink")
	void onClick(ClickEvent e) {
		Window.alert("Hello!");
	}

}
