package edu.ycp.cs320spring2015.oubliation.shared.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320spring2015.oubliation.shared.Profile;
import edu.ycp.cs320spring2015.oubliation.shared.location.Dungeon;
import edu.ycp.cs320spring2015.oubliation.shared.location.EmptySpace;
import edu.ycp.cs320spring2015.oubliation.shared.location.Floor;
import edu.ycp.cs320spring2015.oubliation.shared.location.Cardinal;
import edu.ycp.cs320spring2015.oubliation.shared.location.Ordinal;
import edu.ycp.cs320spring2015.oubliation.shared.location.Tile;
import edu.ycp.cs320spring2015.oubliation.shared.location.ToOutskirts;
import edu.ycp.cs320spring2015.oubliation.shared.location.Wall;
import edu.ycp.cs320spring2015.oubliation.shared.test.Debug;

import java.util.HashMap;
import java.util.Map;

public class DungeonTest  {
	private Dungeon dungeon;
	private Profile profile = Debug.makeProfile();
	private Floor map = Debug.makeMap(0, "first floor");
	private Floor map1 = Debug.makeMap(1, "second floor");
	
	//dungeon.
	@Before
	public void setUp(){
		HashMap<String, Floor> floors = new HashMap<String, Floor>();
		floors.put("0", map);
		floors.put("1", map1);
		dungeon = new Dungeon(0, floors, null);
	}	
	
	@Test
	public void testInitial() {
		assertTrue(dungeon.getPlayerX() == 1);
		assertTrue(dungeon.getPlayerY() == 2);
		assertTrue(dungeon.getMap() == map);
		dungeon.setLevel(1);
		assertTrue(dungeon.getLevel().equals("1"));
		assertTrue(dungeon.getTitle() == "second floor");
	}	

	@Test
	public void testMovement() {
		// Checks the ability to change directions
		dungeon.move(Ordinal.left, profile);
		assertTrue(dungeon.getFacing() == Cardinal.south);
		dungeon.move(Ordinal.right, profile);
		assertTrue(dungeon.getFacing() == Cardinal.west);
		dungeon.move(Ordinal.right, profile);
		assertTrue(dungeon.getFacing() == Cardinal.north);
		dungeon.move(Ordinal.right, profile);
		assertTrue(dungeon.getFacing() == Cardinal.east);
		dungeon.move(Ordinal.forward, profile);
		assertEquals(2, dungeon.getPlayerX());
		assertEquals(2, dungeon.getPlayerY());
		dungeon.move(Ordinal.backward, profile);
		// Checking that backwards put the party back where it was
		assertEquals(1, dungeon.getPlayerX());
		assertEquals(2, dungeon.getPlayerY());
		// Checks if the party is standing on an empty space
		assertEquals(EmptySpace.class, dungeon.getCurrentMapTile().getClass());
		// Position to check for wall in a relative position
		dungeon.move(Ordinal.left, profile);
		dungeon.move(Ordinal.left, profile);
		assertEquals(Wall.class, dungeon.getRelTile(1, 0).getClass());
		// Getting in position for the door
		dungeon.move(Ordinal.left, profile);
		dungeon.move(Ordinal.forward, profile);
		dungeon.move(Ordinal.forward, profile);
		dungeon.move(Ordinal.left, profile);
		dungeon.move(Ordinal.forward, profile);
		dungeon.move(Ordinal.forward, profile);
		// Before door
		assertEquals(3, dungeon.getPlayerX());
		assertEquals(4, dungeon.getPlayerY());
		Map<String, Tile.Reaction> reactMap = dungeon.getControls(profile);
		reactMap.get("enter").react();
		// After door
		assertEquals(5, dungeon.getPlayerX());
		assertEquals(4, dungeon.getPlayerY());		
		// Checking for a ToOutskirts tile
		assertEquals(ToOutskirts.class, dungeon.getRelTile(1, 0).getClass());
	}

}
