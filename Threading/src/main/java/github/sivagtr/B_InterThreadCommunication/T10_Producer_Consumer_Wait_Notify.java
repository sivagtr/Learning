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
/**
 *
 * Output:
 *
 * Adding new element 0
 * Adding new element 1
 * Adding new element 2
 * Adding new element 3
 * Adding new element 4
 * Adding new element 5
 * Adding new element 6
 * Adding new element 7
 * Adding new element 8
 * Adding new element 9
 * Producer reached limit.. Proceeding to waiting state !!
 * Removing the element 0
 * Removing the element 1
 * Removing the element 2
 * Removing the element 3
 * Removing the element 4
 * Removing the element 5
 * Removing the element 6
 * Removing the element 7
 * Removing the element 8
 * Removing the element 9
 * Consumer reached limit.. Proceeding to waiting state !!
 * Adding new element 10
 * Adding new element 11
 * Adding new element 12
 * Adding new element 13
 * Adding new element 14
 * Adding new element 15
 * Adding new element 16
 * Adding new element 17
 * Adding new element 18
 */