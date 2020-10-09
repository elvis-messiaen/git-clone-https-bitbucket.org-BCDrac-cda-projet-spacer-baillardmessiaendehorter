package fr.afpa.cda.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class GameInterface extends JFrame {
	public void fenetre() {
		JFrame fenetre = new JFrame("Jeu d'avion");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setSize(600, 600);
		fenetre.setLocationRelativeTo(null);
		fenetre.setResizable(false);
		fenetre.setAlwaysOnTop(true);
		JPanel panel = new JPanel();
		fenetre.setContentPane(panel);

		JLabel title = new JLabel("Mon jeu d'avion", SwingConstants.CENTER);
		JPanel panelHaut = new JPanel();
		panelHaut.setLayout(new GridBagLayout());
		title.setPreferredSize(new Dimension(600, 75));
		title.setBorder(new LineBorder(Color.BLACK, 2));
		title.add(panelHaut);
		fenetre.add(title);
		
		JPanel panelBas = new JPanel();
		JLabel fleche = new JLabel("test");
panelBas.setLayout(new GridBagLayout());
GridBagConstraints contrainte = new GridBagConstraints();
contrainte.gridx = 11;
contrainte.gridy = 11;

contrainte.gridheight = 50;
contrainte.gridwidth = 50;
panelBas.add(fleche,contrainte);
fenetre.add(fleche);

		fenetre.setVisible(true);

	}

}
