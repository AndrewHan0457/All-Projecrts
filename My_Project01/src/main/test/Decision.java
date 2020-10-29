package main.test;

import java.util.Random;

public class Decision {

	public static void WhoTakeDelivery() {
		String str1 = "Yeda";
		String str2 = "Guangzhong";
		Random ran = new Random();
		int num = ran.nextInt(2);
		//System.out.println("The random number is: " + num + ".");
		if(num==0) {
			System.out.println(str1 + " should take the delivery!");
		}
		else
			System.out.println(str2 + " should take the delivery!");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WhoTakeDelivery();
	}

}
