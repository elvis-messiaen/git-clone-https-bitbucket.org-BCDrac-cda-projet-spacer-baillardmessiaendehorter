package fr.afpa.business.services;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

public class ScoreBusiness {
	private final int scoreMax = 999;
	private int score;
	
	public ScoreBusiness() {
		this.score = 0;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getScoreMax() {
		return scoreMax;
	}
	
}
