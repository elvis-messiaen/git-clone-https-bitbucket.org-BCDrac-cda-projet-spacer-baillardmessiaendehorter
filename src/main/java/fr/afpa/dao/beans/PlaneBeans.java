package fr.afpa.dao.beans;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

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
	private double positionX;
	private double PositionY;

	public PlaneBeans() {
		super();
		this.positionX = 110;
		this.PositionY = 300;
		
		icoPlane = new ImageIcon(getClass().getResource("/plane.png"));
		this.plane = this.icoPlane.getImage();
	}

	@Override
	protected void paintComponent(Graphics graph) {
		super.paintComponents(graph);
		Graphics graph2 = (Graphics2D)graph;
		graph2.drawImage(plane,300,400,null);
	}

}
