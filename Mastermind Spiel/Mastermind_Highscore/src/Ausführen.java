import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ausführen {
	public static void main(String[] args) throws IOException {
		 
       
//	      	
//      	 Spielbrett HUHU4 = new Spielbrett();
//      	 
//       	HUHU4.Ausführen();
////        Neuer_Highscore HUHU1 = new Neuer_Highscore();
////      	HUHU1.Ausführen(900);
		
//		Highscore_GUI HUHU = new Highscore_GUI();
//    	HUHU.Ausführen();
//		
			AusgabeClient.VerbindeMitServer();
//		
//		
//	
			AusgabeClient.ÜbergabeServer();
		
		
		
		

		Highscore Test = new Highscore();
		System.out.println(Test.Scores.get(3).getName());
		
    	
       	
       	
       
     
       	}
	
	
}
