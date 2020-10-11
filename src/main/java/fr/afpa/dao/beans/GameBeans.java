package fr.afpa.dao.beans;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameBeans extends JPanel {
	/*
	 * classe de jeu
	 * on integre les composants avion,fond,fleche,météorites
	 */
	private PlaneBeans plane;
	private List<MeteoriteBeans> meteorites;
	private BackgroundBeans gameBackground;
	private ArrowBeans arrows;
	Random rand = new Random();

	public GameBeans() {

		super();

		this.plane = new PlaneBeans();
		this.meteorites = new ArrayList<MeteoriteBeans>();
		this.gameBackground = new BackgroundBeans();
		this.arrows = new ArrowBeans();

		this.setFocusable(true);
		this.addKeyListener(new Keyboard());

		Thread gameThread = new Thread(new GameThread());
		Thread meteoritesSpawner = new Thread(new Runnable() {
			public void run() {
				while (true) {
					if (meteorites.size() < 3) {
						try {
							generateMeteorites();
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					//meteoriteDie();
				}
			}
		});

		gameThread.start();
		meteoritesSpawner.start();
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
		}
	}

	@Override
	protected void paintComponent(Graphics graph) {

		super.paintComponents(graph);

		Graphics graph2 = (Graphics2D) graph;

		this.gameBackground.draw(graph2);
		this.arrows.draw(graph2);
		this.plane.draw(graph2);
		paintMeteorites(graph2);
	}

	protected void paintMeteorites(Graphics g) {

		for (MeteoriteBeans meteorite : this.meteorites) {
			meteorite.draw(g);
		}
	}

	private void generateMeteorites() {

		// int meteoriteType = this.rand.nextInt(5);
		int randPositionX = this.rand.nextInt(300);

		// switch (meteoriteType) {
		// case 0:
		this.meteorites.add(new SimpleMeteorite(randPositionX));
		// break;
		// }
	}

	private void meteoriteDie() {

		if (this.meteorites.size() > 0) {
			for (MeteoriteBeans meteorite : this.meteorites) {
				if (meteorite.getPositionY() == 620) {
					this.meteorites.remove(meteorite);
				}
			}
		}
	}

	public PlaneBeans getPlane() {
		return plane;
	}

}
