package fr.afpa.cda.cda_projet_spacer_BaillardMessiaenDehorter;

//import fr.afpa.dao.beans.HighScore;

import fr.afpa.business.services.HighScoreBusiness;
import fr.afpa.cda.View.EndPanel;
import fr.afpa.cda.View.GameInterface;
import fr.afpa.cda.controller.ScoreController;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        GameInterface game = new GameInterface();
//        game.fenetre();
        
      // EndPanel game = new EndPanel();
    	
//    	ScoreController sc = new ScoreController();
//    	sc.DirectoryExists();
       
       HighScoreBusiness score = new HighScoreBusiness();
       score.setNewHighScore();
      
        
   
    }
}