package fr.afpa.cda.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
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
import fr.afpa.dao.beans.MeteoriteBeans;
import fr.afpa.dao.beans.PlaneBeans;
import fr.afpa.dao.beans.PlayerBeans;

public class GamePanel extends JPanel {
	/*
	 * classe de jeu on integre les composants avion,fond,fleche,météorites
	 */
	public PlaneBeans plane;
	public PlayerBeans player;
	private List<MeteoriteBeans> meteorites;
	private MeteoriteImpactControl meteoriteImpact = new MeteoriteImpactControl();
	private GameController gameControl = new GameController();
	private PlayerController playControle;
	private BackgroundBeans gameBackground;
	private ArrowBeans arrows;
	private GameOverBeans gameOver;
	private EndPanel endPanel;
	private GameThread gameThread;
	private Thread meteoriteThread;
	public boolean gameIsFinished;
	private Font police;
	private int meteoriteAttack;
	private Timer timer;
	private JFrame window;
	
	public GamePanel(PlayerBeans joueur) {

		this.player =joueur;
		System.out.println(player.getName());
		this.plane = new PlaneBeans();
		this.meteorites = new ArrayList<MeteoriteBeans>();
		this.playControle = new PlayerController();
		this.gameBackground = new BackgroundBeans();
		this.arrows = new ArrowBeans();
		this.gameOver = new GameOverBeans();
		this.setFocusable(true);
		this.addKeyListener(new KeyboardListener(this));
		this.gameIsFinished = false;
		this.police = new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 24);
		
		window();
	}

	public void startGame() {

		this.gameThread = new GameThread(this);
		Thread thread = new Thread(gameThread);
		this.meteoriteThread = new Thread(new MeteoriteThread(this.meteorites));
		thread.setPriority(Thread.MAX_PRIORITY);
		this.meteoriteThread.setPriority(Thread.MIN_PRIORITY);
		thread.start();
		this.meteoriteThread.start();
	}

	/*
	 * calcule la position en fonction de la vitesse et empêche la sortie de l'écran
	 * sur une fenêtre de taille fixe fixe
	 * 
	 */
	public void logic() {

		this.plane.movePlane();
		this.meteoriteAttack = 0;

		synchronized (this.meteorites) {

			for (int i = 0; i < this.meteorites.size(); i++) {
				this.meteorites.get(i).move();

				if (this.meteorites.get(i).isDead() && !this.gameIsFinished) {
					this.player.setScore(this.player.getScore() + this.meteorites.get(i).getPoints());
				}

				if (this.meteoriteImpact.meteorContact(this.plane, this.meteorites.get(i))) {
					this.meteoriteAttack = this.meteorites.get(i).getDamage();
					this.meteorites.remove(this.meteorites.get(i));
				}
			}
		}

		if (this.meteoriteAttack != 0) {
			planeGetHurt(this.meteoriteAttack);
		}

		if (this.gameControl.planeIsDestroyed(this.plane.getHealthPoints())) {
			this.gameIsFinished = true;
			gameThread.setGameOver(true);
			/*
			 * planificateur de tache
			 * 
			 */
			 ScheduledExecutorService scheduler =
				     Executors.newScheduledThreadPool(1);
			 scheduler.schedule(new Runnable() {
			       public void run() {
						  endPanel=new EndPanel();
							window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
							gameThread.setRunning(false);

			    }
			     }, 2, TimeUnit.SECONDS);
		}
	}

	public int planeGetHurt(int damage) {
		this.plane.setHealthPoints(this.plane.getHealthPoints() - damage);
		return this.plane.getHealthPoints();
	}

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
		System.out.println(name);
		graph2.drawString(name, 250, 50);

		String life = String.valueOf("HP : " + this.plane.getHealthPoints());
		graph2.drawString(life, 500, 50);

	}

	protected void paintMeteorites(Graphics graph) {
		for (MeteoriteBeans meteorite : this.meteorites) {
			meteorite.draw(graph);
		}
	}

	public void showScore(Graphics graph2) {
		graph2.setFont(this.police);
		graph2.drawString(this.gameControl.checkScore(this.player.getScore()), 20, 50);
	}

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