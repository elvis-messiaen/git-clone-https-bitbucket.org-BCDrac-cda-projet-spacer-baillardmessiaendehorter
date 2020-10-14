package fr.afpa.cda.controller;

import fr.afpa.dao.beans.GameConstants;

public class GameController {
	
	public boolean planeIsDestroyed(int planeHealthPoints) {
		if (planeHealthPoints <= 0) {
			return true;
		}
		return false;
	}
	
	
	public String checkScore(int score) {

		String string = "";

		if (score <= 9) {
			string = String.valueOf("Score : 00" + score);

		} else if (score > 9 && score <= 99) {
			string = String.valueOf("Score : 0" + score);

		} else if (score > 99 || score < GameConstants.MAX_SCORE) {
			string = String.valueOf("Score : " + score);

		} else {
			string = " 999";
		}
		return string;
	}
}