
package Test;



// Bibliotheken einbinden
import java.util.Random;
import javax.swing.*; /////////////////////////////////////////////////


public class Spielfeld {

	// Attribute
	
	// Spielfeldarrays
	private int[][] pinn;
	private int[][] kontrolle;
	private int[] ziel;
	
	// Variablen zur Spielanpassung
	private int anzahlPinns;
	private int anzahlReihen;
	private int anzahlFarben;
	
	// Hilfsvariablen
	private int aktiveReihe;
	private boolean spielende;
	
	
	
	
	
	// Konstruktoren
	
	// Standardkonstruktor
	public Spielfeld() {
		this(1);
	}
	
	// Konstruktor für Level
	public Spielfeld(int level) {
		
		// Spielanpassung
		if (level == 2) {
			anzahlPinns = 5;
			anzahlReihen = 9;
		}
		else if (level == 3) {
			anzahlPinns = 6;
			anzahlReihen = 10;
		}
		else {
			anzahlPinns = 4;
			anzahlReihen = 8;	
		}
		anzahlFarben = 6;
		
		if (level == 4) {
			// Todo Zeitlevel starten
		} // Todo als switch umschreiben?? incl. 4??
		
		// Hilfsvariablen vorbelegen
		aktiveReihe = 0;
		spielende = false;
		
		// Spielfeldarrays mit gewünschter Spielanpassung erstellen
		pinn = new int[anzahlPinns][anzahlReihen];
		kontrolle = new int[anzahlPinns][anzahlReihen];
		ziel = new int[anzahlPinns];
		
		// Zufallsgenerator starten
		Random random = new Random();
		
		// Spielfeldarrays mit Werten vorbelegen
		for (int i = 0; i<anzahlPinns; i++) {
			ziel[i] = random.nextInt(anzahlFarben) + 1;	// Zielfeld mit Zufallsfarbe füllen
			for (int j = 0; j<anzahlReihen; j++) {
				pinn[i][j] = 0;		// Pinnfelder mit 0 füllen (bedeutet: hat im Moment keine Farbe)
				kontrolle[i][j] = 0;	// Kontrollfelder mit 0 füllen (bedeutet: hat im Moment keine Farbe)
			}
		}
	}
	
	
	
	// Get-Methoden

	int[][] getPinn(){return pinn;}
	
	int[] getPinn(int reihe){
		int[] zeile = null;
		//if (reihe >= 0 && reihe < anzahlReihen) {
			zeile = new int[anzahlPinns];
			for (int i=0; i<anzahlPinns; i++)
				zeile[i] = pinn[i][reihe];
		//}
		return zeile;
	}
	
	int getPinn(int position, int reihe){
		//if(position >= 0 && position < anzahlPinns)
		//	if(reihe >= 0 && reihe < anzahlReihen)
				return pinn[position][reihe];
		//return -1;
		}
	
	int[][] getKontrolle(){return kontrolle;}
	
	int[] getKontrolle(int reihe){
		int[] zeile = null;
		//if(reihe >= 0 && reihe < anzahlReihen) {
			zeile = new int[anzahlPinns];
			for (int i=0; i<anzahlPinns; i++)
				zeile[i] = kontrolle[i][reihe];
		//}
		return zeile;
	}
	
	int getKontrolle(int position, int reihe){
		//if(position >= 0 && position < anzahlPinns)
		//	if(reihe >= 0 && reihe < anzahlReihen)
				return kontrolle[position][reihe];
		//return -1;
	}

	int[] getZiel(){return ziel;}

	int getZiel(int position){
		//if(position >= 0 && position < anzahlPinns)
			return ziel[position];
		//return -1;
	}

	int getAnzahlPinns(){return anzahlPinns;}

	int getAnzahlReihen(){return anzahlReihen;}

	int getAnzahlFarben(){return anzahlFarben;}

	int getAktiveReihe(){return aktiveReihe;}



	// Methoden
	
	// Farbe schaltet bei Aufruf eins weiter, ohne wieder auf 0 (keine Farbe) zu gehen
	public void pinnFarbe(int pinnPos, int reihe) { // pinnPos: 0 bis Anzahl-1 und reihe: 0 bis Anzahl-1
		if(!spielende && reihe == aktiveReihe)
			if (pinnPos >= 0 && pinnPos < anzahlPinns)
				if (pinn[pinnPos][aktiveReihe] == anzahlFarben)
					pinn[pinnPos][aktiveReihe] = 1;
				else
					pinn[pinnPos][aktiveReihe]++;
	}
	
	
	
