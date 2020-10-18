package fr.afpa.cda.View;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;

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
	private Image imageStartPanel;
	private JFrame startWindow;
	public JTextField playerName;

	/*
	 * fenetre de demarage demande de nom
	 * 
	 */
	public StartPanel() {
		this.startWindow = new JFrame();
		JPanel name = new JPanel();
		JLabel nom = new JLabel("Entrez votre nom de jeu :");
		this.playerName = new JTextField(25);
		JButton valid = new JButton("Valider");

		valid.addActionListener(this);
		name.add(nom);
		name.add(this.playerName);
		name.add(valid);

		this.startWindow.setSize(300, 300);
		this.startWindow.setLocationRelativeTo(null);
		this.startWindow.setResizable(false);
		this.startWindow.setAlwaysOnTop(true);
		this.playerName.addActionListener(this);
		this.startWindow.setVisible(true);
		this.startWindow.add(name);
		this.startWindow.setVisible(true);

	}

	/*
	 * dessin de la fenetre de demande de nom
	 */
	public void draw(Graphics graph2) {
		graph2.drawImage(this.imageStartPanel, 10, 660, null);

	}

	/*
	 * methode de controle de nom lancement si nom valide de la partie de jeu le
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String name = this.playerName.getText();

		PlayerBeans player = new PlayerBeans();
		PlayerController controlName = new PlayerController();
		LocalDateTime date = LocalDateTime.now();

		player.setName(name);
		player.setGameStartedDate(date);

		if (controlName.nameControle(name)) {

			GamePanel game = new GamePanel(player);
			game.startGame();
			this.startWindow.dispatchEvent(new WindowEvent(startWindow, WindowEvent.WINDOW_CLOSING));
		
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
