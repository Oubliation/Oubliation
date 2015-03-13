package edu.ycp.cs320spring2015.oubliation.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import edu.ycp.cs320spring2015.oubliation.shared.actor.player.Profile;

public class ViewOutskirts extends Composite {

	private static OutskirtsUiBinder uiBinder = GWT
			.create(OutskirtsUiBinder.class);

	interface OutskirtsUiBinder extends UiBinder<Widget, ViewOutskirts> {
	}
	
	Profile profile;

	public ViewOutskirts(Profile profile) {
		initWidget(uiBinder.createAndBindUi(this));
		this.profile = profile;
	}

	public ViewOutskirts(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@UiHandler("stats")
	void onClick(ClickEvent e) {
		this.setVisible(false);
		RootPanel.get("gwtapp").add(new ViewStats(profile.getParty(), this));
	}
}
