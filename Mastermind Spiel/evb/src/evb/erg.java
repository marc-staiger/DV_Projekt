package evb;

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
		

		String s =  "waowiroiuuauhreoiug 093w8878775";
	   	Pattern p = Pattern.compile("[+-]?[0-9]+");
	   	Matcher m = p.matcher(s);
	   	while ( m.find() ) {
	    	   System.out.print(s.substring(m.start(), m.end()));
	   	}    	
	
	    String firstname1 = "waowiroiuuauhreoiug 093w8878775";
        firstname1 = firstname1.replaceAll("[0-9]","");
       
        System.out.println(firstname1);
       String eriuh ="087";
       int uwdgfz =Integer.parseInt(eriuh);
       
       System.out.println(uwdgfz);
	}}
		
	
