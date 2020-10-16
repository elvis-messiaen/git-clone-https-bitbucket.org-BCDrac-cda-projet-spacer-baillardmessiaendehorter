package fr.afpa.cda.controller;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;

public class TestPlayerController extends TestCase {
	
	PlayerController playerController;
	
	public void setUp() throws Exception {
		
		super.setUp();
		this.playerController = new PlayerController();	
	}

	@Test
	public void testNameControle() {
		
		assertTrue(this.playerController.nameControle("Drac"));
		assertFalse(this.playerController.nameControle("1gho"));
		assertFalse(this.playerController.nameControle("o"));
		assertFalse(this.playerController.nameControle("fgpoiho"));
	}

}