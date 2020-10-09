package fr.afpa.dao.beans;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import fr.afpa.cda.cda_projet_spacer_BaillardMessiaenDehorter.Test;

public class Keyboard implements KeyListener {


	@Override
	public void keyPressed(KeyEvent e) {
		
		if (e.getKeyCode() == KeyEvent.VK_RIGHT && Test.plane.getPositionX() != 598) {
			System.out.println("doite");
			Test.plane.setPositionX(+1);
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT && Test.plane.getPositionX() != 2) {
			Test.plane.setPositionX(-1);
			System.out.println("gauche");
		} else if (e.getKeyCode() == KeyEvent.VK_UP && Test.plane.getPositionY() != 450) {
			Test.plane.setPositionX(+1);
			System.out.println("haut");
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN && Test.plane.getPositionY() != 150) {
			Test.plane.setPositionX(-1);
			System.out.println("bas");
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
