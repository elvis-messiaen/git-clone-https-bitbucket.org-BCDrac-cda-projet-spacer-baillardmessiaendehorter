package fr.afpa.dao.beans;

public class IceMeteoriteBeans extends MeteoriteBeans implements FlyingObject{
	
	public IceMeteoriteBeans(int positionX) {
		
		super(positionX, "/iceMeteorite.png");

		this.damage = 2;
		this.points = 3;
	}
}