package edu.ycp.cs320spring2015.oubliation.shared;
import static org.junit.Assert.*;

import org.junit.Test;

import edu.ycp.cs320spring2015.oubliation.shared.category.NameTag;

public class actorTest {
	
	@Test
	public void NameTag() {
		NameTag nameTag = new NameTag("Name", "Description");
		assertTrue(nameTag.getName() == "Name");
		assertTrue(nameTag.getDescription() == "Description");
	}
	
	@Test
	public void Identity() {
		
	}
}