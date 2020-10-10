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
public class PlaneBeans extends JPanel {
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
		this.PositionY = 400;
		icoPlane = new ImageIcon(getClass().getResource("/plane.png"));
		this.plane = this.icoPlane.getImage();
		this.setFocusable(true);
		this.addKeyListener(new Keyboard());
		Thread latencePlane = new Thread(new ThreadsPlane());
		latencePlane.start();
	}
/*
 * calcul la position en fonction de la vitesse
 */
	public void mouvePlane() {
		this.positionX += speedX;
		this.PositionY += speedY;
		
		if (positionX > 540) {
			positionX = 540;
		} else if (positionX < 10) {
			positionX = 10;
		}
		
		if (PositionY > 400) {
			PositionY = 400;
		} else if (PositionY < 150) {
			PositionY = 150;
		}
	}
	
	@Override
	protected void paintComponent(Graphics graph) {
		super.paintComponents(graph);
		Graphics graph2 = (Graphics2D)graph;
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
