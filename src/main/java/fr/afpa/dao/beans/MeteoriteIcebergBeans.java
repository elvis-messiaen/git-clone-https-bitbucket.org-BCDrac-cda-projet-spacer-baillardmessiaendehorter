package fr.afpa.dao.beans;

/**
 * Classe de la météorite iceberg
 * 
 * Hérite de MeteoriteAbstractBeans
 * 
 * @author Cécile
 */
public class MeteoriteIcebergBeans extends MeteoriteAbstractBeans {

	/**
	 * Constructeur de la météorite iceberg
	 * 
	 * Utilise le constructeur super() de la classe MeteoriteAbstractBeans
	 * 
	 * @param positionX : la position horizontale de la météorite iceberg
	 */
	public MeteoriteIcebergBeans(int positionX) {

		super(positionX, "/meteoriteIceberg.png");
		
		this.damage = 4;
		this.points = 5;
	}
}