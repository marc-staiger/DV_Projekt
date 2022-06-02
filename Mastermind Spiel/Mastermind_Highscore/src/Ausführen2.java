import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ausführen2 {
	public static void main(String[] args) throws IOException {
		 
       
//	      	
//      	 Spielbrett HUHU4 = new Spielbrett();
//      	 
//       	HUHU4.Ausführen();
////        Neuer_Highscore HUHU1 = new Neuer_Highscore();
////      	HUHU1.Ausführen(900);
		
//		Highscore_GUI HUHU = new Highscore_GUI();
//    	HUHU.Ausführen();
		
			AusgabeClient.VerbindeMitServer();
		
		
	
			AusgabeClient.ÜbergabeServer();
		
		
		System.out.print("iohf");
		int PKTE = 0 ;
		
		for (int i = 0; i < 9; i++) {
			
			String s =  AusgabeClient.ReadHighscore().get(i);
		   	Pattern p = Pattern.compile("[+-]?[0-9]+");
		   	Matcher m = p.matcher(s);
		   	while ( m.find() ) {
		    	     PKTE=Integer.parseInt(s.substring(m.start(), m.end()));
		   	}    	
		
		    String firstname1 = AusgabeClient.ReadHighscore().get(i);
	        firstname1 = firstname1.replaceAll("[0-9]","");
	       
	          String Name=firstname1;
	    	    
	    	    HighscoreEntry Neu = new HighscoreEntry(PKTE,Name);
	    	    System.out.print(Neu);
		}

		Highscore Test = new Highscore();
		System.out.println(Test.Scores.get(3).getName());
		
    	
       	
       	
       
     
       	}
	
	
}
