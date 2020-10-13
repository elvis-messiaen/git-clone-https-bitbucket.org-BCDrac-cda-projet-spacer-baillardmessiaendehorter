package fr.afpa.cda.controller;

import fr.afpa.business.services.GameBusiness;

public class GameController {
	
	private GameBusiness game = new GameBusiness();
	
	public int getPlayerScore() {
		return this.game.getPlayerScore();
	}
	
	public String getPlayerName() {
		return this.game.getPlayerName();
	}
	
	public int getPlaneHealthPoints() {
		return this.game.getPlaneHealthPoints();
	}

}
