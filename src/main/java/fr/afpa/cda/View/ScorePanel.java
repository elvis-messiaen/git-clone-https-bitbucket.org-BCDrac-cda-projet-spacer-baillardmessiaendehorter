package fr.afpa.cda.View;

import java.awt.BorderLayout;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.afpa.business.services.PlayersList;
import fr.afpa.cda.controller.ScoreController;
import fr.afpa.dao.beans.PlayerBeans;


/**
 * Affiche les 20 meilleurs scores
 * 
 * @author Julien
 */
public class ScorePanel extends JFrame {
	
	List<PlayerBeans> players;

	public ScorePanel() throws IOException {
		
		ScoreController score = new ScoreController();
		setTitle("Tableau des 20 meilleurs joueurs : ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.players = score.GetListHighScore();
		JTable table = new JTable(new PlayersList(this.players));
		
		getContentPane().add(new JScrollPane(table),BorderLayout.CENTER);
		pack();
		setVisible(true);
	}
}