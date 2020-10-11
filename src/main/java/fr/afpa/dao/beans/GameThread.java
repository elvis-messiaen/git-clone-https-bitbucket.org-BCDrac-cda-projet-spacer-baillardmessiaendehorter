package fr.afpa.dao.beans;

import fr.afpa.cda.cda_projet_spacer_BaillardMessiaenDehorter.Test;

public class GameThread implements Runnable {
	/*
	 * classe pour rendre le deplacement de l'avion plus fluide appel de la fonction
	 * movePlane pour définir postion avion en fonction de sa vitesse
	 * thread(1000/60) niveau de rafraichissment d'image équivalent jeu rps
	 */
	@Override
	public void run() {

		while (true) {

			Test.game.logic();
			Test.game.repaint();

			try {		
				Thread.sleep(1000 / 60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
