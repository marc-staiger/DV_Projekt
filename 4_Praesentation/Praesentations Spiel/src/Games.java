import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class Games extends JFrame {

	/**
	 * Launch the application.
	 */
	public void Ausführen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Games frame = new Games();
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
	public Games() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(300, 40, 800, 700);
	}
}
