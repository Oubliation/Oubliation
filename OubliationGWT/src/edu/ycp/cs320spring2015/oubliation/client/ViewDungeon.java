package edu.ycp.cs320spring2015.oubliation.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

import edu.ycp.cs320spring2015.oubliation.shared.Profile;
import edu.ycp.cs320spring2015.oubliation.shared.location.Dungeon;
import edu.ycp.cs320spring2015.oubliation.shared.location.Ordinal;

/**
 * 
 * Provides first person view of dungeon and controls for navigating it.  
 *
 */
public class ViewDungeon extends Composite {

	private static ViewDungeonUiBinder uiBinder = GWT
			.create(ViewDungeonUiBinder.class);

	interface ViewDungeonUiBinder extends UiBinder<Widget, ViewDungeon> {
	}
	
	@UiField Label dungeonLvl;
	
	@UiField(provided = true) Canvas canvas; //canvas HTML object
	private final Context2d context; //Canvas 2d drawing context
	private final Profile profile;
	private final Dungeon dungeon; //dungeon model

	public ViewDungeon(Profile profile) {
		canvas = Canvas.createIfSupported();
		initWidget(uiBinder.createAndBindUi(this));
		
		this.profile = profile;
		dungeon = new Dungeon(0);
		context = canvas.getContext2d();
		dungeonLvl.setText("You are on dungeon level " + Integer.toString(dungeon.getLevel()));
	}
	
	@UiHandler("Forward")
	void onClickForward() {
		dungeon.move(Ordinal.forward, profile);
	}
	
	@UiHandler("Backward")
	void onClickBackward() {
		dungeon.move(Ordinal.backward, profile);
	}
	
	@UiHandler("Left")
	void onClickLeft() {
		dungeon.move(Ordinal.left, profile);
	}
	
	@UiHandler("Right")
	void onClickRight() {
		dungeon.move(Ordinal.right, profile);
	}
	
	
	/**
	 * renders current dungeon view to context
	 */
	private void renderDungeon() {
	}
}
