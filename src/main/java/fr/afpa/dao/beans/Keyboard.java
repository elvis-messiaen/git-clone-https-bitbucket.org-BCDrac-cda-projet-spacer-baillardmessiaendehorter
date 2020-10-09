package fr.afpa.dao.beans;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import fr.afpa.cda.cda_projet_spacer_BaillardMessiaenDehorter.Test;

public class Keyboard implements KeyListener {


	@Override
	public void keyPressed(KeyEvent e) {
		
		if (e.getKeyCode() == KeyEvent.VK_RIGHT && Test.plane.getPositionX() != 598) {
		Test.plane.setPositionX(1);
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT && Test.plane.getPositionX() != 2) {
			Test.plane.setPositionX(-1);
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT && Test.plane.getPositionY() != 450) {
			Test.plane.setPositionX(1);
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT && Test.plane.getPositionY() != 150) {
			Test.plane.setPositionX(-1);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
//		Test.plane.setPositionX(0);
//		Test.plane.setPositionY(0);
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
