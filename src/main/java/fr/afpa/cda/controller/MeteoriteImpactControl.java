package fr.afpa.cda.controller;

import fr.afpa.dao.beans.MeteoriteAbstractBeans;
import fr.afpa.dao.beans.PlaneBeans;
import lombok.Getter;
import lombok.Setter;


/**
 * Contrôle l'impact entre l'avion et les météorites
 * 
 * @author Elvis
 */
@Getter
@Setter
public class MeteoriteImpactControl {


	/**
	 * Vérifie l'impact entre l'avion et la météorite
	 * 
	 * @return boolean
	 */
	public boolean meteorContact(PlaneBeans plane, MeteoriteAbstractBeans meteorite) {

		if (plane.getPositionX() < meteorite.getPositionX() + meteorite.getWidth()
				&& plane.getPositionX() + plane.getLargeur() > meteorite.getPositionX()
				&& plane.getPositionY() < meteorite.getPositionY() + meteorite.getHeight()
				&& plane.getPositionY() + plane.getHauteur() > meteorite.getPositionY()) {
			
			return true;
		}
		return false;
	}

}