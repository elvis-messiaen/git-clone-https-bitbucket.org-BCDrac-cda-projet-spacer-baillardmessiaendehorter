package fr.afpa.dao.beans;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import fr.afpa.dao.beans.GameConstants;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class MeteoriteBeans implements FlyingObject {

	private ImageIcon meteoriteIcon;
	private Image imageMeteorite;
	private int damage;
	private int meteoriteSize;
	private int positionX;
	private int positionY = 80;
	private int speedX;
	private int speedY = 2;
	private boolean dead = false;
	private int width = 20;
	private int height = 20;
	
	
	@Override
	public void move() {

	}
	
	public void draw(Graphics graph) {
		graph.drawImage(this.imageMeteorite, this.positionX, this.positionY, null);
	}

	public int getPositionX() {
		return this.positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return this.positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public int getSpeedX() {
		return this.speedX;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public int getSpeedY() {
		return this.speedY;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}
	
	public boolean isDead() {
		return this.dead;
	}

	public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}