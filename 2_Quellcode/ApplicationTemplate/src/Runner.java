import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Runner
{
	static int count = 0;
	
	public static void main(String[] args)
	{
		//--- create main window ---//
        JFrame mainWindow = new JFrame("Our Application");
        mainWindow.addWindowListener(new WindowAdapter() { 
        	@Override
            public void windowClosing(WindowEvent e)
        	{
        		System.out.println("The window was closed. Exiting ...");
        		System.exit(0); 
        	}
        });
               
        //--- create a label, a text field, a fly button and a custom drawing canvas ---//
        JLabel label = new JLabel("Welcome! Launch the rocket as fast as possible by clicking \"Fly\"!");
        JTextField textField = new JTextField("Fly clicked: 0x");
        textField.setColumns(40);
        JButton buttonFly = new JButton("Fly");
        Canvas canvas = new Canvas();

        //--- update user interface when the fly button was clicked ---//
        buttonFly.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				System.out.println("The button \"Fly\" was clicked ...");
				textField.setText("Fly clicked: "+(++Runner.count)+"x");
				canvas.repaint();
			}
		});
        
        //--- add components to the main window ---//
        Container pane = mainWindow.getContentPane();
        pane.setLayout(new FlowLayout());
        pane.add(label);
        pane.add(textField);
        pane.add(buttonFly);
        pane.add(canvas);
        
        //--- set window position and size and show window ---//
        mainWindow.setBounds(50, 50, 550, 500);;
        mainWindow.setVisible(true);
	}
}