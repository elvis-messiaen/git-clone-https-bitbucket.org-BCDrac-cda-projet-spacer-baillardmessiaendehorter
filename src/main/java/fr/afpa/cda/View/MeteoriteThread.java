package fr.afpa.cda.View;

import java.util.List;

import fr.afpa.cda.controller.GameController;
import fr.afpa.dao.beans.MeteoriteAbstractBeans;


/**
 * Classe du thread des météorites
 * 
 * Gère la génération et la destruction des météorites
 * 
 * @author Elvis
 */
public class MeteoriteThread implements Runnable {

	private List<MeteoriteAbstractBeans> meteorites;
	private GameController gameControl;

	
	/**
	 * Constructeur
	 * @param meteorites : la liste qui contiendra les météorites du jeu
	 */
	public MeteoriteThread(List<MeteoriteAbstractBeans> meteorites) {
		this.meteorites = meteorites;
		this.gameControl = new GameController();
	}

	@Override
	public void run() {

		while (true) {

			this.meteoriteDie();

			if (this.canGenerateMeteorites()) {
				
				try {
					this.generateMeteorites();
					
					Thread.sleep(500);
					this.generateMeteorites();
					
					Thread.sleep(1000);

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	/**
	 * Vérifie si on peut générer des météorites
	 * 
	 * @return boolean : retourne true si on peut générer des météorites
	 */
	private boolean canGenerateMeteorites() {
		return this.gameControl.canGenerateMeteorites(this.meteorites);
	}

	
	/**
	 * Génère une météorite dans la liste
	 */
	private void generateMeteorites() {

		if (this.canGenerateMeteorites()) {
			this.meteorites.add(this.gameControl.generateMeteorites());
		}
	}
	
	/**
	 * Permet de détruire une météorite
	 */
	private void meteoriteDie() {

		synchronized (this.meteorites) {
			
			if (this.gameControl.meteoritesExist(this.meteorites)) {
				this.meteorites = this.gameControl.meteoritesDie(this.meteorites);
			}
		}
	}
}