import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.*;
import java.util.Random;

/**
 * Klasse enthaellt das komplette Spielfeld, dass der Benutzer nach der Levelauswahl sieht und die Spiellogik
 *
 */
public class Frame_2 extends JFrame {

	private JPanel contentPane;
	static final long serialVersionUID = 1L;
	static Color[] colors = { Color.green, Color.red, Color.blue, Color.yellow, Color.cyan, Color.orange,};
	
	private int anzahlZeilen; // 6 Zeilen
	private int anzahlSpalten; // 4 Spalten
	private JButton[][] pinnButtons;// Array für die Eingabefelder
	
	//private int Buttons3=6;
	private JButton [] Controlbutton1; 
	private JButton [] Controlbutton2; 
	private JButton [] Controlbutton3; 
	private JButton [] Controlbutton4; 
	private JButton [] Controlbutton5;
	private JButton [] Controlbutton6;
	
	//Labels
	private JLabel Gewinnlabel;
	private JLabel Verlorenlabel;
	private JLabel Punktelabel;
	
	private  JButton[] zielButtons;// Array Zielergebnis der Farbmöglichkeiten
	
	private int anzahlFarben; // 6Farben
	private JButton[] farbenButtons; // Array Farbmöglichkeiten unten
	
	private int aktiveReihe;
	
