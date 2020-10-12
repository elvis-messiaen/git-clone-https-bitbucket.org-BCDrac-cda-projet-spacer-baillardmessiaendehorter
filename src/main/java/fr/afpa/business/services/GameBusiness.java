package fr.afpa.business.services;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import fr.afpa.cda.controller.MeteoriteImpactControl;
import fr.afpa.dao.beans.ArrowBeans;
import fr.afpa.dao.beans.BackgroundBeans;
import fr.afpa.dao.beans.GameOverBeans;
import fr.afpa.dao.beans.MeteoriteBeans;
import fr.afpa.dao.beans.PlaneBeans;
import lombok.Getter;
import lombok.Setter;


public class GameBusiness extends JPanel {
	/*
	 * classe de jeu
	 * on integre les composants avion,fond,fleche,météorites
	 */
	private PlaneBeans plane;
	private List<MeteoriteBeans> meteorites;
	private BackgroundBeans gameBackground;
	private ArrowBeans arrows;
	private GameOverBeans gameOver;
	private Thread meteoritesSpawner;
	private Thread gameThread;
	private Thread meteoriteThread;
	private boolean gameO;

	public GameBusiness() {

		super();

		this.plane = new PlaneBeans();
		this.meteorites = new ArrayList<MeteoriteBeans>();
		this.gameBackground = new BackgroundBeans();
		this.arrows = new ArrowBeans();
		this.gameOver = new GameOverBeans();
		this.setFocusable(true);
		this.addKeyListener(new KeyboardListener());
		this.gameO = false;
		
		// le Thread est executé avant la fin du constructeur
		// comme c'est aléatoire :
		// plantage du jeu
		//  idéal sortir le Threads du constructeur vers une fonction
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
		for (MeteoriteBeans meteorite : this.meteorites) {
			meteorite.move();
			if (MeteoriteImpactControl.meteorContact(plane,  meteorite)) {
				this.gameO = true;

			}
		}
	}

	@Override
	protected void paintComponent(Graphics graph) {
		super.paintComponents(graph);
		Graphics graph2 = (Graphics2D) graph;
		if (gameO == true) {
			this.gameOver.draw(graph2);
		} else {
			this.gameBackground.draw(graph2);
			this.arrows.draw(graph2);
			this.plane.draw(graph2);
			paintMeteorites(graph2);

		}

	}

	protected void paintMeteorites(Graphics graph) {

		for (MeteoriteBeans meteorite : this.meteorites) {
			meteorite.draw(graph);
		}
	}

	public PlaneBeans getPlane() {
		return plane;
	}

	public void setPlane(PlaneBeans plane) {
		this.plane = plane;
	}

	public List<MeteoriteBeans> getMeteorites() {
		return meteorites;
	}

	public void setMeteorites(List<MeteoriteBeans> meteorites) {
		this.meteorites = meteorites;
	}

	public BackgroundBeans getGameBackground() {
		return gameBackground;
	}

	public void setGameBackground(BackgroundBeans gameBackground) {
		this.gameBackground = gameBackground;
	}

	public ArrowBeans getArrows() {
		return arrows;
	}

	public void setArrows(ArrowBeans arrows) {
		this.arrows = arrows;
	}

	public GameOverBeans getGameOver() {
		return gameOver;
	}

	public void setGameOver(GameOverBeans gameOver) {
		this.gameOver = gameOver;
	}

	public Thread getMeteoritesSpawner() {
		return meteoritesSpawner;
	}

	public void setMeteoritesSpawner(Thread meteoritesSpawner) {
		this.meteoritesSpawner = meteoritesSpawner;
	}

	public Thread getGameThread() {
		return gameThread;
	}

	public void setGameThread(Thread gameThread) {
		this.gameThread = gameThread;
	}

	public Thread getMeteoriteThread() {
		return meteoriteThread;
	}

	public void setMeteoriteThread(Thread meteoriteThread) {
		this.meteoriteThread = meteoriteThread;
	}
	
}