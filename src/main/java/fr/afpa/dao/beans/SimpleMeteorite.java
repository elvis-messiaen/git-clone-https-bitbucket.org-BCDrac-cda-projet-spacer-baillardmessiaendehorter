package fr.afpa.dao.beans;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimpleMeteorite extends MeteoriteBeans implements FlyingObject {

	private ImageIcon meteoriteIcon;
	private Image meteoriteImage;
	private int type;
	private int meteoriteSize;
	private int positionX;
	private int positionY = 80;
	private int speedX;
	private int speedY = 2;
	
	public SimpleMeteorite(int positionX) {
		
		super();
		
		this.positionX = positionX;
		
		this.meteoriteIcon = new ImageIcon(getClass().getResource("/meteorite.png"));
		this.meteoriteImage = this.meteoriteIcon.getImage();

	}

	@Override
	public void spawn() {

	}

	@Override
	public void move() {
		
		this.positionY += this.speedY;

		if (this.positionX > 540) {
			this.positionX = 540;
		} else if (this.positionX < 10) {
			this.positionX = 10;
		}

		if (this.positionY > 620) {
			this.positionY = 620;
		} else if (this.positionY < 100) {
			this.positionY = 100;
		}
	}
	
	protected void draw(Graphics graph) {
		graph.drawImage(this.meteoriteImage, this.positionX, this.positionY, null);
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public int getSpeedX() {
		return speedX;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public int getSpeedY() {
		return speedY;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}

}