package ProducerConsumerProblem;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {
	private Queue<Integer> queue;
	private int bufferSize;

	public SharedResource(int bufferSize) {
		this.bufferSize = bufferSize;
		this.queue = new LinkedList<>();
	}

	public synchronized void Producer(int item) throws InterruptedException {
		if (queue.size() == bufferSize) {
			System.out.println("The Queue is full waiting for the consumer ");
			wait();
		}
		queue.add(item);
		System.out.println("The Iteam is added by the :" + Thread.currentThread().getName());
		notify();
		/*
		 * After adding an item, notify() is called to signal that the shared
		 * condition has changed. One arbitrary thread waiting on this monitor
		 * (typically the consumer) is moved from WAITING to BLOCKED so that it
		 * can re-acquire the lock and continue execution.
		 */
	}

	public synchronized void Consumer() throws InterruptedException {
		if (queue.isEmpty()) {
			System.out.println("The Queue is empty waiting for the producer ");
			wait();
		}
		queue.poll();
		System.out.println("The Iteam is consumed by the :" + Thread.currentThread().getName());
		notify();
		/*
		 * After removing an item, notify() is called to signal that the shared
		 * condition has changed. One arbitrary thread waiting on this monitor
		 * (typically the producer) is moved from WAITING to BLOCKED so that it
		 * can re-acquire the lock and continue execution.
		 */
	}

}
