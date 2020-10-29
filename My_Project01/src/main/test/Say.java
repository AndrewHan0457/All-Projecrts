package main.test;

public class Say {
	public static void main(String[] args) {
		People Andrew = new People("Andrew Han", 22, "man", "Prograssor");
		System.out.println(Andrew);
		System.out.println(Andrew.getName());
		System.out.println(Andrew.getAge());
		System.out.println(Andrew.getGender());
		System.out.println(Andrew.getJob());

	}
}
