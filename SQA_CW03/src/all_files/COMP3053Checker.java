package all_files;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class COMP3053Checker {

	private String email;
	private String password;
	
	public COMP3053Checker() {}
	
	public COMP3053Checker(String email, String pwd) {
		this.setEmail(email);;
		this.setPwd(pwd);
	}
	
	//Email part.
	public Boolean beginWithAlphabet() {
		String fir_s = email.substring(0, 1);//get the first char of email in string form.
		Pattern p = Pattern.compile("[a-zA-Z]+");
		Matcher m = p.matcher(fir_s);
		if (m.find())
			return true;
		else {
			System.out.println("Invalid Email: email should begin with alphbat");
			return false;
		}
	}	
	
	public Boolean separatedByAt() {
		if (email.split("@").length == 2)//whether the email contains a '@' and separated by '@' into two parts.
			return true;
		else {
			System.out.println("Invalid Email: email should contain one '@' symbol and be separated into two parts by it.");
			return false;
		}
	}
	

	public Boolean leftLength() {
		if(separatedByAt()) {
			if(email.split("@")[0].length() <= 225 && email.split("@")[0].length() >=1) {
				return true;
			}
			else {
				System.out.println("Invalid Email: the length of left part in email should be from 1 to 225 (both side included).");
				return false;
			}
		}
		return false;
	}
	
	public Boolean rightLength() {
		if(separatedByAt()) {
			if(email.split("@")[1].length() <= 225) {
				return true;
			}
			else {
				System.out.println("Invalid Email: the length of right part in email should be at most 225. ");
				return false;
			}
		}
		return false;
	}
	
	public Boolean rightSeparatedByDot() {
		if(separatedByAt()) {
			String right_arr[] = email.split("@")[1].split("\\.");
//			System.out.println(right_arr.length);
			if(right_arr.length >= 2) {//whether right part contain "." and separated by "." into at least 2 parts.
				return true;
			}
			else {
				System.out.println("Invalid Email: the right part of email should contain at least one dot symbol and be separated into at least two part by dot(s)");
				return false;
			}
		}
		return false;
	}
	
	// Password part.
	public Boolean containUppercaseLetters() {//whether containing upper case letters or not.
		for (int i = 0; i < password.length(); i++) {
			if(Character.isUpperCase(password.charAt(i))) {
				return true;
			}
		}
		System.out.println("Invalid Password: password should contain at least one upper case letter!");
		return false;
	}
	
	public Boolean containLowercaseLetters() {//whether containing lower case letters or not.
		for (int i = 0; i < password.length(); i++) {
			if(Character.isLowerCase(password.charAt(i))) {
				return true;
			}
		}
		System.out.println("Invalid Password: password should contain at least one lower case letter!");
		return false;
	}
	
	public Boolean containNums() { //whether containing numbers or not.
		for (int i = 0; i < password.length(); i++) {
			if(Character.isDigit(password.charAt(i))) {
				return true;
			}
		}
		System.out.println("Invalid Password: password should contain at least one number!");
		return false;
	}
	
	//Second Requirement: The password shouldn't begin with number and symbol.
	public Boolean beginWithNumOrSymbol() {
		String str = ""+password.charAt(0);
		String regEx="[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~£¡@#£¤%¡­¡­&*£¨£©¡ª¡ª+|{}¡¾¡¿¡®£»£º¡±¡°¡¯¡££¬¡¢£¿]";
		Pattern p=Pattern.compile(regEx);
		Matcher m=p.matcher(str);
		if (!m.find() && !Character.isDigit(password.charAt(0)))
			return true;
		else {
			System.out.println("Invalid Password: password should not begin with number or symbol!");
			return false;
		}
	}
	
	//Third Requirement: The length of password is at least 8.
	public Boolean lengthAtLeast8() {
		if(password.length()>=8)
			return true;
		System.out.println("Invalid Password: password should have at least 8 length!");
		return false;
	}
	
	//getters and setters
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return password;
	}

	public void setPwd(String pwd) {
		this.password = pwd;
	}
	
	public static void main(String[] args) {
		Boolean goon = true;

		Scanner  scan1 = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);

		while(goon) {//whether the while loop continue to run.
			System.out.print("Please Enter Your Email: ");
			String email = scan1.nextLine();
			COMP3053Checker comp = new COMP3053Checker();
			//email part
			Boolean valid_email = false;
			comp.setEmail(email);
			if(comp.beginWithAlphabet() &&
			comp.separatedByAt() && 
			comp.leftLength() &&
			comp.rightLength() &&
			comp.rightSeparatedByDot()
			) {
				System.out.println("Valid Email!");
				valid_email = true;
			}
			else {
				continue;
			}
			
			//pwd part
			Boolean valid_pwd = false;
			do {
				System.out.print("Please Enter Your Password: ");
				String pwd = scan2.nextLine();
				comp.setPwd(pwd);
				if(comp.containUppercaseLetters()&&
						comp.containLowercaseLetters()&&
						comp.containNums()&&
						comp.beginWithNumOrSymbol()&&
						comp.lengthAtLeast8()
						) {
					System.out.println("Valid Password!");
					valid_pwd = true;
				}
			}while(!valid_pwd);

			if (valid_email&&valid_pwd) {
				goon = false;//stop the loop.
			}
		}
		scan1.close();
		scan2.close();

	}
}
