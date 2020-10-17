package fr.afpa.dao.beans;

/**
 * Classe de la météorite basique
 * 
 * Hérite de MeteoriteAbstractBeans
 * 
 * @author Cécile
 */
public class MeteoriteSimpleBeans extends MeteoriteAbstractBeans {
	
	/**
	 * Constructeur de la météorite basique
	 * 
	 * Utilise le constructeur super() de la classe MeteoriteAbstractBeans
	 * 
	 * @param positionX : la position horizontale de la météorite basique
	 */
	public MeteoriteSimpleBeans(int positionX) {
		
		super(positionX, "/meteorite.png");
		
		this.damage = 1;
		this.points = 2;
	}
}