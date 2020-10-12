package fr.afpa.dao.beans;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Classe de l'image de fond du jeu
 * 
 * @author Elvis
 */
@Getter
@Setter
public class BackgroundBeans {

	private ImageIcon iconBackground;
	private Image imageBackground;

	/**
	 * Constructeur
	 */
	public BackgroundBeans() {
		
		this.iconBackground = new ImageIcon(getClass().getResource("/starfall2.gif"));
		this.imageBackground = this.iconBackground.getImage();
	}

	/**
	 * Affiche le visuel de la classe
	 * 
	 * @param graph : le graphisme de la classe
	 */
	public void draw(Graphics graph) {
		graph.drawImage(this.imageBackground, 0, 75, null);
	}
}