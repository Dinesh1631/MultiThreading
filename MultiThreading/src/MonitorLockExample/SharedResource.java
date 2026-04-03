package MonitorLockExample;

public class SharedResource {
  private boolean isAvailable = false;
  
 
  public  synchronized void producer() {
	  isAvailable = true;
	  System.out.println("Added item by current thread : "+Thread.currentThread().getName() +" Now invoking the NotifyAll Method" );
	  notifyAll();//This will tell all the threads that are waiting for this resource that the resource is available.
  }
  
  public  synchronized void Consumer() {
	System.out.println("The consume method is invoked by : "+ Thread.currentThread().getName());
	
	while(!isAvailable)
	{
		try {
			System.out.println("The Thread is in waiting state : ");
			wait();//Will relaese all the monitor locks. 
		}
		catch(Exception ex) {
			
		}
	}
	System.out.println("iteam is  consumed by : "+ Thread.currentThread().getName());
	isAvailable=false;
  }
}
