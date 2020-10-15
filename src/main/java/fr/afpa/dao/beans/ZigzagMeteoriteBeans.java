package fr.afpa.dao.beans;

public class ZigzagMeteoriteBeans extends MeteoriteBeans implements FlyingObject {

	int goalX;
	int startX;
	int steps;
	int count;
	boolean hasMovedOnce;

	public ZigzagMeteoriteBeans(int positionX) {

		super(positionX, "/zigzagMeteoriteLeft.png");

		this.positionX = positionX;
		this.startX = positionX;
		this.positionY = GameConstants.GAME_SCREEN_MIN_HEIGHT;
		this.speedX = 2;
		this.speedY = 1;
		this.damage = 2;
		this.points = 5;
		this.count = 0;
		this.hasMovedOnce = false;
	}

	@Override
	public void move() {

		/*
		 * 
		 * if (this.positionX > GameConstants.GAME_SCREEN_MAX_WIDTH) { this.positionX =
		 * GameConstants.GAME_SCREEN_MAX_WIDTH;
		 * 
		 * } else if (this.positionX < GameConstants.GAME_SCREEN_MIN_WIDTH) {
		 * this.positionX = GameConstants.GAME_SCREEN_MIN_WIDTH; }
		 * 
		 * 

		 * if (this.goalX > GameConstants.GAME_SCREEN_MAX_WIDTH / 2) {
		 * 
		 * if (this.positionX > this.goalX && !this.hasMovedOnce) { this.positionX -=
		 * this.speedX; this.positionY += this.speedY; }
		 * 
		 * if (this.positionX == this.goalX) { this.hasMovedOnce = true; }
		 * 
		 * if (this.positionX == this.goalX && this.hasMovedOnce) { this.positionX +=
		 * this.speedX; this.positionY += this.speedY;
		 * 
		 * if (this.positionX == this.startX) { this.hasMovedOnce = false; } }
		 * 
		 * } else if (this.goalX > GameConstants.GAME_SCREEN_MAX_WIDTH / 2) {
		 * 
		 * if (this.positionX < this.goalX && !this.hasMovedOnce) { this.positionX +=
		 * this.speedX; this.positionY += this.speedY; }
		 * 
		 * if (this.positionX == this.goalX) { this.hasMovedOnce = true; }
		 * 
		 * if (this.positionX == this.goalX && this.hasMovedOnce) { this.positionX -=
		 * this.speedX; this.positionY += this.speedY;
		 * 
		 * if (this.positionX == this.startX) { this.hasMovedOnce = false; } } }
		 */

		this.positionX += this.speedX;
		this.positionY += this.speedY;

		// If knock a wall, revert horizontal speed
		if (this.positionX <= GameConstants.GAME_SCREEN_MIN_WIDTH) {
			this.positionX = GameConstants.GAME_SCREEN_MIN_WIDTH;

			if (this.count <= 0) {
				this.speedX -= speedX;
				this.count++;
			}

		} else if (this.positionX >= GameConstants.GAME_SCREEN_MAX_WIDTH) { // Replace 600 by game screen // width
			this.positionX = GameConstants.GAME_SCREEN_MAX_WIDTH;// Replace 600 by game screen width

			if (this.count <= 0) {
				this.speedX -= speedX;
				this.count++;
			}
		}

		if (this.count >= 2) {
			this.speedX = -2;
			this.count--;
		}

		if (this.positionY > GameConstants.GAME_SCREEN_MAX_HEIGHT) {
			this.positionY = GameConstants.GAME_SCREEN_MAX_HEIGHT;
			this.dead = true;

		} else if (this.positionY < GameConstants.GAME_SCREEN_MIN_HEIGHT) {
			this.positionY = GameConstants.GAME_SCREEN_MIN_HEIGHT;
		}

		// bonus random speedX variation
		/*
		Random random = new Random();
		if (random.nextInt(5 * 60) % 2 == 0) {// Randomly every 5 seconds
			speedX = random.nextInt(5) - 2; // from -2 to + 2
		}
		*/

	}
}