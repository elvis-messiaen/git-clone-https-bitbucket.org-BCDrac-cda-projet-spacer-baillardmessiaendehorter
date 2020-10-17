package fr.afpa.cda.controller;


/**
 * Classe controllant des éléments du joueur
 * 
 * @author Elvis
 */
public class PlayerController {
	
	/**
	 * Contrôle si le nom correspond aux contraintes imposées
	 * 
	 * @param name : le nom à contrôler
	 * @return boolean : retourne true si le nom correspond 
	 */
	public boolean nameControle(String name) {
		/*
		 * controle de validité de nom
		 */
		if (name.matches("[a-zA-Z&._-]{3,6}")) {
			return true;
		}
		return false;
	}

}