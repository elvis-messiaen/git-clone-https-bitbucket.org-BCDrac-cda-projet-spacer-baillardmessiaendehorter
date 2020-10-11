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
	private ImageIcon icoPlane;
	private Image plane;
	private ImageIcon icoPlaneRight;
	private Image planeRight;
	private ImageIcon icoPlaneLeft;
	private Image planeLeft;
	private int healtPoint;
	private int positionX;
	private int positionY;
	private int speedX;
	private int speedY;
	private int largeur = 112;
	private int hauteur = 85;

	public PlaneBeans() {
		super();

		this.positionX = 300;
		this.positionY = 540;
		
		this.icoPlane = new ImageIcon(getClass().getResource("/plane2.gif"));
		this.plane = this.icoPlane.getImage();
		
		this.icoPlaneRight = new ImageIcon(getClass().getResource("/plane2right.gif"));
		this.planeRight = this.icoPlaneRight.getImage();
		
		this.icoPlaneLeft = new ImageIcon(getClass().getResource("/plane2left.gif"));
		this.planeLeft = this.icoPlaneLeft.getImage();
	}
/*
 * calcul la position en fonction de la vitesse
 * empeche la sortie de l'écran sur une taille de fenetre fixe 
 * 
 */
	public void movePlane() {
		
		this.positionX += speedX;
		this.positionY += speedY;
		
		if (positionX > 490) {
			positionX = 490;
		} else if (positionX < 10) {
			positionX = 10;
		}
		
		if (positionY > 560) {
			positionY = 560;
		} else if (positionY < 100) {
			positionY = 100;
		}
	}

	protected void draw(Graphics graph) {
		if (speedX < 0)
			graph.drawImage(this.planeLeft, this.positionX, this.positionY, null);
		else if (speedX > 0)
			graph.drawImage(this.planeRight, this.positionX, this.positionY, null);
		else
			graph.drawImage(this.plane, this.positionX, this.positionY, null);
	}
	
	/*
	 * Getter et Setter ne pas enlevé même si LOMBOK
	 * car sinon la classe Keyboard ne la voit pas !
	 * on les enleve à la fin du projet car j'bokai un souci avec le mac 
	 * je ne peux pas joindre le jar Lombok 
	 */
	public int getPositionX() {
		return positionX;
	}
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
	public int getPositionY() {
		return positionY;
	}
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	public int getSpeedX() {
		return speedX;
	}
	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}
	public int getSpeedY() {
		return speedY;
	}
	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}
	public int getLargeur() {
		return largeur;
	}
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}
	public int getHauteur() {
		return hauteur;
	}
	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}
	
	
	public ImageIcon getIcoPlane() {
		return icoPlane;
	}
	public void setIcoPlane(ImageIcon icoPlane) {
		this.icoPlane = icoPlane;
	}
	public Image getPlane() {
		return plane;
	}
	public void setPlane(Image plane) {
		this.plane = plane;
	}
	public ImageIcon getIcoPlaneRight() {
		return icoPlaneRight;
	}
	public void setIcoPlaneRight(ImageIcon icoPlaneRight) {
		this.icoPlaneRight = icoPlaneRight;
	}
	public Image getPlaneRight() {
		return planeRight;
	}
	public void setPlaneRight(Image planeRight) {
		this.planeRight = planeRight;
	}
	public ImageIcon getIcoPlaneLeft() {
		return icoPlaneLeft;
	}
	public void setIcoPlaneLeft(ImageIcon icoPlaneLeft) {
		this.icoPlaneLeft = icoPlaneLeft;
	}
	public Image getPlaneLeft() {
		return planeLeft;
	}
	public void setPlaneLeft(Image planeLeft) {
		this.planeLeft = planeLeft;
	}
	
	
	
}
