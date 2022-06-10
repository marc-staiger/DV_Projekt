
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Neuer_Highscore extends JFrame {
    private  static int erreichtePunkte;
    
	private JPanel contentPane;
	private JTextField txtNewHighscore;
	private JTextField txtName;
	private JTextField txtSieHabenX;

	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public void Ausführen(int PKT ) throws IOException{
		
		  erreichtePunkte=PKT;
		Highscore HIGH = new Highscore();
		  if(HIGH.Scores.get(9).getPunktzahl()<PKT) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Neuer_Highscore frame = new Neuer_Highscore();
				     
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});}
		  
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public Neuer_Highscore() throws IOException {
        setResizable(false);
		Highscore HIGH = new Highscore();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNewHighscore = new JTextField();
		txtNewHighscore.setEditable(false);
		txtNewHighscore.setFont(new Font("MV Boli", Font.PLAIN, 25));
		txtNewHighscore.setHorizontalAlignment(SwingConstants.CENTER);
		txtNewHighscore.setText("New Highscore");
		txtNewHighscore.setBounds(5, 5, 426, 47);
		contentPane.add(txtNewHighscore);
		txtNewHighscore.setColumns(10);
		
		JButton btnNewButton = new JButton("Best\u00E4tigen");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				HIGH.setNewHighScore(erreichtePunkte, txtName.getText());
				
				System.out.println(HIGH.getHighscore(9).getPunktzahl()+HIGH.getHighscore(9).getName());
				
				
		try {
			AusgabeClient.Save(HIGH.getHighscoreAll());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
				setVisible(false);
			}
		});
		btnNewButton.setBounds(145, 218, 149, 23);
		contentPane.add(btnNewButton);
		
		txtName = new JTextField();
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setText("Name");
		txtName.setBounds(110, 119, 213, 72);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtSieHabenX = new JTextField();
		txtSieHabenX.setEditable(false);
		txtSieHabenX.setText("Sie haben "+erreichtePunkte+" Punkte erreicht bitte tragen Sie ihren Namen ein");
		txtSieHabenX.setBounds(51, 63, 355, 45);
		contentPane.add(txtSieHabenX);
		txtSieHabenX.setColumns(10);
	}
	

	
	
}
