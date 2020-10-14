package fr.afpa.dao.beans;

public class SimpleMeteoriteBeans extends MeteoriteBeans implements FlyingObject {
	
	public SimpleMeteoriteBeans(int positionX) {
		
		super(positionX, "/meteorite.png");
		
		this.damage = 1;
		this.points = 2;
	}
}