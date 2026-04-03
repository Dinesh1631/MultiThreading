package CustomLocks.ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;

public class SharedResource {
	private ReadWriteLock lock;

	public SharedResource(ReadWriteLock lock) {
		this.lock = lock;
	}

	public void producer() {
		try {
			lock.readLock().lock();
			System.out.println("The read Lock is aquired by : " + Thread.currentThread().getName());
			Thread.sleep(4000);

		} catch (Exception ex) {

		} finally {
			System.out.println("The read Lock is released by : " + Thread.currentThread().getName());
			lock.readLock().unlock();
		}
	}

	public void consumer() {
		try {
			lock.writeLock().lock();
			System.out.println("The Write Lock is aquired by : " + Thread.currentThread().getName());
			Thread.sleep(4000);

		} catch (Exception ex) {

		} finally {
			System.out.println("The Write Lock is released by : " + Thread.currentThread().getName());
			lock.writeLock().unlock();
		}
	}

}
