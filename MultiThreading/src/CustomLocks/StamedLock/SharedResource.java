package CustomLocks.StamedLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.StampedLock;

public class SharedResource {
	private StampedLock lock;

	public SharedResource(StampedLock lock) {
		this.lock = lock;
	}
	long stamp;
	public void producer() {
		try {
			stamp = lock.readLock();
			System.out.println("The read Lock is aquired by : " + Thread.currentThread().getName());
			Thread.sleep(4000);

		} catch (Exception ex) {

		} finally {
			System.out.println("The read Lock is released by : " + Thread.currentThread().getName());
			lock.unlock(stamp);
		}
	}

//	public void consumer() {
//		try {
//			lock.writeLock().lock();
//			System.out.println("The Write Lock is aquired by : " + Thread.currentThread().getName());
//			Thread.sleep(4000);
//
//		} catch (Exception ex) {
//
//		} finally {
//			System.out.println("The Write Lock is released by : " + Thread.currentThread().getName());
//			lock.writeLock().unlock();
//		}
//	}

}

