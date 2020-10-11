package fr.afpa.dao.beans;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaneBeans {
	/*
	 * attribut de l'avion
	 */
	private ImageIcon icoPlane;
	private Image plane;
	private int healtPoint;
	private int positionX;
	private int positionY;
	private int speedX;
	private int speedY;

	public PlaneBeans() {
		super();

		this.positionX = 300;
		this.positionY = 560;
		this.icoPlane = new ImageIcon(getClass().getResource("/plane2.gif"));
		this.plane = this.icoPlane.getImage();
	}
/*
 * calcul la position en fonction de la vitesse
 * empeche la sortie de l'écran sur une taille de fenetre fixe 
 * 
 */
	public void movePlane() {
		
		this.positionX += speedX;
		this.positionY += speedY;
		
		if (positionX > 490) {
			positionX = 490;
		} else if (positionX < 10) {
			positionX = 10;
		}
		
		if (positionY > 560) {
			positionY = 560;
		} else if (positionY < 100) {
			positionY = 100;
		}
	}

	protected void draw(Graphics graph) {
		graph.drawImage(this.plane, this.positionX, this.positionY, null);
	}
}
