package edu.ycp.cs320spring2015.oubliation.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import edu.ycp.cs320spring2015.oubliation.shared.Profile;

public class ViewOutskirts extends Composite {

	private static OutskirtsUiBinder uiBinder = GWT
			.create(OutskirtsUiBinder.class);

	interface OutskirtsUiBinder extends UiBinder<Widget, ViewOutskirts> {
	}
	
	final Profile profile;

	public ViewOutskirts(Profile profile) {
		initWidget(uiBinder.createAndBindUi(this));
		this.profile = profile;
	}
	
	@UiHandler("stats")
	void onClickViewStats(ClickEvent e) {
		this.setVisible(false);
		RootPanel.get("gwtapp").add(new ViewStats(profile.getParty(), this));
	}
	
	@UiHandler("guild")
	void onClickGuild(ClickEvent e) {
		this.removeFromParent();
		RootPanel.get("gwtapp").add(new ViewGuild(profile));
		
	}
	
}
