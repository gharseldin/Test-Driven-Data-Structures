import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecondClass {

	int variable = 10;
	
	public void decrement() {
		variable--;
	}
	
	public static void main(String[] args){
		Pattern pattern = Pattern.compile("g1.*(g2).*(g3)");
		Matcher matcher = pattern.matcher("hg1hg2hg3hg4h2");
		
		
		System.out.println(matcher.replaceAll("-- $2 --- $1-- "));
	}
}
