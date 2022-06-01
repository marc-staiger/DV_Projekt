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
	try {
		AusgabeClient.VerbindeMitServer();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		AusgabeClient.ÜbergabeServer();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
	for (int i = 0; i < 9; i++) {
		
	
		    String Temp = AusgabeClient.ArrayzumSortieren().get(i);
		    System.out.print(Temp);
		
         	Pattern p = Pattern.compile("[+-]?[0-9]+");
           	Matcher m = p.matcher(Temp);
    	    int PKTE=Integer.parseInt(Temp.substring(m.start(), m.end()));
    	    
    	    String Name = String_Scores.get(i).replaceAll("[0-9]","");
    	    
    	    HighscoreEntry Neu = new HighscoreEntry(PKTE,Name);
    	    Scores.add(Neu);
	}
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