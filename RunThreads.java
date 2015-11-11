
public class RunThreads implements Runnable {
	public static void main(String[] args) {
		
		RunThreads runner = new RunThreads();
		Thread billy = new Thread(runner);
		Thread jason = new Thread(runner);
		billy.setName("Billy");
		jason.setName("Jason");
		
		billy.start();
		jason.start();
		
	}

	
	public void run() {
		
		for (int i = 0; i < 25; i++) {
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + " is now running.");
		}
	}
}
