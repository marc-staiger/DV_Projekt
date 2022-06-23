
import java.awt.event.*;
import javax.swing.*;

/**
 	* Die Klasse steuert und verwaltet die Punktzahlvergabe des Spiels
	*/
public class Punkte {
	
	private int Multiplikator;
	private boolean Time;
	private Timer timer;
	private ActionListener listener;
	private int Zeit;
	
	public Punkte(int Level)
	{
		Time = false;
		switch(Level)
		{
			case 1:
				Multiplikator = 75;
				break;
			case 2:
				Multiplikator = 80;
				break;
			case 3:
				Multiplikator = 100;
				break;
			default:
				Multiplikator = 0;
				Time = true;
				break;
		}
		
		if(Time == true)
			Zeit = 0;
		{
			listener = new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					Zeit++;
				}
			};
			
			timer = new Timer(100, listener);
		}
	}
	
	/**
		 * Berechnet die Punktzahl anhand des Levels und der nach dem Spiel übrigen Reihen
		 *
		 * @param  Anzahl der Reihen (als Ganzzahl), die nach dem Ende des Spiels noch frei ist
		 * @return   Erreichte Punktzahl (als Ganzzahl)
		 */
	public int wertung(int Reihe)
	{
		int Punkte;
		if(Time == false)
		{
			Punkte = Multiplikator*Reihe;
			return Punkte;
		}
		else
		{
			Punkte = 900-Zeit;
			return Punkte;
		}
	}
}

