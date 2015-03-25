package edu.ycp.cs320spring2015.oubliation.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

import edu.ycp.cs320spring2015.oubliation.shared.actor.player.PlayerActor;

public class ViewStats extends Composite {

	private static ViewStatsUiBinder uiBinder = GWT
			.create(ViewStatsUiBinder.class);

	interface ViewStatsUiBinder extends UiBinder<Widget, ViewStats> {
	}
	
	@UiField FlowPanel statContainer;
	
	final Widget previousScreen;
	
	public ViewStats(PlayerActor[] party, Widget currentScreen) {
		initWidget(uiBinder.createAndBindUi(this));
		this.previousScreen = currentScreen;
		
		for (PlayerActor actor : party) {
			StatBlock stats = new StatBlock(actor);
			statContainer.add(stats);
		}
	}

	@UiHandler("backLink")
	void onClick(ClickEvent e) {
		this.removeFromParent();
		previousScreen.setVisible(true);
	}

}
