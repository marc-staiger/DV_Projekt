import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MainKlasse {

	
	public static void main(String[] args) throws IOException {
		
		System.out.println("Main START");
		Sortierung_Test.ArrayAusgabe();	
		AusgabeClient.VerbindeMitServer();
										       
		System.out.println("Main FERTIG");
	}
}



//Main Methode startet Client


//Server wird auf externen Pc über Anwendung gestartet


//Server : [ liest datei ]  ( schickt als array ) zu client

//Client : ( liest array ein ) und ( schickt array ) zum sortiren

//Ausgabe 

//Client : ( liest array ein ) und ( schickt array ) zum Server

//Server : ( liest array ein ) und [ speichert in datei ]
