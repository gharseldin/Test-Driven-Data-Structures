import java.util.Scanner;

public class StringArray {
	
	public static void main(String[] args){
		
	}
	
	private static String compressString(String string){
		
		char[] charactersOfString = string.toCharArray();
		int n = charactersOfString.length;
		
		int count = 1;
		int charactersToBeDeleted = 0;
		
		char currentChar = charactersOfString[0];
	
		for(int i=1; i<n; i++){
			if(charactersOfString[i] == currentChar){
				count++;
				continue;
			}else{
				// for now assuming that 
				charactersToBeDeleted += count-2;	//accounting for the character and the number following
				
				currentChar = charactersOfString[i];
				count = 1;
				
			}
		}
		return 0;
	}
	
	private static void replaceSpace(){
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		scanner.close();
		
		System.out.println(input);
		char[] characters = input.toCharArray();
		int n = characters.length;
		
		for(int i=0; i<n; i++)
			if(characters[i] == ' ')
				insertSymbol(characters, i);
		
		for(char c: characters)
			System.out.print(c);	
	}
	
	private static void insertSymbol(char[] ch, int position){
		int n = ch.length;
		
		// shift cells forward to leave space
		for(int i=n; i>position ; i--){
			ch[i-1] = ch[i-3];
		}
		
		ch[position] = '%';
		ch[position+1] = '2';
		ch[position+2] = '0';
			
	}
}
