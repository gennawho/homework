package driver;

public class Main {

	public static void main(String[] args) {
		String input = "Hello World";
		if(IsAllUnique(input)) {
			System.out.println("the string " + input + " has all unique characters");
		}
		else {
			System.out.println("the string " + input + " does not have all unique characters");
		}

	}
	public static boolean IsAllUnique(String str){
	    char alreadyFound[] = new char[100];
	    int count = 0;
	    if(count == 0) {
			alreadyFound[count] = str.charAt(0);
			count++;
		}
		for(int i = 1; i< str.length(); i++) {
			
				for(int j=0; j<count; j++) {
					   if(Character.compare(str.charAt(i), alreadyFound[j]) == 0) {
						   return false;
					   }
					   if (j == count-1) {
						   alreadyFound[count] = str.charAt(i);
						   count++;
						   j=count;
					   }
					   
				}
		   
		}
		return true; 
	}

}
