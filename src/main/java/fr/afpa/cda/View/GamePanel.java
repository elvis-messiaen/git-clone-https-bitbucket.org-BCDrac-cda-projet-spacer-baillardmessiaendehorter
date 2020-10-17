package fr.afpa.cda.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.Border;

import fr.afpa.cda.controller.GameController;
import fr.afpa.cda.controller.MeteoriteImpactControl;
import fr.afpa.cda.controller.PlayerController;
import fr.afpa.dao.beans.ArrowBeans;
import fr.afpa.dao.beans.BackgroundBeans;
import fr.afpa.dao.beans.GameConstants;
import fr.afpa.dao.beans.GameOverBeans;
import fr.afpa.dao.beans.MeteoriteAbstractBeans;
import fr.afpa.dao.beans.PlaneBeans;
import fr.afpa.dao.beans.PlayerBeans;

/**
 * Classe de jeu intégrant les composants avion, fond, fleches et météorites
 * 
 * @author Elvis
 */
public class GamePanel extends JPanel {
	
	public PlaneBeans plane;
	public PlayerBeans player;
	private List<MeteoriteAbstractBeans> meteorites;
	private MeteoriteImpactControl meteoriteImpactControl;
	private GameController gameControl;
	private PlayerController playerController;
	private BackgroundBeans gameBackground;
	private ArrowBeans arrows;
	private GameOverBeans gameOver;
	private EndPanel endPanel;
	private GameThread gameThread;
	private Thread meteoriteThread;
	public boolean gameIsFinished;
	private Font police;
	private int meteoriteAttack;
	private int meteoritePoints;
	private Timer timer;
	private JFrame window;
	
	/**
	 * Constructeur
	 * 
	 * @param player : le joueur qui va utiliser le jeu
	 */
	public GamePanel(PlayerBeans player) {

		this.player = player;
		this.plane = new PlaneBeans();
		this.meteorites = new ArrayList<MeteoriteAbstractBeans>();
		this.playerController = new PlayerController();
		this.gameControl = new GameController();
		this.meteoriteImpactControl = new MeteoriteImpactControl();
		this.gameBackground = new BackgroundBeans();
		this.arrows = new ArrowBeans();
		this.gameOver = new GameOverBeans();
		this.setFocusable(true);
		this.addKeyListener(new KeyboardListener(this));
		this.gameIsFinished = false;
		this.police = new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 24);
		
