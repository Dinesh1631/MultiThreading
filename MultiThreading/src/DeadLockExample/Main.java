package DeadLockExample;

import java.util.concurrent.locks.LockSupport;

public class Main {
	@SuppressWarnings("removal")
	public static void main(String[] args) {
		SharedResource resource = new SharedResource();
		System.out.println("Main Method has started");
		Thread T1 = new Thread(() -> {
			System.out.println("Thread 1 Calling the Produce");
			resource.producer();
		});

		Thread T2 = new Thread(() -> {
			try {
				Thread.sleep(1000);
			} catch (Exception ex) {

			}
			System.out.println("Thread 2 Calling the Produce");
			resource.producer();
		});

		T1.start();
		T2.start();
		try {
			Thread.sleep(3000);
		} catch (Exception ex) {

		}
		System.out.println("Thread 1 has been parked (suspended safely)");
		T1.suspend();

		System.out.println("Main Method has Ended");
	}
}
