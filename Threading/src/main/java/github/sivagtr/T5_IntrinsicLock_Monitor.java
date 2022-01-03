package github.sivagtr;

/**
 * ------------------------------------------------------------
 * Problem: Protecting critical sections when threading
 * Solution: Using synchronized block
 * ============================================================
 * Further Problem: Using synchronization method can lead to serial processing, because of class/object level locking
 * Even when there is no dependency, ends up in serial processing.
 * ------------------------------------------------------------
 */

/**
 * Simple example demonstrates: Intrinsic Lock (Monitor)
 * -----------------------------------------------------
 * <p>
 * When a method is used as synchronized, the lock will be acquired at class level.
 * Once a thread enters, it acquires lock. Upon exit, lock is released.
 * <p>
 * Since the lock is acquired at class level, other threads can't perform any operations if the thread doesn't exits.
 * <p>
 * Here is a example, Thread1 incrementing counter1 & Thread2 incrementing counter2.
 * Both are independent, But once thread1 enters. Thread 2 can't perform any operation because both methods have synchronized at method level.
 * Means, it acquires at class level.
 * <p>
 * Thread 1 has sleep, we can see thread 2 can't perform any operation.
 * <p>
 * If we remove synchronized keyword for any one method, it executes simultaneously.
 *
 */
class IntrinsicLock_Monitor {
	private int counter1 = 0;
	private int counter2 = 0;

	public static void main(String[] args) {
		IntrinsicLock_Monitor monitor = new IntrinsicLock_Monitor();
		Thread t1 = new Thread(() -> {
			for(int i = 0; i < 100; i++) {
				monitor.increment1();
			}
		});
		Thread t2 = new Thread(() -> {
			for(int i = 0; i < 100; i++) {
				monitor.increment2();
			}
		});
		t1.start();
		t2.start();
	}

	/**
	 * Test 1:
	 * Remove synchronized keyword for any method and test
	 * <p>
	 * Test 2:
	 * Try changing the sleep value to 100ms and test
	 */

	private synchronized void increment1() {
		System.out.println("Increment1 : " + counter1);
		try {
			Thread.sleep(10000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		counter1++;
	}

	private synchronized void increment2() {
		System.out.println("Increment2 : " + counter2);
		counter2++;
	}
}
