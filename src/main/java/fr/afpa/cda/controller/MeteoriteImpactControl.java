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

	private PlaneBeans plane;
	private MeteoriteBeans meteorite;

	public MeteoriteImpactControl(PlaneBeans plane, MeteoriteBeans meteorite) {
		this.plane = plane;
		this.meteorite = meteorite;
	}

	
	/**
	 * Vérifie l'impact entre l'avion et la météorite
	 * 
	 * @return boolean
	 */
	public boolean meteorContact() {
		return checkPositionLeft() && checkPositionRight() && checkPositionTop() && checkPositionBottom();
	}

	
	/**
	 * Vérifie l'impact de gauche
	 * @return boolean
	 */
	private boolean checkPositionLeft() {
		return this.plane.getPositionX() < this.meteorite.getPositionX() + this.meteorite.getWidth();
	}

	
	/**
	 * Vérifie l'impact de droite
	 * @return boolean
	 */
	private boolean checkPositionRight() {
		return this.plane.getPositionX() + this.plane.getLargeur() > this.meteorite.getPositionX();
	}

	
	/**
	 * Vérifie l'impact du haut
	 * @return boolean
	 */
	private boolean checkPositionTop() {
		return this.plane.getPositionY() < this.meteorite.getPositionY() + this.meteorite.getWidth();
	}

	
	/**
	 * Vérifie l'impact du bas
	 * @return boolean
	 */
	private boolean checkPositionBottom() {
		return this.plane.getPositionY() + this.plane.getHauteur() > this.meteorite.getPositionY();
	}
}