package fr.afpa.dao.beans;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Classe contenant les éléments graphiques des fléches
 * 
 * @author Elvis
 */
@Getter
@Setter
public class ArrowBeans {

	private ImageIcon iconArrow;
	private Image imageArrow;

	/**
	 * Constructeur
	 */
	public ArrowBeans() {

		this.iconArrow = new ImageIcon(getClass().getResource("/keys.jpg"));
		this.imageArrow = this.iconArrow.getImage();
	}

	/**
	 * Affiche le visuel de la classe
	 * 
	 * @param graph : le graphisme de la classe
	 */
	public void draw(Graphics graph) {
		graph.drawImage(this.imageArrow, 10, 680, null);
	}
}