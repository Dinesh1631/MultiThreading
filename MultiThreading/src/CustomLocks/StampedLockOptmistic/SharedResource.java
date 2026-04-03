package CustomLocks.StampedLockOptmistic;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {
	private StampedLock lock;

	public SharedResource(StampedLock lock) {
		this.lock = lock;
	}

	int a = 10;

	public void producer() {
		try {
			long stamp = lock.tryOptimisticRead();
			System.out.println("The read Lock is aquired by : " + Thread.currentThread().getName());
			Thread.sleep(4000);
			if (lock.validate(stamp)) {
				System.out.println("DB updation is successfull");
			} else {
				System.out.println("DB updation has failed as someone has done write opration on the resource");
				a = 10;
			}

		} catch (Exception ex) {
		} finally {
		}
	}

	public void consumer() {
		long stamp = 0;
		try {
			stamp = lock.writeLock();
			System.out.println("The Write Lock is aquired by : " + Thread.currentThread().getName());
			a = 9;
		} catch (Exception ex) {

		} finally {
			if (stamp != 0) {
				System.out.println("The Write Lock is released by : " + Thread.currentThread().getName());
				lock.unlockWrite(stamp);
			}
		}
	}

}
