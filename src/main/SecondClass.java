import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecondClass {

	int variable = 10;
	
	public void decrement() {
		variable--;
	}
	
	public static void main(String[] args){
		
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        String[] inputLines;
        Scanner scanner = new Scanner(System.in);
        int numberOfLines = scanner.nextInt();
        
        inputLines = new String[numberOfLines];
        
        scanner.nextLine();
        for(int i=0; i<numberOfLines; i++){
            inputLines[i] = scanner.nextLine();
        }
        scanner.close();
	    
//        StringBuilder html = new StringBuilder();
//	    
//        // bundle up in one big string
//        for(int i = 0; i<numberOfLines; i++){
//        	html.append(inputLines[i]);
//        }
        Pattern p = Pattern.compile("<a\\s*href=\"([^\"]*)\"[^>]*>(.*)</a>.*");
        for(int i=0; i<numberOfLines; i++){
	        Matcher m = p.matcher(inputLines[i]);
	        while(m.find()){
	        	System.out.println(m.group(1).trim()+","+m.group(2).trim());
	        }
        }
//        Pattern pattern = Pattern.compile(".*href=\"([^\"]*)\"[^>]*>(.*)</a>.*");
//        Matcher matcher;
//        
//        String[] tokens = html.toString().split("<a ");
//        String[] strippedLinks = new String[tokens.length-1];
//        for(int i=1; i<tokens.length; i++){
//	        matcher = pattern.matcher(tokens[i]);
//	        strippedLinks[i-1] = matcher.replaceAll("$1,$2");
//        }
//        for(int i=0; i<strippedLinks.length; i++){
//        	if(strippedLinks[i].contains("<")){
//        		String[] temp = strippedLinks[i].split(">|<");
//        		System.out.println((temp[0]+temp[(temp.length/2)]).trim());
//        	}else{
//        		System.out.println(strippedLinks[i].trim());
//        	}
//        }
	}
}
