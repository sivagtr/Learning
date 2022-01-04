package github.sivagtr.B_InterThreadCommunication;

import java.util.LinkedList;
import java.util.List;
/**
 * ------------------------------------------------------------
 * <br>
 * Problem: Implementation of Producer/Consumer Pattern
 * <br>
 * Solution: Producer/Consumer pattern can be implemented with multi-threading wait/notify.
 * <p>
 * Note:
 * <br>
 * In else condition, notify is called. However, the other thread will not be released.
 * Since, while(true) doesn't end the loop. So the further statements will continue to execute.
 * Once it reaches the limit, current thread goes to waiting state.
 * </p>
 * ============================================================
 * <p>
 * Further Problem: NA
 * </p>
 * ------------------------------------------------------------
 */
public class T10_Producer_Consumer_Wait_Notify {

	private List<Integer> data = new LinkedList<>();
	private final Object lock = new  Object();

	private final int UPPER_LIMIT = 10;
	private final int LOWER_LIMIT = 0;
	private int value = 0;

	private void producer() throws InterruptedException {
		synchronized(lock){
			while(true){
				if(data.size() == UPPER_LIMIT){
					System.out.println("Producer reached limit.. Proceeding to waiting state !!");
					lock.wait();
				}else {
					System.out.println("Adding new element " + value);
					data.add(value);
					value++;
					lock.notify();
				}
				Thread.sleep(500);
			}
		}
	}

	private void consumer() throws InterruptedException {
		synchronized(lock){
			while(true){
				if(data.size() == LOWER_LIMIT){
					System.out.println("Consumer reached limit.. Proceeding to waiting state !!");
					lock.wait();
				}else {
					System.out.println("Removing the element " + data.remove(0));
					lock.notify();
				}
				Thread.sleep(500);
			}
		}
	}

	public static void main(String[] args) {
		T10_Producer_Consumer_Wait_Notify wait_notify = new T10_Producer_Consumer_Wait_Notify();
		Thread pt = new Thread(()->{
			try {
				wait_notify.producer();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		});
		Thread ct = new Thread(()->{
			try {
				wait_notify.consumer();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		});
		pt.start();
		ct.start();
	}
}
