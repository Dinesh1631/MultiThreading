package CustomLocks.ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {

	public static void main(String args[]) {
		ReadWriteLock lock = new ReentrantReadWriteLock();

		// Two resouces are created .
		SharedResource resource1 = new SharedResource(lock);
		SharedResource resource2 = new SharedResource(lock);

		Thread t1 = new Thread(() -> resource1.producer());
		Thread t2 = new Thread(() -> resource1.producer());
		Thread t3 = new Thread(() -> resource2.consumer());
		Thread t4 = new Thread(() -> resource2.consumer());

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
