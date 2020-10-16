package fr.afpa.cda.View;

import java.util.List;
import java.util.Random;

import fr.afpa.dao.beans.MeteoriteFireBeans;
import fr.afpa.dao.beans.GameConstants;
import fr.afpa.dao.beans.MeteoriteIceBeans;
import fr.afpa.dao.beans.MeteoriteIcebergBeans;
import fr.afpa.dao.beans.MeteoriteAbstractBeans;
import fr.afpa.dao.beans.MeteoriteSimpleBeans;
import fr.afpa.dao.beans.MeteoriteZigzagBeans;

public class MeteoriteThread implements Runnable {

	private List<MeteoriteAbstractBeans> meteorites;
	private Random rand = new Random();

	public MeteoriteThread(List<MeteoriteAbstractBeans> meteorites) {
		this.meteorites = meteorites;
	}

	@Override
	public void run() {

		while (true) {
			meteoriteDie();
			
			if (meteorites.size() < 4) {
				try {
					generateMeteorites();
					Thread.sleep(500);
					generateMeteorites();
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	
	private void generateMeteorites() {

		if (this.meteorites.size() < 4) {
			int meteoriteType = this.rand.nextInt(5);
			int randPositionX = this.rand.nextInt(GameConstants.GAME_SCREEN_MAX_WIDTH);

			switch (meteoriteType) {
				case 0 : this.meteorites.add(new MeteoriteSimpleBeans(randPositionX)); break;
				case 1 : this.meteorites.add(new MeteoriteFireBeans(randPositionX)); break;
				case 2 : this.meteorites.add(new MeteoriteIceBeans(randPositionX)); break;
				case 3 : this.meteorites.add(new MeteoriteZigzagBeans(randPositionX)); break;
				case 4 : this.meteorites.add(new MeteoriteIcebergBeans(randPositionX)); break;
			}
		}
	}

	
	private void meteoriteDie() {
		
		synchronized (this.meteorites) {
			
			if (!this.meteorites.isEmpty()) {
				for (int i = 0; i < this.meteorites.size(); i++) {

					if (this.meteorites.get(i).isDead()) {
						this.meteorites.remove(i);
						generateMeteorites();
					}
				}
			}
		}
	}
}