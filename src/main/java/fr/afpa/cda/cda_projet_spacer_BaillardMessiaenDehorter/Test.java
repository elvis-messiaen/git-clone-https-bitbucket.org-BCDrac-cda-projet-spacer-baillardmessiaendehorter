package fr.afpa.cda.cda_projet_spacer_BaillardMessiaenDehorter;

import javax.swing.JFrame;

import fr.afpa.dao.beans.GameBeans;

public class Test {
	
	public static GameBeans game;

	public static void main(String[] args) {

		JFrame fenetre = new JFrame();
		
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setSize(600, 900);
		
		fenetre.setLocationRelativeTo(null);
		fenetre.setResizable(false);
		fenetre.setAlwaysOnTop(true);

		game = new GameBeans();

		fenetre.setContentPane(game);
		fenetre.setVisible(true);
	}

}
