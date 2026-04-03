package ThreadCreationWays;

public class Task1 implements Runnable {

	@Override
	public void run() {
		System.out.println("Current Thead Name : "+Thread.currentThread().getName());

	}

}
