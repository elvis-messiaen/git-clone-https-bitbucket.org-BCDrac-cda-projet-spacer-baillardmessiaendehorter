package fr.afpa.dao.beans;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class HighScore {

	// Attributs
	String PlayerName;
	int Score;
	String CurrentDate;

	// Constructeur

	
	public HighScore () {
		
	}
	
	public HighScore(String PlayerName, int Score, String CurrentDate) {

	}

	// Methodes
	
	public void setNewHighScore() {
		try {
		    // create temporary folder
		    Path path = Files.createTempDirectory("cda-projet-spacer");
		   String pathFile = path + "cda-projet-spacer/Save.txt";
		    File file = new File(pathFile);
		    file.getParentFile().mkdirs(); 
		    file.createNewFile();
		    System.out.println("ok");
//			String absolute = file.getAbsolutePath();
//			try {
//				FileWriter myWriter = new FileWriter(absolute, true);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		    
//		    
//		    %temp%

		    // print path
		    System.out.println(path.toAbsolutePath().toString());

		} catch (IOException ex) {
		    ex.printStackTrace();
		}
		
	}
	

//	public void setNewHighScore(String PlayerName, int Score, String CurrentDate) {
//		
//		try {
//		    // create temporary folder
//		    Path path = Files.createTempDirectory("java-");
//
//		    // print path
//		    System.out.println(path.toAbsolutePath().toString());
//
//		} catch (IOException ex) {
//		    ex.printStackTrace();
//		}
	////
//
//		File file = new File("Save.txt");
//		String absolute = file.getAbsolutePath();
//		try {
//			FileWriter myWriter = new FileWriter(absolute, true);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(Locale.FRANCE)
//				.withZone(ZoneId.systemDefault());

//			for (Entry<Integer, String> entry : highScore.entrySet()) {
//				if (file.length() == 0) {
//					myWriter.write(entry.getKey() + "\t" + entry.getValue() + "\t" + date);
//					myWriter.close();
//
//				} else {
//					myWriter.write(System.getProperty("line.separator") + entry.getKey() + "\t" + entry.getValue()
//							+ "\t" + date);
//					myWriter.close();
//
//				}
//			}
//		} catch (IOException e) {
//			System.out.println("Une erreur s'est produite");
//			e.printStackTrace();
//
		// }
		// }

	}


