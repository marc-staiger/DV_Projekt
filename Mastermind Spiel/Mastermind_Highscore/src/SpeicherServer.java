import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;


//-----------------------------------------------------------------------------------------------------------------------   

public class SpeicherServer
{
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
   
    
    
  //-----------------------------------------------------------------------------------------------------------------------   
 
  public static void main(String[] args) throws IOException
    {
	
	SpeicherServer server=new SpeicherServer();
    
    System.out.println("Server START");
    
    server.VerbindeMitClient(6666);
        
    System.out.println("Server FERTIG");
    
    }

    
 //-----------------------------------------------------------------------------------------------------------------------   
  
    public void VerbindeMitClient(int port) throws IOException {
    	
    	System.out.println("Server 2");
    	
    	
    	
    	
    	ServerSocket serverSocket = new ServerSocket(port);
    	
    	System.out.println("Server 3");
    
    
    	
        Socket clientSocket = serverSocket.accept();
  		 
  		
        System.out.println("Server 4");
        
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(clientSocket.getInputStream())));
        
       
//Datei Lesen 
//----------------------------------------------------------------------------------------------------------------------
        try{
        	
        
		
        File Datei1= new File(System.getProperty("java.io.tmpdir")+"//Highscore_Speicher.txt");
       
       
        
        if (Datei1.createNewFile())
            {
        	System.out.println("Speicherdatei wurde angelegt");
            PrintWriter PrintWriterzwei = new PrintWriter(new FileWriter(Datei1));
			
    		
            PrintWriterzwei.println("0");
            PrintWriterzwei.println("0");
            PrintWriterzwei.println("0");
            PrintWriterzwei.println("0");
            PrintWriterzwei.println("0");
            PrintWriterzwei.println("0");
            PrintWriterzwei.println("0");
            PrintWriterzwei.println("0");
    		PrintWriterzwei.println("0");
    		PrintWriterzwei.println("0");
    		
    		PrintWriterzwei.flush();
    		PrintWriterzwei.close();
           
            
            }
            
            
        else
            System.out.println("Speicherdatei besteht bereits");
        
        
        
        Scanner ScannerNr1 = new Scanner(Datei1);
        					
        ArrayList<String> AusgabePunkte;
        AusgabePunkte = new ArrayList<String>(10);
        			
        while (ScannerNr1.hasNextLine()) 
        { 
        			
        AusgabePunkte.add(ScannerNr1.nextLine());
        			
        }
        			
        System.out.println("Eingelesen Array von Txt "+AusgabePunkte);
        
        int k = 0;
		while(k <=9)
		{
        out.println(AusgabePunkte.get(k));
				
		k++;	
		
		}
        out.flush();
        }
        				
        catch (FileNotFoundException e){
        e.printStackTrace();}
        			   
        

//Einlesen vom Client       
//-----------------------------------------------------------------------------------------------------------------------   			
    	System.out.println("Server 6");
    
	
		ArrayList<String> Highscore;
		Highscore = new ArrayList<String>(10);
		
		
	
		
		
		int i =0;
		while(i <=9)
		{
			
		Highscore.add(in.nextLine());
//		System.out.println(in.nextLine());
		i++;		
		
		}
	
		
		System.out.println("Test"+Highscore);	
		
		System.out.println("Server 7");
		
		
		
//Datei Schreiben in TXT Datei
//----------------------------------------------------------------------------------------------------------------------
		try 
		{
		
			
		System.out.println("Server 8");	
		File Datei2 = new File (System.getProperty("java.io.tmpdir")+"//Highscore_Speicher.txt");
		PrintWriter eins = new PrintWriter(new FileWriter(Datei2));
			
		
		eins.println(Highscore.get(0));
		eins.println(Highscore.get(1));
		eins.println(Highscore.get(2));
		eins.println(Highscore.get(3));
		eins.println(Highscore.get(4));
		eins.println(Highscore.get(5));
		eins.println(Highscore.get(6));
		eins.println(Highscore.get(7));
		eins.println(Highscore.get(8));
		eins.println(Highscore.get(9));
		
		
		System.out.println("Server 9");
				
		eins.flush();
		eins.close();
			
		
		}
		catch (IOException e) 
		{
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		
		System.out.println("Server 10");
			
		
		}		
		
	    
		public  void stop() throws IOException {
		        in.close();
		        out.close();
		        clientSocket.close();
		        serverSocket.close();
		    }
		}
