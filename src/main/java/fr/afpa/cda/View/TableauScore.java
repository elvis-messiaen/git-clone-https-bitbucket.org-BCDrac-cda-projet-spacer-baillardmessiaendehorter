package fr.afpa.cda.View;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.afpa.business.services.ListJoueur;

public class TableauScore extends JFrame {

	public TableauScore() {
		
		setTitle("Tableau des 20 meilleurs joueur ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTable tableau = new JTable(new ListJoueur());
		
		getContentPane().add(new JScrollPane(tableau),BorderLayout.CENTER);
		pack();
		setVisible(true);
	}
}
