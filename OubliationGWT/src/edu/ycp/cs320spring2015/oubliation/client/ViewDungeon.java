package edu.ycp.cs320spring2015.oubliation.client;

import java.util.Map;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import edu.ycp.cs320spring2015.oubliation.client.town.ViewTown;
import edu.ycp.cs320spring2015.oubliation.client.transfer.EntityResourceMap;
import edu.ycp.cs320spring2015.oubliation.client.transfer.overlays.FloorOverlay;
import edu.ycp.cs320spring2015.oubliation.shared.Profile;
import edu.ycp.cs320spring2015.oubliation.shared.location.Dungeon;
import edu.ycp.cs320spring2015.oubliation.shared.location.Exitable;
import edu.ycp.cs320spring2015.oubliation.shared.location.Floor;
import edu.ycp.cs320spring2015.oubliation.shared.location.Ordinal;
import edu.ycp.cs320spring2015.oubliation.shared.location.Tile;

/**
 * 
 * Provides first person view of dungeon and controls for navigating it.  
 *
 */
public class ViewDungeon extends Composite implements Exitable{

	private static ViewDungeonUiBinder uiBinder = GWT
			.create(ViewDungeonUiBinder.class);

	interface ViewDungeonUiBinder extends UiBinder<Widget, ViewDungeon> {
	}
	
	@UiField Label mapError;
	
	@UiField Label dungeonName;
	@UiField Label cardinalDirection;
	@UiField FlowPanel canvasPanel;
	@UiField FlowPanel controls;
	
	private Canvas canvas; //canvas HTML object
	private Context2d context; //Canvas 2d drawing context
	private Profile profile;
	private Dungeon dungeon; //dungeon model
	private final double tileSize = 7.5;
		
	public ViewDungeon(Profile profile) {
		initWidget(uiBinder.createAndBindUi(this));
		
		AsyncCallback<EntityResourceMap<FloorOverlay>> floorCallback = new AsyncCallback<EntityResourceMap<FloorOverlay>>() {
			public void onSuccess(EntityResourceMap<FloorOverlay> data) {
				Map<String, Floor> floors = FloorOverlay.remapFloors(data);
				ViewDungeon.this.dungeon = new Dungeon(0, floors, ViewDungeon.this);

				renderDungeon();
			}
			
			public void onFailure(Throwable caught) {
				mapError.setText(caught.getMessage());
			}
		};		
		AsyncCallback<EntityResourceMap<FloorOverlay>> enemyCallback = new AsyncCallback<EntityResourceMap<FloorOverlay>>() {
			public void onSuccess(EntityResourceMap<FloorOverlay> data) {
				Map<String, Floor> floors = FloorOverlay.remapFloors(data);
				ViewDungeon.this.dungeon = new Dungeon(0, floors, ViewDungeon.this);

				renderDungeon();
			}
			
			public void onFailure(Throwable caught) {
				mapError.setText(caught.getMessage());
			}
		};		
		
		new FloorOverlay.ResourceMap(new String[] {"/data/dungeon.json"}, floorCallback);
		
		this.profile = profile;
		canvas = Canvas.createIfSupported();
		context = canvas.getContext2d();
		canvasPanel.add(canvas);
	}
	
	
	
	/**
	 * Move forward!
	 * @param e
	 */
	@UiHandler("Forward")
	void onClickForward(ClickEvent e) {
		if(!dungeon.getRelTile(1, 0).isSolid()){move(Ordinal.forward);}		
		renderDungeon();
	}
	

	
	/**
	 *  Move backward!
	 * @param e
	 */
	@UiHandler("Backward")
	void onClickBackward(ClickEvent e) {
		if(!dungeon.getRelTile(-1, 0).isSolid()){move(Ordinal.backward);}
		renderDungeon();
	}
	
	/**
	 * Turn left!
	 * @param e
	 */
	@UiHandler("Left")
	void onClickLeft(ClickEvent e) {
		move(Ordinal.left);
		renderDungeon();
	}
	
	/**
	 * Turn right!
	 * @param e
	 */
	@UiHandler("Right")
	void onClickRight(ClickEvent e) {
		move(Ordinal.right);
		renderDungeon();
	}	
	
	private void move(Ordinal direction) {
		final Tile.Reaction onEnterDelay = dungeon.move(direction, profile);
		if (onEnterDelay != null) {
			Timer delay = new Timer() {
				public void run() {
					onEnterDelay.react();
				}
			};
			delay.schedule(500);
		}
	}
	
	/**
	 * renders current dungeon view to context
	 */
	private void renderDungeon() {
		
		dungeonName.setText("You are on dungeon level " + dungeon.getLevel() +": "+ dungeon.getTitle() + "!"); // level you are on
		cardinalDirection.setText("You are facing " + dungeon.getFacing() + "."); // compass facing
		context.rect(0, 0, canvas.getCoordinateSpaceWidth(), canvas.getCoordinateSpaceHeight());
		// TODO: change to use the floor method
		for(int i = 0; i < dungeon.getMap().getMapWidth(); i++){
			for(int j = 0; j < dungeon.getMap().getMapHeight(); j++){				
				if(i == dungeon.getPlayerX() && j == dungeon.getPlayerY()){context.setFillStyle("#FFFC00");} // player position
				else {
					context.setFillStyle( dungeon.getMap().getTile(i, j).getHtmlColor() );
				}
				context.fillRect(i*tileSize, j*tileSize, tileSize, tileSize);
				
			}
		}
		controls.clear();
		final Map<String, Tile.Reaction> controlMap = dungeon.getControls(profile);
		for (final String action : controlMap.keySet()) {
			Hyperlink control = new Hyperlink();
			control.setText(action);
			control.addHandler(new ClickHandler() {
				public void onClick(com.google.gwt.event.dom.client.ClickEvent e) {
					controlMap.get(action).react();
					renderDungeon();
				}
			}, ClickEvent.getType());
			controls.add(control);
		}
	}



	@Override
	public void exit() {
		this.removeFromParent();
		RootPanel.get("gwtapp").add(new ViewTown(profile));
	}

	
}

