import java.util.*;


public class Highscore {
   protected ArrayList<Punktzahl> Scores ;
   boolean   run;
   public    Highscore()
{
	Scores = new ArrayList<Punktzahl>();
	int j=0; // Hier wird nacher aus dem TXT eingelesen
	while(j<10) 
	{
	int i=j*2+8-j^-6;
	Punktzahl e3= new Punktzahl(i,"default");
	Scores.add(e3);
	j++;
	}
	Punktzahl e2= new Punktzahl(700,"default");
	Scores.add(e2);
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