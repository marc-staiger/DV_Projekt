/**
 * 
 */

/**
 * @author krome
 *
 */

	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.PrintWriter;
	import java.util.Scanner;

	public class DatenSpeichern
	{

		
		
		
			
		try {
			
		
		File Auslesen= new File("C://Users//krome//Desktop//12.txt");
		Scanner Nr1;
		
		Nr1 = new Scanner(Auslesen);
		
		
		
		
		while (Nr1.hasNextLine()) 
		{ System.out.println(Nr1.nextLine());}
		
		
		}
		
		catch (FileNotFoundException e)
		{
			
		e.printStackTrace();
		
		
		
		
		
		
		}
		
		
		try {
		File Nr2 = new File (System.getProperty("java.io.tmpdir")+"C://Users//krome//Desktop//12.txt");
		Nr2.createNewFile();
		
		
		
		PrintWriter eins = new PrintWriter(new FileWriter(Nr2));
		 
		eins.println("2324");
		eins.flush();
		eins.close();
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		}
		


		
}
