package fr.afpa.business.services;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Collections;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;



import fr.afpa.cda.controller.ScoreController;
import fr.afpa.dao.beans.PlayerBeans;

/**
 * Classe HighScoreBusiness. 
 * 
 * Gère la création et la manipulation du fichier de sauvegarde
 * 
 * @author Julien
 */
public class HighScoreBusiness  {

	// Attributs
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
	 * @param f : le fichier dont on prend le chemin
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
			e.printStackTrace();
		}
	}

	/*
	 * Lecture
	 */
	public void GetListHighScore(File f) throws IOException {

		List<String> result = Files.readAllLines(Paths.get(f.getAbsolutePath()));
		Collections.sort(result, (a,b) -> b.compareTo(a));	
		
		Iterator<String> itr = result.iterator();
		while (itr.hasNext()) {				
		
		System.out.println(itr.next());
		}
		
	}
	
	public String getScores (String s) {
		
	String result = null;
	
	Pattern pattern = Pattern.compile(";(.*?);");
	Matcher matcher = pattern.matcher(s);
	if (matcher.find())
	{
	    result = matcher.group(1);
	}
	System.out.println( result);
	return result;
}
	
}
