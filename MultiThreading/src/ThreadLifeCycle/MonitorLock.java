package ThreadLifeCycle;

public class MonitorLock {

	
	public synchronized void task1() {
		try {
			System.out.println("Inside Task1");
			Thread.sleep(10000);
		}
		catch(Exception ex) {
			
		}
	}
	
	public void task2() {
		System.out.println("Inside task2 ,before sysnchronized");
		synchronized(this){
			System.out.println("Inside task2 ,After sysnchronized");
		}
	}
	
	public void task3() {
		System.out.println("Inside task3 : ");
	}
}
