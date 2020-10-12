package fr.afpa.dao.beans;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameOverBeans {

	private ImageIcon icoBoom;
	private Image boom;
	
	private ImageIcon icoGameOver;
	private Image gameOver;

	public GameOverBeans() {

		super();
  
		this.icoBoom = new ImageIcon(getClass().getResource("/explosion.gif"));
		this.boom = this.icoBoom.getImage();
		
		this.icoGameOver = new ImageIcon(getClass().getResource("/gameOver.gif"));
		this.gameOver = this.icoGameOver.getImage();
	}

	protected void draw(Graphics graph2) {
		graph2.drawImage(this.boom, 0, 75, null);
		graph2.drawImage(this.gameOver, 50, 150, null);
	}

}
