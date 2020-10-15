package fr.afpa.cda.View;

/**
 * Thread principal du jeu
 * 
 * Classe rendant le deplacement de l'avion plus fluide
 * 
 * @author Elvis
 */
public class GameThread implements Runnable {
	
	private boolean running;
	private boolean gameOver;
	private GamePanel game;
	
	public GameThread(GamePanel game) {
		this.game = game;
	}
	
	/**
	 * Appel de la fonction movePlane() pour définir la postion de l'avion en fonction de sa vitesse
	 * thread(1000/60) niveau de rafraichissment d'image équivalent jeu rps
	 */
	@Override
	public void run() {
		running = true;
		while (running) {
			if (!gameOver) {
			this.game.logic();
			}
			this.game.repaint();

			try {
				Thread.sleep(1000 / 60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void setRunning(boolean running) {
		this.running = running;
	}
	
	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}
}