package fr.afpa.dao.beans;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import fr.afpa.cda.cda_projet_spacer_BaillardMessiaenDehorter.Test;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class BackgroundBeans {
	/*
	 * attribut du fond
	 */
	private ImageIcon icoBackground;
	private Image background;

	public BackgroundBeans() {
		
		super();
		
		this.icoBackground = new ImageIcon(getClass().getResource("/starfall.gif"));
		this.background = this.icoBackground.getImage();
	}

	protected void draw(Graphics graph2) {
		graph2.drawImage(this.background, 0, 75, null);
	}

}
