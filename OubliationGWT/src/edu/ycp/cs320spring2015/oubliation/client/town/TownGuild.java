/**
 * 
 */
package edu.ycp.cs320spring2015.oubliation.client.town;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

import edu.ycp.cs320spring2015.oubliation.shared.Profile;
import edu.ycp.cs320spring2015.oubliation.shared.actor.player.PlayerActor;

/**
 * View of guild with party management features
 *
 */
public class TownGuild extends Composite{
	//TODO: Only allows you to remove actors, not add them
	private static ViewGuildUiBinder uiBinder = GWT
			.create(ViewGuildUiBinder.class);

	interface ViewGuildUiBinder extends UiBinder<Widget, TownGuild> {
	}
	
	@UiField FlowPanel party;
	@UiField FlowPanel guild;
	
	final Profile profile;
	
	public TownGuild(Profile profile) {
		initWidget(uiBinder.createAndBindUi(this));
		this.profile = profile;
		update();
	}
	
	/**
	 * updates UI to encompass changes to the party & roster
	 */
	private void update() {
		PlayerActor partyArr[] = profile.getParty();
		PlayerActor rosterArr[] = profile.getRoster();
		
		party.clear();
		guild.clear();
		
		for(final PlayerActor partyMember : partyArr){
			Button button = new Button(partyMember.getName());
			button.addClickHandler(new ClickHandler() { public void onClick(ClickEvent e) {
				profile.removeActor(partyMember);
				update();
			}});
			party.add(button); 
		}		
		for(final PlayerActor guildMember : rosterArr){
			Button button = new Button(guildMember.getName());
			button.addClickHandler(new ClickHandler() {public void onClick(ClickEvent e) {
				if (!profile.hasMaxParty()) {
					profile.addActor(guildMember);
					update();
				}
			}});
			guild.add(button);
		}
	}
	
//	@UiField
//	Button button;
//
//	public ViewGuild(String firstName) {
//		initWidget(uiBinder.createAndBindUi(this));
//
//		// Can access @UiField after calling createAndBindUi
//		button.setText(firstName);
//	}
//
//	@UiHandler("button")
//	void onClick(ClickEvent e) {
//		Window.alert("Hello!");
//	}
//
//	public void setText(String text) {
//		button.setText(text);
//	}
//
//	/**
//	 * Gets invoked when the default constructor is called
//	 * and a string is provided in the ui.xml file.
//	 */
//	
//	public String getText() {
//		return button.getText();
//	}
//	
}
