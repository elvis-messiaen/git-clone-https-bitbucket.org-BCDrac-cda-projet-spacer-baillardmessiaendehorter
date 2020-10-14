package fr.afpa.dao.beans;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class IcebergMeteoriteBeans extends MeteoriteBeans implements FlyingObject {

	private ImageIcon iconMeteorite;
	private Image imageMeteorite;
	private int damage = 4;
	private int meteoriteSize;
	private int positionX;
	private int positionY = 80;
	private int speedX;
	private int speedY = 2;
	private int points = 5;
	private boolean dead = false;

	public IcebergMeteoriteBeans(int positionX) {

		super();

		this.positionX = positionX;

		this.iconMeteorite = new ImageIcon(getClass().getResource("/iceMeteorite.png"));
		this.imageMeteorite = this.iconMeteorite.getImage();
	}

	@Override
	public void move() {

		this.positionY += this.speedY;

		if (this.positionX > GameConstants.GAME_SCREEN_MAX_WIDTH) {
			this.positionX = GameConstants.GAME_SCREEN_MAX_WIDTH;

		} else if (this.positionX < GameConstants.GAME_SCREEN_MIN_WIDTH) {
			this.positionX = GameConstants.GAME_SCREEN_MIN_WIDTH;
		}

		if (this.positionY > GameConstants.GAME_SCREEN_MAX_HEIGHT) {
			this.positionY = GameConstants.GAME_SCREEN_MAX_HEIGHT;
			this.dead = true;

		} else if (this.positionY < GameConstants.GAME_SCREEN_MIN_HEIGHT) {
			this.positionY = GameConstants.GAME_SCREEN_MIN_HEIGHT;
		}
	}

	public void draw(Graphics graph) {
		graph.drawImage(this.imageMeteorite, this.positionX, this.positionY, null);
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

	public int getDamage() {
		return this.damage;
	}

	public boolean isDead() {
		return this.dead;
	}

}