package fr.afpa.business.services;

import java.util.List;
import java.util.Random;

import fr.afpa.dao.beans.GameConstants;
import fr.afpa.dao.beans.MeteoriteAbstractBeans;
import fr.afpa.dao.beans.MeteoriteFireBeans;
import fr.afpa.dao.beans.MeteoriteIceBeans;
import fr.afpa.dao.beans.MeteoriteIcebergBeans;
import fr.afpa.dao.beans.MeteoriteSimpleBeans;
import fr.afpa.dao.beans.MeteoriteZigzagBeans;


/**
 * Classe gérant des aspects du jeu comme la destruction et génération de météorites
 * 
 * @author Cécile
 */
public class GameBusiness {
	
	
	/**
	 * Détruit les météorites en état de mort
	 * 
	 * @param meteorites : la liste de météorites contenant les météorites à détruire
	 * @return List : la liste de météorite purgée
	 */
	public List <MeteoriteAbstractBeans> meteoritesDie(List <MeteoriteAbstractBeans> meteorites) {
		
		for (int i = 0; i < meteorites.size(); i++) {

			if (meteorites.get(i).isDead()) {
				meteorites.remove(i);
			}
		}
		return meteorites;
	}
	
	
	/**
	 * Génère une météorite de façon aléatoire
	 * 
	 * @return MeteoriteAbstractBeans : retourne une météorite
	 * 
	 * @author Cécile
	 */
	public MeteoriteAbstractBeans generateMeteorite() {
		
		Random random = new Random();
		MeteoriteAbstractBeans meteorite = null;
		int meteoriteType = random.nextInt(5);
		int randPositionX = random.nextInt(GameConstants.GAME_SCREEN_MAX_WIDTH);

		switch (meteoriteType) {
			case 0 : meteorite = new MeteoriteSimpleBeans(randPositionX); break;
			case 1 : meteorite = new MeteoriteFireBeans(randPositionX); break;
			case 2 : meteorite = new MeteoriteIceBeans(randPositionX); break;
			case 3 : meteorite = new MeteoriteZigzagBeans(randPositionX); break;
			case 4 : meteorite = new MeteoriteIcebergBeans(randPositionX); break;
		}
		return meteorite;
	}

}