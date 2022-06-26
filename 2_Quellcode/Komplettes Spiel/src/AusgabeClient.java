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
    

/**
 * Central method which controls the Client. 
 * @throws IOException
 */
public static void VerbindeMitServer() throws IOException {
	
	System.out.println("Client main start");
	 
	AusgabeClient client= new AusgabeClient();
	
	System.out.println("Client 1");
	
   	client.ConnectSocket();
   	
   	System.out.println("Client main fertig");
}

       
  //-----------------------------------------------------------------------------------------------------------------------   
    /**
     * Uses the IP-address and Port to connect client with the server. 
     * It also creates the Scanner "in" and the PrintWriter "out" to handle the input and output of the Client to send 
     * and receive data from the server. 		
     * @throws IOException
     */
    public void ConnectSocket() throws IOException {
    		 
    clientSocket = new Socket("localhost", 6666);
    
   	 
    	
    System.out.println("Client 2");
    	  
    out = new PrintWriter(clientSocket.getOutputStream(), true);
    in = new Scanner(new BufferedReader(new InputStreamReader(clientSocket.getInputStream())));
        
    }        
        
    	
    	
//Einlesen vom Server und abspeichern in Array  
//-----------------------------------------------------------------------------------------------------------------------   

    /**
     * This method reads the data which gets send by the server. It is used in the Highscore class with a loop to get all
     * lines of the txt file.
     * @return
     * @throws IOException
     */
    public static String ArrayzumSortieren() throws IOException
{
	
       String S= in.nextLine();
        
       
		
		return S;
		

        
}
//Übergabe an Server		
//-----------------------------------------------------------------------------------------------------------------------               
 
/**
 * Send the sorted Array List in single Strings to the server.
 * @param SortierterHighscore
 * @throws IOException
 */
public static void Save_Standart(ArrayList<String> SortierterHighscore) throws IOException
{		    	
  		
 
    
    	int k = 0;
		while(k <=9)
		{
        out.println(SortierterHighscore.get(k));	
        k++;	
        out.flush();
		}
		
		
     
        System.out.println("Client SM fertig");

        
    	}  	 

/**
 * Stops the connection by closing the socket.
 * @throws IOException
 */
public static void ClientStop() throws IOException
{

clientSocket.close();

}

}  
    
     
       

     