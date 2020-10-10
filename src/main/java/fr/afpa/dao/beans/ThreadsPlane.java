package fr.afpa.dao.beans;

import fr.afpa.cda.cda_projet_spacer_BaillardMessiaenDehorter.Test;

public class ThreadsPlane implements Runnable {
/*
 * classe pour rendre le deplacement de l'avion plus fluide
 * appel de la fonction mouvePlane pour de
 */
	@Override
	public void run() {
		while (true) {
			Test.plane.mouvePlane();
			Test.plane.repaint();
			try {
				
				Thread.sleep(1000/60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
