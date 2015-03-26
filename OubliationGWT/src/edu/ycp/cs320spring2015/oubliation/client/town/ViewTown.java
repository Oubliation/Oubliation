package edu.ycp.cs320spring2015.oubliation.client.town;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import edu.ycp.cs320spring2015.oubliation.shared.Profile;

/**
 * Displays controls for navigating the town
 *
 */
public class ViewTown extends Composite {

	private static OutskirtsUiBinder uiBinder = GWT
			.create(OutskirtsUiBinder.class);

	interface OutskirtsUiBinder extends UiBinder<Widget, ViewTown> {
	}
	
	@UiField FlowPanel body;
	@UiField Hyperlink exit;
	
	String outskirtsHeader = "Welcome to the town outskirts";
	String returnExit = "Return to the town outskirts";
	String dungeonExit = "Enter the Oubliette";
	
	private Label outskirts = new Label(outskirtsHeader);
	private final Profile profile;
	private Widget location;

	public ViewTown(Profile profile) {
		initWidget(uiBinder.createAndBindUi(this));
		this.profile = profile;
		enterOutskirts();
	}
	
	@UiHandler("stats")
	void onClickViewStats(ClickEvent e) {
		this.setVisible(false);
		RootPanel.get("gwtapp").add(new ViewStats(profile.getParty(), this));
	}
	
	@UiHandler("guild")
	void onClickGuild(ClickEvent e) {
		enterLocation(new TownGuild(profile));
	}

	private void enterLocation(Widget destination) {
		if (location != null) {
			location.removeFromParent();
		}
		location = destination;
		outskirts.removeFromParent();
		exit.setText(returnExit);
		body.add(location);
	}
	
	private void enterOutskirts() {
		location = null;
		exit.setText(dungeonExit);
		body.add(outskirts);
	}
	
	@UiHandler("exit")
	void onClickExit(ClickEvent e) {
		if (location != null) {
			body.remove(location);
			enterOutskirts();
		} else {
			//enter the dungeon
		}
	}
	
}
