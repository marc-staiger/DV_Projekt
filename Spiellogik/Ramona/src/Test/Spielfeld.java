package Test;

import java.util.Random;
import java.util.Scanner; ///////////////////////////////////////////////
import javax.swing.*;

public class Spielfeld {
	
	private int[][] pinn;
	private int[][] kontrolle;
	private int[] ziel;
	
	private int anzahlPinns;
	private int anzahlReihen;
	private int anzahlFarben;
	
	private int aktiveReihe;
	private boolean spielende;
	
	public Spielfeld() {
		anzahlPinns = 4;
		anzahlReihen = 8;
		anzahlFarben = 6;
		
		aktiveReihe = 0;
		spielende = false;
		
		pinn = new int[anzahlPinns][anzahlReihen];
		kontrolle = new int[anzahlPinns][anzahlReihen];
		ziel = new int[anzahlPinns];
		
		Random random = new Random();
		
		for (int i = 0; i<anzahlPinns; i++) {
			ziel[i] = random.nextInt(6 + 1) + 1;
			for (int j = 0; j<anzahlReihen; j++) {
				pinn[i][j] = 0;
				kontrolle[i][j] = 0;	
			}
		}
	}
	
	public void pinnFarbe(int pinnPos, int reihe) { // pinnPos 0 bis Anzahl-1 und reihe 0 bis Anzahl-1
		if(!spielende && reihe == aktiveReihe)
			if (pinnPos >= 0 && pinnPos < anzahlPinns)
				if (pinn[pinnPos][aktiveReihe] == anzahlFarben)
					pinn[pinnPos][aktiveReihe] = 1;
				else
					pinn[pinnPos][aktiveReihe]++;
	}
	
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
	
	private void naechsteReihe() {
		aktiveReihe++;
		if (aktiveReihe == anzahlReihen) {
			spielende = true;
			//spielende(verloren)
		}
	}
	
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
