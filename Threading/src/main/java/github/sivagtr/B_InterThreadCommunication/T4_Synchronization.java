package github.sivagtr.B_InterThreadCommunication;
/**
 * ------------------------------------------------------------
 * <p>
 * Problem: Multi-Threading doesn't respect critical sections resulting in compromising predictable output
 * <br>
 * Solution: Use synchronization for critical sections
 * </p>
 * ============================================================
 * <br>
 * Further Problem: If synchronization is not used properly, it ends with serial processing
 * <br>
 * ------------------------------------------------------------
 */

class SynchronizationFailed {

	/**
	 * Example for not having synchronization lead to wrong counter values.
	 */
	private static Integer counter = 0;

	public static void main(String[] args) {
		process();
	}

	public static void process() {
		Thread t1 = new Thread(() -> {
			for(int i = 0; i < 1000; i++) {
				counter++;
			}
		});

		Thread t2 = new Thread(() -> {
			for(int i = 0; i < 1000; i++) {
				counter++;
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
		System.out.println("The counter value " + counter);
	}
}

/**
 * This has proper synchronization.
 */
public class T4_Synchronization {

	private static Integer counter = 0;

	public static void main(String[] args) {
		process();
	}

	public static void process() {
		Thread t1 = new Thread(() -> {
			for(int i = 0; i < 1000; i++) {
				increment();
			}
		});

		Thread t2 = new Thread(() -> {
			for(int i = 0; i < 1000; i++) {
				increment();
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
		System.out.println("The counter value " + counter);
	}

	/**
	 * Synchronization keyword is used.
	 */
	public static synchronized void increment() {
		counter++;
	}
}
