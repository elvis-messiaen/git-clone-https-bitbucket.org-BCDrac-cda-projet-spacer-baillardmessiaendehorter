package fr.afpa.dao.beans;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * Interface gerant le comportement des météorittes
 * 
 * @author Cécile
 */
public interface FlyingObject {

	public void move();
	
	public void draw(Graphics graph);

	public int getPositionX();

	public void setPositionX(int positionX);
	
	public int getPositionY();

	public void setPositionY(int positionY);

	public int getSpeedX();

	public void setSpeedX(int speedX);

	public int getSpeedY();

	public void setSpeedY(int speedY);
	
	public boolean isDead();

	public int getWidth();

	public void setWidth(int width);

	public int getHeight();

	public void setHeight(int height);
	
	public ImageIcon getIconMeteorite();
	
	public void setIconMeteorite(ImageIcon iconMeteorite);
	
	public Image getImageMeteorite();
	
	public void setImageMeteorite(Image imageMeteorite);
	
	public int getDamage();
	
	public void setDamage(int damage);
	
	public int getPoints();
	
	public void setPoints(int points);
	
	public void setDead(boolean dead);
}