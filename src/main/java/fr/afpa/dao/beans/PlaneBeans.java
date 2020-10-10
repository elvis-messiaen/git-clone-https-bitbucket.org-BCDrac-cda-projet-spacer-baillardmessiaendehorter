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
public class PlaneBeans {
	/*
	 * attribut de l'avion
	 */
	private ImageIcon icoPlane;
	private Image plane;
	private int healtPoint;
	private int positionX;
	private int PositionY;
	private int speedX;
	private int speedY;
	
	public PlaneBeans() {
		super();

		this.positionX = 300;
		this.PositionY = 580;
		icoPlane = new ImageIcon(getClass().getResource("/plane.png"));
		this.plane = this.icoPlane.getImage();
	}
/*
 * calcul la position en fonction de la vitesse
 * empeche la sortie de l'écran sur une taille de fenetre fixe 
 * 
 */
	public void mouvePlane() {
		this.positionX += speedX;
		this.PositionY += speedY;
		
		if (positionX > 540) {
			positionX = 540;
		} else if (positionX < 10) {
			positionX = 10;
		}
		
		if (PositionY > 580) {
			PositionY = 580;
		} else if (PositionY < 100) {
			PositionY = 100;
		}
	}
	
	protected void draw(Graphics graph2) {
		graph2.drawImage(plane,positionX,PositionY,null);
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return PositionY;
	}

	public void setPositionY(int positionY) {
		PositionY = positionY;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}
	
	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}
}
