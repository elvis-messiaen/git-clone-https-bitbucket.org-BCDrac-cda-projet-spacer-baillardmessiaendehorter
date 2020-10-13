package fr.afpa.dao.beans;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EndPanel {

	private Image imageEndPanel;

	public EndPanel() {
		
		JFrame fenetreGameOver = new JFrame();

		JPanel panelChoix = new JPanel();

		JButton NewGame = new JButton("Nouvelle partie");
		JButton Scores = new JButton("Affichers les meilleurs scores");
		JButton Quit = new JButton("Quitter le jeu");

		fenetreGameOver.setSize(300, 300);
		fenetreGameOver.setLocationRelativeTo(null);
		fenetreGameOver.setResizable(false);
		fenetreGameOver.setAlwaysOnTop(true);

		panelChoix.setLayout(new GridLayout(3, 1));
		panelChoix.setSize(200,200);
		panelChoix.add(NewGame);
		panelChoix.add(Scores);
		panelChoix.add(Quit);
		
		panelChoix.setVisible(true);

		fenetreGameOver.add(panelChoix);

		fenetreGameOver.setVisible(true);

	}
	
	public void draw(Graphics graph) {
		graph.drawImage(this.imageEndPanel, 10, 660, null);
		
	
	}

}