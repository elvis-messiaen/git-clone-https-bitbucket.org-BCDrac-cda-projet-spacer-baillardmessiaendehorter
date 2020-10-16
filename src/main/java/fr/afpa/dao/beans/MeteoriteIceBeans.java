package fr.afpa.dao.beans;

/**
 * Classe de la météorite de glace
 * 
 * Hérite de MeteoriteAbstractBeans
 * 
 * @author Cécile
 */
public class MeteoriteIceBeans extends MeteoriteAbstractBeans {
	
	/**
	 * Constructeur de la météorite de glace
	 * 
	 * Utilise le constructeur super() de la classe MeteoriteAbstractBeans
	 * 
	 * @param positionX : la position horizontale de la météorite de glace
	 */
	public MeteoriteIceBeans(int positionX) {
		
		super(positionX, "/meteoriteIce.png");

		this.damage = 2;
		this.points = 3;
	}
}