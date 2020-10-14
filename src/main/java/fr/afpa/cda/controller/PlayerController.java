package fr.afpa.cda.controller;

import fr.afpa.dao.beans.NameBeans;
import fr.afpa.dao.beans.PlayerBeans;

public class PlayerController {
	public boolean nameControle() {
		PlayerBeans name = new PlayerBeans();
		if (name.getName().matches("[a-zA-Z&._-]{3,6}")) {
			return true;
		}
		return false;
	}
}
