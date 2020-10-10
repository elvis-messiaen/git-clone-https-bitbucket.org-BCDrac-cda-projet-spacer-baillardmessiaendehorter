package fr.afpa.cda.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import fr.afpa.dao.beans.PlaneBeans;

public class GameInterface extends JFrame {
	public static PlaneBeans plane;
	public void fenetre() {
		
		ImageIcon icon;

		// Instanciations des différents élements
		JFrame fenetre = new JFrame("Mon jeu d'avion");

		JPanel panelDisplay = new JPanel();
		JPanel panelButtons = new JPanel();
		JLabel infos = new JLabel(" ");
		JLabel background = new JLabel();

		JLabel score = new JLabel("  score");
		JLabel name = new JLabel("name");
		JLabel hp = new JLabel("hp  ");
//		JLabel leftArrow = new JLabel("<-");
//		JLabel upArrow = new JLabel("up");
//		JLabel downArrow = new JLabel("down");
//		JLabel rightArrow = new JLabel("->");
		JLabel keys = new JLabel();

		Border blackline = BorderFactory.createLineBorder(Color.black, 3);

		// Paramétrage des éléments

		// Elements JFrame
		fenetre.setLayout(new BorderLayout());
		fenetre.setSize(600, 600);
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

		infos.setLayout(new BorderLayout());

		name.setHorizontalAlignment(JLabel.CENTER);

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

		icon = new ImageIcon(getClass().getResource("/background.jpg"));
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
		infos.add(score, BorderLayout.WEST);
		infos.add(name, BorderLayout.CENTER);
		infos.add(hp, BorderLayout.EAST);
		infos.setVisible(true);

		panelDisplay.add(infos, BorderLayout.NORTH);

		panelDisplay.add(background, BorderLayout.CENTER);

		// Assemblage de la fenêtre
		fenetre.add(panelDisplay, BorderLayout.CENTER);
		fenetre.add(panelButtons, BorderLayout.SOUTH);

		// Ajout de l'icone de'avion dans la frame

		ImageIcon plane = new ImageIcon(getClass().getResource("/plane.png"));

		fenetre.setVisible(true);
	}
}
