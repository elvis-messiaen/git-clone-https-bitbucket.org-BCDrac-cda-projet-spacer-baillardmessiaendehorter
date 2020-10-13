package fr.afpa.business.services;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import fr.afpa.cda.cda_projet_spacer_BaillardMessiaenDehorter.Test;

/**
 * Classe contenant le KeyListener, permettant de déplacer l'avion
 * 
 * @author Elvis
 *
 */
public class KeyboardListener implements KeyListener {

	
	/**
	 * Méthode deffinissant l'action lorsqu'on appuie sur une touche permet de
	 * déplacer l'avion
	 * 
	 */
	@Override
	public void keyPressed(KeyEvent event) {

		if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
			
			Test.game.plane.setSpeedX(3);

		} else if (event.getKeyCode() == KeyEvent.VK_LEFT) {
			Test.game.plane.setSpeedX(-3);

		} else if (event.getKeyCode() == KeyEvent.VK_DOWN) {
			Test.game.plane.setSpeedY(3);

		} else if (event.getKeyCode() == KeyEvent.VK_UP) {
			Test.game.plane.setSpeedY(-3);
		}
	}

	
	/**
	 * Méthode definissant l'action lorsque on lâche un bouton l'avion se stoppe
	 */
	@Override
	public void keyReleased(KeyEvent event) {
		
		if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
			Test.game.plane.setSpeedX(0);

		} else if (event.getKeyCode() == KeyEvent.VK_LEFT) {
			Test.game.plane.setSpeedX(0);

		} else if (event.getKeyCode() == KeyEvent.VK_DOWN) {
			Test.game.plane.setSpeedY(0);

		} else if (event.getKeyCode() == KeyEvent.VK_UP) {
			Test.game.plane.setSpeedY(0);
		}
	}

	
	@Override
	public void keyTyped(KeyEvent e) {
	}
}