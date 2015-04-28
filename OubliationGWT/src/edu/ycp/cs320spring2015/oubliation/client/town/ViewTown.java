package edu.ycp.cs320spring2015.oubliation.client.town;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import edu.ycp.cs320spring2015.oubliation.client.Login;
import edu.ycp.cs320spring2015.oubliation.client.Oubliation;
import edu.ycp.cs320spring2015.oubliation.client.ViewDungeon;
import edu.ycp.cs320spring2015.oubliation.client.ViewStats;
import edu.ycp.cs320spring2015.oubliation.shared.Profile;

/**
 * Displays controls for navigating the town
 *
 */
public class ViewTown extends Composite {

	private static ViewTownUiBinder uiBinder = GWT
			.create(ViewTownUiBinder.class);

	interface ViewTownUiBinder extends UiBinder<Widget, ViewTown> {
	}
	
	@UiField FlowPanel body;
	@UiField Hyperlink exit;
	@UiField Label error;
	
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
		enterLocation(new TownGuild(this));
	}
	
	@UiHandler("barracks")
	void onClickBarracks(ClickEvent e) {
		enterLocation(new TownBarracks(this));
	}

	public void enterLocation(Widget destination) {
		if (location != null) {
			location.removeFromParent();
		}
		location = destination;
		saveGame();
		
		outskirts.removeFromParent();
		exit.setText(returnExit);
		body.add(location);
	}
	
	private void enterOutskirts() {
		location = null;
		
		saveGame();
		exit.setText(dungeonExit);
		body.add(outskirts);
	}
	
	public Profile getProfile() {
		return profile;
	}
	
	private void saveGame() {
		AsyncCallback<Void> callback = new AsyncCallback<Void>() {
			public void onSuccess(Void _) {}
			
			public void onFailure(Throwable caught) {
				error.setText("Error: couldn't save data");
			}
		 };
		Oubliation.getDataKeeper().saveProfile(profile.getUsername(), profile.getTransferData(), callback);
	}
	
	@UiHandler("exit")
	void onClickExit(ClickEvent e) {
		if (location != null) {
			body.remove(location);
			enterOutskirts();
		} else {
			//enter the dungeon
			this.removeFromParent();
			RootPanel.get("gwtapp").add(new ViewDungeon(profile));
		}
	}
	
	@UiHandler("quit")
	void onClickQuit(ClickEvent e){
		saveGame();
		this.removeFromParent();
		RootPanel.get("gwtapp").add(new Login());
	}
}
