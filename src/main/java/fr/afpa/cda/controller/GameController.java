package fr.afpa.cda.controller;

import java.util.List;

import fr.afpa.business.services.GameBusiness;
import fr.afpa.dao.beans.GameConstants;
import fr.afpa.dao.beans.MeteoriteAbstractBeans;


/**
 * Classe de contrôle du jeu
 * 
 * Contrôle des éléments du jeu tels que le score, la génération des météorites...
 * 
 * @author Cécile
 */
public class GameController {
	
	GameBusiness gameBusiness;
	
	/**
	 * Constructeur
	 */
	public GameController () {
		gameBusiness = new GameBusiness();
	}
	
	
	/**
	 * Contrôle de la possibilité de génération des météorites
	 * 
	 * Vérifie si la taille de la liste des météorites permet d'en générer une nouvelle
	 * @param meteorites : la liste de météorites dont on vérifie la taille
	 * @return boolean : retourne true si on peut créer une météorite
	 * 
	 * @author Cécile
	 */
	public boolean canGenerateMeteorites(List <MeteoriteAbstractBeans> meteorites) {
		if (meteorites.size() < 4) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * Génération d'une météorite
	 * 
	 * @return MeteoriteAbstractBeans : retourne un objet hérité de MeteoriteAbstractBeans
	 * créé depuis la méthode generateMeteorite() de la classe GameBusiness
	 * 
	 * @author Cécile
	 */
	public MeteoriteAbstractBeans generateMeteorites(){
		return this.gameBusiness.generateMeteorite();
	}
	
	
	/**
	 * Vérifie si une liste de météorite n'est pas vide
	 * 
	 * @param meteorites : la liste de météorites dont on vérifie le contenu
	 * @return boolean : retourne true si la liste n'est pas vide
	 * 
	 * @author Cécile
	 */
	public boolean meteoritesExist(List <MeteoriteAbstractBeans> meteorites) {
		if (!meteorites.isEmpty()) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * Méthode "tuant" une météorite
	 * 
	 * Fait appel à la méthode meteoritesDie() de la classe GameBusiness
	 * pour détruire une météorite dans une liste
	 * 
	 * @param meteorites : la liste contenant les météorites
	 * @return List : retourne la liste de météorite purgée des météorites morts
	 * 
	 * @author Cécile
	 */
	public List <MeteoriteAbstractBeans> meteoritesDie(List <MeteoriteAbstractBeans> meteorites) {
		return this.gameBusiness.meteoritesDie(meteorites);
	}
	
	
	/**
	 * Méthode vérifiant l'état de l'avion
	 * 
	 * Vérifie les points de vie de l'avion pour dire si celui-ci est détruit
	 * 
	 * @param planeHealthPoints : les points de vie de l'avion à vérifier
	 * @return boolean : retourne true si l'avion peut être considéré comme détruit
	 * @author Elvis
	 */
	public boolean planeIsDestroyed(int planeHealthPoints) {
		if (planeHealthPoints <= 0) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * Méthode vérifiant le score pour affichage
	 * 
	 * Vérifie le score du joueur pour déterminer la string permettant de l'afficher dans la fenêtre de jeu
	 * 
	 * @param score : le score à vérifier
	 * @return String : contient la façon d'afficher le score, selon l'état des points (nombre de chiffres)
	 * @author Elvis
	 */
	public String checkScore(int score) {
		
		String string = "";
		
		if (score <= 9) {
			string = String.valueOf("Score : 00" + score);		

		} else if (score > 9 && score <= 99) {
			string = String.valueOf("Score : 0" + score);

		} else if (score > 99 || score < GameConstants.MAX_SCORE) {
			string = String.valueOf("Score : " + score);
			
		} else {
			string = " 999";
		}
		return string;
	}
	
}