	private Punkte punkte; //fuer Punktezaehlung
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_2 frame = new Frame_2(6,10);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Frame_2(int Spalten, int Zeilen) 
	{
		//Setzen der Zeilen und Spalten
		this.anzahlSpalten=Spalten;
		this.anzahlZeilen=Zeilen;
		anzahlFarben = 6;
		
		//Punktezaehlung Anfang
		if(anzahlSpalten==4)
			punkte = new Punkte(1);
		else if(anzahlSpalten==5)
			punkte = new Punkte(2);
		else if(anzahlSpalten==6)
			punkte = new Punkte(3);
		//Punktezaehlung Ende
		
		setFrame();
		
		setLabel();
				
		setPinnButtons();
	
		setControlButton();
		
		setZiel();

		setFarbhilfe();

		setKontrollbutton();
		
		setZurueckbutton();
		
		setHauptmenubutton();
		
		setX(); ////////////////////////////////////////////////////////////
		
	}
	
		
	/**
	 * Setzt alle Parameter fuer das Fenster, in dem das Spielfeld angezeigt wird
	 *
	 * @param  -
	 * @return   -
	 */
		private void setFrame(){
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(400, 400, 1800, 1200);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			setExtendedState(MAXIMIZED_BOTH);
			
			JLabel lblNewLabel = new JLabel("Mastermind");
			lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 21));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			contentPane.add(lblNewLabel, BorderLayout.NORTH);
		}
	
		/**
		 * Setzt alle Parameter fuer das Gewinn- und Verlierenlabel, die spaeter angezeigt werden, wenn das Spiel beendet ist
		 *
		 * @param  -
		 * @return   -
		 */
		private void setLabel() {
			//Anfang GewinnLabel	
			Gewinnlabel = new JLabel ("Sie haben Gewonnen!");
			Gewinnlabel.setBounds(530,300,1500,1000);
			Gewinnlabel.setVerticalAlignment(JLabel.CENTER);
			Gewinnlabel.setSize(311, 100);
			contentPane.add(Gewinnlabel);
			Gewinnlabel.setOpaque(true);
			Gewinnlabel.setBackground(Color.WHITE);
			Gewinnlabel.setForeground(Color.BLACK);
			Gewinnlabel.setFont(new Font("Sie Haben Gewonnen", 60, 30));
			Gewinnlabel.setVisible(false);
			//Ende GewinnLabel
				
			//Anfang VerlorenLabel
			Verlorenlabel = new JLabel ("Sie haben Verloren!");
			Verlorenlabel.setBounds(530,300,1500,1000);
			Verlorenlabel.setVerticalAlignment(JLabel.CENTER);
			Verlorenlabel.setSize(284, 100);
			contentPane.add(Verlorenlabel);
			Verlorenlabel.setOpaque(true);
			Verlorenlabel.setBackground(Color.WHITE);
			Verlorenlabel.setForeground(Color.BLACK);
			Verlorenlabel.setFont(new Font("Sie Haben Verloren", 60,30));
			Verlorenlabel.setVisible(false);
			//Ende Verlorenlabel
		}
		
		/**
		 * Setzt alle Kontrollkaestchen, in denen spaeter die schwarzen und weissen Pinns gesetzt werden
		 *
		 * @param  -
		 * @return   -
		 */
		private void setControlButton(){
			Controlbutton1= new JButton[anzahlZeilen]; 
			Controlbutton2= new JButton[anzahlZeilen]; 
			Controlbutton3= new JButton[anzahlZeilen]; 
			Controlbutton4= new JButton[anzahlZeilen]; 
			Controlbutton5= new JButton[anzahlZeilen]; 
			Controlbutton6= new JButton[anzahlZeilen]; 
			
			for( int iZeile=0; iZeile<anzahlZeilen; ++iZeile){
				JButton btnNewButton = new JButton("");
				JButton btnNewButton_1 = new JButton("");
				JButton btnNewButton_2 = new JButton("");
				JButton btnNewButton_3 = new JButton("");
				JButton btnNewButton_4 = new JButton("");
				JButton btnNewButton_5 = new JButton("");
				
				Controlbutton1[iZeile]= btnNewButton;
				Controlbutton2[iZeile]= btnNewButton_1;
				Controlbutton3[iZeile]= btnNewButton_2;
				Controlbutton4[iZeile]= btnNewButton_3;
				Controlbutton5[iZeile]= btnNewButton_4;
				Controlbutton6[iZeile]= btnNewButton_5;
			
				
				switch(anzahlSpalten){
					case 4:
						contentPane.add(Controlbutton1[iZeile]);
						contentPane.add(Controlbutton2[iZeile]);
						contentPane.add(Controlbutton3[iZeile]);
						contentPane.add(Controlbutton4[iZeile]); 

						Controlbutton1[iZeile].setBounds(350, 600-iZeile*70, 15, 15);
						Controlbutton2[iZeile].setBounds(370, 600-iZeile*70, 15, 15);
						Controlbutton3[iZeile].setBounds(350, 620-iZeile*70, 15, 15);
						Controlbutton4[iZeile].setBounds(370, 620-iZeile*70, 15, 15);
						break;
			 
					case 5:
						contentPane.add(Controlbutton1[iZeile]);
						contentPane.add(Controlbutton2[iZeile]);
						contentPane.add(Controlbutton3[iZeile]);
						contentPane.add(Controlbutton4[iZeile]); 
						contentPane.add(Controlbutton5[iZeile]); 
				
						Controlbutton1[iZeile].setBounds(350, 600-iZeile*60, 15, 15);
						Controlbutton2[iZeile].setBounds(370, 600-iZeile*60, 15, 15);
						Controlbutton3[iZeile].setBounds(350, 620-iZeile*60, 15, 15);
						Controlbutton4[iZeile].setBounds(370, 620-iZeile*60, 15, 15);
						Controlbutton5[iZeile].setBounds(390, 600-iZeile*60, 15, 15);
						break;
				
					case 6:
						contentPane.add(Controlbutton1[iZeile]);
						contentPane.add(Controlbutton2[iZeile]);
						contentPane.add(Controlbutton3[iZeile]);
						contentPane.add(Controlbutton4[iZeile]); 
						contentPane.add(Controlbutton5[iZeile]); 
						contentPane.add(Controlbutton6[iZeile]); 
				
						Controlbutton1[iZeile].setBounds(400, 600-iZeile*55, 15, 15);
						Controlbutton2[iZeile].setBounds(420, 600-iZeile*55, 15, 15);
						Controlbutton3[iZeile].setBounds(400, 620-iZeile*55, 15, 15);
						Controlbutton4[iZeile].setBounds(420, 620-iZeile*55, 15, 15);
						Controlbutton5[iZeile].setBounds(440, 600-iZeile*55, 15, 15);
						Controlbutton6[iZeile].setBounds(440, 620-iZeile*55, 15, 15);
						break;
				
					default:
						break;
				}
			}
		}
		
		/**
		 * Legt ueber einen Zufallsgenerator den Zielcode fest, der erraten werden soll
		 *
		 * @param  -
		 * @return   -
		 */
		private void setZiel() {
		
			zielButtons = new JButton[anzahlSpalten];
			for(int i=0; i<anzahlSpalten; ++i){
				JButton zielButton = new JButton("");
				Random random = new Random();
				int zufallsZahl = random.nextInt(5);
				contentPane.add(zielButton);
				zielButton.setOpaque(true);
				zielButton.setBackground(colors[zufallsZahl]);
				zielButton.setBounds(10+i*50, 10, 50, 50);
				zielButtons[i] = zielButton;
				zielButtons[i].setEnabled(false);
				zielButtons[i].setVisible(false); //Lässt die Buttons verschwinden
			}
		}

		
		/**
		 * Setzt alle Parameter fuer den Butten, der zurueck zum Hauptmenue fuehrt
		 *
		 * @param  -
		 * @return   -
		 */
		private void setHauptmenubutton() {
			JButton Hauptmenubutton = new JButton("Hauptmen�");
			Hauptmenubutton.setBounds(700, 200, 100, 40);
			contentPane.add(Hauptmenubutton);
			Hauptmenubutton.setOpaque(true);
			Hauptmenubutton.setBorderPainted(true);
			Hauptmenubutton.setBackground(Color.WHITE);
			Hauptmenubutton.setForeground(Color.BLACK);
			
			Hauptmenubutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e6){
					
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									Spielbrett frame = new Spielbrett();
									frame.setVisible(true);
									dispose();
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
				}	
			});
		}
		
		/**
		 * Setzt alle Parameter fuer den Button, der zurueck zur Levelauswahl fuehrt
		 *
		 * @param  -
		 * @return   -
		 */
		private void setZurueckbutton(){
			JButton Zurueckbutton = new JButton("Zur�ck");
			Zurueckbutton.setBounds(700, 100, 100, 40);
			contentPane.add(Zurueckbutton);
			Zurueckbutton.setOpaque(true);
			Zurueckbutton.setBorderPainted(true);
			Zurueckbutton.setBackground(Color.WHITE);
			Zurueckbutton.setForeground(Color.BLACK);
			
			Zurueckbutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e6){
					
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									GUI_Levelauswahl frame = new GUI_Levelauswahl();
									frame.setVisible(true);
									dispose();
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
				}	
			});
		}
		
		/**
		 * Erzeugt eine Schaltflaeche, auf der die Farbreihenfolge beim durchklicken der Pinns als Spielhilfe angezeigt wird
		 *
		 * @param  -
		 * @return   -
		 */
		private void setFarbhilfe(){
			// Anzeige der Farbmöglichkeiten unten
			farbenButtons = new JButton[anzahlFarben];
			for(int iFarbe=0; iFarbe<anzahlFarben; ++iFarbe)
			{
				JButton farbeButton = new JButton("");
				farbeButton.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent e5)
					{
						((JButton)e5.getSource()).setBackground(Color.BLUE);
					}
				});
				contentPane.add(farbeButton);
				farbeButton.setOpaque(true);
				farbeButton.setBorderPainted(false);
				farbeButton.setBackground(colors[iFarbe]);
				farbeButton.setBounds(10+iFarbe*50, 700, 50, 50);
				farbenButtons[iFarbe] = farbeButton;
				farbenButtons[iFarbe].setEnabled(false);
			}
			// Ende der Anzeige der Fabmöglichkeiten unten
		}
		
		/**
		 * Setzt alle Parameter fuer das Haupspielfeld, bestehend aus den Reihen der Pinns
		 *
		 * @param  -
		 * @return   -
		 */
		private void setPinnButtons(){
			///Direkte Spieleingabe
			pinnButtons= new JButton[anzahlZeilen] [anzahlSpalten];
			for( int iZeile=0; iZeile<anzahlZeilen; ++iZeile){
				for( int iSpalte=0; iSpalte<anzahlSpalten; ++iSpalte){ 
					JButton pinnButton= new JButton("");
					pinnButton.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e1){	
								pinnButton.setBorderPainted(false);
								pinnButton.setOpaque(true);
						
								Color c = ((JButton)e1.getSource()).getBackground();
								
								if (c.getRGB()==Color.green.getRGB()) 	{
									((JButton)e1.getSource()).setBackground(colors[1]);
								}
								
								else if (c.getRGB()==Color.red.getRGB()){
									((JButton)e1.getSource()).setBackground(colors[2]);
								}
								
								else if (c.getRGB()==Color.blue.getRGB())	{
									((JButton)e1.getSource()).setBackground(colors[3]);
								}
								
								else if (c.getRGB()==Color.yellow.getRGB())	{
									((JButton)e1.getSource()).setBackground(colors[4]);
								}
								
								else if (c.getRGB()==Color.cyan.getRGB())	{
									((JButton)e1.getSource()).setBackground(colors[5]);
								}
								
								else if (c.getRGB()==Color.orange.getRGB() || c.getRGB()==Color.white.getRGB())	{
									((JButton)e1.getSource()).setBackground(colors[0]);
								}
							}	
						});
					
					contentPane.add(pinnButton);
					pinnButton.setBackground(Color.white);
					pinnButtons[iZeile][iSpalte] = pinnButton;
				
					switch(anzahlSpalten){
						case(4):
							pinnButton.setBounds(50+iSpalte*70, 600-iZeile*70, 35, 30);
						break;
						
						case(5):
							pinnButton.setBounds(50+iSpalte*60, 600-iZeile*60, 35, 30);
						break;
						
						case(6):
							pinnButton.setBounds(50+iSpalte*55, 600-iZeile*55, 35, 30);
							break;
						default:
							break;
					}
				
				if (iZeile > 0){
					pinnButtons[iZeile][iSpalte].setEnabled(false);
					}
				}
			}
			
			for (int i=0; i<anzahlSpalten; i++){ // Sichtbar machen der grünen Farbe in 1. Zeile
			pinnButtons[0][i].setBorderPainted(false);
			pinnButtons[0][i].setOpaque(true);
			}
			// Ende direkte Spieleingabe
		}
		
		/**
		 * Setzt den Button, der zur Kontrolle einer Farbkombination gedrueckt wird, fuehrt die Kontrolle durch und gibt die Rueckmeldung durch setzen der Kontrollpinns
		 *
		 * @param  -
		 * @return   -
		 */
		private void setKontrollbutton(){
			// Anfang Kontrollbutton 
			JButton Kontrollbutton = new JButton("Check");
			Kontrollbutton.setBounds(700, 600, 100, 40);
			contentPane.add(Kontrollbutton);
			Kontrollbutton.setOpaque(true);
			Kontrollbutton.setBorderPainted(true);
			Kontrollbutton.setBackground(Color.WHITE);
			Kontrollbutton.setForeground(Color.BLACK);
			
			Kontrollbutton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e6)
				{
					boolean reiheVoll=true;
					for(int i=0; i<anzahlSpalten; ++i) {
					Color c = pinnButtons[aktiveReihe][i].getBackground();	
						if(c.getRGB()==Color.white.getRGB()) {
							reiheVoll=false;
						}
					}
					
					if(reiheVoll) {
						for(int i=0; i<anzahlSpalten; ++i) {
							pinnButtons[0+aktiveReihe][i].setEnabled(false);
						}
							
						Controlbutton1[aktiveReihe].setOpaque(true);
						Controlbutton1[aktiveReihe].setBorderPainted(false);
							
						Controlbutton2[aktiveReihe].setOpaque(true);
						Controlbutton2[aktiveReihe].setBorderPainted(false);
							
						Controlbutton3[aktiveReihe].setOpaque(true);
						Controlbutton3[aktiveReihe].setBorderPainted(false);
							
						Controlbutton4[aktiveReihe].setOpaque(true);
						Controlbutton4[aktiveReihe].setBorderPainted(false);
							
						if(anzahlSpalten>4) {
							Controlbutton5[aktiveReihe].setOpaque(true);
							Controlbutton5[aktiveReihe].setBorderPainted(false);
						}
						
						if(anzahlSpalten>5) {
							Controlbutton6[aktiveReihe].setOpaque(true);
							Controlbutton6[aktiveReihe].setBorderPainted(false);
						}
						
							int weiss = 0;
							int schwarz = 0;
							
							// Hilfsarrays mit Info �ber Pinns die einen "Partner" gefunden haben
							boolean[] schonGeprueftPinn = new boolean[anzahlSpalten];
							boolean[] schonGeprueftZiel = new boolean[anzahlSpalten];
							for (int i = 0; i<anzahlSpalten; i++) {
								schonGeprueftPinn[i] = false;
								schonGeprueftZiel[i] = false;
							}
							
							// Pro Pinn mit richtiger Farbe an richtiger Stelle kommt ein schwarzer Pinn dazu 
							for (int i = 0; i<anzahlSpalten; i++) {
								if (zielButtons[i].getBackground() == pinnButtons[aktiveReihe][i].getBackground())
									schwarz++;
								
								for (int j = 0; j<anzahlSpalten; j++) {
									if (zielButtons[i].getBackground() == pinnButtons[aktiveReihe][j].getBackground() && (!schonGeprueftPinn[j] && !schonGeprueftZiel[i])) {
										weiss++;
										schonGeprueftPinn[j] = true;
										schonGeprueftZiel[i] = true;
									}
								}
							}
						
							switch (weiss){
								case 1: 
									Controlbutton1[aktiveReihe].setBackground(Color.WHITE);
									break;
									
								case 2: 
									Controlbutton1[aktiveReihe].setBackground(Color.WHITE);
									Controlbutton2[aktiveReihe].setBackground(Color.WHITE);
									break;
									
								case 3:
									Controlbutton1[aktiveReihe].setBackground(Color.WHITE);
									Controlbutton2[aktiveReihe].setBackground(Color.WHITE);
									Controlbutton3[aktiveReihe].setBackground(Color.WHITE);
									break;
									
								case 4: 
									
									Controlbutton1[aktiveReihe].setBackground(Color.WHITE);
									Controlbutton2[aktiveReihe].setBackground(Color.WHITE);
									Controlbutton3[aktiveReihe].setBackground(Color.WHITE);
									Controlbutton4[aktiveReihe].setBackground(Color.WHITE);
									break;
									
								case 5: 
									Controlbutton1[aktiveReihe].setBackground(Color.WHITE);
									Controlbutton2[aktiveReihe].setBackground(Color.WHITE);
									Controlbutton3[aktiveReihe].setBackground(Color.WHITE);
									Controlbutton4[aktiveReihe].setBackground(Color.WHITE);
									Controlbutton5[aktiveReihe].setBackground(Color.WHITE);
									break;
		
								case 6: 
									Controlbutton1[aktiveReihe].setBackground(Color.WHITE);
									Controlbutton2[aktiveReihe].setBackground(Color.WHITE);
									Controlbutton3[aktiveReihe].setBackground(Color.WHITE);
									Controlbutton4[aktiveReihe].setBackground(Color.WHITE);
									Controlbutton5[aktiveReihe].setBackground(Color.WHITE);
									Controlbutton6[aktiveReihe].setBackground(Color.WHITE);
									break;	
								default: 
									break;
							}
							
							switch (schwarz){
								case 1: 
									Controlbutton1[aktiveReihe].setBackground(Color.BLACK);
									break;
									
								case 2: 
									Controlbutton1[aktiveReihe].setBackground(Color.BLACK);
									Controlbutton2[aktiveReihe].setBackground(Color.BLACK);
									break;
									
								case 3:
									Controlbutton1[aktiveReihe].setBackground(Color.BLACK);
									Controlbutton2[aktiveReihe].setBackground(Color.BLACK);
									Controlbutton3[aktiveReihe].setBackground(Color.BLACK);
									break;
									
								case 4: 
									Controlbutton1[aktiveReihe].setBackground(Color.BLACK);
									Controlbutton2[aktiveReihe].setBackground(Color.BLACK);
									Controlbutton3[aktiveReihe].setBackground(Color.BLACK);
									Controlbutton4[aktiveReihe].setBackground(Color.BLACK);
									break;
									
								case 5: 
									Controlbutton1[aktiveReihe].setBackground(Color.BLACK);
									Controlbutton2[aktiveReihe].setBackground(Color.BLACK);
									Controlbutton3[aktiveReihe].setBackground(Color.BLACK);
									Controlbutton4[aktiveReihe].setBackground(Color.BLACK);
									Controlbutton5[aktiveReihe].setBackground(Color.BLACK);
									break;
									
								case 6: 
									Controlbutton1[aktiveReihe].setBackground(Color.BLACK);
									Controlbutton2[aktiveReihe].setBackground(Color.BLACK);
									Controlbutton3[aktiveReihe].setBackground(Color.BLACK);
									Controlbutton4[aktiveReihe].setBackground(Color.BLACK);
									Controlbutton5[aktiveReihe].setBackground(Color.BLACK);
									Controlbutton6[aktiveReihe].setBackground(Color.BLACK);
									break;
								
								default: 
									break;
							}
							
							if (schwarz!=anzahlSpalten && aktiveReihe==anzahlZeilen-1){
								 
								 	Verlorenlabel.setVisible(true);
								 	////////////////////////////////////////
									Punktelabel = new JLabel ("Punktzahl: " +  punkte.wertung(anzahlZeilen-(aktiveReihe+1)));
									Punktelabel.setBounds(530,400,1500,1000);
									Punktelabel.setVerticalAlignment(JLabel.CENTER);
									Punktelabel.setSize(284, 100);
									contentPane.add(Punktelabel);
									Punktelabel.setOpaque(true);
									Punktelabel.setBackground(Color.WHITE);
									Punktelabel.setForeground(Color.BLACK);
									Punktelabel.setFont(new Font("", 60,30));
									Punktelabel.setVisible(true);
									Kontrollbutton.setEnabled(false);
									///////////////////////////////////////////
								 	for(int i=0; i<anzahlSpalten; ++i) {
								 		zielButtons[i].setVisible(true);
								 	}
								}	
								
								
							else if (schwarz!=anzahlSpalten){
								aktiveReihe++;
								
								for(int i=0; i<anzahlSpalten; ++i) {
									pinnButtons[aktiveReihe][i].setBackground(pinnButtons[aktiveReihe-1][i].getBackground());
									
									pinnButtons[0+aktiveReihe][i].setEnabled(true);
									
									pinnButtons[0+aktiveReihe][i].setOpaque(true);
									pinnButtons[0+aktiveReihe][i].setBorderPainted(false);
								}
							}
						 
							else if (schwarz==anzahlSpalten)
							{	
								Gewinnlabel.setVisible(true);
								////////////////////////////////////////////////
								Punktelabel = new JLabel ("Punktzahl: " +  punkte.wertung(anzahlZeilen-aktiveReihe));
								Punktelabel.setBounds(530,400,1500,1000);
								Punktelabel.setVerticalAlignment(JLabel.CENTER);
								Punktelabel.setSize(284, 100);
								contentPane.add(Punktelabel);
								Punktelabel.setOpaque(true);
								Punktelabel.setBackground(Color.WHITE);
								Punktelabel.setForeground(Color.BLACK);
								Punktelabel.setFont(new Font("", 60,30));
								Punktelabel.setVisible(true);
								Kontrollbutton.setEnabled(false);
								///////////////////////////////////////////////
								for(int i=0; i<anzahlSpalten; ++i) {	
									zielButtons[i].setVisible(true);
								}
									 Neuer_Highscore NEW = null;
									try {
										NEW = new Neuer_Highscore();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								     try {
										NEW.Ausf�hren(punkte.wertung(anzahlZeilen-aktiveReihe));
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								
							}
						}//ende if
				}
			});
		}
		// Ende Kontrollbutton
		
		
		///////////////////////////////////////////////////////////////////
		private void setX() {
			JButton X = new JButton("");
			X.setBounds(1000, 600, 20, 20);
			contentPane.add(X);
			X.setOpaque(true);
			X.setBorderPainted(true);
			X.setBackground(Color.WHITE);
			X.setForeground(Color.BLACK);
			
			X.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e6)
				{
					if(zielButtons[0].isVisible())
						for(int i=0; i<anzahlSpalten; ++i)
							zielButtons[i].setVisible(false);
					else
						for(int i=0; i<anzahlSpalten; ++i)
							zielButtons[i].setVisible(true);
				}
			});
		}////////////////////////////////////////////////////////////////////
		
}//Ende der Klasse






