package fr.afpa.dao.beans;

public class IcebergMeteoriteBeans extends MeteoriteBeans {

	public IcebergMeteoriteBeans(int positionX) {

		super(positionX, "/icebergMeteorite.png");
		
		this.damage = 4;
		this.points = 5;
	}
}