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

public class Frame_2 extends JFrame {

	private JPanel contentPane;
	static final long serialVersionUID = 1L;
	static Color[] colors = { Color.green, Color.red, Color.blue, Color.yellow, Color.orange};
	
	private int Buttons2=6; // 6 Zeilen
	private int Buttons1= 4; // 4 Spalten
	private JButton[][] buttons1= new JButton[Buttons2] [Buttons1]; // Array für die Eingabefelder
	private int I2; // Durchzählen der Zeilen
	private int I1; // Durchzählen der Spalten
	
	
	private int Buttons3=6;
	private JButton [] Controlbutton1= new JButton[Buttons3]; 
	private JButton [] Controlbutton2= new JButton[Buttons3]; 
	private JButton [] Controlbutton3= new JButton[Buttons3]; 
	private JButton [] Controlbutton4= new JButton[Buttons3]; 
	
	
	private int numButtons4 = 4; //4Farben
	private  JButton[] buttons4 = new JButton[numButtons4]; // Array Zielergebnis der Farbmöglichkeiten
	
	private int numButtons5 = 5; // 5Farben
	private JButton[] buttons5 = new JButton[numButtons5]; // Array Farbmöglichkeiten unten
	
	private int Zaehler1;
	
	
	
	
	
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_2 frame = new Frame_2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param p2 
	 */
	public Frame_2() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 400, 1800, 1200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Mastermind");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 21));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		
		
		
		
		
		
		
		
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
							
							else if (c.getRGB()==Color.orange.getRGB())
								
							{
								((JButton)e1.getSource()).setBackground(colors[0]);
							}
							
						}
						
					});
			contentPane.add(b1);
		//	b1.setBorderPainted(false);
		//	b1.setOpaque(true);
			b1.setBackground(Color.orange);
			b1.setBounds(30+i1*70, 500-i2*70, 35, 30);
			buttons1[i2][i1] = b1;
			
			if (i2 > 0)
				{
				buttons1[i2][i1].setEnabled(false);
				}
	
			}
		}
		
		
		// Ende direkte Spieleingabe
		
		
		
		
		
		
		// Beginn der Überprüfung der Eingabe
		
		for( int i3=0; i3<Buttons3; ++i3)
			
		{
			JButton btnNewButton = new JButton("");
			JButton btnNewButton_1 = new JButton("");
			JButton btnNewButton_2 = new JButton("");
			JButton btnNewButton_3 = new JButton("");
		
		//btnNewButton.setOpaque(true);
		//btnNewButton.setBorderPainted(false);
		//btnNewButton.setBackground(Color.BLUE);	
		Controlbutton1[i3]= btnNewButton;
		Controlbutton1[i3].setBounds(350, 500-i3*70, 15, 15);
		contentPane.add(Controlbutton1[i3]);
		
		
	
		
		
		btnNewButton_1.setBounds(370, 500-i3*70, 15, 15);
		//btnNewButton_1.setOpaque(true);
		//btnNewButton_1.setBorderPainted(false);
		//btnNewButton_1.setBackground(Color.BLUE);
		Controlbutton2[i3]= btnNewButton_1;
		contentPane.add(Controlbutton2[i3]);
		
		btnNewButton_2.setBounds(350, 520-i3*70, 15, 15);
		//btnNewButton_2.setOpaque(true);
		//btnNewButton_2.setBorderPainted(false);
		//btnNewButton_2.setBackground(Color.BLUE);
		Controlbutton3[i3]= btnNewButton_2;
		contentPane.add(Controlbutton3[i3]);
	
		btnNewButton_3.setBounds(370, 520-i3*70, 15, 15);
		//btnNewButton_3.setOpaque(true);
		//btnNewButton_3.setBorderPainted(false);
		//btnNewButton_3.setBackground(Color.BLUE);
		Controlbutton4[i3]= btnNewButton_3;
		contentPane.add(Controlbutton4[i3]); 
		
		}
		
		
		
		// Ende der Überprüfung der Eingabe
		
		
	
		
		
		
		
		
		// Beginn der korrekten Farbkombination oben
		
		
		for(int i4=0; i4<numButtons4; ++i4)
		{
			JButton b4 = new JButton(""+i4);
			//final int pos4 = i4;
			b4.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e4)
				{
					//System.out.println(""+pos4);
					((JButton)e4.getSource()).setBackground(Color.BLUE);
				}
				
			});
			contentPane.add(b4);
			b4.setOpaque(true);
			b4.setBackground(colors[i4]);
			b4.setBounds(10+i4*50, 10, 50, 50);
			buttons4[i4] = b4;
			
			buttons4[i4].setEnabled(false);
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
		Kontrollbutton.setBounds(300, 600, 60, 40);
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
				
				
				
				
				Zaehler1++;
				buttons1[0+Zaehler1][0].setEnabled(true);
				buttons1[0+Zaehler1][1].setEnabled(true);
				buttons1[0+Zaehler1][2].setEnabled(true);
				buttons1[0+Zaehler1][3].setEnabled(true);
				}
			
			
			//Color c= ((JButton)e1.getSource()).getBackground();
			
		});
	
		
		
	
		
		
		// Ende Kontrollbutton
		
		
		
		
		
		
		
		
	}
}
