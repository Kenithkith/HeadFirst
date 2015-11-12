class TestSync implements Runnable {

	private int balance;

	public void run() {

		// Each thread runs 50 times, incrementing the
		// balance on each iteration.
		for (int i = 0; i < 50; i++) {
			increment();
			System.out.println(Thread.currentThread().getName()
					+ " says the balance is now " + balance + ".");

		}
	}

	public synchronized void increment() {
		
		// Here's the crucial part: We increment the balance by
		// adding 1 to whatever the value of the balance was AT THE
		// TIME WE READ IT - rather than adding 1 to whatever the CURRENT
		// value is.
		int i = balance;
		balance = i + 1;

	}
}

public class TestSyncTest {
	public static void main(String[] args) {

		TestSync job = new TestSync();
		
		Thread a = new Thread(job);
		Thread b = new Thread(job);
		
		a.setName("Bob the Panda");
		b.setName("Pippin the Cat");
		
		a.start();
		b.start();

	}
}
