
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Button;
import java.awt.FlowLayout;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.Label;
import javax.swing.JTextArea;
import java.awt.TextField;
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class Spielbrett extends JFrame {

	private JPanel contentPane;
	private JTextField txtNewMastermifnd;

	/**
	 * Launch the application.
	 * @param i 
	 */
	public  void Ausführen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Spielbrett frame = new Spielbrett();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Spielbrett() {
		setResizable(false);
		setTitle("Mastermind The Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1035, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.setBackground(Color.YELLOW);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnNewButton.setForeground(Color.MAGENTA);
		btnNewButton.setFont(new Font("MV Boli", Font.PLAIN, 40));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GUI_Levelauswahl.Ausführen();
				dispose();
			}
		});
		btnNewButton.setBounds(345, 174, 353, 89);
		contentPane.add(btnNewButton);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Help Hilfe = new Help();
				Hilfe.Ausführen();
			}
		});
		btnHelp.setBackground(Color.PINK);
		btnHelp.setForeground(Color.MAGENTA);
		btnHelp.setFont(new Font("MV Boli", Font.PLAIN, 40));
		btnHelp.setBounds(10, 351, 353, 89);
		contentPane.add(btnHelp);
		
		JButton btnHighscore = new JButton("Highscore");
		btnHighscore.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Highscore_GUI.Ausführen();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnHighscore.setBackground(Color.PINK);
		btnHighscore.setForeground(Color.MAGENTA);
		btnHighscore.setFont(new Font("MV Boli", Font.PLAIN, 40));
		btnHighscore.setBounds(658, 351, 353, 89);
		contentPane.add(btnHighscore);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(985, 0, -1009, 107);
		contentPane.add(textArea);
		
		txtNewMastermifnd = new JTextField();
		txtNewMastermifnd.setForeground(Color.MAGENTA);
		txtNewMastermifnd.setText("Mastermind");
		txtNewMastermifnd.setHorizontalAlignment(SwingConstants.CENTER);
		txtNewMastermifnd.setFont(new Font("MV Boli", Font.PLAIN, 43));
		txtNewMastermifnd.setEditable(false);
		txtNewMastermifnd.setColumns(10);
		txtNewMastermifnd.setBounds(257, 23, 524, 96);
		contentPane.add(txtNewMastermifnd);
	}
}
