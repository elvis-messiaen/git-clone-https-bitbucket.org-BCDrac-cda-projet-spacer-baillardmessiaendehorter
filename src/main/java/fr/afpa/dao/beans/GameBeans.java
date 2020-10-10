package fr.afpa.dao.beans;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import fr.afpa.cda.cda_projet_spacer_BaillardMessiaenDehorter.Test;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class GameBeans extends JPanel {
	/*
	 * attribut de l'avion
	 */
	private PlaneBeans plane;
	private BackgroundBeans background;
	private ArrowBeans arrows;
	public GameBeans() {
		super();
		plane = new PlaneBeans();
		background = new BackgroundBeans();
		arrows = new ArrowBeans();
		
		this.setFocusable(true);
		this.addKeyListener(new Keyboard());
		Thread gameThread = new Thread(new GameThread());
		gameThread.start();
	}
/*
 * calcul la position en fonction de la vitesse
 * empeche la sortie de l'écran sur une taille de fenetre fixe 
 * 
 */
	public void logic() {
		this.plane.mouvePlane();
	}
	
	@Override
	protected void paintComponent(Graphics graph) {
		super.paintComponents(graph);
		Graphics graph2 = (Graphics2D)graph;
		
		background.draw(graph2);
		arrows.draw(graph2);
		plane.draw(graph2);
		
		
	}
	
	public PlaneBeans getPlane() {
		return plane;
	}

}
