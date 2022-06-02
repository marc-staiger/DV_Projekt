package evb;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class erg {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		String s = "löasjjfjj 94057";
//   	Pattern p = Pattern.compile("[+-]?[0-9]+");
//   	Matcher m = p.matcher(s);
//   	while ( m.find() ) {
//    	    System.out.println(s.substring(m.start(), m.end()));
//   	}    	
//   	    String firstname1 = "löasjjfjj 94057";
//        firstname1 = firstname1.replaceAll("[0-9]","");
//       
//        System.out.println(firstname1);
		
//
//		String s =  "waowiroiuuauhreoiug 093w8878775";
//	   	Pattern p = Pattern.compile("[+-]?[0-9]+");
//	   	Matcher m = p.matcher(s);
//	   	while ( m.find() ) {
//	    	   System.out.print(s.substring(m.start(), m.end()));
//	   	}    	
//	
//	    String firstname1 = "waowiroiuuauhreoiug 093w8878775";
//        firstname1 = firstname1.replaceAll("[0-9]","");
//       
//        System.out.println(firstname1);
//       String eriuh ="087";
//       int uwdgfz =Integer.parseInt(eriuh);
//       
//       System.out.println(uwdgfz);
		
		try {
			AusgabeClient.VerbindeMitServer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			AusgabeClient.ÜbergabeServer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		int PKTE = 0 ;
		
		for (int i = 0; i < 9; i++) {
			
			String s =  AusgabeClient.ReadHighscore().get(i);
		   	Pattern p = Pattern.compile("[+-]?[0-9]+");
		   	Matcher m = p.matcher(s);
		   	while ( m.find() ) {
		    	     PKTE=Integer.parseInt(s.substring(m.start(), m.end()));
		   	}    	
		
		    String firstname1 = AusgabeClient.ReadHighscore().get(i);
	        firstname1 = firstname1.replaceAll("[0-9]","");
	       
	          String Name=firstname1;
	    	    
	    	    HighscoreEntry Neu = new HighscoreEntry(PKTE,Name);
	    	    Scores.add(Neu);
		}
	SortiereHighscore();
	}}
		
	
