package fr.afpa.business.services;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import fr.afpa.dao.beans.PlayerBeans;

public class ListJoueur extends AbstractTableModel{
private final String[] entetes = {"Nom", "Date", "Score"};	
private final PlayerBeans []play;
public ListJoueur() {
	super(); 

PlayerBeans joue = new PlayerBeans();
        play = new PlayerBeans[]{
                new PlayerBeans(joue.getName(),joue.getGameStartedDate (),joue.getScore()),
                new PlayerBeans(joue.getName(),joue.getGameStartedDate (),joue.getScore()),
                new PlayerBeans(joue.getName(),joue.getGameStartedDate (),joue.getScore()),
                new PlayerBeans(joue.getName(),joue.getGameStartedDate (),joue.getScore()),
                new PlayerBeans(joue.getName(),joue.getGameStartedDate (),joue.getScore()),
                new PlayerBeans(joue.getName(),joue.getGameStartedDate (),joue.getScore()),
                new PlayerBeans(joue.getName(),joue.getGameStartedDate (),joue.getScore())
        };
    }


 
    public int getRowCount() {
        return play.length;
    }
 
    public int getColumnCount() {
        return entetes.length;
    }
 
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }
 
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return play[rowIndex].getName();
            case 1:
                return play[rowIndex].getGameStartedDate();
            case 2:
                return play[rowIndex].getScore();
            default:
                return null;
        }
    }
}
