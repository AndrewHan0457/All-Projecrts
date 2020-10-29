package main.test;

import java.util.Scanner;

public class CheckYear {
	
	private static Scanner scan = new Scanner(System.in);
	private static int year;
	
	public static boolean Check() {
		System.out.print("Please input Year to check: ");
		year = scan.nextInt();
		if (year % 4 == 0 || year % 400 == 0 && year % 100 != 0) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean boo = Check();
		System.out.println(boo);
	}

}
