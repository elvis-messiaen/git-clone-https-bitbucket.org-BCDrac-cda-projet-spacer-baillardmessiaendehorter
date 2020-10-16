package fr.afpa.dao.beans;

public class MeteoriteIceBeans extends MeteoriteAbstractBeans implements FlyingObject{
	
	public MeteoriteIceBeans(int positionX) {
		
		super(positionX, "/meteoriteIce.png");

		this.damage = 2;
		this.points = 3;
	}
}