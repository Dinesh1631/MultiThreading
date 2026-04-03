package CustomLocks.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

	public  void producer(ReentrantLock lock) {
		try {
			lock.lock();
			System.out.println("Lock Aquired by : "+ Thread.currentThread().getName());
			Thread.sleep(4000);
		}
		catch (Exception ex) {
			
		}
		finally {
			System.out.println("Lock Released  by : "+ Thread.currentThread().getName());
			lock.unlock();
		}
	}

}
