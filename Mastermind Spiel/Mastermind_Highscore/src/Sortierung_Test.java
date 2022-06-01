import java.io.IOException;
import java.util.ArrayList;

public class Sortierung_Test {
	


	public static ArrayList<String> ArrayAusgabe() throws IOException {
		
		
//		System.out.println("unsortiert"+AusgabeClient.ArrayzumSortieren());
			
		ArrayList<String> SortierterHighscore;
		SortierterHighscore = new ArrayList<String>(10);	


		SortierterHighscore.add("Spieler 1   173");
		SortierterHighscore.add("Spieler 2   12f3");
		SortierterHighscore.add("Spieler 3   41763");
		SortierterHighscore.add("Spieler 4   135");			
		SortierterHighscore.add("Spieler 5   143gr3");
		SortierterHighscore.add("Spieler 6   13");
		SortierterHighscore.add("Spieler 7   32413");
		SortierterHighscore.add("Spieler 8   1123");
		SortierterHighscore.add("Spieler 9   12za3");
		SortierterHighscore.add("Spieler 0   613");
		
		System.out.println("sortiert"+SortierterHighscore);
		
		return SortierterHighscore;

		
		}
		
	}
	

