package fr.afpa.cda.controller;

import fr.afpa.dao.beans.GameConstants;
import fr.afpa.dao.beans.PlayerBeans;

public class GameController {
	
	public boolean planeIsDestroyed(int planeHealthPoints) {
		if (planeHealthPoints <= 0) {
			return true;
		}
		return false;
	}
	
	
	public String checkScore(PlayerBeans player) {
		
		String string = "";
		
		if (player.getScore() <= 9) {
			string = String.valueOf("Score : 00" + player.getScore());		

		} else if (player.getScore() > 9 && player.getScore() <= 99) {
			string = String.valueOf("Score : 0" + player.getScore());

		} else if (player.getScore() > 99 || player.getScore() < GameConstants.MAX_SCORE) {
			string = String.valueOf("Score : " + player.getScore());
			
		} else {
			string = " 999";
		}
		return string;
	}
}
