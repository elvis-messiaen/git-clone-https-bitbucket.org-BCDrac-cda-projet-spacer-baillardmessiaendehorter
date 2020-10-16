package fr.afpa.dao.beans;

/**
 * Classe de la météorite de feu
 * 
 * Hérite de MeteoriteAbstractBeans
 * 
 * @author Cécile
 */
public class MeteoriteFireBeans extends MeteoriteAbstractBeans {
	
	/**
	 * Constructeur de la météorite de feu
	 * 
	 * Utilise le constructeur super() de la classe MeteoriteAbstractBeans
	 * 
	 * @param positionX : la position horizontale de la météorite de feu
	 */
	public MeteoriteFireBeans(int positionX) {
		
		super(positionX, "/meteoriteFire.png");
		
		this.damage = 2;
		this.speedY = 1;
		this.points = 1;
	}
}