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
public class ArrowBeans {
	/*
	 * attribut arrow
	 */
	private ImageIcon icoArrow;
	private Image arrow;

	public ArrowBeans() {
		super();
		icoArrow = new ImageIcon(getClass().getResource("/keys.jpg"));
		this.arrow = this.icoArrow.getImage();
	}

	protected void draw(Graphics graph3) {
		graph3.drawImage(arrow, 10, 660, null);
	}

}
