package fr.afpa.cda.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import fr.afpa.business.services.HighScoreBusiness;
import fr.afpa.dao.beans.PlayerBeans;

/**
 * Classe ScoreController. Vérifie l'existence du fichier de sauvegarde.
 *  
 * S'il n'existe pas, elle appelle la fonction de création "createSaveFile" dans "HighScoreBusiness", 
 * sinon elle appelle la fonction d'écriture "setNewHighScore" dans "HighScoreBusiness"
 * 
 * @author Julien
 */
public class ScoreController {

	
	/**
	 * Vérifier si le fichier "spacer_score_cda20156.ser" existe dans le dossier "cda-projet-spacer"
	 * 
	 * @return boolean : return true si le fichier existe
	 */
	public boolean directoryExists() {

		StringBuilder sb = new StringBuilder();
		sb.append(System.getProperty("java.io.tmpdir"));
		sb.append("cda-projet-spacer/spacer_score_cda20156.ser");

		File file = new File(sb.toString());

		if (file.exists()) {
			return true;
		}
		return false;
	}
	

	/**
	 * Permet de créer le fichier de sauvegarde
	 */
	public void createSaveFile() {
		HighScoreBusiness score = new HighScoreBusiness();

		StringBuilder sb = new StringBuilder();
		sb.append(System.getProperty("java.io.tmpdir"));
		sb.append("cda-projet-spacer/spacer_score_cda20156.ser");

		File file = new File(sb.toString());

		score.createSaveFile(file);
	}
	
	
	/**
	 * Inscrit les scores dans un fichier
	 * 
	 * @param player : le joueur à inscrire
	 */
	public void setNewHighScore(PlayerBeans player) {
		HighScoreBusiness score = new HighScoreBusiness();
		
		StringBuilder sb = new StringBuilder();
		sb.append(System.getProperty("java.io.tmpdir"));
		sb.append("cda-projet-spacer/spacer_score_cda20156.ser");

		File file = new File(sb.toString());
		
		score.setNewHighScore(file, player);
	}
	
	
	/**
	 * Récupère et retourne une liste de joueurs triés
	 * 
	 * @return List : retourne une liste de joueurs triés par score
	 * @throws IOException : throw en cas d'exception
	 */
	public List<PlayerBeans> GetListHighScore() throws IOException {
		HighScoreBusiness score = new HighScoreBusiness();		
		return score.GetListHighScore();
	}
}
