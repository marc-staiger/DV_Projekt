import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Highscore {
   protected ArrayList<HighscoreEntry> Scores ;
   protected ArrayList<String> String_Scores ;
   boolean   run;
    
{
	   AusgabeClient HUH= new AusgabeClient();
	Scores = new ArrayList<HighscoreEntry>();
	String_Scores= new ArrayList<String>();
	// hier rein
}

public Highscore()

{
	//try {
	//	AusgabeClient.VerbindeMitServer();
//	} catch (IOException e) {
//		 TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	
//	try {
//		AusgabeClient.‹bergabeServer();
//	} catch (IOException e) {
//		 TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	
	
	 System.out.println("Client Einslesen");
     
 	
		ArrayList<String> HighscoreUnsortiert;
		HighscoreUnsortiert = new ArrayList<String>(10);
				
		
		
		System.out.println("Client Einslesen 2");
		
		int k=0;
		
		while(k <=9)
		{
		
		HighscoreUnsortiert.add(AusgabeClient.ArrayzumSortieren());
		
		k++;		
		
		}
			
		System.out.println("Einlesen vom Server/Senden an Sortierung "+HighscoreUnsortiert);
		System.out.println("Einlesen beendet");
		//---------------------------------------------------------------------------------
	
	
		System.out.println("Einlesen vom Server/Senden an Sortierung "+HighscoreUnsortiert);
	
	
	
//	
//	int PKTE = 0 ;
//	
//	for (int i = 0; i < 9; i++) {
//		
//		String s =  AusgabeClient.ReadHighscore().get(i);
//		String s1= s;
//	   	Pattern p = Pattern.compile("[+-]?[0-9]+");
//	   	Matcher m = p.matcher(s);
//	   	while ( m.find() ) {
//	    	     PKTE=Integer.parseInt(s.substring(m.start(), m.end()));
//	   	}    	
//	
//	    String firstname1 = s1;
//        firstname1 = firstname1.replaceAll("[0-9]","");
//       
//          String Name=firstname1;
//    	    
//    	    HighscoreEntry Neu = new HighscoreEntry(PKTE,Name);
//    	    Scores.add(Neu);
//	}
SortiereHighscore();
}
		
		
  

public HighscoreEntry getHighscore(int i)

{
  return Scores.get(i);
}

public ArrayList<HighscoreEntry> getHighscoreAll()

{
  return Scores; 
}
public void SortiereHighscore()
{
	
	
	{
		this.Scores.sort(new Comparator<HighscoreEntry>()
		{
			@Override
			public int compare(HighscoreEntry o1, HighscoreEntry o2) {
				if (o1.Punktzahl>o2.Punktzahl) return -1;
				else if (o1.Punktzahl<o2.Punktzahl) return 1;
				return 0;
			}
	
		});
	}}}