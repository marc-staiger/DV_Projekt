
package Test;



// Bibliotheken einbinden
import java.util.Random;
import java.util.Scanner; ///////////////////////////////////////////////
import javax.swing.*;



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
	
	
	
	// Konstruktor
	public Spielfeld() {
		
		// Spielanpassung
		anzahlPinns = 4;
		anzahlReihen = 8;
		anzahlFarben = 6;
		
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
			ziel[i] = random.nextInt(6 + 1) + 1;	// Zielfeld mit Zufallsfarbe füllen
			for (int j = 0; j<anzahlReihen; j++) {
				pinn[i][j] = 0;		// Pinnfelder mit 0 füllen (bedeutet: hat im Moment keine Farbe)
				kontrolle[i][j] = 0;	// Kontrollfelder mit 0 füllen (bedeutet: hat im Moment keine Farbe)
			}
		}
	}
	
	
	
	// Funktionen
	
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
			boolean istVoll = true;
			for (int i = 0; i < anzahlPinns; i++)
				if(pinn[i][aktiveReihe] == 0)
					istVoll = false;
			if (istVoll) {
				int weiss = 0;
				int schwarz = 0;
				boolean[] schonGeprueft = new boolean[anzahlPinns];
				for (int i = 0; i<anzahlPinns; i++)
					schonGeprueft[i] = false;
				for (int i = 0; i<anzahlPinns; i++) {
					if (ziel[i] == pinn[i][aktiveReihe])
						schwarz++;
					for (int j = 0; j<anzahlPinns; j++) {
						if (ziel[i] == pinn[j][aktiveReihe] && !schonGeprueft[j]) {
							weiss++;
							schonGeprueft[j] = true;
						}
					}
				}
				for (int i = 0; i<weiss; i++)
					kontrolle[i][aktiveReihe] = 1;
				for (int i = 0; i<schwarz; i++)
					kontrolle[i][aktiveReihe] = 2;
				if (schwarz == anzahlPinns)
					spielende = true;
					//spielende(gewonnen)
				else
					naechsteReihe();
			}
		}
	}

	// Bei Aufruf wird die nächste Reihe "aktiviert" (Es ist immer nur eine Aktiv)
	private void naechsteReihe() {
		aktiveReihe++;
		if (aktiveReihe == anzahlReihen) {
			spielende = true;
			//spielende(verloren)
		}
	}
	
	
	
	
	
	// Hilfsfunktionen um Programm zu testen, werden später nicht benötigt
	private void fuelleReihe() { ///////////////////////////////////////////
		//Scanner eingabewert = new Scanner(System.in);
		String eingabe = JOptionPane.showInputDialog("Zahl eingeben");
		
		
		if(!spielende) {
		for (int i = 0; i<anzahlPinns; i++)
			pinn[i][aktiveReihe] = Character.getNumericValue(eingabe.charAt(i));//eingabewert.nextInt();

		}
	} ///////////////////////////////////////////
	public boolean ausgabe() { ///////////////////////////////////////////
		for (int i = 0; i<anzahlPinns; i++)
			System.out.print(ziel[i] + "  ");
		System.out.println();
		
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
			System.out.println("Spiel zu Ende!");
			for (int i = 0; i<anzahlPinns; i++)
				System.out.print(ziel[i] + "  ");
			System.out.println();
			return false;
		}
	} ///////////////////////////////////////////

}
