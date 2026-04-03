package CustomLocks.StamedLock;

import java.util.concurrent.locks.StampedLock;

public class Main {
	public static void main(String args[]) {
		 StampedLock lock = new  StampedLock();
		 SharedResource resource = new SharedResource(lock);
		 Thread t1 = new Thread(()-> resource.producer());
		 Thread t2 = new Thread(()-> resource.producer());
		 Thread t3 = new Thread(()-> resource.producer());
		 
		 t1.start();
		 t2.start();
		 t3.start();
	}
}
