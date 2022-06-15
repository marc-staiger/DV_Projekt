import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Help extends JFrame {

	private JPanel contentPane;
	private JTextField txtHelp;

	/**
	 * Launch the application.
	 */
	public void Ausführen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Help frame = new Help();
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
	public Help() {
		setResizable(false);
		setTitle("Help");
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setBounds(100, 100, 535, 389);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JEditorPane dtrpnMastermindIstEin = new JEditorPane();
		dtrpnMastermindIstEin.setToolTipText("hzfhu");
		dtrpnMastermindIstEin.setForeground(Color.BLUE);
		dtrpnMastermindIstEin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		dtrpnMastermindIstEin.setEditable(false);
		dtrpnMastermindIstEin.setText("Mastermind ist ein Logikspiel bei dem eine 4-stellige Farbkombination (Farbe und Reihenfolge) mit 8 Versuchen erraten werden muss. Dabei stehen 6 verschiedene Farben zur Verf\u00FCgung. Nach jedem Versuch wird durch schwarze oder wei\u00DFe Pinns angezeigt, wie nah der Versuch an der L\u00F6sung ist. Schwarze Pinns stehen f\u00FCr eine richtig erratene Farbe am richtigen Platz, wei\u00DFe f\u00FCr eine vorhandene Farbe, die aber nicht an diesem Platz ist.");
		dtrpnMastermindIstEin.setBounds(10, 131, 501, 210);
		contentPane.add(dtrpnMastermindIstEin);
		
		txtHelp = new JTextField();
		txtHelp.setText("Help");
		txtHelp.setHorizontalAlignment(SwingConstants.CENTER);
		txtHelp.setForeground(Color.MAGENTA);
		txtHelp.setFont(new Font("MV Boli", Font.PLAIN, 43));
		txtHelp.setEditable(false);
		txtHelp.setColumns(10);
		txtHelp.setBounds(10, 11, 524, 96);
		contentPane.add(txtHelp);
	}
}
