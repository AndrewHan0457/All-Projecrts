package threadTest;

import java.util.concurrent.TimeUnit;

public class Mythread  implements Runnable{
	
	public int state = 0;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int preState;
		System.out.println(this.state+" running...");
		while(true){
			preState = this.state;
			while(preState==this.state) {
				try {
					TimeUnit.SECONDS.sleep(1);
					System.out.println("in loop!");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			preState = this.state;
//			notifySensor(this.state);
			System.out.println("out!");
			break;
		}
	}
}
