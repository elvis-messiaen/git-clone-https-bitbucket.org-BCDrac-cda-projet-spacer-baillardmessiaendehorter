package fr.afpa.business.services;

import fr.afpa.cda.cda_projet_spacer_BaillardMessiaenDehorter.Test;


/**
 * Thread principal du jeu
 * 
 * Classe rendant le deplacement de l'avion plus fluide
 * 
 * @author Elvis
 */
public class GameThread implements Runnable {
	
	/**
	 * Appel de la fonction movePlane() pour définir la postion de l'avion en fonction de sa vitesse
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