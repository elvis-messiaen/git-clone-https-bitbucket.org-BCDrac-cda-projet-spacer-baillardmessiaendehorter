package fr.afpa.dao.beans;

import javax.swing.ImageIcon;

public class IcebergMeteoriteBeans extends MeteoriteBeans {

	public IcebergMeteoriteBeans(int positionX) {

		super(positionX, "/icebergMeteorite.png");
		
		this.damage = 4;
		this.points = 5;
	}

	@Override
	public void setIconMeteorite(ImageIcon iconMeteorite) {
		
		
	}
}