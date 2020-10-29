package threadTest;

import java.util.concurrent.TimeUnit;

public class test {
	public static void main(String[] args) {
		Mythread mt = new Mythread();
		new Thread(mt).start();
		try {
			TimeUnit.SECONDS.sleep(3);
			System.out.println("state has changed!");
			mt.state = 2;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
