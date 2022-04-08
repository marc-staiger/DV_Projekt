import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.JTextField;
import javax.swing.DropMode;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;


@SuppressWarnings("serial")
public class GUIHighscore extends JFrame{
	private JLabel labelOperand1;
	
    private Highscore hiscore =new Highscore();
	private JFrame frame;
	private JTextField txtTheMastermindedPlayers;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JButton btnAddName;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	

	

	
       public GUIHighscore() {
		setTitle("Highscore");
	    setVisible(true);
		frame = new JFrame();
		frame.setBounds(100, 100, 582, 528);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtTheMastermindedPlayers = new JTextField();
		txtTheMastermindedPlayers.setBounds(6, 11, 561, 49);
		txtTheMastermindedPlayers.setFont(new Font("Tahoma", Font.BOLD, 35));
		txtTheMastermindedPlayers.setText("The Masterminded players");
		txtTheMastermindedPlayers.setDropMode(DropMode.INSERT_ROWS);
		frame.getContentPane().add(txtTheMastermindedPlayers);
		txtTheMastermindedPlayers.setColumns(10);
		initComponents();
		
       }
private void initComponents() {
	
	

	textField = new JTextField();
	textField.setBounds(10, 90, 557, 20);
	textField.setText("1. ... "+Highscore.Scores.get(0).getPunktzahl()+"..."+Highscore.Scores.get(0).getName());
	frame.getContentPane().add(textField);
	textField.setColumns(10);
	
	textField_1 = new JTextField();
	textField_1.setBounds(10, 116, 557, 20);
	textField_1.setText("2. ... "+Highscore.Scores.get(1).getPunktzahl()+"..."+Highscore.Scores.get(1).getName());
	textField_1.setColumns(10);
	frame.getContentPane().add(textField_1);
	
	textField_2 = new JTextField();
	textField_2.setBounds(10, 142, 557, 20);
	textField_2.setText("3. ... "+Highscore.Scores.get(2).getPunktzahl()+"..."+Highscore.Scores.get(2).getName());
	textField_2.setColumns(10);
	frame.getContentPane().add(textField_2);
	
	textField_3 = new JTextField();
	textField_3.setBounds(10, 173, 557, 20);
	textField_3.setText("4. ... "+Highscore.Scores.get(3).getPunktzahl()+"..."+Highscore.Scores.get(3).getName());
	textField_3.setColumns(10);
	frame.getContentPane().add(textField_3);
	
	textField_4 = new JTextField();
	textField_4.setBounds(10, 204, 557, 20);
	textField_4.setText("5. ... "+Highscore.Scores.get(4).getPunktzahl()+"..."+Highscore.Scores.get(4).getName());
	textField_4.setColumns(10);
	frame.getContentPane().add(textField_4);
	
	textField_5 = new JTextField();
	textField_5.setText("6. ... "+Highscore.Scores.get(5).getPunktzahl()+"..."+Highscore.Scores.get(5).getName());
	textField_5.setColumns(10);
	textField_5.setBounds(10, 235, 557, 20);
	frame.getContentPane().add(textField_5);
	
	textField_6 = new JTextField();
	textField_6.setText("7. ... "+Highscore.Scores.get(6).getPunktzahl()+"..."+Highscore.Scores.get(6).getName());
	textField_6.setColumns(10);
	textField_6.setBounds(10, 266, 557, 20);
	frame.getContentPane().add(textField_6);
	
	textField_7 = new JTextField();
	textField_7.setText("8. ... "+Highscore.Scores.get(7).getPunktzahl()+"..."+Highscore.Scores.get(7).getName());
	textField_7.setColumns(10);
	textField_7.setBounds(10, 297, 557, 20);
	frame.getContentPane().add(textField_7);
	
	textField_8 = new JTextField();
	textField_8.setText("9. ... "+Highscore.Scores.get(8).getPunktzahl()+"..."+Highscore.Scores.get(8).getName());
	textField_8.setColumns(10);
	textField_8.setBounds(10, 328, 557, 20);
	frame.getContentPane().add(textField_8);
	
	textField_9 = new JTextField();
	textField_9.setText("10. ... "+Highscore.Scores.get(9).getPunktzahl()+"..."+Highscore.Scores.get(9).getName());
	textField_9.setColumns(10);
	textField_9.setBounds(10, 359, 557, 20);
	frame.getContentPane().add(textField_9);
	
	JButton btnNewButton = new JButton("refresh");
	buttonGroup.add(btnNewButton);
	btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 36));
	btnNewButton.setBounds(6, 408, 192, 72);
	frame.getContentPane().add(btnNewButton);
	
	btnAddName = new JButton("add ");
	btnAddName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 36));
	btnAddName.setBounds(366, 408, 192, 72);
	frame.getContentPane().add(btnAddName);

}
	
	
}

