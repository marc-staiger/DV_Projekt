import java.io.IOException;
import java.util.ArrayList;

public class Sortierung_Test {
	

//	public static void main(String[] args) throws IOException {ArrayAusgabe();}
	public static ArrayList<String> ArrayAusgabe() throws IOException {
		
	ArrayList<String> SortierterHighscore;
	SortierterHighscore = new ArrayList<String>(10);	
	
	SortierterHighscore.add("Spieler 1         43");
	SortierterHighscore.add("Spieler 2         14");
	SortierterHighscore.add("Spieler 3         6");
	SortierterHighscore.add("Spieler 4         7");			
	SortierterHighscore.add("Spieler 5         6");
	SortierterHighscore.add("Spieler 6         2");
	SortierterHighscore.add("Spieler 7         9");
	SortierterHighscore.add("Spieler 8         10");
	SortierterHighscore.add("Spieler 9         5");
	SortierterHighscore.add("Spieler 10        1");
	
	System.out.println("sortiert"+SortierterHighscore);
	
	return SortierterHighscore;
	}
	
}
