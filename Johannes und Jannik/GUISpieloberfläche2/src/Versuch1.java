//package Try1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
	

public class Versuch1 extends JFrame {
	
	static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	static Color[] colors = { Color.red, Color.blue, Color.green, Color.yellow };
	/**
	 * @wbp.nonvisual location=430,8
	 */
	private final JPanel panel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Versuch1 frame = new Versuch1();
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
	public Versuch1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Mastermind");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 21));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		int numButtons = 4;
		JButton[] buttons = new JButton[numButtons];
		for(int i=0; i<numButtons; ++i)
		{
			JButton b = new JButton(""+i);
			final int pos = i;
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println(""+pos);
					((JButton)e.getSource()).setBackground(Color.BLUE);
				}
				
			});
			contentPane.add(b);
			b.setBackground(colors[i]);
			b.setBounds(10+i*50, 10, 50, 50);
			buttons[i] = b;
		}
	}

}
