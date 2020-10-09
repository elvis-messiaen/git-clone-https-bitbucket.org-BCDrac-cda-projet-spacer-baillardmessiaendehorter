package fr.afpa.dao.beans;

public class SimpleMeteorite extends Meteorite implements FlyingObject{
	
	private int type;
	private int size;
	private int speed;
	private double positionX;
	private double positionY;

	@Override
	public void spawn() {
		
	}
	
	@Override
	public double move() {
		return this.positionY - 1;
	}

}
