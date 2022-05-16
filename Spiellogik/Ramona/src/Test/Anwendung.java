package Test;

public class Anwendung {

	public static void main(String[] args) {
				
				boolean weiter = true;
				Spielfeld spielfeld = new Spielfeld();
				
				while (weiter)
					weiter = spielfeld.ausgabe();

	}

}
