import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class AusgabeClient {

	
public Scanner in;
public PrintWriter out;
    
//-----------------------------------------------------------------------------------------------------------------------    
    
    
    //public static void main(String[] args) throws IOException
    
    //{
    	
    //AusgabeClient client= new AusgabeClient();
   	//client.sendMessage();
    	        	
   // }
    
public static void VerbindeMitServer() throws IOException {
	
	 System.out.println("Client main start");
	 
	AusgabeClient client= new AusgabeClient();
	
	System.out.println("Client 1");
	
   	client.sendMessage();
	
   	System.out.println("Client main fertig");
}

       
  //-----------------------------------------------------------------------------------------------------------------------   
    		
    	public void sendMessage() throws IOException {
    		 
    	Socket clientSocket = new Socket("192.168.178.106", 6666);
    	 
    	
    	System.out.println("Client 2");
    	  
    	PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(clientSocket.getInputStream())));
        
        
        
//Einlesen vom Server und abspeichern in Array  
//-----------------------------------------------------------------------------------------------------------------------   
        System.out.println("Client Einslesen");
        
    	
		ArrayList<String> HighscoreUnsortiert;
		HighscoreUnsortiert = new ArrayList<String>(10);
				
		int i=0;
		
		System.out.println("Client Einslesen 2");
		
		while(i <=9)
		{
			
		HighscoreUnsortiert.add(in.nextLine());
		
		i++;		
		
		}
			
		System.out.println("Einlesen vom Server/Senden an Sortierung "+HighscoreUnsortiert);
		System.out.println("Server 7");
		
//Synchronisieren
//-----------------------------------------------------------------------------------------------------------------------   
		System.out.println("Start Sync Client");
		out.println("SYNC");
		
		while(in.nextLine()=="SYNC")
		{
		System.out.println("Synchro"+i);
		i++;	
		}	
		System.out.println("Sync Client erfolgreich"); 
		
//Übergabe an Server		
//-----------------------------------------------------------------------------------------------------------------------               
        
    	ArrayList<String> SortierterHighscore;
    	SortierterHighscore  = new ArrayList<String>(10);	
    	
    	
    	System.out.println("Einlesen vom Sortierung"+Sortierung_Test.ArrayAusgabe());
    	SortierterHighscore  = Sortierung_Test.ArrayAusgabe();

    	System.out.println("Sortierung Nr5"+SortierterHighscore.get(5));
    	System.out.println("Sortierung Nr5"+SortierterHighscore.get(2));	
    	
    	
    	System.out.println("Client 3");
    	
    	

    
    	int k = 0;
		while(k <=9)
		{
        out.println(SortierterHighscore.get(k));	
        k++;	
        out.flush();
		}
		
		System.out.println("Client 4");            

     
        System.out.println("Client SM fertig");
        
    	}  	 
        
}  
    
     