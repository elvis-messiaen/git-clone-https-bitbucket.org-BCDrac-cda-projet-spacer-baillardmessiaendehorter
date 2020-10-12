package fr.afpa.business.services;

import java.util.List;
import java.util.Random;

import fr.afpa.dao.beans.MeteoriteBeans;
import fr.afpa.dao.beans.SimpleMeteoriteBeans;

public class MeteoriteThread implements Runnable {

	private List<MeteoriteBeans> meteorites;
	private Random rand = new Random();

	public MeteoriteThread(List<MeteoriteBeans> meteorites) {
		this.meteorites = meteorites;
	}

	@Override
	public void run() {

		while (true) {
			meteoriteDie();
			if (meteorites.size() < 3) {
				try {
					generateMeteorites();
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void generateMeteorites() {

		if (this.meteorites.size() < 3) {
			// int meteoriteType = this.rand.nextInt(5);
			int randPositionX = this.rand.nextInt(540);

			// switch (meteoriteType) {
			// case 0:
			this.meteorites.add(new SimpleMeteoriteBeans(randPositionX));
			// break;
		}
	}

	private void meteoriteDie() {

		if (!this.meteorites.isEmpty()) {
			for (int i = 0; i < this.meteorites.size(); i++) {

				if (this.meteorites.get(i).isDead()) {
					this.meteorites.remove(meteorites.get(i));
					generateMeteorites();
				}
			}
		}
	}
}