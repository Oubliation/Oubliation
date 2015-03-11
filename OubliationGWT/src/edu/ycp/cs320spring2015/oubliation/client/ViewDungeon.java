package edu.ycp.cs320spring2015.oubliation.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import edu.ycp.cs320spring2015.oubliation.shared.actor.player.Profile;
import edu.ycp.cs320spring2015.oubliation.shared.location.Dungeon;

public class ViewDungeon extends Composite {

	private static ViewDungeonUiBinder uiBinder = GWT
			.create(ViewDungeonUiBinder.class);

	interface ViewDungeonUiBinder extends UiBinder<Widget, ViewDungeon> {
	}
	
	@UiField(provided = true) Canvas canvas;
	private Context2d context;
	private Profile profile;
	private Dungeon dungeon;

	public ViewDungeon(Profile profile) {
		canvas = Canvas.createIfSupported();
		initWidget(uiBinder.createAndBindUi(this));
		this.profile = profile;
		context = canvas.getContext2d(); 
	}
	
	private void renderDungeon() {
		
	}
}
