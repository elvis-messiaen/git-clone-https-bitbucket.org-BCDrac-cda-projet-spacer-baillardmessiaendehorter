package fr.afpa.cda.controller;

import java.io.File;
import java.nio.file.Path;

public class ScoreController {

	/*
	 * Est-ce que le fichier "Save.txt" existe dans le dossier "cda-projet-spacer"
	 * situé dans "temp" ? Si oui, il retourne true, sinon il retournera false
	 */
	public boolean DirectoryExists() {

		StringBuilder sb = new StringBuilder();
		sb.append(System.getProperty("java.io.tmpdir"));
		sb.append("cda-projet-spacer/Save.txt");

		File file = new File(sb.toString());

		return (file.exists() ? true : false);

	}

}
