package fr.afpa.dao.beans;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class ZigzagMeteoriteBeans extends MeteoriteBeans implements FlyingObject{
	
	private ImageIcon iconMeteorite;
	private Image imageMeteorite;
	private int damage = 2;
	private int meteoriteSize;
	private int positionX;
	private int goalX;
	private int positionY = GameConstants.GAME_SCREEN_MIN_HEIGHT;
	private int speedX = 2;
	private int speedY = 1;
	private double angle = 30.0;
	private float amplitude = 8.0f;
	private int points = 5;
	private boolean dead = false;
	
	public ZigzagMeteoriteBeans(int positionX) {
		
		super();
		
		this.positionX = positionX;
		
		this.iconMeteorite = new ImageIcon(getClass().getResource("/zigzagMeteoriteLeft.png"));
		this.imageMeteorite = this.iconMeteorite.getImage();
	}

	@Override
	public void move() {
		

		if (this.positionX >= GameConstants.GAME_SCREEN_MAX_WIDTH / 2) {
			this.goalX = this.positionX - 20;
			this.positionX -= this.speedX;
			this.positionY += this.speedY;
		}
		
		if (this.positionX <= GameConstants.GAME_SCREEN_MAX_WIDTH / 2) {
			this.goalX = this.positionX + 20;
			this.positionX += this.speedX;
			this.positionY += this.speedY;
		}


		if (this.positionX > GameConstants.GAME_SCREEN_MAX_WIDTH) {
			this.positionX = GameConstants.GAME_SCREEN_MAX_WIDTH;
			this.positionX -= 10;

		} else if (this.positionX < GameConstants.GAME_SCREEN_MIN_WIDTH) {
			this.positionX = GameConstants.GAME_SCREEN_MIN_WIDTH;
			this.positionX += 10;
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
		return this.speedX;
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