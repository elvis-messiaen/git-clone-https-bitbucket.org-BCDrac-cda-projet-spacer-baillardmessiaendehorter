package fr.afpa.dao.beans;

public class MeteoriteIcebergBeans extends MeteoriteAbstractBeans {

	public MeteoriteIcebergBeans(int positionX) {

		super(positionX, "/meteoriteIceberg.png");
		
		this.damage = 4;
		this.points = 5;
	}
}