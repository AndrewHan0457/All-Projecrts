package threadTest;

import java.util.Set;

public class temp {
	public static void main(String[] args) {
		Runtime.getRuntime().addShutdownHook(new Thread()
        {
            @Override
            public void run()
            {

                System.out.println("Interrupting threads");
                Set<Thread> runningThreads = Thread.getAllStackTraces().keySet();
                for (Thread runningThread : runningThreads) {
                    // Determine if the thread is the one we are testing
                    if (runningThread.getName().equals("InteruptThread")) {
                        //If the thread is not interrupted, we interrupt it
                        if (!runningThread.isInterrupted()) {
                            System.out.println("InteruptThread is not interrupted, we are going to interupt it");
                            runningThread.interrupt();
                        }
                    }
                }

                System.out.println("Shutdown hook ran!");
            }
        });

      
    }

	}
