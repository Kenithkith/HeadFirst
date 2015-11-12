class BankAccount {

	private int balance = 100;

	public int getBalance() {
		return this.balance;
	}

	public void withdraw(int amount) {
		this.balance -= amount;
	}
}

public class RyanAndMonicaJob implements Runnable {

	// There will only be ONE instance of the RyanAndMonicaJob.
	// That means there will only be ONE instance of BankAccount.
	// Both threads will access this one account.
	private BankAccount account = new BankAccount();

	public static void main(String[] args) {

		// Instantiate the Runnable(job).
		RyanAndMonicaJob theirJob = new RyanAndMonicaJob();

		// Make two threads, giving each the same Runnable job.
		// That means both threads will be accessing the one account
		// instance variable ("account") in the Runnable class.
		Thread one = new Thread(theirJob);
		Thread two = new Thread(theirJob);

		one.setName("Ryan");
		two.setName("Monica");

		one.start();
		two.start();
	}

	public void run() {

		// In the run() method, a thread loops through and tries to make a
		// withdrawal
		// with each iteration. After the withdrawal, it checks the balance once
		// again
		// to see if the account is overdrawn.
		for (int i = 0; i < 10; i++) {

			makeWithdrawal(10);

			if (account.getBalance() < 0) {
				System.out.println("Overdrawn!");

			}
		}
	}

	private synchronized void makeWithdrawal(int amount) {

		// Check the account balance, and if there's not enough money,
		// we just print a message. If there IS enough, we go to sleep,
		// then wake up and complete the withdrawal, just like Ryan did.
		if (account.getBalance() >= amount) {
			System.out.println(Thread.currentThread().getName()
					+ " is about to withdraw " + amount + " pounds.");

			try {
				System.out.println(Thread.currentThread().getName()
						+ " suffers from narcolepsy and has fallen asleep.  Oops.");
				Thread.sleep(500);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}

			System.out.println(Thread.currentThread().getName() + " wakes up.");
			account.withdraw(amount);
			System.out.println(Thread.currentThread().getName()
					+ " completes the withdrawal.");
			System.out.println();
			

		} else {
			System.out.println("Sorry, not enough money in the account for "
					+ Thread.currentThread().getName() + ".");

		}
	}

}
