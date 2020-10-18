package fr.afpa.cda.services;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.afpa.business.services.GameBusiness;
import fr.afpa.dao.beans.MeteoriteAbstractBeans;
import fr.afpa.dao.beans.MeteoriteFireBeans;
import fr.afpa.dao.beans.MeteoriteIceBeans;
import fr.afpa.dao.beans.MeteoriteSimpleBeans;
import junit.framework.TestCase;

public class TestGameBusiness extends TestCase {

	GameBusiness gameBusiness;
	List<MeteoriteAbstractBeans> meteoritesList;

	public void setUp() throws Exception {

		super.setUp();
		this.gameBusiness = new GameBusiness();
		this.meteoritesList = new ArrayList<MeteoriteAbstractBeans>();
	}

	@Test
	public void testMeteoritesDie() {

		this.meteoritesList.add(new MeteoriteSimpleBeans(10));
		this.meteoritesList.add(new MeteoriteFireBeans(10));
		this.meteoritesList.add(new MeteoriteIceBeans(10));
		this.meteoritesList.add(new MeteoriteFireBeans(10));
		this.meteoritesList.add(new MeteoriteSimpleBeans(10));
		
		for (int i = 1; i < this.meteoritesList.size(); i++) {
			this.meteoritesList.get(i).setDead(true);
		}
		
		this.meteoritesList = this.gameBusiness.meteoritesDie(this.meteoritesList);
		assertFalse(this.meteoritesList.get(0).isDead());
	}
	

	@Test
	public void testGenerateMeteorite() {
		assertNotNull(this.gameBusiness.generateMeteorite());
	}

}
