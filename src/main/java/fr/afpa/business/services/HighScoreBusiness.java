package fr.afpa.business.services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.afpa.dao.beans.PlayerBeans;

/**
 * Classe HighScoreBusiness.
 * 
 * Gère la création et la manipulation du fichier de sauvegarde
 * 
 * @author Julien
 */
public class HighScoreBusiness {

	// Attributs
	PlayerBeans player;
	String PlayerName;
	String CurrentDate;
	String str;
	int Score;

	/**
	 * Constructeur
	 */
	public HighScoreBusiness() {
		this.str = System.getProperty("java.io.tmpdir");
	}

	// Methodes

	/**
	 * S'il n'existe pas déjà, creation du fichier "Save.text" dans le dossier
	 * "cda-projet-spacer" situé dans le répertoire temp
	 * 
	 * @param f : le fichier dont on prend le chemin
	 */
	public void createSaveFile(File f) {

		try {
			String pathFile = f.getPath();
			File file = new File(pathFile);
			
			file.getParentFile().mkdirs();
			file.createNewFile();	

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * Inscription des HighScores dans le fichier spacer_score_cda20156.ser situé dans le répertoire
	 * temp
	 * 
	 * @param file : le fichier où seront enregistrés les scores
	 * @param player : le joueur à enregistrer
	 */
	public void setNewHighScore(File file, PlayerBeans player) {

		// Récupération des infos du joueur, et création du string à écrire dans le
		// fichier de sauvegarde

		StringBuilder sb = new StringBuilder();		

		sb.append(player.getName());
		sb.append(";");
		sb.append(player.getScore());
		sb.append(";");
		sb.append(player.getGameStartedDate());

		try {
			FileWriter myWriter = new FileWriter(file.getAbsolutePath(), true);

			// Si le fichier est vide, le programme écrira à la première ligne...
			if (file.length() == 0) {
				myWriter.write(sb.toString());
				myWriter.close();

				// ...sinon il passe une ligne avant d'écrire
			} else {
				myWriter.write(System.lineSeparator() + sb.toString());
				myWriter.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * Récupération et tri des scores
	 * 
	 * @return List : retourne la liste de joueurs triés par score
	 * @throws IOException : throw en cas d'exception
	 */
	public List<PlayerBeans> GetListHighScore() throws IOException {
		
		StringBuilder sb = new StringBuilder();
		sb.append(System.getProperty("java.io.tmpdir"));
		sb.append("cda-projet-spacer/spacer_score_cda20156.ser");

		File file = new File(sb.toString());
		List<String> result = Files.readAllLines(Paths.get(file.getAbsolutePath()));
		List<PlayerBeans> players = new ArrayList<PlayerBeans>();	

		for (int i = 0; i < result.size(); i++) {

			if (players.size() < 20) {
				String[] splitResult = result.get(i).split(";");
				PlayerBeans player = new PlayerBeans();

				player.setName(splitResult[0]);
				player.setScore(Integer.parseInt(splitResult[1]));
				player.setGameStartedDate(splitResult[2]);

				players.add(player);
			}
		}
		
		Collections.sort(players, new SortByScore());
		
		return players;
	}
	

	
	@Deprecated
	public String getScores(String s) {

		String result = null;

		Pattern pattern = Pattern.compile(";(.*?);");
		Matcher matcher = pattern.matcher(s);
		if (matcher.find()) {
			result = matcher.group(1);
		}
		System.out.println(result);
		return result;
	}
}


/**
 * Permet de trier les scores avec un override de la méthode compare()
 * 
 * @author Cécile
 */
class SortByScore implements Comparator {

	@Override
	public int compare(Object playerA, Object playerB) {
		return ((PlayerBeans) playerB).getScore() - ((PlayerBeans) playerA).getScore();
	}
}