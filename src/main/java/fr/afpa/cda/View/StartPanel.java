package fr.afpa.cda.View;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.afpa.cda.controller.PlayerController;
import fr.afpa.dao.beans.PlayerBeans;

public class StartPanel implements ActionListener {
	private Image imageStarPanel;
	JFrame fenetrestart;
	public JTextField theName;

	/*
	 * fenetre de demarage demande de nom
	 */
	public StartPanel() {
		fenetrestart = new JFrame();
		JPanel name = new JPanel();
		JLabel nom = new JLabel("Entrez votre nom de jeu :");
		theName = new JTextField(25);
		JButton valid = new JButton("Valider");
		valid.addActionListener(this);
		name.add(nom);
		name.add(theName);
		name.add(valid);
		fenetrestart.setSize(300, 300);
		fenetrestart.setLocationRelativeTo(null);
		fenetrestart.setResizable(false);
		fenetrestart.setAlwaysOnTop(true);
		theName.addActionListener(this);
		fenetrestart.setVisible(true);
		fenetrestart.add(name);
		fenetrestart.setVisible(true);
	}

	/*
	 * dessin de la fenetre de demande de nom
	 */
	public void draw(Graphics graph2) {
		graph2.drawImage(this.imageStarPanel, 10, 660, null);

	}

	/*
	 * methode de controle de nom lancement si nom valide de la partie de jeu le
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String nam = theName.getText();
		PlayerBeans joueur = new PlayerBeans();
		PlayerController controleName = new PlayerController();

			joueur.setName(nam);
			
			if (controleName.nameControle(joueur)) {
				GamePanel game = new GamePanel();
				game.startGame();
				joueur.setName(nam);
				fenetrestart.dispatchEvent(new WindowEvent(fenetrestart, WindowEvent.WINDOW_CLOSING));
			
		} else {
			/*
			 * lancement de fenetre alerte si le nom est pas valide on ferme le pop up et
			 * continue de demander un nom correct affiche un message precisant le type de
			 * nom de joueur accepter
			 * 
			 */

			JOptionPane optionPane = new JOptionPane("pseudo 3 à 6 lettres !!!", JOptionPane.ERROR_MESSAGE);
			JDialog dialog = optionPane.createDialog("Message d'erreur !");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
			
		}

	}
}
