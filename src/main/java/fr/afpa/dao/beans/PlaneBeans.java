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
	private int positionX;
	private int PositionY;

	public PlaneBeans() {
		super();


		icoPlane = new ImageIcon(getClass().getResource("/plane.png"));
		this.plane = this.icoPlane.getImage();
		this.setFocusable(true);
		this.addKeyListener(new Keyboard());
	}

	@Override
	protected void paintComponent(Graphics graph) {
		super.paintComponents(graph);
		this.positionX = 300;
		this.PositionY = 400;
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

}
