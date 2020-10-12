package fr.afpa.dao.beans;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import lombok.Getter;
import lombok.Setter;


/**
 * Classe de l'image de game over
 * 
 * @author Elvis
 */
@Getter
@Setter
public class GameOverBeans {

	private ImageIcon iconBoom;
	private Image imageBoom;
	
	private ImageIcon iconGameOver;
	private Image imageGameOver;

	
	/**
	 * Constructeur
	 */
	public GameOverBeans() {

		super();
  
		this.iconBoom = new ImageIcon(getClass().getResource("/explosion.gif"));
		this.imageBoom = this.iconBoom.getImage();
		
		this.iconGameOver = new ImageIcon(getClass().getResource("/gameOver.gif"));
		this.imageGameOver = this.iconGameOver.getImage();
	}

	
	/**
	 * Affiche le visuel de la classe
	 * 
	 * @param graph : le graphisme de la classe
	 */
	public void draw(Graphics graph) {
		graph.drawImage(this.imageBoom, 0, 75, null);
		graph.drawImage(this.imageGameOver, 50, 150, null);
	}
}