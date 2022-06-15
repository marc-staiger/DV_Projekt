import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Frame_2 extends JFrame {

	private JPanel contentPane;
	static final long serialVersionUID = 1L;
	static Color[] colors = { Color.green, Color.red, Color.blue, Color.yellow, Color.cyan, Color.orange,};
	
	private int Buttons2=10; // 6 Zeilen
	private int Buttons1=6; // 4 Spalten
	private JButton[][] buttons1= new JButton[Buttons2] [Buttons1]; // Array für die Eingabefelder
	private int I2; // Durchzählen der Zeilen
	private int I1; // Durchzählen der Spalten
	
	
	//private int Buttons3=6;
	private JButton [] Controlbutton1= new JButton[Buttons2]; 
	private JButton [] Controlbutton2= new JButton[Buttons2]; 
	private JButton [] Controlbutton3= new JButton[Buttons2]; 
	private JButton [] Controlbutton4= new JButton[Buttons2]; 
	private JButton [] Controlbutton5= new JButton[Buttons2]; 
	private JButton [] Controlbutton6= new JButton[Buttons2]; 
	
	
	private  JButton[] buttons4 = new JButton[Buttons1]; // Array Zielergebnis der Farbmöglichkeiten
	
	private int numButtons5 = 6; // 6Farben
	private JButton[] buttons5 = new JButton[numButtons5]; // Array Farbmöglichkeiten unten
	
	private int Zaehler1;
	
	/*private int Feld1Gedrueckt;
	private int Feld2Gedrueckt;
	private int Feld3Gedrueckt;
	private int Feld4Gedrueckt;
	private int Feld5Gedrueckt;
	private int Feld6Gedrueckt;
	*/
	
	
	
	
	
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Frame_2 frame = new Frame_2(6,10);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * @param p2 
	 */
	public Frame_2(int Zeile, int Reihe) 
	{
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(0, 0, 1800, 1200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.Buttons1=Zeile;
		this.Buttons2=Reihe;
		
		
		JLabel lblNewLabel = new JLabel("Mastermind");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 21));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		
		
		
				
				//Anfang GewinnLabel
				
				JLabel Gewinnlabel = new JLabel ("Sie haben Gewonnen!");
				Gewinnlabel.setBounds(530,300,1000,1000);
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

				JLabel Verlorenlabel = new JLabel ("Sie haben Verloren!");
				Verlorenlabel.setBounds(530,300,1000,1000);
				Verlorenlabel.setVerticalAlignment(JLabel.CENTER);
				Verlorenlabel.setSize(284, 100);
				contentPane.add(Verlorenlabel);
				Verlorenlabel.setOpaque(true);
				Verlorenlabel.setBackground(Color.WHITE);
				Verlorenlabel.setForeground(Color.BLACK);
				Verlorenlabel.setFont(new Font("Sie Haben Verloren", 60,30));
				Verlorenlabel.setVisible(false);
			
				
				//Ende Verlorenlabel
				
				
				
				
		///Direkte Spieleingabe
	
		for( int i2=0; i2< Buttons2; ++i2)
	
		{
			I2=i2;
		
		
		for( int i1=0; i1<Buttons1; ++i1)
			
			{ 
			I1=i1;
			JButton b1= new JButton("");
			//final int pos1 =i1;
			b1.addActionListener(new ActionListener() 
					{
						public void actionPerformed(ActionEvent e1)
						{
							
							b1.setBorderPainted(false);
							b1.setOpaque(true);
					
							Color c= ((JButton)e1.getSource()).getBackground();
							
							if (c.getRGB()==Color.green.getRGB()) 
								
							{
								((JButton)e1.getSource()).setBackground(colors[1]);
							}
							
							else if (c.getRGB()==Color.red.getRGB())
							
							{
								((JButton)e1.getSource()).setBackground(colors[2]);
							}
							
							else if (c.getRGB()==Color.blue.getRGB())
								
							{
								((JButton)e1.getSource()).setBackground(colors[3]);
							}
							
							else if (c.getRGB()==Color.yellow.getRGB())
								
							{
								((JButton)e1.getSource()).setBackground(colors[4]);
							}
							
							else if (c.getRGB()==Color.cyan.getRGB())
								
							{
								((JButton)e1.getSource()).setBackground(colors[5]);
							}
							
							else if (c.getRGB()==Color.orange.getRGB())
								
							{
								((JButton)e1.getSource()).setBackground(colors[0]);
							}
							
						}
						
					});
			contentPane.add(b1);
		//	b1.setBorderPainted(false);
		//	b1.setOpaque(true);
		//	b1.setBackground(Color.green);
			buttons1[i2][i1] = b1;
			
			switch(Buttons1)
			
			{
			
			case(4):
				
				
				b1.setBounds(50+i1*70, 600-i2*70, 35, 30);
				
				break;
			
			case(5):
				
				b1.setBounds(50+i1*60, 600-i2*60, 35, 30);
				
				break;
				
			case(6):
				
				b1.setBounds(50+i1*55, 600-i2*55, 35, 30);
			default:
				break;
			}
			
			
			
			
			if (i2 > 0)
				{
				buttons1[i2][i1].setEnabled(false);
				}
	
			}
		}
		
		
		for (int w1=0; w1<Buttons1; w1++) // Sichtbar machen der grünen Farbe in 1. Zeile
		{
		buttons1[0][w1].setBorderPainted(false);
		buttons1[0][w1].setOpaque(true);
		buttons1[0][w1].setBackground(Color.green);
		
		}
		
		// Ende direkte Spieleingabe
		
		
		
		
		
		
		// Beginn der Überprüfung der Eingabe
		
		for( int i3=0; i3<Buttons2; ++i3)
			
		{
			JButton btnNewButton = new JButton("");
			JButton btnNewButton_1 = new JButton("");
			JButton btnNewButton_2 = new JButton("");
			JButton btnNewButton_3 = new JButton("");
			JButton btnNewButton_4 = new JButton("");
			JButton btnNewButton_5 = new JButton("");
		
			
			
		Controlbutton1[i3]= btnNewButton;
		
		
		//btnNewButton_1.setOpaque(true);
		//btnNewButton_1.setBorderPainted(false);
		//btnNewButton_1.setBackground(Color.BLUE);
		Controlbutton2[i3]= btnNewButton_1;
		
		
		Controlbutton3[i3]= btnNewButton_2;
		
		
		Controlbutton4[i3]= btnNewButton_3;
		
		
		Controlbutton5[i3]= btnNewButton_4;
		
		
		Controlbutton6[i3]= btnNewButton_5;
		
		
		switch(Buttons1)
		
		{
		case 4:
			
			contentPane.add(Controlbutton1[i3]);
			contentPane.add(Controlbutton2[i3]);
			contentPane.add(Controlbutton3[i3]);
			contentPane.add(Controlbutton4[i3]); 
			
			Controlbutton1[i3].setBounds(350, 600-i3*70, 15, 15);
			Controlbutton2[i3].setBounds(370, 600-i3*70, 15, 15);
			Controlbutton3[i3].setBounds(350, 620-i3*70, 15, 15);
			Controlbutton4[i3].setBounds(370, 620-i3*70, 15, 15);
			
			break;
		 
		case 5:
			
			contentPane.add(Controlbutton1[i3]);
			contentPane.add(Controlbutton2[i3]);
			contentPane.add(Controlbutton3[i3]);
			contentPane.add(Controlbutton4[i3]); 
			contentPane.add(Controlbutton5[i3]); 
			
			Controlbutton1[i3].setBounds(350, 600-i3*60, 15, 15);
			Controlbutton2[i3].setBounds(370, 600-i3*60, 15, 15);
			Controlbutton3[i3].setBounds(350, 620-i3*60, 15, 15);
			Controlbutton4[i3].setBounds(370, 620-i3*60, 15, 15);
			Controlbutton5[i3].setBounds(390, 600-i3*60, 15, 15);
			
			break;
			
		case 6:
			
			contentPane.add(Controlbutton1[i3]);
			contentPane.add(Controlbutton2[i3]);
			contentPane.add(Controlbutton3[i3]);
			contentPane.add(Controlbutton4[i3]); 
			contentPane.add(Controlbutton5[i3]); 
			contentPane.add(Controlbutton6[i3]); 
			
			Controlbutton1[i3].setBounds(400, 600-i3*55, 15, 15);
			Controlbutton2[i3].setBounds(420, 600-i3*55, 15, 15);
			Controlbutton3[i3].setBounds(400, 620-i3*55, 15, 15);
			Controlbutton4[i3].setBounds(420, 620-i3*55, 15, 15);
			Controlbutton5[i3].setBounds(440, 600-i3*55, 15, 15);
			Controlbutton6[i3].setBounds(440, 620-i3*55, 15, 15);
			
			break;
			
		default:
			
			break;
		}
		
		
		
		}
		
		
		
		// Ende der Überprüfung der Eingabe
		
		
	
		
		
		
		
		
		// Beginn der korrekten Farbkombination oben
		
		
		for(int i4=0; i4<Buttons1; ++i4)
		{
			JButton b4 = new JButton(""+i4);
			//final int pos4 = i4;
		/*	b4.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e4)
				{
					//System.out.println(""+pos4);
					((JButton)e4.getSource()).setBackground(Color.BLUE);
				}
				
			});*/
			
			
			Random random = new Random();
			int zahl = random.nextInt(5);
			contentPane.add(b4);
			b4.setOpaque(true);
			b4.setBackground(colors[zahl]);
			b4.setBounds(10+i4*50, 10, 50, 50);
			buttons4[i4] = b4;
			
			buttons4[i4].setEnabled(false);
			buttons4[i4].setVisible(false); //Lässt die Buttons verschwinden
		}
		
		
		
		// Ende der korrekten Farbkombination oben
		
		
		
		
		
		
		// Anzeige der Farbmöglichkeiten unten
		
		

		for(int i5=0; i5<numButtons5; ++i5)
		{
			JButton b5 = new JButton("");
		//	final int pos5 = i5;
			b5.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e5)
				{
				//	System.out.println(""+pos5);
					((JButton)e5.getSource()).setBackground(Color.BLUE);
				}
				
			});
			contentPane.add(b5);
			b5.setOpaque(true);
			b5.setBorderPainted(false);
			b5.setBackground(colors[i5]);
			b5.setBounds(10+i5*50, 700, 50, 50);
			buttons5[i5] = b5;
			
			buttons5[i5].setEnabled(false);
		}
		
		
		// Ende der Anzeige der Fabmöglichkeiten unten
		
		
		
		
		
		
		// Anfang Kontrollbutton 
		
		
		JButton Kontrollbutton = new JButton("Check");
		Kontrollbutton.setBounds(700, 600, 60, 40);
		contentPane.add(Kontrollbutton);
		Kontrollbutton.setOpaque(true);
		Kontrollbutton.setBorderPainted(true);
		Kontrollbutton.setBackground(Color.WHITE);
		Kontrollbutton.setForeground(Color.BLACK);
		
		Kontrollbutton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e6)
			{
				//System.out.println(""+pos4);
				//((JButton)e6.getSource()).setBackground(Color.BLUE);
				
			if (Buttons1==4)
			{
				buttons1[0+Zaehler1][0].setEnabled(false);
				buttons1[0+Zaehler1][1].setEnabled(false);
				buttons1[0+Zaehler1][2].setEnabled(false);
				buttons1[0+Zaehler1][3].setEnabled(false);
				
				Color c1= buttons1[0+Zaehler1][0].getBackground();
				Color c2= buttons1[0+Zaehler1][1].getBackground();
				Color c3= buttons1[0+Zaehler1][2].getBackground();
				Color c4= buttons1[0+Zaehler1][3].getBackground();
				
				Color cc1= buttons4[0].getBackground();
				Color cc2= buttons4[1].getBackground();
				Color cc3= buttons4[2].getBackground();
				Color cc4= buttons4[3].getBackground();
				
				Controlbutton1[Zaehler1].setOpaque(true);
				Controlbutton1[Zaehler1].setBorderPainted(false);
				
				Controlbutton2[Zaehler1].setOpaque(true);
				Controlbutton2[Zaehler1].setBorderPainted(false);
				
				Controlbutton3[Zaehler1].setOpaque(true);
				Controlbutton3[Zaehler1].setBorderPainted(false);
				
				Controlbutton4[Zaehler1].setOpaque(true);
				Controlbutton4[Zaehler1].setBorderPainted(false);
				
				/*
				if (c1 == cc1)
					{
					Controlbutton1[Zaehler1].setBackground(Color.BLACK);
					}
				else if (c1 == cc2 | c1 == cc3 | c1 == cc4)
					{Controlbutton1[Zaehler1].setBackground(Color.WHITE);}
				
				else
				{}
				
				
				
				if (c2 == cc2)
					
				{
					Controlbutton2[Zaehler1].setBackground(Color.BLACK);
				}
				
				else if (c2 == cc1 | c2 == cc3 | c2 == cc4)
				{
					Controlbutton2[Zaehler1].setBackground(Color.WHITE);
				}
			
				else
				{}
				
				
				
				if (c3 == cc3)
					
				{
					Controlbutton3[Zaehler1].setBackground(Color.BLACK);
				}
				
				else if (c3 == cc1 | c3 == cc2 | c3 == cc4)
				{
					Controlbutton3[Zaehler1].setBackground(Color.WHITE);
				}
			
				else
				{}
				
				
				
				if (c4 == cc4)
					
				{
					Controlbutton4[Zaehler1].setBackground(Color.BLACK);
				}
				
				else if (c4 == cc1 | c4 == cc2 | c4 == cc3)
				{
					Controlbutton4[Zaehler1].setBackground(Color.WHITE);
				}
			
				else
				{}
				*/
				
				
				//////
				int weiss = 0;
				int schwarz = 0;
				
				// Hilfsarrays mit Info �ber Pinns die einen "Partner" gefunden haben
				boolean[] schonGeprueftPinn = new boolean[Buttons1];
				boolean[] schonGeprueftZiel = new boolean[Buttons1];
				for (int i = 0; i<Buttons1; i++) {
					schonGeprueftPinn[i] = false;
					schonGeprueftZiel[i] = false;
				}
				
				// Pro Pinn mit richtiger Farbe an richtiger Stelle kommt ein schwarzer Pinn dazu 
				for (int i = 0; i<Buttons1; i++) {
					if (buttons4[i].getBackground() == buttons1[Zaehler1][i].getBackground())
						schwarz++;
					
					for (int j = 0; j<Buttons1; j++) {
						if (buttons4[i].getBackground() == buttons1[Zaehler1][j].getBackground() && (!schonGeprueftPinn[j] && !schonGeprueftZiel[i])) {
							weiss++;
							schonGeprueftPinn[j] = true;
							schonGeprueftZiel[i] = true;
						}
					}
				}
				
				
			
				switch (weiss)
				{
				case 1: 
					
					Controlbutton1[Zaehler1].setBackground(Color.WHITE);
					break;
					
				case 2: 
					
					Controlbutton1[Zaehler1].setBackground(Color.WHITE);
					Controlbutton2[Zaehler1].setBackground(Color.WHITE);
				
					break;
					
				case 3:
				
					Controlbutton1[Zaehler1].setBackground(Color.WHITE);
					Controlbutton2[Zaehler1].setBackground(Color.WHITE);
					Controlbutton3[Zaehler1].setBackground(Color.WHITE);
		
					break;
					
				case 4: 
					
					Controlbutton1[Zaehler1].setBackground(Color.WHITE);
					Controlbutton2[Zaehler1].setBackground(Color.WHITE);
					Controlbutton3[Zaehler1].setBackground(Color.WHITE);
					Controlbutton4[Zaehler1].setBackground(Color.WHITE);
				
					break;
				
				default: 
					
				break;
				
				}
				
				
				
				
				switch (schwarz)
				{
				case 1: 
					
					Controlbutton1[Zaehler1].setBackground(Color.BLACK);
					break;
					
				case 2: 
					
					Controlbutton1[Zaehler1].setBackground(Color.BLACK);
					Controlbutton2[Zaehler1].setBackground(Color.BLACK);
				
					break;
					
				case 3:
				
					Controlbutton1[Zaehler1].setBackground(Color.BLACK);
					Controlbutton2[Zaehler1].setBackground(Color.BLACK);
					Controlbutton3[Zaehler1].setBackground(Color.BLACK);
		
					break;
					
				case 4: 
					
					Controlbutton1[Zaehler1].setBackground(Color.BLACK);
					Controlbutton2[Zaehler1].setBackground(Color.BLACK);
					Controlbutton3[Zaehler1].setBackground(Color.BLACK);
					Controlbutton4[Zaehler1].setBackground(Color.BLACK);
					
					Gewinnlabel.setVisible(true);
					buttons4[0].setVisible(true);
					buttons4[1].setVisible(true);
					buttons4[2].setVisible(true);
					buttons4[3].setVisible(true);
					
					
					break;
				
				default: 
					
					break;
				}
		
				//////
			
				
				
			 if (schwarz!=4 && Zaehler1==Buttons2-1)
			 	{
				 
				 Verlorenlabel.setVisible(true);
				 buttons4[0].setVisible(true);
				 buttons4[1].setVisible(true);
				 buttons4[2].setVisible(true);
				 buttons4[3].setVisible(true);
				}	
				
				
			else if (schwarz!=4)
				{
				Zaehler1++;
				
				buttons1[0+Zaehler1][0].setEnabled(true);
				buttons1[0+Zaehler1][1].setEnabled(true);
				buttons1[0+Zaehler1][2].setEnabled(true);
				buttons1[0+Zaehler1][3].setEnabled(true);
				
				buttons1[0+Zaehler1][0].setBackground(c1);
				buttons1[0+Zaehler1][1].setBackground(c2);
				buttons1[0+Zaehler1][2].setBackground(c3);
				buttons1[0+Zaehler1][3].setBackground(c4);
				
				buttons1[0+Zaehler1][0].setOpaque(true);
				buttons1[0+Zaehler1][0].setBorderPainted(false);
				buttons1[0+Zaehler1][1].setOpaque(true);
				buttons1[0+Zaehler1][1].setBorderPainted(false);
				buttons1[0+Zaehler1][2].setOpaque(true);
				buttons1[0+Zaehler1][2].setBorderPainted(false);
				buttons1[0+Zaehler1][3].setOpaque(true);
				buttons1[0+Zaehler1][3].setBorderPainted(false);
				}
			 
			else if (schwarz==4)
			{
				
			}
				
		}
			
			else if (Buttons1==5)
				
			{
				buttons1[0+Zaehler1][0].setEnabled(false);
				buttons1[0+Zaehler1][1].setEnabled(false);
				buttons1[0+Zaehler1][2].setEnabled(false);
				buttons1[0+Zaehler1][3].setEnabled(false);
				buttons1[0+Zaehler1][4].setEnabled(false);
				
				
				Color c1= buttons1[0+Zaehler1][0].getBackground();
				Color c2= buttons1[0+Zaehler1][1].getBackground();
				Color c3= buttons1[0+Zaehler1][2].getBackground();
				Color c4= buttons1[0+Zaehler1][3].getBackground();
				Color c5= buttons1[0+Zaehler1][4].getBackground();
				
				Color cc1= buttons4[0].getBackground();
				Color cc2= buttons4[1].getBackground();
				Color cc3= buttons4[2].getBackground();
				Color cc4= buttons4[3].getBackground();
				Color cc5= buttons4[4].getBackground();
				
				
				Controlbutton1[Zaehler1].setOpaque(true);
				Controlbutton1[Zaehler1].setBorderPainted(false);
				
				Controlbutton2[Zaehler1].setOpaque(true);
				Controlbutton2[Zaehler1].setBorderPainted(false);
				
				Controlbutton3[Zaehler1].setOpaque(true);
				Controlbutton3[Zaehler1].setBorderPainted(false);
				
				Controlbutton4[Zaehler1].setOpaque(true);
				Controlbutton4[Zaehler1].setBorderPainted(false);
				
				Controlbutton5[Zaehler1].setOpaque(true);
				Controlbutton5[Zaehler1].setBorderPainted(false);
				
				
				//////
				int weiss = 0;
				int schwarz = 0;
				
				// Hilfsarrays mit Info �ber Pinns die einen "Partner" gefunden haben
				boolean[] schonGeprueftPinn = new boolean[Buttons1];
				boolean[] schonGeprueftZiel = new boolean[Buttons1];
				for (int i = 0; i<Buttons1; i++) {
					schonGeprueftPinn[i] = false;
					schonGeprueftZiel[i] = false;
				}
				
				// Pro Pinn mit richtiger Farbe an richtiger Stelle kommt ein schwarzer Pinn dazu 
				for (int i = 0; i<Buttons1; i++) {
					if (buttons4[i].getBackground() == buttons1[Zaehler1][i].getBackground())
						schwarz++;
					
					for (int j = 0; j<Buttons1; j++) {
						if (buttons4[i].getBackground() == buttons1[Zaehler1][j].getBackground() && (!schonGeprueftPinn[j] && !schonGeprueftZiel[i])) {
							weiss++;
							schonGeprueftPinn[j] = true;
							schonGeprueftZiel[i] = true;
						}
					}
				}
				
			/*	// Kontrollpinns setzen
				for (int i = 0; i<weiss; i++)
					kontrolle[i][aktiveReihe] = 1; // wei�e Pinns werden gesetzt
				for (int i = 0; i<schwarz; i++)
					kontrolle[i][aktiveReihe] = 2; // schwarze Pinns werden gesetzt
			*/
				
			
				switch (weiss)
				{
				case 1: 
					
					Controlbutton1[Zaehler1].setBackground(Color.WHITE);
					break;
					
				case 2: 
					
					Controlbutton1[Zaehler1].setBackground(Color.WHITE);
					Controlbutton2[Zaehler1].setBackground(Color.WHITE);
				
					break;
					
				case 3:
				
					Controlbutton1[Zaehler1].setBackground(Color.WHITE);
					Controlbutton2[Zaehler1].setBackground(Color.WHITE);
					Controlbutton3[Zaehler1].setBackground(Color.WHITE);
		
					break;
					
				case 4: 
					
					Controlbutton1[Zaehler1].setBackground(Color.WHITE);
					Controlbutton2[Zaehler1].setBackground(Color.WHITE);
					Controlbutton3[Zaehler1].setBackground(Color.WHITE);
					Controlbutton4[Zaehler1].setBackground(Color.WHITE);
				
					break;
					
				case 5: 
					
					Controlbutton1[Zaehler1].setBackground(Color.WHITE);
					Controlbutton2[Zaehler1].setBackground(Color.WHITE);
					Controlbutton3[Zaehler1].setBackground(Color.WHITE);
					Controlbutton4[Zaehler1].setBackground(Color.WHITE);
					Controlbutton5[Zaehler1].setBackground(Color.WHITE);
				
					break;
				
				default: 
					
				break;
				
				}
				
				
				
				
				switch (schwarz)
				{
				case 1: 
					
					Controlbutton1[Zaehler1].setBackground(Color.BLACK);
					break;
					
				case 2: 
					
					Controlbutton1[Zaehler1].setBackground(Color.BLACK);
					Controlbutton2[Zaehler1].setBackground(Color.BLACK);
				
					break;
					
				case 3:
				
					Controlbutton1[Zaehler1].setBackground(Color.BLACK);
					Controlbutton2[Zaehler1].setBackground(Color.BLACK);
					Controlbutton3[Zaehler1].setBackground(Color.BLACK);
		
					break;
					
				case 4: 
					
					Controlbutton1[Zaehler1].setBackground(Color.BLACK);
					Controlbutton2[Zaehler1].setBackground(Color.BLACK);
					Controlbutton3[Zaehler1].setBackground(Color.BLACK);
					Controlbutton4[Zaehler1].setBackground(Color.BLACK);
					
					
					break;
					
					
				case 5: 
					
					Controlbutton1[Zaehler1].setBackground(Color.BLACK);
					Controlbutton2[Zaehler1].setBackground(Color.BLACK);
					Controlbutton3[Zaehler1].setBackground(Color.BLACK);
					Controlbutton4[Zaehler1].setBackground(Color.BLACK);
					Controlbutton5[Zaehler1].setBackground(Color.BLACK);
					
					Gewinnlabel.setVisible(true);
					buttons4[0].setVisible(true);
					buttons4[1].setVisible(true);
					buttons4[2].setVisible(true);
					buttons4[3].setVisible(true);
					buttons4[4].setVisible(true);
				
					break;
					
				default: 
					
					break;
				}
		
				//////
			
				
				
			 if (schwarz!=5 && Zaehler1==Buttons2-1)
			 	{
				 
				 Verlorenlabel.setVisible(true);
				 buttons4[0].setVisible(true);
				 buttons4[1].setVisible(true);
				 buttons4[2].setVisible(true);
				 buttons4[3].setVisible(true);
				 buttons4[4].setVisible(true);
				}	
				
				
			else if (schwarz!=5)
				{
				Zaehler1++;
				
				buttons1[0+Zaehler1][0].setEnabled(true);
				buttons1[0+Zaehler1][1].setEnabled(true);
				buttons1[0+Zaehler1][2].setEnabled(true);
				buttons1[0+Zaehler1][3].setEnabled(true);
				buttons1[0+Zaehler1][4].setEnabled(true);
				
				buttons1[0+Zaehler1][0].setBackground(c1);
				buttons1[0+Zaehler1][1].setBackground(c2);
				buttons1[0+Zaehler1][2].setBackground(c3);
				buttons1[0+Zaehler1][3].setBackground(c4);
				buttons1[0+Zaehler1][4].setBackground(c5);
				
				buttons1[0+Zaehler1][0].setOpaque(true);
				buttons1[0+Zaehler1][0].setBorderPainted(false);
				buttons1[0+Zaehler1][1].setOpaque(true);
				buttons1[0+Zaehler1][1].setBorderPainted(false);
				buttons1[0+Zaehler1][2].setOpaque(true);
				buttons1[0+Zaehler1][2].setBorderPainted(false);
				buttons1[0+Zaehler1][3].setOpaque(true);
				buttons1[0+Zaehler1][3].setBorderPainted(false);
				buttons1[0+Zaehler1][4].setOpaque(true);
				buttons1[0+Zaehler1][4].setBorderPainted(false);
				}
			 
			else if (schwarz==5)
			{
				
			}
				
			} //Ende else if Schleife BUttons1==5
			
			
			
			
			
			else if (Buttons1==6)
				
			{
				buttons1[0+Zaehler1][0].setEnabled(false);
				buttons1[0+Zaehler1][1].setEnabled(false);
				buttons1[0+Zaehler1][2].setEnabled(false);
				buttons1[0+Zaehler1][3].setEnabled(false);
				buttons1[0+Zaehler1][4].setEnabled(false);
				buttons1[0+Zaehler1][5].setEnabled(false);
				
				
				Color c1= buttons1[0+Zaehler1][0].getBackground();
				Color c2= buttons1[0+Zaehler1][1].getBackground();
				Color c3= buttons1[0+Zaehler1][2].getBackground();
				Color c4= buttons1[0+Zaehler1][3].getBackground();
				Color c5= buttons1[0+Zaehler1][4].getBackground();
				Color c6= buttons1[0+Zaehler1][5].getBackground();
				
				Color cc1= buttons4[0].getBackground();
				Color cc2= buttons4[1].getBackground();
				Color cc3= buttons4[2].getBackground();
				Color cc4= buttons4[3].getBackground();
				Color cc5= buttons4[4].getBackground();
				Color cc6= buttons4[5].getBackground();
				
				
				Controlbutton1[Zaehler1].setOpaque(true);
				Controlbutton1[Zaehler1].setBorderPainted(false);
				
				Controlbutton2[Zaehler1].setOpaque(true);
				Controlbutton2[Zaehler1].setBorderPainted(false);
				
				Controlbutton3[Zaehler1].setOpaque(true);
				Controlbutton3[Zaehler1].setBorderPainted(false);
				
				Controlbutton4[Zaehler1].setOpaque(true);
				Controlbutton4[Zaehler1].setBorderPainted(false);
				
				Controlbutton5[Zaehler1].setOpaque(true);
				Controlbutton5[Zaehler1].setBorderPainted(false);
				
				Controlbutton6[Zaehler1].setOpaque(true);
				Controlbutton6[Zaehler1].setBorderPainted(false);
				
				
				//////
				int weiss = 0;
				int schwarz = 0;
				
				// Hilfsarrays mit Info �ber Pinns die einen "Partner" gefunden haben
				boolean[] schonGeprueftPinn = new boolean[Buttons1];
				boolean[] schonGeprueftZiel = new boolean[Buttons1];
				for (int i = 0; i<Buttons1; i++) {
					schonGeprueftPinn[i] = false;
					schonGeprueftZiel[i] = false;
				}
				
				// Pro Pinn mit richtiger Farbe an richtiger Stelle kommt ein schwarzer Pinn dazu 
				for (int i = 0; i<Buttons1; i++) {
					if (buttons4[i].getBackground() == buttons1[Zaehler1][i].getBackground())
						schwarz++;
					
					for (int j = 0; j<Buttons1; j++) {
						if (buttons4[i].getBackground() == buttons1[Zaehler1][j].getBackground() && (!schonGeprueftPinn[j] && !schonGeprueftZiel[i])) {
							weiss++;
							schonGeprueftPinn[j] = true;
							schonGeprueftZiel[i] = true;
						}
					}
				}
				
			/*	// Kontrollpinns setzen
				for (int i = 0; i<weiss; i++)
					kontrolle[i][aktiveReihe] = 1; // wei�e Pinns werden gesetzt
				for (int i = 0; i<schwarz; i++)
					kontrolle[i][aktiveReihe] = 2; // schwarze Pinns werden gesetzt
			*/
				
			
				switch (weiss)
				{
				case 1: 
					
					Controlbutton1[Zaehler1].setBackground(Color.WHITE);
					break;
					
				case 2: 
					
					Controlbutton1[Zaehler1].setBackground(Color.WHITE);
					Controlbutton2[Zaehler1].setBackground(Color.WHITE);
				
					break;
					
				case 3:
				
					Controlbutton1[Zaehler1].setBackground(Color.WHITE);
					Controlbutton2[Zaehler1].setBackground(Color.WHITE);
					Controlbutton3[Zaehler1].setBackground(Color.WHITE);
		
					break;
					
				case 4: 
					
					Controlbutton1[Zaehler1].setBackground(Color.WHITE);
					Controlbutton2[Zaehler1].setBackground(Color.WHITE);
					Controlbutton3[Zaehler1].setBackground(Color.WHITE);
					Controlbutton4[Zaehler1].setBackground(Color.WHITE);
				
					break;
					
				case 5: 
					
					Controlbutton1[Zaehler1].setBackground(Color.WHITE);
					Controlbutton2[Zaehler1].setBackground(Color.WHITE);
					Controlbutton3[Zaehler1].setBackground(Color.WHITE);
					Controlbutton4[Zaehler1].setBackground(Color.WHITE);
					Controlbutton5[Zaehler1].setBackground(Color.WHITE);
				
					break;
					
					
				case 6: 
					
					Controlbutton1[Zaehler1].setBackground(Color.WHITE);
					Controlbutton2[Zaehler1].setBackground(Color.WHITE);
					Controlbutton3[Zaehler1].setBackground(Color.WHITE);
					Controlbutton4[Zaehler1].setBackground(Color.WHITE);
					Controlbutton5[Zaehler1].setBackground(Color.WHITE);
					Controlbutton6[Zaehler1].setBackground(Color.WHITE);
				
					break;	
				
				default: 
					
				break;
				
				}
				
				
				
				
				switch (schwarz)
				{
				case 1: 
					
					Controlbutton1[Zaehler1].setBackground(Color.BLACK);
					break;
					
				case 2: 
					
					Controlbutton1[Zaehler1].setBackground(Color.BLACK);
					Controlbutton2[Zaehler1].setBackground(Color.BLACK);
				
					break;
					
				case 3:
				
					Controlbutton1[Zaehler1].setBackground(Color.BLACK);
					Controlbutton2[Zaehler1].setBackground(Color.BLACK);
					Controlbutton3[Zaehler1].setBackground(Color.BLACK);
		
					break;
					
				case 4: 
					
					Controlbutton1[Zaehler1].setBackground(Color.BLACK);
					Controlbutton2[Zaehler1].setBackground(Color.BLACK);
					Controlbutton3[Zaehler1].setBackground(Color.BLACK);
					Controlbutton4[Zaehler1].setBackground(Color.BLACK);
					
					
					break;
					
					
				case 5: 
					
					Controlbutton1[Zaehler1].setBackground(Color.BLACK);
					Controlbutton2[Zaehler1].setBackground(Color.BLACK);
					Controlbutton3[Zaehler1].setBackground(Color.BLACK);
					Controlbutton4[Zaehler1].setBackground(Color.BLACK);
					Controlbutton5[Zaehler1].setBackground(Color.BLACK);
					
					
					break;
					
				case 6: 
					
					Controlbutton1[Zaehler1].setBackground(Color.BLACK);
					Controlbutton2[Zaehler1].setBackground(Color.BLACK);
					Controlbutton3[Zaehler1].setBackground(Color.BLACK);
					Controlbutton4[Zaehler1].setBackground(Color.BLACK);
					Controlbutton5[Zaehler1].setBackground(Color.BLACK);
					Controlbutton6[Zaehler1].setBackground(Color.BLACK);
					
					Gewinnlabel.setVisible(true);
					buttons4[0].setVisible(true);
					buttons4[1].setVisible(true);
					buttons4[2].setVisible(true);
					buttons4[3].setVisible(true);
					buttons4[4].setVisible(true);
					buttons4[5].setVisible(true);
					
					break;
				
				default: 
					
					break;
				}
		
				//////
			
				
				
			 if (schwarz!=6 && Zaehler1==Buttons2-1)
			 	{
				 
				 Verlorenlabel.setVisible(true);
				 buttons4[0].setVisible(true);
				 buttons4[1].setVisible(true);
				 buttons4[2].setVisible(true);
				 buttons4[3].setVisible(true);
				 buttons4[4].setVisible(true);
				 buttons4[5].setVisible(true);
				}	
				
				
			else if (schwarz!=6)
				{
				Zaehler1++;
				
				buttons1[0+Zaehler1][0].setEnabled(true);
				buttons1[0+Zaehler1][1].setEnabled(true);
				buttons1[0+Zaehler1][2].setEnabled(true);
				buttons1[0+Zaehler1][3].setEnabled(true);
				buttons1[0+Zaehler1][4].setEnabled(true);
				buttons1[0+Zaehler1][5].setEnabled(true);
				
				buttons1[0+Zaehler1][0].setBackground(c1);
				buttons1[0+Zaehler1][1].setBackground(c2);
				buttons1[0+Zaehler1][2].setBackground(c3);
				buttons1[0+Zaehler1][3].setBackground(c4);
				buttons1[0+Zaehler1][4].setBackground(c5);
				buttons1[0+Zaehler1][5].setBackground(c6);
				
				buttons1[0+Zaehler1][0].setOpaque(true);
				buttons1[0+Zaehler1][0].setBorderPainted(false);
				buttons1[0+Zaehler1][1].setOpaque(true);
				buttons1[0+Zaehler1][1].setBorderPainted(false);
				buttons1[0+Zaehler1][2].setOpaque(true);
				buttons1[0+Zaehler1][2].setBorderPainted(false);
				buttons1[0+Zaehler1][3].setOpaque(true);
				buttons1[0+Zaehler1][3].setBorderPainted(false);
				buttons1[0+Zaehler1][4].setOpaque(true);
				buttons1[0+Zaehler1][4].setBorderPainted(false);
				buttons1[0+Zaehler1][5].setOpaque(true);
				buttons1[0+Zaehler1][5].setBorderPainted(false);
				}
			 
			else if (schwarz==6)
			{
				
			}
				
			}
			
			
			}
		
			
			
			//Color c= ((JButton)e1.getSource()).getBackground();
			
		});
	
		
		
	
		
		
		// Ende Kontrollbutton
		
		//Anfang Zurückbutton
		
		JButton Zurueckbutton = new JButton("Zurück");
		Zurueckbutton.setBounds(700, 100, 60, 40);
		contentPane.add(Zurueckbutton);
		Zurueckbutton.setOpaque(true);
		Zurueckbutton.setBorderPainted(true);
		Zurueckbutton.setBackground(Color.WHITE);
		Zurueckbutton.setForeground(Color.BLACK);
		
		Zurueckbutton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e6)
			{
				{
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								GUI_Levelauswahl frame = new GUI_Levelauswahl();
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});

				}
			}
			
		});
		
		
		//Ende Zurückbutton
		
		
		
	}
}
