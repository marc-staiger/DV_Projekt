package lökdafljh;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class erafd extends JFrame {

	private JPanel HighscoreAnzeige;
	private JTextField txtEnterYourName;
	private JTextField txtPkt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					erafd frame = new erafd();
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
	public erafd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		HighscoreAnzeige = new JPanel();
		HighscoreAnzeige.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(HighscoreAnzeige);
		HighscoreAnzeige.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NEW HIGHSCORE !!!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 416, 61);
		HighscoreAnzeige.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(147, 210, 107, 42);
		HighscoreAnzeige.add(btnNewButton);
		
		txtEnterYourName = new JTextField();
		txtEnterYourName.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterYourName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEnterYourName.setText("enter your name");
		txtEnterYourName.setBounds(93, 99, 206, 72);
		HighscoreAnzeige.add(txtEnterYourName);
		txtEnterYourName.setColumns(10);
		
		txtPkt = new JTextField();
		txtPkt.setHorizontalAlignment(SwingConstants.CENTER);
		txtPkt.setText("9999999");
		txtPkt.setBounds(282, 207, 144, 54);
		HighscoreAnzeige.add(txtPkt);
		txtPkt.setColumns(10);
	}

}
