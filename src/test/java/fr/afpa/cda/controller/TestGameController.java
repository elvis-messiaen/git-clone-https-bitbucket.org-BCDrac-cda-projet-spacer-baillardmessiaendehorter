package fr.afpa.cda.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.afpa.dao.beans.MeteoriteAbstractBeans;
import fr.afpa.dao.beans.MeteoriteSimpleBeans;
import junit.framework.TestCase;

public class TestGameController extends TestCase {
	
	GameController gameController;
	List <MeteoriteAbstractBeans> meteoritesList;

public void setUp() throws Exception {
		
		super.setUp();
		this.gameController = new GameController();
		this.meteoritesList = new ArrayList<MeteoriteAbstractBeans>();
	}


	@Test
	public void testCanGenerateMeteorites() {
		
		this.meteoritesList.add(new MeteoriteSimpleBeans(10));
		this.meteoritesList.add(new MeteoriteSimpleBeans(10));
		this.meteoritesList.add(new MeteoriteSimpleBeans(10));
		assertTrue (this.gameController.canGenerateMeteorites(this.meteoritesList));
		
		this.meteoritesList.add(new MeteoriteSimpleBeans(10));
		assertFalse (this.gameController.canGenerateMeteorites(this.meteoritesList));	
	}

	
	@Test
	public void testGenerateMeteorites() {
		this.meteoritesList.add(new MeteoriteSimpleBeans(10));
		assertNotNull(this.gameController.generateMeteorites());
	}

	
	@Test
	public void testMeteoritesExist() {
		
		assertFalse(this.gameController.meteoritesExist(this.meteoritesList));
		
		this.meteoritesList.add(new MeteoriteSimpleBeans(10));
		assertTrue(this.gameController.meteoritesExist(this.meteoritesList));
	}

	
	@Test
	public void testMeteoritesDie() {
		this.meteoritesList.add(new MeteoriteSimpleBeans(10));
		this.meteoritesList.get(0).setDead(true);
		assertNotNull(this.gameController.meteoritesDie(this.meteoritesList));
	}

	
	@Test
	public void testPlaneIsDestroyed() {
		assertFalse(this.gameController.planeIsDestroyed(15));
		assertTrue(this.gameController.planeIsDestroyed(0));
	}

}