package fr.afpa.cda.cda_projet_spacer_BaillardMessiaenDehorter;

import javax.swing.JFrame;

import fr.afpa.business.services.GameBusiness;
import fr.afpa.cda.View.GameInterface;
import fr.afpa.dao.beans.GameBeans;
import fr.afpa.dao.beans.GameConstants;

public class Test {
	
	public static GameBusiness game;

	public static void main(String[] args) {
		

		JFrame fenetre = new JFrame();
		
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setSize(GameConstants.WINDOW_MAX_WIDTH, GameConstants.WINDOW_MAX_HEIGHT);
		
		fenetre.setLocationRelativeTo(null);
		fenetre.setResizable(false);
		fenetre.setAlwaysOnTop(false);

		game = new GameBusiness();

		fenetre.setContentPane(game);
		fenetre.setVisible(true);
	}

}
