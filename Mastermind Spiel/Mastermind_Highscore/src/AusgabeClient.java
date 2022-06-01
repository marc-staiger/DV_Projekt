import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class AusgabeClient {

	
public static Scanner in;
public static PrintWriter out;
    
//-----------------------------------------------------------------------------------------------------------------------    
    

    
public static void VerbindeMitServer() throws IOException {
	
	System.out.println("Client main start");
	 
	AusgabeClient client= new AusgabeClient();
	
	System.out.println("Client 1");
	
   	client.sendMessage();
   	
   	//ArrayzumSortieren();	
	 	
	
   	System.out.println("Client main fertig");
}

       
  //-----------------------------------------------------------------------------------------------------------------------   
    		
    public void sendMessage() throws IOException {
    		 
    Socket clientSocket = new Socket("localhost", 6666);
    	 
    	
    System.out.println("Client 2");
    	  
    out = new PrintWriter(clientSocket.getOutputStream(), true);
    in = new Scanner(new BufferedReader(new InputStreamReader(clientSocket.getInputStream())));
        
    }        
        
    	
    	
//Einlesen vom Server und abspeichern in Array  
//-----------------------------------------------------------------------------------------------------------------------   
public static  ArrayList<String> ArrayzumSortieren()
{
	
        
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
		
		
		
		return HighscoreUnsortiert;
		
}


public static  ArrayList<String> ReadHighscore()
{
	
        
        System.out.println("Client Einslesen");
        
    	
		ArrayList<String> Highscore;
		Highscore = new ArrayList<String>(10);
	
				
		int i=0;
		
		System.out.println("Client Einslesen 2");
		
		
		
		while(i <=9)
		{
		
		Highscore.add(in.nextLine());
		
		i++;		
		
		}
			
		System.out.println("Einlesen vom Server/Senden an Sortierung "+Highscore);
		
		
		
		return Highscore;
		
}

public static void ÜbergabeServer() throws IOException
{		    	
  		
//Übergabe an Server		
//-----------------------------------------------------------------------------------------------------------------------               
        
    	ArrayList<String> SortierterHighscore;
    	SortierterHighscore  = new ArrayList<String>(10);	
    	
    	
    	//System.out.println("Einlesen vom Sortierung"+Sortierung_Test_2.ArrayAusgabe());
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
    
     
       

     