import java.util.*;


public class Highscore {
   protected static ArrayList<Punktzahl> Scores ;
  Punktzahl smaller;
  Punktzahl bigger;
  boolean  run;
public    Highscore()
{
	Scores = new ArrayList<Punktzahl>();
	
}


public void setNewHighScore(Punktzahl Score)

{
  Scores.add(Score);
}
public Punktzahl getHighscore(int i)

{
  return Scores.get(i);
}

public ArrayList<Punktzahl> getHighscoreAll()

{
  return Scores;
}
public void SortiereHighscore(ArrayList<Punktzahl> zuSortierendeListe)
{
	
	
	for (int i = 0; i < zuSortierendeListe.size() && run == true; i++) {
	    run = false;

	   for (int y = 0; y <  zuSortierendeListe.size(); y++) {
	        if(zuSortierendeListe.get(y).getPunktzahl() > zuSortierendeListe.get(y).getPunktzahl())  {
	            bigger = zuSortierendeListe.get(y) ;
	            smaller = zuSortierendeListe.get(y+1) ;
	            zuSortierendeListe.add(y, smaller);
	            zuSortierendeListe.add(y+1, smaller);
	            run = true;
	          }
	    }
	}
//	
}
}

