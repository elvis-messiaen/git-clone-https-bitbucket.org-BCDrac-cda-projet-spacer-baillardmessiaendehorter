package fr.afpa.dao.beans;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StartPanel implements ActionListener {
	private Image imageStarPanel;

	public StartPanel() {
		JFrame fenetrestart = new JFrame();
		JPanel name = new JPanel();
		JLabel nom = new JLabel("Entrez votre nom de jeu :");
		JTextField theName = new JTextField(25);
		JButton valid = new JButton("Valider");
		name.add(nom);
		name.add(theName);
		name.add(valid);
		fenetrestart.setSize(300, 300);
		fenetrestart.setLocationRelativeTo(null);
		fenetrestart.setResizable(false);
		fenetrestart.setAlwaysOnTop(true);

		fenetrestart.setVisible(true);
		fenetrestart.add(name);
		fenetrestart.setVisible(true);
	}

	public void draw(Graphics graph2) {
		graph2.drawImage(this.imageStarPanel, 10, 660, null);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
