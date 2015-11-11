class MyRunnable implements Runnable {

	// Runnable has only one method to implement: 
	// public void run() - with no arguments.  This is where
	// you put the JOB the thread is supposed to run.  This is
	// the method that goes at the BOTTOM of the new stack
	// -- like MAIN goes at the bottom of the primary thread.
	public void run() {
		go();
	}
	
	public void go() {
		
		try {
			Thread.sleep(2000);
			
		} catch(InterruptedException ex) {
			ex.printStackTrace();
		} 
		
		doMore();
	}
	
	public void doMore() {
		
		System.out.println("Wait for it......");
		
		System.out.println("Top o' the stack!");
	}
}

public class ThreadTester {
	public static void main(String[] args) {
		
		// Pass the new Runnable instance into the new
		// Thread constructor.  This tells the thread
		// what method to put on the bottom of the new
		// stack.  In other words, the first method that
		// this new thread will run.
		
		MyRunnable threadJob = new MyRunnable();
		Thread myThread = new Thread(threadJob);
		
		myThread.start();
		
		System.out.println("Back in main.");
		
		
		
	}
}
