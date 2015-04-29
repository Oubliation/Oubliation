package edu.ycp.cs320spring2015.oubliation.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import edu.ycp.cs320spring2015.oubliation.client.town.ViewTown;
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
	
	@UiField Label error;
	
	@UiField Label dungeonLvl;
	@UiField Label cardinalDirection;
	@UiField FlowPanel canvasPanel;
	
	private final Canvas canvas; //canvas HTML object
	private final Context2d context; //Canvas 2d drawing context
	private final Profile profile;
	private final Dungeon dungeon; //dungeon model
	private final double tileSize = 7.5;
		
	public ViewDungeon(Profile profile) {
		initWidget(uiBinder.createAndBindUi(this));
		
		this.profile = profile;
		dungeon = new Dungeon(0);
		canvas = Canvas.createIfSupported();
		context = canvas.getContext2d();
		canvasPanel.add(canvas);
		renderDungeon();
	}
	
	/**
	 * Move forward!
	 * @param e
	 */
	@UiHandler("Forward")
	void onClickForward(ClickEvent e) {
		if(dungeon.getRelTile(1, 0).isToOutskirts()){enterOutskirts();}
		else if(!dungeon.getRelTile(1, 0).isSolid()){dungeon.move(Ordinal.forward, profile);}
		
		renderDungeon();
	}
	
	/**
	 *  Move backward!
	 * @param e
	 */
	@UiHandler("Backward")
	void onClickBackward(ClickEvent e) {
		if(dungeon.getRelTile(-1, 0).isToOutskirts()){enterOutskirts();}
		if(!dungeon.getRelTile(-1, 0).isSolid()){dungeon.move(Ordinal.backward, profile);}
		renderDungeon();
	}
	
	/**
	 * Turn left!
	 * @param e
	 */
	@UiHandler("Left")
	void onClickLeft(ClickEvent e) {
		dungeon.move(Ordinal.left, profile);
		renderDungeon();
	}
	
	/**
	 * Turn right!
	 * @param e
	 */
	@UiHandler("Right")
	void onClickRight(ClickEvent e) {
		dungeon.move(Ordinal.right, profile);
		renderDungeon();
	}	
	
	private void enterOutskirts() {
		this.removeFromParent();
		RootPanel.get("gwtapp").add(new ViewTown(profile));
	}
	
	/**
	 * renders current dungeon view to context
	 */
	private void renderDungeon() {
		dungeonLvl.setText("You are on dungeon level " + Integer.toString(dungeon.getLevel())); // level you are on
		cardinalDirection.setText("You are facing " + dungeon.getFacing() + "."); // compass facing
		context.rect(0, 0, canvas.getCoordinateSpaceWidth(), canvas.getCoordinateSpaceHeight());
		// TODO: change to use the floor method
//		for(int i = 0; i < dungeon.getMap().length; i++){
//			for(int j = 0; j < dungeon.getMap()[i].length; j++){				
//				if(i == dungeon.getPlayerX() && j == dungeon.getPlayerY()){context.setFillStyle("#FFFC00");} // player position
//				else if(dungeon.getMap()[i][j].isToOutskirts()){context.setFillStyle("#00FF00");}  // back to town; doesn't work now, renders as no wall
//				else if(dungeon.getMap()[i][j].isSolid()){context.setFillStyle("#FF0000");} // wall
//				else if(!dungeon.getMap()[i][j].isSolid()){context.setFillStyle("#0026FF");} // no wall
//				context.fillRect(i*tileSize, j*tileSize, tileSize, tileSize);
//				
//			}
//		}		
	}
}

