package fr.afpa.dao.beans;

public class ZigzagMeteoriteBeans extends MeteoriteBeans implements FlyingObject{

	public ZigzagMeteoriteBeans(int positionX) {
		
		super(positionX, "/zigzagMeteoriteLeft.png");
		
		this.positionX = positionX;
		this.positionY = GameConstants.GAME_SCREEN_MIN_HEIGHT;
		this.speedX = 2;
		this.speedY = 1;
		this.damage = 2;
		this.points = 5;
	}

	@Override
	public void move() {
		
		int goalX = 0;

		if (this.positionX > GameConstants.GAME_SCREEN_MAX_WIDTH / 2) {
			goalX = this.positionX - 20;
			this.positionX -= this.speedX;
			this.positionY += this.speedY;
		}
		
		if (this.positionX < GameConstants.GAME_SCREEN_MAX_WIDTH / 2) {
			goalX = this.positionX + 20;
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
}