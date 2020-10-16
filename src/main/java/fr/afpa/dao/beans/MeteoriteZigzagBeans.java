package fr.afpa.dao.beans;

import javax.swing.ImageIcon;

/**
 * Classe de la météorite zig-zag
 * 
 * Hérite de MeteoriteAbstractBeans
 * 
 * @author Cécile
 */
public class MeteoriteZigzagBeans extends MeteoriteAbstractBeans {

	int goalX;
	int startX;
	int steps;
	int count;
	boolean left;
	
	/**
	 * Constructeur de la météorite zig-zag
	 * 
	 * Utilise le constructeur super() de la classe MeteoriteAbstractBeans
	 * 
	 * @param positionX : la position horizontale de la météorite zig-zag
	 */
	public MeteoriteZigzagBeans(int positionX) {

		super(positionX, "/zigzagMeteoriteLeft.png");

		this.positionX = positionX;
		this.startX = positionX;
		this.positionY = GameConstants.GAME_SCREEN_MIN_HEIGHT;
		this.speedX = 2;
		this.speedY = 1;
		this.damage = 2;
		this.points = 5;
		this.count = 0;
		this.left = false;
	}

	
	/**
	 * Override de la méthode move() de l'interface FlyingObject
	 * 
	 * Permet à la météorite de se déplacer en zig-zag, et change d'image suivant son déplacement
	 */
	@Override
	public void move() {

		if (this.positionX <= GameConstants.GAME_SCREEN_MIN_WIDTH) {
			this.positionX = GameConstants.GAME_SCREEN_MIN_WIDTH;

		} else if (this.positionX >= GameConstants.GAME_SCREEN_MAX_WIDTH) {
			this.positionX = GameConstants.GAME_SCREEN_MAX_WIDTH;
		}

		if (this.positionY > GameConstants.GAME_SCREEN_MAX_HEIGHT) {
			this.positionY = GameConstants.GAME_SCREEN_MAX_HEIGHT;
			this.dead = true;

		} else if (this.positionY < GameConstants.GAME_SCREEN_MIN_HEIGHT) {
			this.positionY = GameConstants.GAME_SCREEN_MIN_HEIGHT;
		}

		this.count++;
		this.positionY += this.speedY;

		// Move left
		if (this.left) {
			if (this.count < 60) {
				this.positionX -= this.speedX;
				this.iconMeteorite = new ImageIcon(getClass().getResource("/zigzagMeteoriteLeft.png"));
				this.imageMeteorite = this.iconMeteorite.getImage();

			} else if (this.count >= 60) {
				this.left = false;
				this.count = 0;
			}

		// Move right
		} else {
			if (this.count < 60) {
				this.positionX += this.speedX;
				this.iconMeteorite = new ImageIcon(getClass().getResource("/zigzagMeteoriteRight.png"));
				this.imageMeteorite = this.iconMeteorite.getImage();

			} else if (this.count >= 60) {
				this.left = true;
				this.count = 0;
			}
		}

	}
}