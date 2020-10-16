package fr.afpa.dao.beans;

public class MeteoriteFireBeans extends MeteoriteAbstractBeans implements FlyingObject{
	
	public MeteoriteFireBeans(int positionX) {
		
		super(positionX, "/meteoriteFire.png");
		
		this.damage = 2;
		this.speedY = 1;
		this.points = 1;
	}
}