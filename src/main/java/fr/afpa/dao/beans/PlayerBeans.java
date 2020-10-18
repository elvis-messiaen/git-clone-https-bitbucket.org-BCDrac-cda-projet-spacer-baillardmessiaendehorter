package fr.afpa.dao.beans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerBeans {

	private String name;
	private String gameStartedDate;
	private int score;

//	public PlayerBeans(String nam) {
//		this.name = nam;
//
//	}

	public PlayerBeans() {

	}

	public PlayerBeans(String nom, int score, String startGame) {
		this.name = nom;
		this.gameStartedDate = startGame;
		this.score = score;
	}

	public PlayerBeans(String name) {
		this.name = name;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGameStartedDate() {
		return gameStartedDate;
	}

	public void setGameStartedDate(String date) {
		this.gameStartedDate = date;
	}

	public int getScore() {
		return this.score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}