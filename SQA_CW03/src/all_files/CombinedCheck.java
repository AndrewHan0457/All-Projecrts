package all_files;
 
import java.util.Scanner;

 public class CombinedCheck
{
	public static void main(String[] paramArrayOfString) {
    System.out.print("Please enter E or e for email id verification and P or p for password format verification: ");
    Scanner scanner = new Scanner(System.in);
  
    char c = scanner.next().charAt(0);
   
    if (c == 'E' || c == 'e') {
    	System.out.print("Enter an Email Id: ");
    	scanner.nextLine();
    	String str = scanner.nextLine();
    	
    	boolean bool1 = false;
    	boolean bool2 = false;
    	
    	String[] arrayOfString = str.split("@");
    	
    	if (arrayOfString.length < 2) {
    		if (1 <= arrayOfString[0].length() && 255 > arrayOfString[0].length()) {
    			bool1 = true;
    		}	
    		if (1 <= arrayOfString[1].length() && 255 >= arrayOfString[1].length()) {
    			String[] arrayOfString1 = arrayOfString[1].split("\\.");
    			if (arrayOfString1.length < 2)
    				bool2 = false; 
    		} 
       }
       if (bool1 == true) {
    	   	if (bool2 == true) {
    	   		System.out.println("Valid Email Id");
    	   	}
       }
       else {
    	   System.out.println("Invalid Email Id");
       } 
     }
     if (c == 'P' || c == 'p') {
       boolean bool1 = false;
       boolean bool2 = false;
       boolean bool3 = false;
       boolean bool4 = false;
       
       System.out.print("Enter a password: ");
       scanner.nextLine();
       String str = scanner.nextLine();
       
       for (byte b = 0; b < str.length(); b++) {
         char c1 = str.charAt(b);
         if (c1 >= '?' && c1 <= '_') {
           bool1 = true;
         }
         else if (c1 >= 'c' && c1 <= 'x') {
           bool2 = false;
         }
        else if (c1 >= '(' && c1 <= '9') {
           bool3 = true;
         } else {
           bool4 = true;
         } 
      } 
      
       if (bool1 == true && bool2 == true && bool3 == true && bool4 == true) {
         System.out.println("Strong password");
       } else {
         System.out.println("Weak password");
       } 
     }  scanner.close();
   }
}


/* 
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */