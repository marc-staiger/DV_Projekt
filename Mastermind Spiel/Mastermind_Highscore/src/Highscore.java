import java.io.IOException;
import java.util.*;


public class Highscore {
   protected ArrayList<Punktzahl> Scores ;
   boolean   run;
   public    Highscore() throws IOException 
{
	   AusgabeClient HUH= new AusgabeClient();
	Scores = new ArrayList<Punktzahl>();
	// hier rein
}

public void setNewHighScore(Punktzahl Score)

{
  Scores.add(Score);// direckt ins txt speichern und sort
}
public Punktzahl getHighscore(int i)

{
  return Scores.get(i);
}

public ArrayList<Punktzahl> getHighscoreAll()

{
  return Scores; 
}
public void SortiereHighscore()
{
	
	
	{
		this.Scores.sort(new Comparator<Punktzahl>()
		{
			@Override
			public int compare(Punktzahl o1, Punktzahl o2) {
				if (o1.Punktzahl>o2.Punktzahl) return -1;
				else if (o1.Punktzahl<o2.Punktzahl) return 1;
				return 0;
			}
	
		});
	}}}