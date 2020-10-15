package fr.afpa.business.services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import fr.afpa.cda.controller.ScoreController;
import fr.afpa.dao.beans.PlayerBeans;

/*
 * Classe HighScoreBusiness. 
 * Gère la création et la manipulation du fichier de sauvegarde
 */
public class HighScoreBusiness {

	// Attributs
	String PlayerName;
	int Score;
	String CurrentDate;
	String str = System.getProperty("java.io.tmpdir");

	// Constructeur

	public HighScoreBusiness() {

	}

	// Methodes

	/*
	 * S'il n'existe pas déjà, creation du fichier "Save.text" dans le dossier
	 * "cda-projet-spacer" situé dans le répertoire temp
	 */

	public void createSaveFile(File f) {

		try {
			String pathFile = f.getPath();
			File file = new File(pathFile);
			file.getParentFile().mkdirs();
			file.createNewFile();
			setNewHighScore(file);
			System.out.println("fichier de save crée, message à supprimer quand les tests seront ok");
			System.out.println(f.getPath());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Inscription des HighScore dans le fichier Save.txt situé dans le répertoire
	 * temp
	 */
	public void setNewHighScore(File f) {

		// Récupération des infos du joueur, et création du string à écrire dans le
		// fichier Save.txt

		StringBuilder sb = new StringBuilder();
		PlayerBeans player = new PlayerBeans();

		sb.append(player.getName());
		sb.append(";");
		sb.append(player.getScore());
		sb.append(";");
		sb.append(player.getGameStartedDate());

		try {
			FileWriter myWriter = new FileWriter(f.getAbsolutePath(), true);

			// Si le fichier est vide, le programme écrira à la première ligne...
			if (f.length() == 0) {
				myWriter.write(sb.toString());
				myWriter.close();

				// ...sinon il passe une ligne avant d'écrire
			} else {
				myWriter.write(System.lineSeparator() + sb.toString());
				myWriter.close();

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
