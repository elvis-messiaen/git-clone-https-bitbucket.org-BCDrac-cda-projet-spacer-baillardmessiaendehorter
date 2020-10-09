package fr.afpa.cda.cda_projet_spacer_BaillardMessiaenDehorter;

import javax.swing.JFrame;

import fr.afpa.dao.beans.PlaneBeans;

public class Test {
 public static PlaneBeans plane;
	public static void main(String[] args) {
		JFrame fenetre = new JFrame();
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setSize(600, 600);
		fenetre.setLocationRelativeTo(null);
		fenetre.setResizable(false);
		fenetre.setAlwaysOnTop(true);

		plane = new PlaneBeans();
		fenetre.setContentPane(plane);
		fenetre.setVisible(true);
		
	}

}
