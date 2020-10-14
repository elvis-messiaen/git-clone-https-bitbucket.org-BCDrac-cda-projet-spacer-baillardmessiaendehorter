package fr.afpa.dao.beans;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaneBeans {
	/*
	 * attribut de l'avion
	 */
	private ImageIcon iconPlane;
	private Image plane;
	private ImageIcon iconPlaneRight;
	private Image planeRight;
	private ImageIcon iconPlaneLeft;
	private Image planeLeft;
	private int healthPoints = 5;
	private int positionX;
	private int positionY;
	private int speedX;
	private int speedY;
	private int largeur = 112;
	private int hauteur = 85;

	public PlaneBeans() {

		this.positionX = 300;
		this.positionY = 540;
		
		this.iconPlane = new ImageIcon(getClass().getResource("/plane2.gif"));
		this.plane = this.iconPlane.getImage();
		
		this.iconPlaneRight = new ImageIcon(getClass().getResource("/plane2right.gif"));
		this.planeRight = this.iconPlaneRight.getImage();
		
		this.iconPlaneLeft = new ImageIcon(getClass().getResource("/plane2left.gif"));
		this.planeLeft = this.iconPlaneLeft.getImage();
	}
/*
 * calcul la position en fonction de la vitesse
 * empeche la sortie de l'écran sur une taille de fenetre fixe 
 * 
 */
	public void movePlane() {
		
		this.positionX += this.speedX;
		this.positionY += this.speedY;
		
		if (this.positionX > 490) {
			this.positionX = 490;
			
		} else if (this.positionX < 10) {
			this.positionX = 10;
		}
		
		if (this.positionY > 560) {
			this.positionY = 560;
			
		} else if (this.positionY < 100) {
			this.positionY = 100;
		}
	}

	public void draw(Graphics graph) {
		
		if (this.speedX < 0) {
			graph.drawImage(this.planeLeft, this.positionX, this.positionY, null);
			
		} else if (this.speedX > 0) {
			graph.drawImage(this.planeRight, this.positionX, this.positionY, null);
			
		} else {
			graph.drawImage(this.plane, this.positionX, this.positionY, null);
		}
	}
	
	/*
	 * Getter et Setter ne pas enlevé même si LOMBOK
	 * car sinon la classe Keyboard ne la voit pas !
	 * on les enleve à la fin du projet car j'bokai un souci avec le mac 
	 * je ne peux pas joindre le jar Lombok 
	 */
	public int getPositionX() {
		return this.positionX;
	}
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
	public int getPositionY() {
		return this.positionY;
	}
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	public int getSpeedX() {
		return this.speedX;
	}
	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}
	public int getSpeedY() {
		return this.speedY;
	}
	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}
	public int getLargeur() {
		return this.largeur;
	}
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}
	public int getHauteur() {
		return this.hauteur;
	}
	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}
	
	public ImageIcon getIconPlane() {
		return this.iconPlane;
	}
	
	public void setIconPlane(ImageIcon icoPlane) {
		this.iconPlane = icoPlane;
	}
	
	public Image getPlane() {
		return this.plane;
	}
	
	public void setPlane(Image plane) {
		this.plane = plane;
	}
	
	public ImageIcon getIconPlaneRight() {
		return this.iconPlaneRight;
	}
	
	public void setIconPlaneRight(ImageIcon icoPlaneRight) {
		this.iconPlaneRight = icoPlaneRight;
	}
	
	public Image getPlaneRight() {
		return this.planeRight;
	}
	
	public void setPlaneRight(Image planeRight) {
		this.planeRight = planeRight;
	}
	
	public ImageIcon getIconPlaneLeft() {
		return this.iconPlaneLeft;
	}
	
	public void setIconPlaneLeft(ImageIcon icoPlaneLeft) {
		this.iconPlaneLeft = icoPlaneLeft;
	}
	
	public Image getPlaneLeft() {
		return this.planeLeft;
	}
	
	public void setPlaneLeft(Image planeLeft) {
		this.planeLeft = planeLeft;
	}
	public int getHealthPoints() {
		return healthPoints;
	}
	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}
	
}