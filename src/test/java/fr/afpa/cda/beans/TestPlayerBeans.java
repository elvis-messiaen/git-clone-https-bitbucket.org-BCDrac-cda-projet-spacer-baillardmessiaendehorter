package fr.afpa.cda.beans;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.afpa.dao.beans.PlayerBeans;
import junit.framework.TestCase;

public class TestPlayerBeans extends TestCase {
	private PlayerBeans player;

	public void setUp() throws Exception {
		super.setUp();
		player = new PlayerBeans();
	}
	@Test
	public void testNameNotNull() {
		assertNotNull("le nom est null",player);
	}

	@Test
	public void testSetName() {
		player.setName("elvism");
		assertEquals("nom incorect", "elvism", player.getName());
	}

	@After
	public void tearDown() throws Exception {
	}



}