	// Kontrolle nach füllen einer Reihe, wenn aufgerufen, wird Kontrollfeld mit weißen (1) und schwarzen (2) Pinns gefüllt
	public void kontrolle() {
		if (!spielende) {
			
			// Test: Ist aktive Reihe komplett befüllt?
			boolean istVoll = true;
			for (int i = 0; i < anzahlPinns; i++)
				if(pinn[i][aktiveReihe] == 0)
					istVoll = false;
			
			if (istVoll) {
				int weiss = 0;
				int schwarz = 0;
				
				// Hilfsarrays mit Info über Pinns die einen "Partner" gefunden haben
				boolean[] schonGeprueftPinn = new boolean[anzahlPinns];
				boolean[] schonGeprueftZiel = new boolean[anzahlPinns];
				for (int i = 0; i<anzahlPinns; i++) {
					schonGeprueftPinn[i] = false;
					schonGeprueftZiel[i] = false;
				}
				
				// Pro Pinn mit richtiger Farbe an richtiger Stelle kommt ein schwarzer Pinn dazu 
				for (int i = 0; i<anzahlPinns; i++) {
					if (ziel[i] == pinn[i][aktiveReihe])
						schwarz++;
					
					for (int j = 0; j<anzahlPinns; j++) {
						if (ziel[i] == pinn[j][aktiveReihe] && (!schonGeprueftPinn[j] && !schonGeprueftZiel[i])) {
							weiss++;
							schonGeprueftPinn[j] = true;
							schonGeprueftZiel[i] = true;
						}
					}
				}
				
				// Kontrollpinns setzen
				for (int i = 0; i<weiss; i++)
					kontrolle[i][aktiveReihe] = 1; // weiße Pinns werden gesetzt
				for (int i = 0; i<schwarz; i++)
					kontrolle[i][aktiveReihe] = 2; // schwarze Pinns werden gesetzt
				if (schwarz == anzahlPinns)
					spielende = true;
					// Todo: spielende(gewonnen)
				else
					naechsteReihe();
			}
		}
	}
	
	
	
	public int wertung() {
		int punkte = 0;
		// Todo: Punktewertung
		return punkte;
	}

	
	
	// Bei Aufruf wird die nächste Reihe "aktiviert" (Es ist immer nur eine Aktiv)
	private void naechsteReihe() {
		aktiveReihe++;
		if (aktiveReihe == anzahlReihen) {
			spielende = true;
			// Todo: spielende(verloren)
		}
	}
	
	
	
	
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// Hilfsfunktionen um Programm zu testen, werden später nicht benötigt
	private void fuelleReihe() { ///////////////////////////////////////////
		String eingabe = JOptionPane.showInputDialog("Zahl eingeben");
		
		

	for (int i = 0; i<anzahlPinns; i++)
		pinn[i][aktiveReihe] = Character.getNumericValue(eingabe.charAt(i));//eingabewert.nextInt();

	} ///////////////////////////////////////////
	public boolean ausgabe() { ///////////////////////////////////////////
		
		fuelleReihe();
		kontrolle();
		
		if(!spielende) {
			for (int i = 0; i<anzahlPinns; i++)
				System.out.print(pinn[i][aktiveReihe-1] + "  ");
			System.out.print("|  ");
			for (int i = 0; i<anzahlPinns; i++)
				System.out.print(kontrolle[i][aktiveReihe-1] + "  ");
			System.out.println();
			return true;
		}
		else {
			int x = aktiveReihe-1;
			if (aktiveReihe < anzahlReihen) 
				x = aktiveReihe;
			
			for (int i = 0; i<anzahlPinns; i++)
				System.out.print(pinn[i][x] + "  ");
			System.out.print("|  ");
			for (int i = 0; i<anzahlPinns; i++)
				System.out.print(kontrolle[i][x] + "  ");
			System.out.println();

			System.out.println("Spiel zu Ende!");
			for (int i = 0; i<anzahlPinns; i++)
				System.out.print(ziel[i] + "  ");
			System.out.println();
			return false;
		}
	} ///////////////////////////////////////////

}
///////////////////////////////////////////////////////////////////////////////////////////////////////
