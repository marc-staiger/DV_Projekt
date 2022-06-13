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




public class GUI_Levelauswahl extends JFrame
{
	private JPanel contentPane;
	static final long serialVersionUID = 1L;

	private int Buttons1;
	private int Buttons2;
	
	public static void main(String[] args) 
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



	public GUI_Levelauswahl()
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
		
		
		//Anfang Buttons Spiellevel
		
				JButton Level1 = new JButton("Level1");
				JButton Level2 = new JButton("Level2");
				JButton Level3 = new JButton("Level3");
				//JButton Zeitlevel = new JButton("Zeitlevel");
				
				
						Level1.setOpaque(true);
						Level1.setBorderPainted(false);
						Level1.setBackground(Color.GREEN);	
						Level1.setForeground(Color.BLACK);	
						Level1.setBounds(550, 150, 300, 150);
						Level1.setFont(new Font("Level1", 60, 30));
						contentPane.add(Level1);
						
						Level1.addActionListener(new ActionListener() 
						{
							public void actionPerformed(ActionEvent e1)
							{
								 Buttons1=4;
								 Buttons2=8;
								
								
								{
									EventQueue.invokeLater(new Runnable() {
										public void run() {
											try {
												Frame_2 frame = new Frame_2(Buttons1, Buttons2);
												frame.setVisible(true);
											} catch (Exception e) {
												e.printStackTrace();
											}
										}
									});
									
								}
								
							}
						});
						
						
						Level2.setOpaque(true);
						Level2.setBorderPainted(false);
						Level2.setBackground(Color.YELLOW);	
						Level2.setBounds(550, 350, 300, 150);
						Level2.setFont(new Font("Level2", 60, 30));
						contentPane.add(Level2);
						
						Level2.addActionListener(new ActionListener() 
						{
							public void actionPerformed(ActionEvent e1)
							{
								 Buttons1=5;
								 Buttons2=9;
								
								{
									EventQueue.invokeLater(new Runnable() {
										public void run() {
											try {
												Frame_2 frame = new Frame_2(Buttons1, Buttons2);
												frame.setVisible(true);
											} catch (Exception e) {
												e.printStackTrace();
											}
										}
									});
									
								}
							}
						});
						
						Level3.setOpaque(true);
						Level3.setBorderPainted(false);
						Level3.setBackground(Color.RED);	
						Level3.setBounds(550, 550, 300, 150);
						Level3.setFont(new Font("Level3", 60, 30));
						contentPane.add(Level3);
						
						Level3.addActionListener(new ActionListener() 
						{
							public void actionPerformed(ActionEvent e1)
							{
								Buttons1=6;
								Buttons2=10;
								
								{
									EventQueue.invokeLater(new Runnable() {
										public void run() {
											try {
												Frame_2 frame = new Frame_2(Buttons1, Buttons2);
												frame.setVisible(true);
											} catch (Exception e) {
												e.printStackTrace();
											}
										}
									});
									
								}
							}
						});
					/*	
						Zeitlevel.setOpaque(true);
						Zeitlevel.setBorderPainted(false);
					//	Zeitlevel.setBackground(Color.);	
						Zeitlevel.setBounds(950, 50, 100, 50);
						contentPane.add(Zeitlevel);
						
						Zeitlevel.addActionListener(new ActionListener() 
						{
							public void actionPerformed(ActionEvent e1)
							{
								Buttons1=4;
								Buttons2=8;
								
							}
						});*/
				
				Level1.setVisible(true);
				Level2.setVisible(true);
				Level3.setVisible(true);
				//Zeitlevel.setVisible(false);
				
				
				//Ende Buttons Spiellevel
		
	}
}

