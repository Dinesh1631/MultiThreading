package ThreadCreationWays;

public class Main {
	public static void main(String args[]) {
		System.out.println("Current Thead Name : " + Thread.currentThread().getName());
		// creating the instace of class that implements runnable interface.
		// Runnable task1 = new Task1();
		// Runnable task2 = new Task2();

		// //This is step where the thread is created.
		// Thread t1 = new Thread(task1);
		// Thread t2 = new Thread(task2);

		// t1.start();
		// t2.start();
		// Same can be done with the extending the Thread Class also.
		Thread t1 = new Thread(() -> {
			System.out.println("Current Thead Name : " + Thread.currentThread().getName());
		});

		Thread t2 = new Thread(() -> {
			System.out.println("Current Thead Name : " + Thread.currentThread().getName());
		});

		t1.start();
		t2.start();
	}
}