		window();
	}

	
	/**
	 * Crée les thread et les démarre pour lancer le jeu
	 * 
	 * @author Cécile
	 */
	public void startGame() {

		this.gameThread = new GameThread(this);
		Thread thread = new Thread(gameThread);
		this.meteoriteThread = new Thread(new MeteoriteThread(this.meteorites));
		
		thread.setPriority(Thread.MAX_PRIORITY);
		this.meteoriteThread.setPriority(Thread.MIN_PRIORITY);
		thread.start();
		this.meteoriteThread.start();
	}

	
	/**
	 * Méthode activée dans le thread du jeu
	 * 
	 * Gère les déplacements et l'état de l'avion, les déplacements des météorites,
	 * calcule la position en fonction de la vitesse et empêche la sortie de l'écran
	 * sur une fenêtre de taille fixe, gère les contacts entre l'avion et les météorites
	 * ainsi que l'affichage du score
	 * 
	 * @author Elvis
	 */
	public void logic() {

		this.plane.movePlane();
		this.meteoriteAttack = 0;

		synchronized (this.meteorites) {
			
			if (!this.meteorites.isEmpty()) {
				
				for (int i = 0; i < this.meteorites.size(); i++) {
					
					if (this.meteorites.get(i) != null) {

						this.meteorites.get(i).move();

						if (this.player.getScore() < GameConstants.MAX_SCORE) {

							if (this.meteorites.get(i).isDead()
									&& !this.meteoriteImpactControl.meteorContact(this.plane, this.meteorites.get(i))
									&& !this.gameIsFinished) {

								this.meteoritePoints = this.meteorites.get(i).getPoints();
								this.meteorites.remove(i);
								this.player.setScore(this.player.getScore() + this.meteoritePoints);
								this.meteoritePoints = 0;
							}

						} else {
							this.player.setScore(999);
						}

						if (!this.meteorites.isEmpty()) {

							if (this.meteorites.get(i) != null) {

								if (this.meteoriteImpactControl.meteorContact(this.plane, this.meteorites.get(i))) {

									this.meteoriteAttack = this.meteorites.get(i).getDamage();
									this.meteorites.remove(i);
								}
							}
						}
					}
				}

			}
		}

		if (this.meteoriteAttack != 0) {
			this.planeGetHurt(this.meteoriteAttack);
		}

		if (this.gameControl.planeIsDestroyed(this.plane.getHealthPoints())) {
			this.gameIsFinished = true;
			this.gameThread.setGameOver(true);
			
			/*
			 * planificateur de tache
			 * execute une fois
			 * on recupere le boolean de la classe thread que l'on met a false
			 * on definis la durée de l'execution  precédente notament animation de fin
			 */
			ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
			scheduler.schedule(new Runnable() {
				
				public void run() {
					
					endPanel = new EndPanel();
					window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
					gameThread.setRunning(false);

				}
			}, 2, TimeUnit.SECONDS);
		}
	}

	
	/**
	 * Permet d'infliger des dégâts à l'avion
	 * 
	 * @param damage : les dégâts à inflliger à l'avion
	 * @return int : les points de vie restants à l'avion
	 */
	public int planeGetHurt(int damage) {
		this.plane.setHealthPoints(this.plane.getHealthPoints() - damage);
		return this.plane.getHealthPoints();
	}
	
	
	/**
	 * Méthode dessinant les éléments graphiques.
	 * 
	 * On ameliore le rendu avec Graphics2D.
	 * 
	 * @param graph : le graphisme à afficher
	 * 
	 * @author Elvis
	 */
	@Override
	protected void paintComponent(Graphics graph) {

		super.paintComponents(graph);
		Graphics graph2 = (Graphics2D) graph;

			if (this.gameIsFinished) {
			gameOver.draw(graph2);
		} else {
			this.gameBackground.draw(graph2);
			this.arrows.draw(graph2);
			this.plane.draw(graph2);
			paintMeteorites(graph2);
		}

		/*
		 * reglage compatibilité mac windows affichage du score pendant et à la fin de
		 * partie score ne dépasse pas 999 score sur 3 chiffres
		 */
		graph2.setColor(Color.WHITE);
		graph2.fillRect(0, 0, 600, 75);
		graph2.setColor(Color.BLACK);
		graph2.setFont(this.police);

		showScore(graph2);

		String name =  String.valueOf ("Name : " + this.player.getName());		
		graph2.drawString(name, 250, 50);

		String life = String.valueOf("HP : " + this.plane.getHealthPoints());
		graph2.drawString(life, 500, 50);
		
	}
	

	/**
	 * Permet l'affichage des météorites
	 * 
	 * @param graph : l'image à  afficher
	 */
	protected void paintMeteorites(Graphics graph) {
		for (int i = 0; i < this.meteorites.size(); i++) {
			this.meteorites.get(i).draw(graph);
		}
	}

	
	/**
	 * Affiche le score sur la fenêtre de jeu
	 * 
	 * @param graph : le graphisme à afficher
	 */
	public void showScore(Graphics graph) {
		graph.setFont(this.police);
		graph.drawString("Score : " + String.format("%03d", this.player.getScore()), 20, 50);
	}

	
	/**
	 * La fenêtre du jeu
	 * 
	 * @author Julien
	 */
	public void window() {

		// Instanciations des différents élements
		window = new JFrame("Mon jeu d'avion");

		JPanel panelDisplay = new JPanel();
		JPanel panelButtons = new JPanel();

		JLabel keys = new JLabel();

		Border blackline = BorderFactory.createLineBorder(Color.black, 3);

		// Paramétrage des éléments

		// Elements JFrame
		window.setLayout(new BorderLayout());
		window.setSize(GameConstants.WINDOW_MAX_WIDTH, GameConstants.WINDOW_MAX_HEIGHT);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.setAlwaysOnTop(true);

		// Elements JPanel
		panelDisplay.setLayout(new BorderLayout());
		panelDisplay.setPreferredSize(new Dimension(400, 200));
		panelDisplay.setBorder(blackline);

		panelButtons.setLayout(new BorderLayout());
		panelButtons.setPreferredSize(new Dimension(200, 200));
		panelButtons.setBorder(blackline);

		// Assemblage du panel panelButtons
		panelButtons.add(keys, BorderLayout.CENTER);
		panelButtons.add(keys, BorderLayout.CENTER);

		// panelDisplay.add(infos(), BorderLayout.NORTH);

		// Assemblage de la fenêtre
		window.add(panelDisplay, BorderLayout.CENTER);
		window.add(panelButtons, BorderLayout.SOUTH);

		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.setAlwaysOnTop(false);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.setAlwaysOnTop(false);

		window.setContentPane(this);
		window.setVisible(true);
	}

}