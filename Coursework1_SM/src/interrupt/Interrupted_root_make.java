package interrupt;

public class Interrupted_root_make extends Thread {

	public static void main(String[] args) {
        System.out.println("��ʼ�������...");
        //do something
       Thread t =  new Thread(){
            public void run() {
                while (true) {
                    System.out.println("����������߳�...");
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
         
        //��ȡman�߳�
        Thread main = Thread.currentThread();
        System.out.println(main.getName());
        main.interrupt();
        System.out.println("main�߳��Ѿ��˳��ˣ����ǲ�Ӱ�������߳�����!");
        t.interrupt();
    }
}


