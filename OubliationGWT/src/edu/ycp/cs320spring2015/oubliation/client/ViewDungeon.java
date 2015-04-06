package edu.ycp.cs320spring2015.oubliation.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
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
	@UiField FlowPanel canvasPanel;
	
	private final Canvas canvas; //canvas HTML object
	private final Context2d context; //Canvas 2d drawing context
	private final Profile profile;
	private final Dungeon dungeon; //dungeon model
	private final int tileSize = 10;

	public ViewDungeon(Profile profile) {
		initWidget(uiBinder.createAndBindUi(this));
		
		this.profile = profile;
		dungeon = new Dungeon(0);
		canvas = Canvas.createIfSupported();
		//canvasPanel.setHeight("400px");
		//canvasPanel.setWidth("800px");
		context = canvas.getContext2d();
		canvasPanel.add(canvas);
		renderDungeon();
	}
	
	@UiHandler("Forward")
	void onClickForward(ClickEvent e) {
		dungeon.move(Ordinal.forward, profile);
	}
	
	@UiHandler("Backward")
	void onClickBackward(ClickEvent e) {
		dungeon.move(Ordinal.backward, profile);
	}
	
	@UiHandler("Left")
	void onClickLeft(ClickEvent e) {
		dungeon.move(Ordinal.left, profile);
	}
	
	@UiHandler("Right")
	void onClickRight(ClickEvent e) {
		dungeon.move(Ordinal.right, profile);
	}
	
	
	/**
	 * renders current dungeon view to context
	 */
	private void renderDungeon() {
		dungeonLvl.setText("You are on dungeon level " + Integer.toString(dungeon.getLevel()));
		
		context.rect(0, 0, canvas.getCoordinateSpaceWidth(), canvas.getCoordinateSpaceHeight());
		for(int i = 0; i < dungeon.getMap().length; i++){
			for(int j = 0; j < dungeon.getMap()[i].length; j++){
				if(i == dungeon.getPlayerX() && j == dungeon.getPlayerY()){context.setFillStyle("0xFFFC00");}
				else if(dungeon.getMap()[i][j].isSolid() == true){context.setFillStyle("0xFF0000");}
				else if(dungeon.getMap()[i][j].isSolid() == true){context.setFillStyle("0x0026FF");}
				context.fillRect(i*tileSize, j*tileSize, tileSize, tileSize);
			}
		}
	}
}
