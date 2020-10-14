package fr.afpa.cda.controller;

import fr.afpa.dao.beans.NameBeans;

public class NameController {
	public boolean nameControle(NameBeans name) {
		if (name.getNom().matches("[a-zA-Z&._-]{3,6}")) {
			return true;
		}
		return false;
	}
}