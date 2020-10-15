package fr.afpa.cda.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import fr.afpa.cda.controller.GameController;
import fr.afpa.dao.beans.GameConstants;
import fr.afpa.dao.beans.MeteoriteBeans;
import fr.afpa.dao.beans.PlaneBeans;

/**
 * Classe gérant l'interface graphique du jeu
 * 
 * @author Julien
 *
 */
public class GameInterface extends JFrame {
	
	//private GamePanel game = new GamePanel(null);
	private PlaneBeans plane = new PlaneBeans();
	private MeteoriteBeans meteorite;
	private GameController gameControl = new GameController();
	
	public GameInterface() {
	}
	
	public void fenetre() {


		// Instanciations des différents élements
		JFrame fenetre = new JFrame("Mon jeu d'avion");

		JPanel panelDisplay = new JPanel();
		JPanel panelButtons = new JPanel();

		
//		JLabel leftArrow = new JLabel("<-");
//		JLabel upArrow = new JLabel("up");
//		JLabel downArrow = new JLabel("down");
//		JLabel rightArrow = new JLabel("->");
		JLabel keys = new JLabel();

		Border blackline = BorderFactory.createLineBorder(Color.black, 3);

		// Paramétrage des éléments

		// Elements JFrame
		fenetre.setLayout(new BorderLayout());
		fenetre.setSize(GameConstants.WINDOW_MAX_WIDTH, GameConstants.WINDOW_MAX_HEIGHT);
		fenetre.setLocationRelativeTo(null);
		fenetre.setResizable(false);
		fenetre.setAlwaysOnTop(true);

		// Elements JPanel
		panelDisplay.setLayout(new BorderLayout());
		panelDisplay.setPreferredSize(new Dimension(400, 200));
		panelDisplay.setBorder(blackline);

		panelButtons.setLayout(new BorderLayout());
		panelButtons.setPreferredSize(new Dimension(200, 200));
		panelButtons.setBorder(blackline);

		// Elements JLabel

		

//		upArrow.setHorizontalAlignment(JLabel.CENTER);
//		downArrow.setHorizontalAlignment(JLabel.CENTER);

		// Assemblage du panel panelButtons

//		panelButtons.add(leftArrow, BorderLayout.WEST);
//		panelButtons.add(upArrow, BorderLayout.NORTH);
//		panelButtons.add(downArrow, BorderLayout.SOUTH);
//		panelButtons.add(rightArrow, BorderLayout.EAST);

		// Préparation de l'image à afficher dans le label "keys", qui ira se placer
		// dans le JPanel "panelButtons"

		//icon = new ImageIcon(getClass().getResource("/keys.jpg"));
		//keys.setIcon(icon);

		// Préparation de l'image à afficher dans le Panel panelDisplay

		//icon = new ImageIcon(getClass().getResource("/starfall2.gif"));
		//background.setIcon(icon);
		
		//this.game.setSize(GameConstants.GAME_SCREEN_MAX_WIDTH, GameConstants.GAME_SCREEN_MAX_HEIGHT);
		//fenetre.add(this.game, BorderLayout.CENTER);

		// Assemblage du panel panelButtons
		panelButtons.add(keys, BorderLayout.CENTER);
//		panelButtons.add(leftArrow, BorderLayout.WEST);
//		panelButtons.add(upArrow, BorderLayout.NORTH);
		panelButtons.add(keys, BorderLayout.CENTER);
//		panelButtons.add(downArrow, BorderLayout.SOUTH);
//		panelButtons.add(rightArrow, BorderLayout.EAST);

		// Assemblage du panel panelDisplay avec le label "infos" comme contenant pour
		// "score", "name" et "hp"
		

		//panelDisplay.add(infos(), BorderLayout.NORTH);

		// Assemblage de la fenêtre
		fenetre.add(panelDisplay, BorderLayout.CENTER);
		fenetre.add(panelButtons, BorderLayout.SOUTH);
		

		// Ajout de l'icone de'avion dans la frame

		//ImageIcon plane = new ImageIcon(getClass().getResource("/plane2.gif"));
		
		fenetre.setLocationRelativeTo(null);
		fenetre.setResizable(false);
		fenetre.setAlwaysOnTop(false);fenetre.setLocationRelativeTo(null);
		fenetre.setResizable(false);
		fenetre.setAlwaysOnTop(false);
		
		//this.game.startGame();
		
		fenetre.setVisible(true);
	}
	
	/*
	private JLabel infos() {
		
		JLabel infos = new JLabel(" ");
		JLabel score = new JLabel("  Score : " + this.game.player.getScore());
		JLabel name = new JLabel("Name : " + this.game.player.getName());
		JLabel hp = new JLabel("HP : " + this.game.plane.getHealthPoints() + " ");
		
		infos.setLayout(new BorderLayout());

		name.setHorizontalAlignment(JLabel.CENTER);
		
		infos.add(score, BorderLayout.WEST);
		infos.add(name, BorderLayout.CENTER);
		infos.add(hp, BorderLayout.EAST);
		infos.setVisible(true);
		
		return infos;
	}*/
}
