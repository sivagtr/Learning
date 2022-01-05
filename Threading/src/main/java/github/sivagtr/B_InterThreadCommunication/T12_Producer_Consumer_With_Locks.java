package github.sivagtr.B_InterThreadCommunication;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ------------------------------------------------------------
 * <br>
 * Problem: Implementation of Producer/Consumer Pattern
 * <br>
 * Solution: Producer/Consumer pattern can be implemented with multi-threading Lock's (Reentrant Locks)
 * <p>
 * Note:
 * <br>
 * Similar to wait and notify --> locks have conditions naming await and signal.
 * These are obtained through Condition Object derived from the lock Object.
 * </p>
 * ============================================================
 * <p>
 * Further Problem: NA
 * </p>
 * ------------------------------------------------------------
 */
public class T12_Producer_Consumer_With_Locks {

	private final Lock lock = new ReentrantLock();
	private final Condition condition = lock.newCondition();

	public static void main(String[] args) {
		T12_Producer_Consumer_With_Locks producerConsumerWithLocks = new T12_Producer_Consumer_With_Locks();
		Thread t1 = new Thread(() -> {
			try {
				producerConsumerWithLocks.produce();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		});

		Thread t2 = new Thread(() -> {
			try {
				producerConsumerWithLocks.consume();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		});

		t1.start();
		t2.start();
	}

	private void produce() throws InterruptedException {
		lock.lock();
		System.out.println("1. In Produce... ");
		condition.await();
		System.out.println("4. Continuing after signal/notify in produce method...");
		lock.unlock();
	}

	private void consume() throws InterruptedException {
		Thread.sleep(1000); // Makes sure producer hits first
		lock.lock();
		System.out.println("2. In Consume Method..");
		condition.signal();
		System.out.println("3. After Signal, Still in Consume method.. Executing remaining steps...");
		lock.unlock();
	}
}
