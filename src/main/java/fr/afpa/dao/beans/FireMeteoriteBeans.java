package fr.afpa.dao.beans;

public class FireMeteoriteBeans extends MeteoriteBeans implements FlyingObject{
	
	public FireMeteoriteBeans(int positionX) {
		
		super(positionX, "/fireMeteorite.png");
		
		this.damage = 2;
		this.speedY = 1;
		this.points = 1;
	}
}