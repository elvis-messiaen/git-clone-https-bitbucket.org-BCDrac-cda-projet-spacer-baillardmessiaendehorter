package fr.afpa.dao.beans;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerBeans {
	
	private String name;
	private LocalDateTime gameStartedDate;
	private int score;

}