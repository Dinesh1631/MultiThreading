package CustomLocks.Semaphore;

import java.util.concurrent.Semaphore;

public class SharedResource {

	public  void producer(Semaphore lock) {
		try {
			lock.acquire();
			System.out.println("Lock Aquired by : "+ Thread.currentThread().getName());
			Thread.sleep(4000);
		}
		catch (Exception ex) {
			
		}
		finally {
			System.out.println("Lock Released  by : "+ Thread.currentThread().getName());
			lock.release();
		}
	}

}
