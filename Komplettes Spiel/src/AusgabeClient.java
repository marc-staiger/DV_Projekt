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
public static  Socket clientSocket;
    
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
    		 
    clientSocket = new Socket("localhost", 6666);
    
   	 
    	
    System.out.println("Client 2");
    	  
    out = new PrintWriter(clientSocket.getOutputStream(), true);
    in = new Scanner(new BufferedReader(new InputStreamReader(clientSocket.getInputStream())));
        
    }        
        
    	
    	
//Einlesen vom Server und abspeichern in Array  
//-----------------------------------------------------------------------------------------------------------------------   
public static String ArrayzumSortieren() throws IOException
{
	
       String S= in.nextLine();
        
       
		
		return S;
		

        
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


    	
		
        
    	
public static void Save(ArrayList<HighscoreEntry> SortierterHighscore) throws IOException
{		    	
  		
//Übergabe an Server		
//-----------------------------------------------------------------------------------------------------------------------               
        
    	
	
    	
	ArrayList<String> Back_value;
	Back_value = new ArrayList<String>(10);
 	
    for (int i =0; i< 10;i++) {
		
		String s =Integer.toString(SortierterHighscore.get(i).getPunktzahl())+SortierterHighscore.get(i).getName();
		Back_value.add(s);
	
		
		
	}


       

    
    int k = 0;
	while(k <=9)
	{
    out.println(Back_value.get(k));	
    k++;	
    out.flush();
	}
	
	
 
    System.out.println("Client SM fertig");
   
	
	
    
	}  	 
   
		
        
    	





public static void Save_Standart(ArrayList<String> SortierterHighscore) throws IOException
{		    	
  		
//Übergabe an Server		
//-----------------------------------------------------------------------------------------------------------------------               
        
    	
	
    	
	


       
  	
    
    	int k = 0;
		while(k <=9)
		{
        out.println(SortierterHighscore.get(k));	
        k++;	
        out.flush();
		}
		
		
     
        System.out.println("Client SM fertig");
       
    	
		
        
    	}  	 
public static void Save_Standart1(ArrayList<String> SortierterHighscore) throws IOException
{		    	
  		
//Übergabe an Server		
//-----------------------------------------------------------------------------------------------------------------------               
        
    	
	
    	
	


       
  	
    
    	int k = 0;
		while(k <=9)
		{
			
        out.println(SortierterHighscore.get(k));	
        k++;	
        out.flush();
		}
		
		
     
        System.out.println("Client SM fertig");
       
    	
		
        
    	}  	 



public static void ClientStop() throws IOException
{

clientSocket.close();

}

}  
    
     
       

     