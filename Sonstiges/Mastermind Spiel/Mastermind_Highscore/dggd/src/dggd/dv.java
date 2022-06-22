package dggd;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class dv {

	public static void main(String[] args) {
		int PKTE = 0;
		// TODO Auto-generated method stub
		for (int i = 0; i <=9; i++) {
			
			String s =  "Hugo .....67.....";
			String s1= s;
		   	Pattern p = Pattern.compile("[+-]?[0-9]+");
		   	Matcher m = p.matcher(s);
		   	while ( m.find() ) {
		    	     PKTE=Integer.parseInt(s.substring(m.start(), m.end()));
		   	}    	
		
		    String firstname1 = s1;
	        firstname1 = firstname1.replaceAll("[0-9]","").replaceAll("[.]","");
	       
	          String Name=firstname1;
	    	    
	    	 System.out.println(Name);
	    	 System.out.println(PKTE);
	    	    }
		

	}

}
