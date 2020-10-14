

package fr.afpa.business.services;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import fr.afpa.cda.controller.MeteoriteImpactControl;
import fr.afpa.cda.controller.PlayerController;
import fr.afpa.dao.beans.ArrowBeans;
import fr.afpa.dao.beans.BackgroundBeans;
import fr.afpa.dao.beans.GameConstants;
import fr.afpa.dao.beans.EndPanel;
import fr.afpa.dao.beans.GameOverBeans;
import fr.afpa.dao.beans.MeteoriteBeans;
import fr.afpa.dao.beans.PlaneBeans;
import fr.afpa.dao.beans.PlayerBeans;
import fr.afpa.dao.beans.StartPanel;

public class GameBusiness extends JPanel {
	/*
	 * classe de jeu on integre les composants avion,fond,fleche,météorites
	 */
	public PlaneBeans plane;
	private PlayerBeans player;
	private List<MeteoriteBeans> meteorites;
	private BackgroundBeans gameBackground;
	private ArrowBeans arrows;
	private GameOverBeans gameOver;
	private EndPanel endPanel;
	private Thread gameThread;
	private Thread meteoriteThread;
	public boolean gameFinished;
	private Font police;
	private StartPanel startPanel;
	private PlayerController namePlayer;
	
	public GameBusiness() {

		super();

		this.player = new PlayerBeans();
		this.plane = new PlaneBeans();
		this.meteorites = new ArrayList<MeteoriteBeans>();
		this.gameBackground = new BackgroundBeans();
		this.arrows = new ArrowBeans();
		this.gameOver = new GameOverBeans();
		this.setFocusable(true);
		this.addKeyListener(new KeyboardListener());
		this.gameFinished = false;
		this.police = new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 24);
		this.namePlayer = new PlayerController();
		this.startPanel= new StartPanel();
		// le Thread est execute avant la fin du constructeur
		// comme c'est aléatoire :
		// plantage du jeu
		// idéal sortir le Threads du constructeur vers une fonction
		// et mettre
		// - gameThread.start();
		// - meteoritesSpawner.start();

		this.gameThread = new Thread(new GameThread());
		this.meteoriteThread = new Thread(new MeteoriteThread(this.meteorites));
		this.gameThread.setPriority(Thread.MAX_PRIORITY);
		this.meteoriteThread.setPriority(Thread.MIN_PRIORITY);
		this.gameThread.start();
		this.meteoriteThread.start();
	}

	/*
	 * calcule la position en fonction de la vitesse et empêche la sortie de l'écran
	 * sur une fenêtre de taille fixe fixe
	 * 
	 */
	public void logic() {

		this.plane.movePlane();

		synchronized (this.meteorites) {
			
			for (int i = 0; i < this.meteorites.size(); i++) {
				meteorites.get(i).move();
	
				if (meteorites.get(i).isDead() && !this.gameFinished) {
					this.player.setScore(this.player.getScore() + meteorites.get(i).getPoints());
				}
				
				if (MeteoriteImpactControl.meteorContact(this.plane, meteorites.get(i))) {
					
					planeGetHurt(meteorites.get(i));
					
					if (this.plane.getHealthPoints() <= 0) {
						this.gameFinished = true;
						if (namePlayer.nameControle()== true) {
							
								
							}
						}
					}
				}
			}
		}
	

	@Override
	protected void paintComponent(Graphics graph) {
		
		super.paintComponents(graph);
		Graphics graph2 = (Graphics2D) graph;

		if (this.gameFinished) {
			this.gameOver.draw(graph2);
			this.endPanel=new EndPanel();
			this.endPanel.draw(graph2);
		} else {
			this.startPanel = new StartPanel();
			this.startPanel.draw(graph2);
			
			this.gameBackground.draw(graph2);
			this.arrows.draw(graph2);
			this.plane.draw(graph2);
			paintMeteorites(graph2);
		}
		/*
		 * reglage compatibilité mac windows
		 * affichage du score pendant et à la fin de partie
		 * score ne dépasse pas 999
		 * score sur 3 chiffres
		 */
		graph2.setColor(Color.WHITE);
		graph2.fillRect(0, 0, 600, 75);
		graph2.setColor(Color.BLACK);
		
		if (this.player.getScore() <=9) {
			graph2.setFont(this.police);
			String string = String.valueOf("Score : 00" + this.player.getScore());
			graph2.drawString(string, 25, 50);

		} else if (this.player.getScore() > 9 && this.player.getScore() <= 99) {
			graph2.setFont(this.police);
			String string = String.valueOf("Score : 0" + this.player.getScore());
			graph2.drawString(string, 25, 50);

		} else if (this.player.getScore() > 99 || this.player.getScore() < GameConstants.MAX_SCORE) {
			graph2.setFont(this.police);
			String string = String.valueOf("Score : " + this.player.getScore());
			graph2.drawString(string, 25, 50);

		} else {
			graph2.setFont(this.police);
			graph2.drawString("Score : 999 ", 25, 50);
		}
		
	}

	protected void paintMeteorites(Graphics graph) {

		for (MeteoriteBeans meteorite : this.meteorites) {
			meteorite.draw(graph);
		}
	}
	
	public int planeGetHurt(MeteoriteBeans meteorite) {
		this.plane.setHealthPoints(this.plane.getHealthPoints() - meteorite.getDamage());
		return this.plane.getHealthPoints();
	}
	
	public String getPlayerName() {
		return this.player.getName();
	}
	
	public int getPlaneHealthPoints() {
		return this.plane.getHealthPoints();
	}
	
	public int getPlayerScore() {
		return this.player.getScore();
	}

}