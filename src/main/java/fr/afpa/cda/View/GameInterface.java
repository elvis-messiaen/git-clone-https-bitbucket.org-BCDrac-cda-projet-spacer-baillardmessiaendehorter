package fr.afpa.cda.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import fr.afpa.cda.controller.GameController;
import fr.afpa.dao.beans.MeteoriteBeans;
import fr.afpa.dao.beans.PlaneBeans;

/**
 * Classe gérant l'interface graphique du jeu
 * 
 * @author Julien
 *
 */
public class GameInterface extends JFrame {
	
	private PlaneBeans plane;
	private MeteoriteBeans meteorite;
	private GameController gameControl = new GameController();
	
	public void fenetre() {
		
		ImageIcon icon;

		// Instanciations des différents élements
		JFrame fenetre = new JFrame("Mon jeu d'avion");

		JPanel panelDisplay = new JPanel();
		JPanel panelButtons = new JPanel();
		
		JLabel background = new JLabel();

		
//		JLabel leftArrow = new JLabel("<-");
//		JLabel upArrow = new JLabel("up");
//		JLabel downArrow = new JLabel("down");
//		JLabel rightArrow = new JLabel("->");
		JLabel keys = new JLabel();

		Border blackline = BorderFactory.createLineBorder(Color.black, 3);

		// Paramétrage des éléments

		// Elements JFrame
		fenetre.setLayout(new BorderLayout());
		fenetre.setSize(600, 900);
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

		icon = new ImageIcon(getClass().getResource("/keys.jpg"));
		keys.setIcon(icon);

		// Préparation de l'image à afficher dans le Panel panelDisplay

		icon = new ImageIcon(getClass().getResource("/starfall2.gif"));
		background.setIcon(icon);

		// Assemblage du panel panelButtons
		panelButtons.add(keys, BorderLayout.CENTER);
//		panelButtons.add(leftArrow, BorderLayout.WEST);
//		panelButtons.add(upArrow, BorderLayout.NORTH);
		panelButtons.add(keys, BorderLayout.CENTER);
//		panelButtons.add(downArrow, BorderLayout.SOUTH);
//		panelButtons.add(rightArrow, BorderLayout.EAST);

		// Assemblage du panel panelDisplay avec le label "infos" comme contenant pour
		// "score", "name" et "hp"
		

		panelDisplay.add(infos(), BorderLayout.NORTH);

		panelDisplay.add(background, BorderLayout.CENTER);

		// Assemblage de la fenêtre
		fenetre.add(panelDisplay, BorderLayout.CENTER);
		fenetre.add(panelButtons, BorderLayout.SOUTH);

		// Ajout de l'icone de'avion dans la frame

		ImageIcon plane = new ImageIcon(getClass().getResource("/plane2.gif"));

		fenetre.setVisible(true);
	}
	
	
	
	private JLabel infos() {
		
		JLabel infos = new JLabel(" ");
		JLabel score = new JLabel("  score : " + this.gameControl.getPlayerScore());
		JLabel name = new JLabel("name : " + this.gameControl.getPlayerName());
		JLabel hp = new JLabel("hp : " + this.gameControl.getPlaneHealthPoints() + " ");
		
		infos.setLayout(new BorderLayout());

		name.setHorizontalAlignment(JLabel.CENTER);
		
		infos.add(score, BorderLayout.WEST);
		infos.add(name, BorderLayout.CENTER);
		infos.add(hp, BorderLayout.EAST);
		infos.setVisible(true);
		
		return infos;
		
	}
}
