import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ausführen {
	public static void main(String[] args) throws IOException{
       Highscore High = new Highscore();
        High.SortiereHighscore();
        System.out.println("Main START");
		Sortierung_Test.ArrayAusgabe();	
		AusgabeClient.VerbindeMitServer();
										       
		System.out.println("Main FERTIG");
    	 Neuer_Highscore HUHU1 = new Neuer_Highscore();
      	HUHU1.Ausführen(900);
      	 Spielbrett HUHU4 = new Spielbrett();
       	HUHU4.Ausführen();
       	
       	
       
     
       	}
	
	
}
