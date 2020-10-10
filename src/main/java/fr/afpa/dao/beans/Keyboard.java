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
		if (e.getKeyCode() == KeyEvent.VK_RIGHT && Test.plane.getPositionX() != 540) {
			Test.plane.setPositionX(Test.plane.getPositionX()+2);
			Test.plane.repaint();
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT && Test.plane.getPositionX() != 10) {
			Test.plane.setPositionX(Test.plane.getPositionX()-2);
			Test.plane.repaint();
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN && Test.plane.getPositionY() != 400) {
			Test.plane.setPositionY(Test.plane.getPositionY()+1);
			Test.plane.repaint();
		} else if (e.getKeyCode() == KeyEvent.VK_UP && Test.plane.getPositionY() != 150) {
			Test.plane.setPositionY(Test.plane.getPositionY()-1);
			Test.plane.repaint();
			System.out.println(Test.plane.getPositionY());
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
