package ThreadExecutorPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main {
	public static void main(String args[]) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.MINUTES, new ArrayBlockingQueue<>(2),
				Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());
		// This is the example for working for executor frame work
		// for (int i = 1 ; i <= 7; i++) {
		// executor.submit(() -> {
		// try {
		// Thread.sleep(4000);
		// } catch (Exception ex) {

		// }
		// System.out.println("This task with id : " + Thread.currentThread().getId() +
		// " is done by : "
		// + Thread.currentThread().getName());
		// });
		// }
		// executor.close();

		/* Future ,Callble */

		/*
		 * Use case :1 Future
		 * 
		 * System.out.println("Main Thread execution has started");
		 * Future<?> obj1 = executor.submit(() -> {
		 * System.out.println("Inside the runnable");
		 * try {
		 * System.out.println("entered Sleep duration");
		 * Thread.sleep(7000);
		 * System.out.println("Finsihed Sleep duration");
		 * } catch (Exception ex) {
		 * System.out.println("The exception is : " + ex.getMessage());
		 * }
		 * });
		 * 
		 * System.out.println("is Done : "+obj1.isDone());
		 * 
		 * try {
		 * try {
		 * obj1.get(2, TimeUnit.SECONDS);
		 * } catch (InterruptedException e) {
		 * // TODO Auto-generated catch block
		 * e.printStackTrace();
		 * } catch (ExecutionException e) {
		 * // TODO Auto-generated catch block
		 * e.printStackTrace();
		 * }
		 * } catch (TimeoutException e) {
		 * System.out.println("The exception is : "+e.getMessage());
		 * }
		 * 
		 * try {
		 * obj1.get();
		 * } catch (InterruptedException e) {
		 * // TODO Auto-generated catch block
		 * e.printStackTrace();
		 * } catch (ExecutionException e) {
		 * // TODO Auto-generated catch block
		 * e.printStackTrace();
		 * }
		 * 
		 * System.out.println("is Done : "+obj1.isDone());
		 * System.out.println("is Cancelled : "+obj1.isCancelled());
		 * 
		 * System.out.println("Main Thread has ended");
		 */

		/* Use case :1 callable */

	}
}
