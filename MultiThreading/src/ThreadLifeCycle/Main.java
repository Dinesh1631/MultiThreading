package ThreadLifeCycle;

public class Main {
	public static void main(String args[]) {
		MonitorLock lock = new MonitorLock();
		Thread t1 = new Thread(() -> lock.task1());
		Thread t2 = new Thread(() -> lock.task2());
		Thread t3 = new Thread(() -> lock.task3());
		t1.start();
		t2.start();
		t3.start();

	}
}

/*
 * MonitorLock : This will help us to control the access of multiple threads to
 * a shared resource.
 * if you see above example all the threads are accessing the shared resource at
 * the same time(Using same object)
 * These monitorLocks are object level locks.So if one thread has taken lock
 * over a shared resource then other threads will wait for the lock to be
 * released.
 * have to wait even if they are not using the same shared resource.
 * Ex:As you can see even though thread 2 is not using the shared resource it
 * has to wait for the lock to be released.
 * As there is synchronized block in task1 method, it will lock the object and
 * other threads will wait for the lock to be released.
 * 
 * if the Threds wprking on diffrent objects then they will not wait for each
 * other.
 */