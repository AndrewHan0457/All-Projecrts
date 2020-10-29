package interrupt;

public class Interrupted_root_make extends Thread {

	public static void main(String[] args) {
        System.out.println("开始进入程序...");
        //do something
       Thread t =  new Thread(){
            public void run() {
                while (true) {
                    System.out.println("我是另外的线程...");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
         
        //获取man线程
        Thread main = Thread.currentThread();
        System.out.println(main.getName());
        main.interrupt();
        System.out.println("main线程已经退出了，但是不影响其他线程运行!");
        t.interrupt();
    }
}


