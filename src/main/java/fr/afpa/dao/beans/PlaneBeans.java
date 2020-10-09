package fr.afpa.dao.beans;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlaneBeans extends JFrame {
	/*
	 * attribut de l'avion
	 */
	private ImageIcon icoPlane;
	private Image plane;

	private int healtPoint;
	private double positionX;
	private double PositionY;

	public PlaneBeans(int life, int posX, int posY, ImageIcon icoPlane) {
		this.positionX = 110;
		this.PositionY = 300;
		icoPlane = new ImageIcon(getClass().getResource("/images/Su-33.png"));
//		this.plane = this.icoPlane.getImage();

	}

	public void dessinePlane() {
		PlaneBeans avion = new PlaneBeans(5,110,300,icoPlane);
	}

}
