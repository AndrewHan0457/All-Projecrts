package main.test;

import java.util.Scanner;

public class FactorialSum {
	
	public static Scanner scan = new Scanner(System.in);
	private static int num = 0;
	private static int sum = 0;
	
	public static int fs() {
		
		System.out.print("input a number: ");
		num = scan.nextInt();
		for (int j = num; j > 0; j--) {
			int fac = 1;
			for (int i = j; i > 0; i--) {
				fac = fac * i;
			}
			System.out.println(fac);
			sum = sum + fac;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fs());
	}

}
