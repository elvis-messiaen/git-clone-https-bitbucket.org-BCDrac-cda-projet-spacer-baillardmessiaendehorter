package fr.afpa.dao.beans;

import java.time.LocalDateTime;

import fr.afpa.cda.controller.PlayerController;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerBeans {

	private String name;
	private LocalDateTime gameStartedDate;
	private int score;
	

	public PlayerBeans() {

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

	public LocalDateTime getGameStartedDate() {
		return gameStartedDate;
	}

	public void setGameStartedDate(LocalDateTime gameStartedDate) {
		this.gameStartedDate = gameStartedDate;
	}

	public int getScore() {
		return this.score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}