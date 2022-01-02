package github.sivagtr;

/**
 * Example for not having synchronization lead to wrong counter values.
 */
class SynchronizationFailed {

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
class SynchronizationTest {

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
