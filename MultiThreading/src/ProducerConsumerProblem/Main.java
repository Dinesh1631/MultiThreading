package ProducerConsumerProblem;

public class Main {
	public static void main(String args[]) {
		SharedResource resource = new SharedResource(3);

		Thread producerThread = new Thread(() -> {
			try {
				for (int i = 1; i <= 6; i++) {
					resource.Producer(i);
				}
			} catch (Exception ex) {

			}
		}

		);

		Thread consumerThread = new Thread(() -> {
			try {
				for (int i = 1; i <= 6; i++) {
					resource.Consumer();
				}
			} catch (Exception ex) {

			}
		}

		);

		producerThread.start();
		consumerThread.start();

	}
}
