package fr.afpa.cda.controller;

import org.junit.Test;

import fr.afpa.cda.controller.GameController;
import junit.framework.TestCase;

public class TestGameController extends TestCase{
	
	private GameController gameController;
	
	public void setUp() throws Exception {
			
		super.setUp();
		this.gameController = new GameController();	
	}

	@Test
	public void testPlaneIsDestroyed() {
		assertFalse(gameController.planeIsDestroyed(15));
		assertTrue(gameController.planeIsDestroyed(0));
	}

	@Test
	public void testCheckScore() {
		gameController.checkScore(154);
		assertEquals(" 999", " 999");
	}

}