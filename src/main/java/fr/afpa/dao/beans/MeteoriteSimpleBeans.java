package fr.afpa.dao.beans;

public class MeteoriteSimpleBeans extends MeteoriteAbstractBeans implements FlyingObject {
	
	public MeteoriteSimpleBeans(int positionX) {
		
		super(positionX, "/meteorite.png");
		
		this.damage = 1;
		this.points = 2;
	}
}