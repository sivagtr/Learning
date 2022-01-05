package github.sivagtr.B_InterThreadCommunication;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ------------------------------------------------------------
 * <br>
 * Problem: What if, need to lock in one method and unlock in another method ?
 * <br>
 * Solution: Reentrant Locks can be used for flexibility.
 * <br>
 * Note:
 * <br>
 * <ol>
 * <li>
 *     It's good practice to use unlocking in finally block. If there is a exception, leads to deadlock.
 * </li>
 * <li>
 *     Fairness is a constructor parameter for Reentrant Lock.
 *     <ol>
 *         <li>
 *             True: It allows long lasting thread to take up the task.
 *             <br>
 *             Avoids: Starvation but Slow
 *         </li>
 *         <li>
 *             False: It allows any thread to take up the task.
 *             <br>
 *             Ends Up: Starvation But Fast since new thread can take task and process.
 *         </li>
 *     </ol>
 *     </li>
 * <li>
 *     Contains Waiting Queue, for the threads.
 * </li>
 * </ol>
 * <br>
 * ============================================================
 * <p>
 * Further Problem: NA
 * </p>
 * ------------------------------------------------------------
 */

public class T11_Lock_ReentrantLock {

	private final Lock lock = new ReentrantLock();

	private int counter = 0;

	/**
	 * Unlocking can be done in another method.
	 * Flexibility for locking and unlocking.
	 * @param args main
	 */
	public static void main(String[] args) {
		T11_Lock_ReentrantLock lock_reentrantLock = new T11_Lock_ReentrantLock();
		Thread t1 = new Thread(() -> {
			try {
				lock_reentrantLock.increment();
			} finally {
				lock_reentrantLock.lock.unlock();
			}
		});
		Thread t2 = new Thread(() -> {
			try {
				lock_reentrantLock.increment();
			} finally {
				lock_reentrantLock.lock.unlock();
			}
		});
		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Final Counter Value:- " + lock_reentrantLock.counter);
	}

	/**
	 * Flexible Usage:
	 * <br>
	 * Lock acquired in increment method.
	 * But it is unlocked in another method.
	 */
	private void increment() {
		lock.lock();
		for(int i = 0; i < 10000; i++)
			counter++;
	}

	/**
	 * Without locking, gives inconsistent counter result
	 */
	//	private void increment() {
	//		for(int i = 0; i < 10000; i++)
	//			counter++;
	//	}
}
/**
 * Output:
 * Final Counter Value:- 20000
 *
 * If uncommented:
 * Final Counter Value:- 17553
 */