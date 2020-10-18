package fr.afpa.cda.controller;

import java.io.File;
import java.nio.file.Path;

import fr.afpa.business.services.HighScoreBusiness;
import fr.afpa.dao.beans.PlayerBeans;

/*
 * Classe ScoreController. Vérifie l'existence du fichier de sauvegarde. 
 * S'il n'existe pas, elle appelle la fonction de création "createSaveFile" dans "HighScoreBusiness", 
 * sinon elle appelle la fonction d'écriture "setNewHighScore" dans "HighScoreBusiness" 
 */
public class ScoreController {

	/**
	 * Est-ce que le fichier "Save.txt" existe dans le dossier "cda-projet-spacer"
	 * situé dans "temp" ? Si oui, il appellera la méthode "setNewHighScore" pour enregistrer des scores, sinon il créera un fichier en appellant la méthode "createSaveFile".
	 */
	public PlayerBeans DirectoryExists(PlayerBeans p) {

		StringBuilder sb = new StringBuilder();
		sb.append(System.getProperty("java.io.tmpdir"));
		sb.append("cda-projet-spacer/Save.txt");

		File file = new File(sb.toString());

		if (file.exists()) {
			HighScoreBusiness score = new HighScoreBusiness();
			score.setNewHighScore(file, p);
		} else {
			HighScoreBusiness score = new HighScoreBusiness();
			score.createSaveFile(file, p);

		}
		return p;
	}
	

}
