package fr.afpa.cda.controller;

public class PlayerController {
	
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