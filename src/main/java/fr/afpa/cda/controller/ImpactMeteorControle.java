package fr.afpa.cda.controller;

import fr.afpa.dao.beans.PlaneBeans;
import fr.afpa.dao.beans.SimpleMeteorite;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImpactMeteorControle {
private PlaneBeans plane;
private SimpleMeteorite simpMeteor;
	public boolean meteorContact() {

		if (plane.getPositionX() < simpMeteor.getPositionX() + simpMeteor.getLargeur()
				&& plane.getPositionX() + plane.getLargeur() > simpMeteor.getPositionX()
				&& plane.getPositionY() < simpMeteor.getPositionY() + simpMeteor.getHauteur()
				&& plane.getPositionY() + plane.getHauteur() > simpMeteor.getPositionY()) {

			return true;
		}
		return false;

	}
	
}
