
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

@SuppressWarnings("serial")
public class Neuer_Highscore extends JFrame {
    private  static double erreichtePunkte;
	private JPanel contentPane;
	private JTextField txtNewHighscore;
	private JTextField txtName;
	private JTextField txtSieHabenX;

	/**
	 * Launch the application.
	 */
	public void Ausführen(double PKT ){
		  erreichtePunkte=PKT;
		Highscore HIGH = new Highscore();
		  if(HIGH.Scores.get(10).getPunktzahl()<PKT) {
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
	 */
	public Neuer_Highscore() {
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
				Punktzahl e1 = new Punktzahl(erreichtePunkte, txtName.getText());
				HIGH.setNewHighScore(e1);
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
