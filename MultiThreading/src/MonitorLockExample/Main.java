package MonitorLockExample;

public class Main {
	public static void main(String args[]) {
		SharedResource resource = new SharedResource();
		System.out.println("The main method is started by the : " + Thread.currentThread().getName());
		Thread ProducerThread = new Thread(() -> {
			try {
				Thread.sleep(5000);
				resource.producer();
			} catch (Exception ex) {

			}
		});

		Thread ConsumerThread = new Thread(() -> {
			resource.Consumer();
		});
		
		ProducerThread.start();
		ConsumerThread.start();
		
		System.out.println("The main method is Ended by the : " + Thread.currentThread().getName());
	}
}
