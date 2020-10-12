package fr.afpa.cda.controller;

import fr.afpa.dao.beans.PlaneBeans;
import fr.afpa.dao.beans.MeteoriteBeans;
import lombok.Getter;
import lombok.Setter;


/**
 * Contrôle l'impact entre l'avion et les météorites
 * 
 * @author Elvis, édité par Cécile
 */
@Getter
@Setter
public class MeteoriteImpactControl {


	/**
	 * Vérifie l'impact entre l'avion et la météorite
	 * 
	 * @return boolean
	 */
	public static boolean meteorContact(PlaneBeans plane,MeteoriteBeans meteorite) {

		if (plane.getPositionX() < meteorite.getPositionX() + meteorite.getWidth()
				&& plane.getPositionX() + plane.getLargeur() > meteorite.getPositionX()
				&& plane.getPositionY() < meteorite.getPositionY() + meteorite.getHeight()
				&& plane.getPositionY() + plane.getHauteur() > meteorite.getPositionY()) {

			return true;
		}
		return false;

	}
	

}