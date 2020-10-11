package fr.afpa.dao.beans;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import fr.afpa.cda.cda_projet_spacer_BaillardMessiaenDehorter.Test;

public class Keyboard implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {
		/*
		 * avion bouge 
		 * mais je doit ajouté le Threads 
		 * car il faut gerer la latence
		 */
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Test.game.getPlane().setSpeedX(3);
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			Test.game.getPlane().setSpeedX(-3);
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			Test.game.getPlane().setSpeedY(3);
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			Test.game.getPlane().setSpeedY(-3);

		}
	}
	
/*
 * fonction pour definir l'action lorsque on lache un bouton
 * l'avion se stoppe
 */
	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Test.game.getPlane().setSpeedX(0);
			
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			Test.game.getPlane().setSpeedX(0);
			
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			Test.game.getPlane().setSpeedY(0);
			
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			Test.game.getPlane().setSpeedY(0);

		}
	}


	@Override
	public void keyTyped(KeyEvent e) {
	}
}
