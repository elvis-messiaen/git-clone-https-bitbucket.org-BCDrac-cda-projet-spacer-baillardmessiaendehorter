package fr.afpa.business.services;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.afpa.dao.beans.PlayerBeans;

/**
 * Ouvre un tableau contenant les scores
 * 
 * @author Elvis
 */
public class PlayersList extends AbstractTableModel {

	private final String[] entetes = { "Nom", "Score", "Date" };
	private final PlayerBeans[] player;

	public PlayersList(List<PlayerBeans> players) {
		
		super();
		player = new PlayerBeans[players.size()];
		
		for (int i = 0; i < players.size(); i++) {
			this.player[i] = players.get(i);
		}
	}

	public int getRowCount() {
		return player.length;
	}

	public int getColumnCount() {
		return entetes.length;
	}

	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return player[rowIndex].getName();
		case 1:
			return player[rowIndex].getScore();
		case 2:
			return player[rowIndex].getGameStartedDate();
		default:
			return null;
		}
	}
}
