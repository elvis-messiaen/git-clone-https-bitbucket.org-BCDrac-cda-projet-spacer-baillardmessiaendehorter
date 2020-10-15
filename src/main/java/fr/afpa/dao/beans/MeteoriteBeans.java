package fr.afpa.dao.beans;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class MeteoriteBeans implements FlyingObject {

	protected ImageIcon iconMeteorite;
	protected Image imageMeteorite;
	protected int damage;
	protected int positionX;
	protected int positionY;
	protected int speedX;
	protected int speedY;
	protected boolean dead;
	protected int width;
	protected int height;
	protected int points;
	
	public MeteoriteBeans(int positionX, String imagePath) {
		
		this.positionY = GameConstants.GAME_SCREEN_MIN_HEIGHT;
		this.speedY = 2;
		this.width = 20;
		this.height = 20;
		this.dead = false;
		
		this.positionX = positionX;
		
		this.iconMeteorite = new ImageIcon(getClass().getResource(imagePath));
		this.imageMeteorite = this.iconMeteorite.getImage();
	}
	
	
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
	
	public ImageIcon getIconMeteorite() {
		return iconMeteorite;
	}
	
	public void setMeteoriteIcon(ImageIcon iconMeteorite) {
		this.iconMeteorite = iconMeteorite;
	}
	
	public Image getImageMeteorite() {
		return imageMeteorite;
	}
	
	public void setImageMeteorite(Image imageMeteorite) {
		this.imageMeteorite = imageMeteorite;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
	
	public void setDead(boolean dead) {
		this.dead = dead;
	}
}