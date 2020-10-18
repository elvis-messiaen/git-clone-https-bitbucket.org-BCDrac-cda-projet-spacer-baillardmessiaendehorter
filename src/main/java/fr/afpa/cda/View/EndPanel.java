package fr.afpa.cda.View;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Affiche l'écran de fin de partie
 * 
 * @author Julien
 */
public class EndPanel implements ActionListener {

	private Image imageEndPanel;
	private JFrame fenetreGameOver;

	
	/**
	 * Affichage de la fenetre de fin de partie, avec 3 boutons cliquables :
	 * nouvelle partie, scores et quitter
	 */
	public EndPanel() {

		fenetreGameOver = new JFrame();
		JPanel panelChoix = new JPanel();

		JButton NewGame = new JButton("Nouvelle partie");
		NewGame.addActionListener(this);

		JButton Scores = new JButton("Afficher les meilleurs scores");
		Scores.addActionListener(this);

		JButton Quit = new JButton("Quitter le jeu");
		Quit.addActionListener(this);

		fenetreGameOver.setSize(300, 300);
		fenetreGameOver.setLocationRelativeTo(null);
		fenetreGameOver.setResizable(false);
		fenetreGameOver.setAlwaysOnTop(true);

		panelChoix.setLayout(new GridLayout(3, 1));
		panelChoix.setSize(200, 200);
		panelChoix.add(NewGame);
		panelChoix.add(Scores);
		panelChoix.add(Quit);

		panelChoix.setVisible(true);

		fenetreGameOver.add(panelChoix);

		fenetreGameOver.setVisible(true);

	}

	
	/**
	 * Affiche le graphisme
	 * 
	 * @param graph : le graphisme à afficher
	 */
	public void draw(Graphics graph) {
		graph.drawImage(this.imageEndPanel, 10, 660, null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand() == "Nouvelle partie") {
			StartPanel start = new StartPanel();
			fenetreGameOver.dispatchEvent(new WindowEvent(fenetreGameOver, WindowEvent.WINDOW_CLOSING));

		} else if (e.getActionCommand() == "Afficher les meilleurs scores") {

			try {
				ScorePanel score = new ScorePanel();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		} else {
			fenetreGameOver.dispatchEvent(new WindowEvent(fenetreGameOver, WindowEvent.WINDOW_CLOSING));
			System.exit(0);
		}
	}

}
