/**
 * 
 */
package edu.ycp.cs320spring2015.oubliation.client;

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
 * @author Brandon Miller
 *
 */
public class ViewGuild extends Composite{
	//TODO: Only allows you to remove actors, not add them
	private static ViewGuildUiBinder uiBinder = GWT
			.create(ViewGuildUiBinder.class);

	interface ViewGuildUiBinder extends UiBinder<Widget, ViewGuild> {
	}
	
	/**
	 * Because this class has a default constructor, it can
	 * be used as a binder template. In other words, it can be used in other
	 * *.ui.xml files as follows:
	 * <ui:UiBinder xmlns:ui="urn:ui:com.google.gwt.uibinder"
	 *   xmlns:g="urn:import:**user's package**">
	 *  <g:**UserClassName**>Hello!</g:**UserClassName>
	 * </ui:UiBinder>
	 * Note that depending on the widget that is used, it may be necessary to
	 * implement HasHTML instead of HasText.
	 */
	@UiField FlowPanel party;
	@UiField FlowPanel guild;
	
	Profile profile;
	
	public ViewGuild(Profile profile) {
		initWidget(uiBinder.createAndBindUi(this));
		this.profile = profile;
		update();
	}
	
	private void update() {
		PlayerActor partyArr[] = profile.getParty();
		PlayerActor rosterArr[] = profile.getRoster();
		
		party.clear();
		guild.clear();
		
		for(final PlayerActor partyMember : partyArr){
			Button button = new Button(partyMember.getName());
			button.addClickHandler(new ClickHandler() {public void onClick(ClickEvent e) { profile.removeActor(partyMember); update();}});
			party.add(button); 
		}		
		for(final PlayerActor guildMember : rosterArr){
			Button button = new Button(guildMember.getName());
			button.addClickHandler(new ClickHandler() {public void onClick(ClickEvent e) { if (!profile.hasMaxParty()) profile.addActor(guildMember); update();}});
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
