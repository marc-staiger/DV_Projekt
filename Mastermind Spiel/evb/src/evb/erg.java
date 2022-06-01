package evb;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class erg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "löasjjfjj 94057";
    	Pattern p = Pattern.compile("[+-]?[0-9]+");
    	Matcher m = p.matcher(s);

    	while ( m.find() ) {
    	    System.out.println(s.substring(m.start(), m.end()));
    	}
    	String firstname1 = "S1234am";
        firstname1 = firstname1.replaceAll("[0-9]","");
        System.out.println(firstname1);
	}}
		
	
