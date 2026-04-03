package DeadLockExample;

public class SharedResource {

	public synchronized void producer() {
		System.out.println("Lock Aquired ");
		try {
			Thread.sleep(8000);
		}
		catch (Exception ex) {
			
		}
		System.out.println("Lock Released ");
	}

}
