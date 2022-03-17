import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUI{
	
	//In der Klasse GUI erfolgt die Grafische Ein- und Ausgabe der Aktorik-Aufgabe

	public static void main(String[] args){
		
		//die Main-Methode wird aufgerufen
		
		//Berechnungs-Button wird angelegt
		//setBounds legt die Größe und Lage des Elements (z.B. Button, Textfeld) fest
		
		JButton button=new JButton("Berechnung");
		button.setBounds(100, 400, 150, 50);
		
		
		//Beschriftungen werden angelegt
		//setBounds legt die Größe und Lage des Elements (z.B. Button, Textfeld) fest
		
		JLabel winkel=new JLabel("Winkel [°]");
		winkel.setBounds(50, 25, 750, 20);
		JLabel dichte=new JLabel("Dichte [kg/mm²]");
		dichte.setBounds(50, 75, 750, 20);
		JLabel volumen=new JLabel("Volumen [mm²]");
		volumen.setBounds(50, 125, 750, 20);
		JLabel durchmesser=new JLabel("Scheibendurchmesser [m]");
		durchmesser.setBounds(50, 175, 750, 20);
		JLabel jm=new JLabel("J Motor [kg*m²]");
		jm.setBounds(50, 225, 750, 20);
		JLabel js=new JLabel("J Scheibe [kg*m²]");
		js.setBounds(50, 275, 750, 20);
		JLabel strecke=new JLabel("Strecke [m]");
		strecke.setBounds(50, 325, 750, 20);
		JLabel zeit=new JLabel("geforderte Zeit [s]");
		zeit.setBounds(50, 375, 750, 20);
		
		
		//Textfelder werden angelegt
		//setBounds legt die Größe und Lage des Elements (z.B. Button, Textfeld) fest
		
		JTextField tf_winkel=new JTextField();
		tf_winkel.setBounds(250, 25, 70, 20);
		JTextField tf_dichte=new JTextField();
		tf_dichte.setBounds(250, 75, 70, 20);
		JTextField tf_volumen=new JTextField();
		tf_volumen.setBounds(250, 125, 70, 20);
		JTextField tf_durchmesser=new JTextField();
		tf_durchmesser.setBounds(250, 175, 70, 20);
		JTextField tf_jm=new JTextField();
		tf_jm.setBounds(250, 225, 70, 20);
		JTextField tf_js=new JTextField();
		tf_js.setBounds(250, 275, 70, 20);
		JTextField tf_stecke=new JTextField();
		tf_stecke.setBounds(250, 325, 70, 20);
		JTextField tf_zeit=new JTextField();
		tf_zeit.setBounds(250, 375, 70, 20);
		JLabel leistung=new JLabel();
		leistung.setBounds(300, 400, 1000, 50);
		
		//Bild einfügen
		ImageIcon bild = new ImageIcon("Aufgabe.jpg");
		JLabel bild1=new JLabel(bild);
		bild1.setBounds(350, 30, 300, 200);		
		
		
		//Ein- und Ausgabefenster (Frame) wird erstellt mit Voreinstellungen
		
		JFrame jr=new JFrame("Motorenberechnung");
		jr.setSize(new Dimension(700,500));
		jr.setLayout(null);
		jr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jr.setTitle("Leistungsberechnung Motor");
		jr.setVisible(true);
		
		//Hinzufügen der Elemente (z.B. Button, Textfeld) zum Frame
		
		jr.add(winkel);
		jr.add(durchmesser);
		jr.add(jm);
		jr.add(js);
		jr.add(strecke);
		jr.add(zeit);
		jr.add(dichte);
		jr.add(volumen);
		jr.add(tf_winkel);
		jr.add(tf_dichte);
		jr.add(tf_volumen);
		jr.add(tf_durchmesser);
		jr.add(tf_jm);
		jr.add(tf_js);
		jr.add(tf_stecke);
		jr.add(tf_zeit);
		jr.add(button);
		jr.add(leistung);
		jr.add(bild1);
		
		
		//Action-Listener - Sobald der Button gedrückt wird, soll der Code
		//in der geschweiften Klammer ausgeführt werden
		
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				
				//Beginn Action-Listener
				
				// Auslesen der Textfelder und Speicherung in Variablen
				
				double w = Double.parseDouble(tf_winkel.getText());
				double di = Double.parseDouble(tf_dichte.getText());
				double v = Double.parseDouble(tf_volumen.getText());
				double d = Double.parseDouble(tf_durchmesser.getText());
				double jm = Double.parseDouble(tf_jm.getText());
				double js = Double.parseDouble(tf_js.getText());
				double s = Double.parseDouble(tf_stecke.getText());
				int t = Integer.parseInt(tf_zeit.getText());
				
				
				//Erstellen eines Objekts Names "eins"
				//und Übergabe der Textfelder in die Methode "foerderbandmotor"
				
				foerderbandmotor eins=new foerderbandmotor(di,v,w,d,jm,js,s,t);
				
				
				//Ausführen der Operation "leistungsberechnung"
				
				double power=eins.leistungsberechnung();
				
				
				//Fehlermitteilung (ja/nein) in "getFehler"
				
				boolean fehler=eins.getFehler();
				
				
				//bei Fehler --> "Fehlerhafte Eingabe!" anzeigen
				//bei keinem Fehler --> die Leistung anzeigen
				//Runden auf zwei Stellen nach dem Komma
				
				if (fehler==true) {
					leistung.setText("Fehlerhafte Eingabe!");
				}else {
					power = power * 100;
					power = (int) power;
					power = (double) power / 100;
					leistung.setText("Erforderliche Motorleistung: "+Double.toString(power)+" Watt");
				}
				
				//Frame aktualisieren
				
				jr.repaint();	
			}
		});
		}
	}

