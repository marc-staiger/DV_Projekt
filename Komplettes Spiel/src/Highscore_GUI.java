
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.io.IOException;

@SuppressWarnings("serial")
public class Highscore_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtTheMastermindedPlayers;
	private JTextField txtZ;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void Ausführen() throws IOException  {
		
					Highscore_GUI frame = new Highscore_GUI();
					frame.setVisible(true);
				
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public Highscore_GUI() throws IOException {
		Highscore HIGH = new Highscore();
		HIGH.SortiereHighscore();
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setBounds(100, 100, 582, 470);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtTheMastermindedPlayers = new JTextField();
		txtTheMastermindedPlayers.setEditable(false);
		txtTheMastermindedPlayers.setFont(new Font("MV Boli", Font.PLAIN, 29));
		txtTheMastermindedPlayers.setHorizontalAlignment(SwingConstants.CENTER);
		txtTheMastermindedPlayers.setText("The Masterminded Players");
		txtTheMastermindedPlayers.setBounds(10, 11, 548, 82);
		contentPane.add(txtTheMastermindedPlayers);
		txtTheMastermindedPlayers.setColumns(10);
		
		txtZ = new JTextField();
		txtZ.setEditable(false);
		txtZ.setText("1. ... "+HIGH.Scores.get(0).getPunktzahl()+"..."+HIGH.Scores.get(0).getName());
		txtZ.setBounds(10, 116, 548, 20);
		contentPane.add(txtZ);
		txtZ.setColumns(10);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setText("2. ... "+HIGH.Scores.get(1).getPunktzahl()+"..."+HIGH.Scores.get(1).getName());
		textField.setColumns(10);
		textField.setBounds(10, 147, 548, 20);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setText("3. ... "+HIGH.Scores.get(2).getPunktzahl()+"..."+HIGH.Scores.get(2).getName());
		textField_1.setColumns(10);
		textField_1.setBounds(10, 178, 548, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setText("4. ... "+HIGH.Scores.get(3).getPunktzahl()+"..."+HIGH.Scores.get(3).getName());
		textField_2.setColumns(10);
		textField_2.setBounds(10, 209, 548, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setText("5. ... "+HIGH.Scores.get(4).getPunktzahl()+"..."+HIGH.Scores.get(4).getName());
		textField_3.setColumns(10);
		textField_3.setBounds(10, 240, 548, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setText("6. ... "+HIGH.Scores.get(5).getPunktzahl()+"..."+HIGH.Scores.get(5).getName());
		textField_4.setColumns(10);
		textField_4.setBounds(10, 271, 548, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setText("7. ... "+HIGH.Scores.get(6).getPunktzahl()+"..."+HIGH.Scores.get(6).getName());
		textField_5.setColumns(10);
		textField_5.setBounds(10, 302, 548, 20);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setText("8. ... "+HIGH.Scores.get(7).getPunktzahl()+"..."+HIGH.Scores.get(7).getName());
		textField_6.setColumns(10);
		textField_6.setBounds(10, 333, 548, 20);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setText("9. ... "+HIGH.Scores.get(8).getPunktzahl()+"..."+HIGH.Scores.get(8).getName());
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(10, 364, 548, 20);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setText("10. ... "+HIGH.Scores.get(9).getPunktzahl()+"..."+HIGH.Scores.get(9).getName());
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(10, 395, 548, 20);
		contentPane.add(textField_8);
	}

}
