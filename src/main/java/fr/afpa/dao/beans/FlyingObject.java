package fr.afpa.dao.beans;

/**
 * Interface gerant le comportement des météorittes
 * 
 * @author Cécile
 */
public interface FlyingObject {
	
	@Deprecated
	public void spawn();	
	public void move();
}