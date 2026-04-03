package CustomLocks.Semaphore;

import java.util.concurrent.Semaphore;

public class Main {
	public static void main(String args[]) {
		SharedResource resource = new SharedResource();
		Semaphore lock = new Semaphore(1);
		Thread t1 = new Thread(() -> resource.producer(lock));
		Thread t2 = new Thread(() -> resource.producer(lock));
		Thread t3 = new Thread(() -> resource.producer(lock));
		Thread t4 = new Thread(() -> resource.producer(lock));

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
